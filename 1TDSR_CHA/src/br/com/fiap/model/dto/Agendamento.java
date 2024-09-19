package br.com.fiap.model.dto;

import java.util.Date;

public class Agendamento {
    private int IdAgendamento;
    private String cliente;
    private String Veiculo;
    private Date Data;
    private String TipoServico;

    public class agendamento {}

    public int getIdAgendamento() {
        return IdAgendamento;
    }

    public void setIdAgendamento(int idAgendamento) {
        IdAgendamento = idAgendamento;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getVeiculo() {
        return Veiculo;
    }

    public void setVeiculo(String veiculo) {
        Veiculo = veiculo;
    }

    public java.sql.Date getData() {
        return (java.sql.Date) Data;
    }

    public void setData(Date data) {
        Data = data;
    }

    public String getTipoServico() {
        return TipoServico;
    }

    public void setTipoServico(String tipoServico) {
        TipoServico = tipoServico;
    }
}
