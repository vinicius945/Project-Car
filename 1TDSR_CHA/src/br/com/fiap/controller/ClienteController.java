package br.com.fiap.controller;

import br.com.fiap.model.dao.ClienteDAO;
import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dto.Cliente;

import java.sql.Connection;
import java.sql.SQLException;

public class ClienteController {
    public String validarCpf(String cpf) {
        if (cpf.length() != 9) {
            return "Erro: O CPF deve ter 9 dígitos.";
        }
        return "CPF válido!";
    }

    public String inserirCliente( Integer Id_cliente, String cpf, String nome, String genero, String motivo_de_contato, Integer veiculoIdCarro) throws ClassNotFoundException, SQLException {
        String validacaoCpf = validarCpf(cpf);
        if (!validacaoCpf.equals("CPF válido!")) {
            return validacaoCpf;
        }
        String resultado;

        Connection con = ConnectionFactory.abrirConexao();

        Cliente cliente = new Cliente();
        cliente.setIdCliente(Id_cliente);
        cliente.setCPF(cpf);
        cliente.setNome(nome);
        cliente.setGenero(genero);
        cliente.setMotivoDeContato(motivo_de_contato);
        cliente.setVeiculoIdCarro(veiculoIdCarro);
        ClienteDAO clienteDAO = new ClienteDAO(con);
        resultado = clienteDAO.inserir(cliente);




        ConnectionFactory.fecharConexao(con);

        return resultado;

    }

    public String alterarCliente(Integer Id_cliente, String cpf, String nome, String genero, String motivo_de_contato, Integer veiculoIdCarro) throws ClassNotFoundException, SQLException {
        String validacaoCpf = validarCpf(cpf);
        if (!validacaoCpf.equals("CPF válido!")) {
            return validacaoCpf;
        }

        String resultado;

        Connection con = ConnectionFactory.abrirConexao();

        Cliente cliente = new Cliente();
        cliente.setIdCliente(Id_cliente);
        cliente.setCPF(cpf);
        cliente.setNome(nome);
        cliente.setGenero(genero);
        cliente.setMotivoDeContato(motivo_de_contato);
        cliente.setVeiculoIdCarro(veiculoIdCarro);

        ClienteDAO clienteDAO = new ClienteDAO(con);
        resultado = clienteDAO.alterar(cliente);

        // Fechar a conexão ANTES do retorno
        ConnectionFactory.fecharConexao(con);

        return resultado;
    }

    public String excluirCliente(String cpf) throws ClassNotFoundException, SQLException {
        String validacaoCpf = validarCpf(cpf);
        if (!validacaoCpf.equals("CPF válido!")) {
            return validacaoCpf;
        }

        String resultado;

        Connection con = ConnectionFactory.abrirConexao();

        Cliente cliente = new Cliente();
        cliente.setCPF(cpf);

        ClienteDAO clienteDAO = new ClienteDAO(con);
        resultado = clienteDAO.excluir(cliente);


        ConnectionFactory.fecharConexao(con);

        return resultado;

    }

    public String listarCliente(String cpf) throws ClassNotFoundException, SQLException {
        String validacaoCpf = validarCpf(cpf);
        if (!validacaoCpf.equals("CPF válido!")) {
            return validacaoCpf;
        }
        String resultado;

        Connection con = ConnectionFactory.abrirConexao();


        Cliente cliente = new Cliente();
        cliente.setCPF(cpf);

        ClienteDAO clienteDAO = new ClienteDAO(con);
        resultado = clienteDAO.listarUm(cliente);


        ConnectionFactory.fecharConexao(con);

        return resultado;

    }

}
