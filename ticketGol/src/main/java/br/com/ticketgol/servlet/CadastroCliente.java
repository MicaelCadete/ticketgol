package br.com.ticketgol.servlet;


import br.com.ticketgol.dao.ClienteDAO;
import br.com.ticketgol.model.Clientes;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-clientes")
public class CadastroCliente extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        String nomeCliente = request.getParameter("nomeCliente");
        String dataDeNascimento = request.getParameter("dataDeNascimento");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String senha = request.getParameter("senhaCliente");

        Clientes clientes = new Clientes();
        clientes.setNomeCliente(nomeCliente);
        clientes.setDataDeNascimento(dataDeNascimento);
        clientes.setEmail(email);
        clientes.setTelefone(telefone);
        clientes.setSenha(senha);

        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.cadastrarCliente(clientes);

       request.getRequestDispatcher("Login.html").forward(request, resp);

    }

}
