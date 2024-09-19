package br.com.fiap.controller;

import br.com.fiap.model.dao.ProblemaDAO;
import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dto.Problema;

import java.sql.Connection;
import java.sql.SQLException;

public class ProblemaController {

    private boolean validarDescricao(String descricao) {
        return descricao != null && !descricao.trim().isEmpty();
    }

    private boolean validarCausaRaiz(String causaRaiz) {
        return causaRaiz != null && !causaRaiz.trim().isEmpty();
    }

    private boolean validarSolucao(String solucao) {
        return solucao != null && !solucao.trim().isEmpty();
    }

    public String inserir( Integer Id_problema, String descricao_1, String causa_raiz, String solucao) throws ClassNotFoundException, SQLException {

        if (!validarDescricao(descricao_1)) {
            return "Tem que haver descição";
        }
        if (!validarCausaRaiz(causa_raiz)) {
            return "A causa Raiz, não foi informada!.";
        }
        if (!validarSolucao(solucao)) {
            return "A solução não foi informada.";
        }


        String resultado;

        Connection con = ConnectionFactory.abrirConexao();

        Problema problema = new Problema();
        problema.setIdProblema(Id_problema);
        problema.setDescricao(descricao_1);
        problema.setCausaRaiz(causa_raiz);
        problema.setSolucao(solucao);



        ProblemaDAO problemaDAO = new ProblemaDAO(con);
        resultado = problemaDAO.inserir(problema);


        ConnectionFactory.fecharConexao(con);

        return resultado;

    }
}
