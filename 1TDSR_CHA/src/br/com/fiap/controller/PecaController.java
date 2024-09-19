package br.com.fiap.controller;

import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dao.PecaDAO;
import br.com.fiap.model.dto.Peca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PecaController {

    private boolean validarNome(String nome) {
        return nome != null && !nome.trim().isEmpty();
    }

    private boolean validarCompatibilidade(String compatibilidade) {
        return compatibilidade != null && !compatibilidade.trim().isEmpty();
    }


    public String inserirPeca( Integer Id_peca, String Nome, String Compatibilidade, String Estoque) throws ClassNotFoundException, SQLException {

        if (!validarNome(Nome)) {
            return "Por favor, digite o nome da peça!";
        }
        if (!validarCompatibilidade(Compatibilidade)) {
            return "Por favor, digite sobre a compatibilidade!";
        }

        String resultado;

        Connection con = ConnectionFactory.abrirConexao();

        Peca peca = new Peca();
        peca.setIdPeca(Id_peca);
        peca.setNome(Nome);
        peca.setCompatibilidade(Compatibilidade);
        peca.setEstoque(Estoque);


        PecaDAO pecaDAO = new PecaDAO(con);
        resultado = pecaDAO.inserir(peca);


        ConnectionFactory.fecharConexao(con);

        return resultado;

    }

    public String excluirPeca(String nome) throws ClassNotFoundException, SQLException {

        String resultado;

        Connection con = ConnectionFactory.abrirConexao();

        Peca peca = new Peca();
        peca.setNome(nome);

        PecaDAO pecaDAO = new PecaDAO(con);
        resultado = pecaDAO.excluir(peca);



        ConnectionFactory.fecharConexao(con);

        return resultado;

    }

    public String listarPeca(String nome) throws ClassNotFoundException, SQLException {

        String resultado;

        Connection con = ConnectionFactory.abrirConexao();

        Peca peca = new Peca();

        peca.setNome(nome);

        PecaDAO pecaDAO = new PecaDAO(con);
        resultado = pecaDAO.listarUm(peca);


        ConnectionFactory.fecharConexao(con);

        return resultado;

    }


    public String alterarPeca(Integer Id_peca, String Nome, String Compatibilidade, String Estoque) throws ClassNotFoundException, SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();


        Peca peca = new Peca();
        peca.setIdPeca(Id_peca);
        peca.setNome(Nome);
        peca.setCompatibilidade(Compatibilidade);
        peca.setEstoque(Estoque);

        PecaDAO pecaDAO = new PecaDAO(con);
        resultado = pecaDAO.alterar(peca);


        ConnectionFactory.fecharConexao(con);

        return resultado;
    }
}
