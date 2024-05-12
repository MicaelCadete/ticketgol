package br.com.ticketgol.servlet;

import br.com.ticketgol.dao.EventoDAO;
import br.com.ticketgol.model.Eventos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


    @WebServlet("/lista-eventos")
    public class Jogos extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            EventoDAO carDAO = new EventoDAO();

            List<Eventos> allCars = carDAO.listarDadosEvento();

            req.setAttribute("dados", allCars);

            req.getRequestDispatcher("/Jogos.jsp").forward(req, resp);

        }

    }
