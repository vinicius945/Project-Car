package br.com.fiap.model.dto;

public class Mecanico {
    private int IdMecanico;
    private int Cpf;
    private String Nome;
    private String InfContato;
    private int NumPropostaComercial;

    public class mecanico {}

    public int getIdMecanico() {
        return IdMecanico;
    }

    public void setIdMecanico(int idMecanico) {
        IdMecanico = idMecanico;
    }

    public int getCpf() {
        return Cpf;
    }

    public void setCpf(int cpf) {
        Cpf = cpf;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getInfContato() {
        return InfContato;
    }

    public void setInfContato(String infContato) {
        InfContato = infContato;
    }

    public int getNumPropostaComercial() {
        return NumPropostaComercial;
    }

    public void setNumPropostaComercial(int numPropostaComercial) {
        NumPropostaComercial = numPropostaComercial;
    }
}
