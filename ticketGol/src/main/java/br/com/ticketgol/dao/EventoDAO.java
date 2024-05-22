package br.com.ticketgol.dao;

import br.com.ticketgol.model.Clientes;
import br.com.ticketgol.model.Eventos;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EventoDAO {
    public void cadastrarEvento(Eventos evento) {

        String SQL = "INSERT INTO EVENTO (nomeEvento , setor, local , data, qtdDisponivel, horario, valor ) VALUES (?,?,?,?,?,?,?)";
        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, evento.getNomeEvento());
            preparedStatement.setString(2, evento.getSetor());
            preparedStatement.setString(3, evento.getLocal());
            preparedStatement.setString(4, evento.getData());
            preparedStatement.setInt(5, evento.getQtdDisponivel());
            preparedStatement.setString(6, evento.getHorario());
            preparedStatement.setString(7, evento.getValor());

            preparedStatement.execute();

            System.out.println("Sucesso ao gravar o evento no banco!");

        } catch (Exception e) {

            System.out.println("Erro ao gravar o evento no banco!");

        }

    }

    public Eventos buscarEventoPorId(int id) {
        String SQL = "SELECT * FROM EVENTO WHERE idEvento = ?";
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String nomeEvento = resultSet.getString("nomeevento");
                String setor = resultSet.getString("setor");
                String local = resultSet.getString("local");
                String data = resultSet.getString("data");
                String horario = resultSet.getString("horario");
                int qtdDisponivel = resultSet.getInt("qtddisponivel");
                String valor = resultSet.getString("valor");

                return new Eventos(local, nomeEvento, setor, data, valor, qtdDisponivel,horario, id);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar evento por ID: " + e.getMessage());
        }
        return null;
    }

    public List<Eventos> listarDadosEvento() {

        try {

            String SQL = "SELECT * FROM EVENTO";

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Eventos> dadosEvento = new ArrayList<>();

            while (resultSet.next()) {

                int id = resultSet.getInt("idevento");
                String nomeEvento = resultSet.getString("nomeevento");
                String setor = resultSet.getString("setor");
                String local = resultSet.getString("local");
                String data = resultSet.getString("data");
                String horario = resultSet.getString("horario");
                int qtdDisponivel = resultSet.getInt("qtddisponivel");
                String valor = resultSet.getString("valor");

                Eventos dados = new Eventos (local, nomeEvento, setor, data, valor, qtdDisponivel,horario, id);
                dadosEvento.add(dados);
            }
            System.out.println("Sucesso ao resgatar dados dos eventos no DB!");

            return dadosEvento;

        } catch (Exception e) {

            System.out.println("Erro ao consultar os carros no DB!");

        }

        return Collections.emptyList();

    }

    public void comprarIngresso(int idEvento, int quantidade) {
        String SQL = "UPDATE EVENTO SET qtdDisponivel = qtdDisponivel - ? WHERE idEvento = ?";
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, quantidade);
            preparedStatement.setInt(2, idEvento);
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Ingressos comprados com sucesso!");
            } else {
                System.out.println("Não foi possível comprar os ingressos.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao comprar ingressos: " + e.getMessage());
        }
    }

    public void deletarEvento(int id) {
        String SQL = "DELETE FROM EVENTO WHERE idEvento  = ?";
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, id);
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Evento deletado com sucesso!");
            } else {
                System.out.println("Nenhum evento encontrado com o ID fornecido.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar evento: " + e.getMessage());
        }
    }



}
