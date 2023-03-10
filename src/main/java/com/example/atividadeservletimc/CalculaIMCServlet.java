package com.example.atividadeservletimc;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "calculaIMCServlet", value = "/calcula")
public class CalculaIMCServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String peso = req.getParameter("weight");
        String altura = req.getParameter("height");

        Double imc = Double.parseDouble(peso) / (Double.parseDouble(altura) * Double.parseDouble(altura));
        req.setAttribute("imc", String.format("%.2f %%", imc));
        resp.setHeader("imc", String.format("%.2f", imc));
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }


}