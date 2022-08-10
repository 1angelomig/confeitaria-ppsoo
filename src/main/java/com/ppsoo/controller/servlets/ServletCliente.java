package com.ppsoo.controller.servlets;

import java.io.IOException;

import com.ppsoo.model.entities.Cliente;
import com.ppsoo.model.repositories.Facade;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operacao = req.getParameter("op");

        if (operacao != null && operacao.equals("cadastro")) {
            req.getRequestDispatcher("/cadastro.jsp").forward(req, resp);
        }

        if (operacao != null && operacao.equals("login")) {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }

        req.getRequestDispatcher("/inicio.jsp").forward(req, resp);
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operacao = req.getParameter("op");
        
        HttpSession session = req.getSession();

        if (operacao != null && operacao.equals("cadastro")) {
            Facade.getCurrentInstance().cadastroCliente(req.getParameter("email"), req.getParameter("senha"));

            session.setAttribute("msg", "Cadastrado com Sucesso");

            resp.sendRedirect("index.jsp");
        }

        if (operacao != null && operacao.equals("login")) {
            Cliente cliente = Facade.getCurrentInstance().logarCliente(req.getParameter("email"), req.getParameter("senha"));
            session.setAttribute("cliente", cliente);

            resp.sendRedirect("inicio.jsp");
        }
    }

}
