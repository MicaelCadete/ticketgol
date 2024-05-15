package br.com.ticketgol.servlet;

import br.com.ticketgol.dao.ClienteDAO;
import br.com.ticketgol.model.Clientes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
    public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String email = request.getParameter("emailLogin");
        String senha = request.getParameter("senhaLogin");

        ClienteDAO verificar = new ClienteDAO();

        if ("adm".equals(email) && "adm".equals(senha)) {
            System.out.println("Administrador logado!");
            request.getRequestDispatcher("JogosADM.jsp").forward(request, resp);
        } else if (verificar.autenticar(email, senha)) {
            System.out.println("Usuário autenticado com sucesso!");
            request.getRequestDispatcher("Home.html").forward(request, resp);
        } else {
            System.out.println("Email ou senha incorretos.");
            request.getRequestDispatcher("Login.html").forward(request, resp);
        }


    }

}