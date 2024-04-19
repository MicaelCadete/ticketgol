package br.com.ticketgol.dao;

import br.com.ticketgol.model.Clientes;

import java.sql.*;

public class ClienteDAO {

    public void cadastrarCliente(Clientes clientes) {

        String SQL = "INSERT INTO CLIENTE (nomeCLiente, emailCliente, telefoneCliente, DATANASCIMENTOCLIENTE, senhaCliente) VALUES (?,?,?,?,?)";
        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, clientes.getNomeCliente());
            preparedStatement.setString(2, clientes.getEmail());
            preparedStatement.setString(3, clientes.getTelefone());
            preparedStatement.setString(4, clientes.getDataDeNascimento());
            preparedStatement.setString(5, clientes.getSenha());

            preparedStatement.execute();

            System.out.println("Sucesso ao gravar cliente no banco!");

        } catch (Exception e) {

            System.out.println("Erro ao gravar cliente no banco!");

        }

    }


}
