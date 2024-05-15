package br.com.ticketgol.servlet;

import br.com.ticketgol.dao.EventoDAO;
import br.com.ticketgol.model.Clientes;
import br.com.ticketgol.model.Eventos;

import java.io.IOException;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deletar")
public class DeletarEvento extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idEvento = Integer.parseInt(request.getParameter("id"));
        System.out.println(idEvento);
        Eventos evento = new Eventos();
        evento.setId(idEvento);

        EventoDAO excluir = new EventoDAO();

        excluir.deletarEvento(idEvento);
        response.sendRedirect("/lista-eventos2");

    }
}
