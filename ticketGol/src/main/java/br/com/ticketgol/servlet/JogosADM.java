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


@WebServlet("/lista-eventos2")
public class JogosADM extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EventoDAO eventos = new EventoDAO();

        List<Eventos> jogos = eventos.listarDadosEvento();

        req.setAttribute("dados", jogos);

        req.getRequestDispatcher("/JogosADM.jsp").forward(req, resp);

    }

}
