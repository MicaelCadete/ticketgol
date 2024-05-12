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
        String senha = request.getParameter("senhaLogin");

        if (email.isEmpty()) {
            System.out.println("Todos os campos devem ser preenchidos");
            request.getRequestDispatcher("compras.html").forward(request, resp);
            return;
        }

        ClienteDAO verificar = new ClienteDAO();

        if (verificar.autenticar(email, senha)) {
            System.out.println("Usuário autenticado com sucesso!");
            request.getRequestDispatcher("Home.html").forward(request, resp);
        } else {
            System.out.println("Email ou senha incorretos.");
            request.getRequestDispatcher("Login.html").forward(request, resp);
        }

        Compras compras = new Compras();
        compras.setFk_cliente(email);

        ComprasDAO comprasdao = new ComprasDAO();
        comprasdao.CommprarIngresso(compras);

        request.getRequestDispatcher("JogosADM.jsp").forward(request, resp);
    }
}
