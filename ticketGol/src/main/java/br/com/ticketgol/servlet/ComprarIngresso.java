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
        // Obtém o ID do evento da solicitação
        int idEvento = Integer.parseInt(request.getParameter("id-evento"));
        System.out.println(idEvento);
        // Atualiza a quantidade de ingressos disponíveis no banco de dados
        EventoDAO eventoDAO = new EventoDAO();
        eventoDAO.comprarIngresso(idEvento, 1); // Considerando que o usuário comprou apenas 1 ingresso

        // Redireciona para uma página de confirmação de compra
        response.sendRedirect("/lista-eventos");
    }
}
