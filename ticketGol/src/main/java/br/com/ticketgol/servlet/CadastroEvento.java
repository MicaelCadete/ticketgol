package br.com.ticketgol.servlet;

import br.com.ticketgol.dao.EventoDAO;
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
        String horario = request.getParameter("horario");
        String qtdDisponivelStr = request.getParameter("qtdDisponivel");

        if (nomeEvento.isEmpty() || horario.isEmpty() || setor.isEmpty() || local.isEmpty() || data.isEmpty() || qtdDisponivelStr.isEmpty()) {
            System.out.println("Todos os campos devem ser preenchidos");
            request.getRequestDispatcher("CadastroJogos.html").forward(request, resp);
            return;
        }

        int qtdDisponivel;
        try {
            qtdDisponivel = Integer.parseInt(qtdDisponivelStr);
        } catch (NumberFormatException e) {

            System.out.println("Quantidade disponível deve ser um número inteiro");
            request.getRequestDispatcher("CadastroJogos.html").forward(request, resp);
            return;
        }
        Eventos eventos= new Eventos();
        eventos.setSetor(setor);
        eventos.setLocal(local);
        eventos.setNomeEvento(nomeEvento);
        eventos.setData(data);
        eventos.setHorario(horario);
        eventos.setQtdDisponivel(qtdDisponivel);

        EventoDAO eventodao = new EventoDAO();
        eventodao.cadastrarEvento(eventos);

        resp.sendRedirect("/lista-eventos2");
    }
}

