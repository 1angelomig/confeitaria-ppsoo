package com.ppsoo.controller.servlets;

import java.io.IOException;

import com.ppsoo.model.entities.Bolo;
import com.ppsoo.model.repositories.Facade;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ServletPedido")
public class ServletPedido extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operacao = req.getParameter("op");
        
        if (operacao != null && operacao.equals("criarPedido")) {
            req.getRequestDispatcher("/pedido.jsp").forward(req, resp);
        }
        
        if (operacao != null && operacao.equals("verPedidos")){
            int idCliente = Integer.parseInt(req.getParameter("idCliente"));
            HttpSession session = req.getSession();
            
            session.setAttribute("pedidos", Facade.getCurrentInstance().lerPedidos(Facade.getCurrentInstance().getCliente(idCliente)));
            System.out.println(Facade.getCurrentInstance().lerPedidos(Facade.getCurrentInstance().getCliente(idCliente)).size());

            req.getRequestDispatcher("/pedidos.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String recheio = req.getParameter("recheioBolo");
        String cobertura = req.getParameter("coberturaBolo");
        int camadas = Integer.parseInt(req.getParameter("camadasBolo"));
        int idCliente = Integer.parseInt(req.getParameter("idCliente"));
        System.out.println(idCliente);

        Bolo bolo = Facade.getCurrentInstance().criaBolo();
        bolo = Facade.getCurrentInstance().adicionaRecheio(bolo, recheio);
        bolo = Facade.getCurrentInstance().adicionaCobertura(bolo, cobertura);
        bolo = Facade.getCurrentInstance().adicionaCamadas(bolo, camadas);

        Facade.getCurrentInstance().fazPedido(bolo, Facade.getCurrentInstance().getCliente(idCliente));

        HttpSession session = req.getSession();
        session.setAttribute("msg", "Pedido feito!");

        resp.sendRedirect("ServletPedido?op=verPedidos&idCliente=" + req.getParameter("idCliente"));
    }

}
