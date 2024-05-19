package br.com.ticketgol.model;

public class Compras {
    private String fk_Evento;
    private String fk_cliente;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Compras() {
    }



    public String getFk_Evento() {
        return fk_Evento;
    }

    public void setFk_Evento(String fk_Evento) {
        this.fk_Evento = fk_Evento;
    }

    public String getFk_Cliente() {
        return fk_cliente;
    }

    public void setFk_cliente(String fk_cliente) {
        this.fk_cliente = fk_cliente;
    }

    public Compras(String fk_Evento, String fk_cliente, int idingresso) {
        this.fk_Evento = fk_Evento;
        this.fk_cliente = fk_cliente;
        this.id = idingresso;
    }
}
