package br.com.fiap.model.dto;

public class Carro {
    private  int IdVeiculo;
    private String PlacaCarro;
    private int cpf;
    private String modelo;

    public class carro {}

    public int getIdVeiculo() {
        return IdVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        IdVeiculo = idVeiculo;
    }

    public String getPlacaCarro() {
        return PlacaCarro;
    }

    public void setPlacaCarro(String placaCarro) {
        PlacaCarro = placaCarro;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}