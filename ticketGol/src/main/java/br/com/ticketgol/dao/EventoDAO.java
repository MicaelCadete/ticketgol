package br.com.ticketgol.dao;

import br.com.ticketgol.model.Clientes;
import br.com.ticketgol.model.Eventos;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EventoDAO {
    public void cadastrarEvento(Eventos evento) {

        String SQL = "INSERT INTO EVENTO (nomeEvento , setor, local , data, qtdDisponivel ) VALUES (?,?,?,?,?)";
        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, evento.getNomeEvento());
            preparedStatement.setString(2, evento.getSetor());
            preparedStatement.setString(3, evento.getLocal());
            preparedStatement.setString(4, evento.getData());
            preparedStatement.setInt(5, evento.getQtdDisponivel());

            preparedStatement.execute();

            System.out.println("Sucesso ao gravar o evento no banco!");

        } catch (Exception e) {

            System.out.println("Erro ao gravar o evento no banco!");

        }

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
                int qtdDisponivel = resultSet.getInt("qtddisponivel");

                Eventos dados = new Eventos (nomeEvento, local, setor, data, qtdDisponivel,id);
                dadosEvento.add(dados);

            }

            System.out.println("Sucesso ao resgatar dados dos eventos no DB!");


            return dadosEvento;

        } catch (Exception e) {

            System.out.println("Erro ao consultar os carros no DB!");

        }

        return Collections.emptyList();

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
