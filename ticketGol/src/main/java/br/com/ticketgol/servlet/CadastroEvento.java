package br.com.ticketgol.servlet;

import br.com.ticketgol.dao.ClienteDAO;
import br.com.ticketgol.dao.EventoDAO;
import br.com.ticketgol.model.Clientes;
import br.com.ticketgol.model.Eventos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/create-evento")
public class CadastroEvento extends HttpServlet {

        protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

            String nomeEvento = request.getParameter("nomeEvento");
            String setor = request.getParameter("setor");
            String local = request.getParameter("local");
            String data = request.getParameter("data");
            int qtdDisponivel = Integer.parseInt(request.getParameter("qtdDisponivel"));

            Eventos eventos= new Eventos();

            eventos.setNomeEvento(nomeEvento);
            eventos.setSetor(setor);
            eventos.setLocal(local);
            eventos.setData(data);
            eventos.setQtdDisponivel(qtdDisponivel);

            EventoDAO eventodao = new EventoDAO();
            eventodao.cadastrarEvento(eventos);

            request.getRequestDispatcher("cadastroEventos.html").forward(request, resp);

        }
}
