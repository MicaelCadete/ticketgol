package br.com.ticketgol.servlet;

import br.com.ticketgol.dao.EventoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ComprarIngresso")
public class ComprarIngresso extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idEvento = Integer.parseInt(request.getParameter("id-evento"));
        System.out.println(idEvento);
        EventoDAO eventoDAO = new EventoDAO();
        eventoDAO.comprarIngresso(idEvento, 1);

        response.sendRedirect("/lista-eventos");
    }
}
