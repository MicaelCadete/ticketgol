package br.com.ticketgol.model;

public class Eventos {
    private String nomeEvento;
    private String local;
    private String setor;
    private String data;
    private String valor;
    private String horario;
    private int qtdDisponivel;
    private int id;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Eventos() {
    }


    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getQtdDisponivel() {
        return qtdDisponivel;
    }

    public void setQtdDisponivel(int qtdDisponivel) {
        this.qtdDisponivel = qtdDisponivel;
    }

    public Eventos(String local, String nomeEvento, String setor, String data, String valor, int qtdDisponivel, String horario, int id) {
        this.local = local;
        this.nomeEvento = nomeEvento;
        this.setor = setor;
        this.data = data;
        this.valor = valor;
        this.qtdDisponivel = qtdDisponivel;
        this.horario = horario;
        this.id = id;
    }
}

