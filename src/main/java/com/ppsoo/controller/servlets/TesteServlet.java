package com.ppsoo.controller.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/TesteServlet")
public class TesteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String voltar = req.getParameter("voltar");
        if(voltar != null){
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }

        req.getRequestDispatcher("/home.jsp").forward(req, resp);

    }
    
}
