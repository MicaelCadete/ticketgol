package br.com.ticketgol.model;

public class Clientes {

    private String nomeCliente;
    private String dataDeNascimento;
    private String email;
    private String telefone;
   private String senha;

   public Clientes() {
   }

   public Clientes(String email, String senha) {
      this.email = email;
      this.senha = senha;
   }

   public String getSenha() {
      return senha;
   }

   public void setSenha(String senha) {
      this.senha = senha;
   }

   public String getNomeCliente() {
      return nomeCliente;
   }

   public void setNomeCliente(String nomeCliente) {
      this.nomeCliente = nomeCliente;
   }

   public String getDataDeNascimento() {
      return dataDeNascimento;
   }

   public void setDataDeNascimento(String dataDeNascimento) {
      this.dataDeNascimento = dataDeNascimento;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getTelefone() {
      return telefone;
   }

   public void setTelefone(String telefone) {
      this.telefone = telefone;
   }




}
