package br.com.ticketgol.dao;

import br.com.ticketgol.model.Clientes;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public boolean autenticar(String email, String senha) {

        String SQL = "SELECT * FROM CLIENTE WHERE emailCliente = ? AND senhaCliente = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, senha);

            try (ResultSet resultado = preparedStatement.executeQuery()) {
                return resultado.next();
            }

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }

    public boolean verificarEmailExistente(String email) {
        String SQL = "SELECT COUNT(*) FROM CLIENTE WHERE emailCliente = ?";
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, email);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado.next()) {
                int count = resultado.getInt(1);
                return count > 0;
            }
        } catch (Exception e) {
            System.out.println("Erro ao verificar email existente no banco!");
        }
        return false;
    }


}

