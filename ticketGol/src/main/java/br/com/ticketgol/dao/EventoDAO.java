package br.com.ticketgol.dao;

import br.com.ticketgol.model.Clientes;
import br.com.ticketgol.model.Eventos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EventoDAO {
    public void cadastrarEvento(Eventos evento) {

        String SQL = "INSERT INTO EVENTO (nomeEvento, setor, local, data, qtdDisponivel) VALUES (?,?,?,?,?)";
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
}
