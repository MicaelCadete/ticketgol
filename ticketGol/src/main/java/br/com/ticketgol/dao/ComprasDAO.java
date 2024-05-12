package br.com.ticketgol.dao;

import br.com.ticketgol.model.Compras;
import br.com.ticketgol.model.Clientes;
import br.com.ticketgol.model.Eventos;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComprasDAO
{
    public void CommprarIngresso(Compras compra) {

        String SQL = "INSERT INTO INGRESSOS (fk_Evento, fk_Cliente) VALUES (?,?)";
        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, compra.getFk_Evento());
            preparedStatement.setString(2, compra.getFk_Cliente());

            preparedStatement.execute();

            System.out.println("Sucesso ao comprar o ingresso no banco!");

        } catch (Exception e) {

            System.out.println("Não foi possivel comprar o ingresso no banco!");

        }

    }
    public List<Compras> listarIngressos() {

        try {

            String SQL = "SELECT * FROM INGRESSOS";

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Compras> dadosIngressos = new ArrayList<>();

            while (resultSet.next()) {

                int id = resultSet.getInt("idingresso");
                String nomeEvento = resultSet.getString("fk_evento");
                String email = resultSet.getString("fk_cliente");

                Compras dados = new Compras (nomeEvento, email, id);
                dadosIngressos.add(dados);

            }

            System.out.println("Sucesso ao resgatar dos ingressos no DB!");


            return dadosIngressos;

        } catch (Exception e) {

            System.out.println("Erro ao consultar os ingressos no DB!");

        }

        return Collections.emptyList();

    }

    /*
    Cancelar compra/ingresso
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
    */


}
