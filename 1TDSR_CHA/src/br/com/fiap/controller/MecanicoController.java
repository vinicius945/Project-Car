package br.com.fiap.controller;

import br.com.fiap.model.dao.MecanicoDAO;
import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dto.Mecanico;

import java.sql.Connection;
import java.sql.SQLException;

public class MecanicoController {
    public String validarCpf(String cpf) {
        if (cpf.length() != 9) {
            return "Erro: O CPF deve ter 9 dígitos.";
        }
        return "CPF válido!";
    }

    public String inserirMecanico( Integer Id_mecanico, Integer cpf, String nome, String informacao_de_contato, Integer numero_porposta_comercial) throws ClassNotFoundException, SQLException {

        String validacaoCpf = validarCpf(String.valueOf(cpf));
        if (!validacaoCpf.equals("CPF válido!")) {
            return validacaoCpf;
        }

        String resultado;

        Connection con = ConnectionFactory.abrirConexao();

        Mecanico mecanico = new Mecanico();
        mecanico.setIdMecanico(Id_mecanico);
        mecanico.setCpf(cpf);
        mecanico.setNome(nome);
        mecanico.setInfContato(informacao_de_contato);
        mecanico.setNumPropostaComercial(numero_porposta_comercial);



        MecanicoDAO mecanicoDAO = new MecanicoDAO(con);
        resultado = mecanicoDAO.inserir(mecanico);


        ConnectionFactory.fecharConexao(con);

        return resultado;

    }

    public String alterarMecanico(Integer Id_mecanico, Integer cpf,String nome, String informacao_de_contato, Integer numero_proposta_comercial) throws ClassNotFoundException, SQLException {
        String validacaoCpf = validarCpf(String.valueOf(cpf));
        if (!validacaoCpf.equals("CPF válido!")) {
            return validacaoCpf;
        }

        String resultado;

        Connection con = ConnectionFactory.abrirConexao();

        Mecanico mecanico = new Mecanico();
        mecanico.setIdMecanico(Id_mecanico);
        mecanico.setCpf(cpf);
        mecanico.setNome(nome);
        mecanico.setInfContato(informacao_de_contato);
        mecanico.setNumPropostaComercial(numero_proposta_comercial);

        MecanicoDAO mecanicoDAO = new MecanicoDAO(con);
        resultado = mecanicoDAO.alterar(mecanico);

        // Fechar a conexão ANTES do retorno
        ConnectionFactory.fecharConexao(con);

        return resultado;
    }

    public String excluirMecanico(Integer cpf) throws ClassNotFoundException, SQLException {
        String validacaoCpf = validarCpf(String.valueOf(cpf));
        if (!validacaoCpf.equals("CPF válido!")) {
            return validacaoCpf;
        }

        String resultado;

        Connection con = ConnectionFactory.abrirConexao();

        Mecanico mecanico = new Mecanico();
        mecanico.setCpf(cpf);

        MecanicoDAO mecanicoDAO = new MecanicoDAO(con);
        resultado = mecanicoDAO.excluir(mecanico);


        ConnectionFactory.fecharConexao(con);

        return resultado;

    }

    public String listarUmMecanico(Integer cpf) throws ClassNotFoundException, SQLException {
        String validacaoCpf = validarCpf(String.valueOf(cpf));
        if (!validacaoCpf.equals("CPF válido!")) {
            return validacaoCpf;
        }

        String resultado;

        Connection con = ConnectionFactory.abrirConexao();

        Mecanico mecanico = new Mecanico();
        mecanico.setCpf(cpf);

        MecanicoDAO mecanicoDAO = new MecanicoDAO(con);
        resultado = mecanicoDAO.listarUm(mecanico);


        ConnectionFactory.fecharConexao(con);

        return resultado;

    }
}
