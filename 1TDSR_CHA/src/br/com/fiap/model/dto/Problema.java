package br.com.fiap.model.dto;

public class Problema {
    private int IdProblema;
    private String descricao;
    private String causaRaiz;
    private String Solucao;

    public class problema {}

    public int getIdProblema() {
        return IdProblema;
    }

    public void setIdProblema(int idProblema) {
        IdProblema = idProblema;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCausaRaiz() {
        return causaRaiz;
    }

    public void setCausaRaiz(String causaRaiz) {
        this.causaRaiz = causaRaiz;
    }

    public String getSolucao() {
        return Solucao;
    }

    public void setSolucao(String solucao) {
        Solucao = solucao;
    }
}
