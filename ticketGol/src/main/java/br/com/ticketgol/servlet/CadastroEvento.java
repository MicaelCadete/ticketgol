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
        String qtdDisponivelStr = request.getParameter("qtdDisponivel");

        // Verifica se algum campo está vazio
        if (nomeEvento.isEmpty() || setor.isEmpty() || local.isEmpty() || data.isEmpty() || qtdDisponivelStr.isEmpty()) {
            // Se algum campo estiver vazio, redireciona de volta ao formulário exibindo uma mensagem de erro
            System.out.println("Todos os campos devem ser preenchidos");
            request.getRequestDispatcher("cadastroEventos.html").forward(request, resp);
            return; // Interrompe o fluxo para evitar processamento adicional
        }

        // Verifica se qtdDisponivel é um número válido
        int qtdDisponivel;
        try {
            qtdDisponivel = Integer.parseInt(qtdDisponivelStr);
        } catch (NumberFormatException e) {
            // Se qtdDisponivel não for um número válido, exibe uma mensagem de erro
            System.out.println("Quantidade disponível deve ser um número inteiro");
            request.getRequestDispatcher("cadastroEventos.html").forward(request, resp);
            return; // Interrompe o fluxo para evitar processamento adicional
        }

        // Se todos os campos estiverem preenchidos e qtdDisponivel for um número válido, continua com o processamento
        Eventos eventos= new Eventos();
        eventos.setNomeEvento(nomeEvento);
        eventos.setSetor(setor);
        eventos.setLocal(local);
        eventos.setData(data);
        eventos.setQtdDisponivel(qtdDisponivel);

        EventoDAO eventodao = new EventoDAO();
        eventodao.cadastrarEvento(eventos);

        request.getRequestDispatcher("JogosADM.jsp").forward(request, resp);
    }
}

