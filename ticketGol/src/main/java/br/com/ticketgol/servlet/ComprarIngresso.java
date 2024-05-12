package br.com.ticketgol.servlet;

import br.com.ticketgol.dao.EventoDAO;
import br.com.ticketgol.model.Eventos;
import br.com.ticketgol.dao.ComprasDAO;
import br.com.ticketgol.model.Compras;
import br.com.ticketgol.dao.ClienteDAO;
import br.com.ticketgol.model.Clientes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/create-compra")

public class ComprarIngresso extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String email = request.getParameter("email");

        // Verifica se algum campo está vazio
        if (email.isEmpty()) {
            System.out.println("Todos os campos devem ser preenchidos");
            request.getRequestDispatcher("compras.html").forward(request, resp);
            return; // Interrompe o fluxo para evitar processamento adicional
        }

        // Se todos os campos estiverem preenchidos e qtdDisponivel for um número válido, continua com o processamento
        Compras compras = new Compras();
        compras.setFk_cliente(email);

        EventoDAO eventodao = new EventoDAO();
        ComprasDAO comprasdao = new ComprasDAO();
        comprasdao.CommprarIngresso(compras);

        request.getRequestDispatcher("JogosADM.jsp").forward(request, resp);
    }
}
