package br.com.fiap.model.dto;

public class Cliente {
    private  int IdCliente;
    private String CPF;
    private String Nome;
    private String Genero;
    private String motivoDeContato;
    private Integer veiculoIdCarro;

    public class cliente {}

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int idCliente) {
        IdCliente = idCliente;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public String getMotivoDeContato() {
        return motivoDeContato;
    }

    public void setMotivoDeContato(String motivoDeContato) {
        this.motivoDeContato = motivoDeContato;
    }

    public Integer getVeiculoIdCarro() {
        return veiculoIdCarro;
    }

    public void setVeiculoIdCarro(Integer veiculoIdCarro) {
        this.veiculoIdCarro = veiculoIdCarro;
    }
}
