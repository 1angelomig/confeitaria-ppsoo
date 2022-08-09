package com.ppsoo.controller.servlets;

import java.io.IOException;

import com.ppsoo.model.entities.Bolo;
import com.ppsoo.model.entities.BoloBase;
import com.ppsoo.model.entities.Pedido;
import com.ppsoo.model.entities.condimentos.Camada;
import com.ppsoo.model.entities.condimentos.coberturas.CoberturaChocolate;
import com.ppsoo.model.entities.condimentos.coberturas.CoberturaMorango;
import com.ppsoo.model.entities.condimentos.recheios.RecheioChocolate;
import com.ppsoo.model.entities.condimentos.recheios.RecheioMorango;

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

        if (operacao != null && operacao.equals("criarBolo")) {
            req.getRequestDispatcher("/pedido.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String recheio = req.getParameter("recheioBolo");
        String cobertura = req.getParameter("coberturaBolo");
        int camadas = Integer.parseInt(req.getParameter("camadasBolo"));

        BoloBase bolo = new BoloBase();
        Bolo boloAux = bolo;

        if (recheio != null) {
            if (recheio.equals("recheioMorango")) {
                boloAux = new RecheioMorango(boloAux);
            }
            if (recheio.equals("recheioChocolate")) {
                boloAux = new RecheioChocolate(boloAux);
            }
        }

        if (cobertura != null) {
            if (cobertura.equals("coberturaMorango")) {
                boloAux = new CoberturaMorango(boloAux);
            }
            if (cobertura.equals("coberturaChocolate")) {
                boloAux = new CoberturaChocolate(boloAux);
            }
        }

        if(camadas > 0){
            for (int i = 0; i < camadas; i++) {
                boloAux = new Camada(boloAux);
            }
        }

        Pedido pedido = new Pedido(boloAux);

        HttpSession session = req.getSession();
        session.setAttribute("msg", "Pedido feito!");
        session.setAttribute("pedido", pedido);

        resp.sendRedirect("pedidofeito.jsp");
    }

}
