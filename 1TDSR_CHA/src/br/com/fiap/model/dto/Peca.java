package br.com.fiap.model.dto;

public class Peca {
    private int IdPeca;
    private String nome;
    private String Compatibilidade;
    private String Estoque;

    public class peca {}

    public int getIdPeca() {
        return IdPeca;
    }

    public void setIdPeca(int idPeca) {
        IdPeca = idPeca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCompatibilidade() {
        return Compatibilidade;
    }

    public void setCompatibilidade(String compatibilidade) {
        Compatibilidade = compatibilidade;
    }

    public String getEstoque() {
        return Estoque;
    }

    public void setEstoque(String estoque) {
        Estoque = estoque;
    }
}
