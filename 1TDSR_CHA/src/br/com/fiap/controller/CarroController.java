package br.com.fiap.controller;

import br.com.fiap.model.dao.CarroDAO;
import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dto.Carro;

import java.sql.Connection;
import java.sql.SQLException;

public class CarroController {

    public String inserirCarro( Integer Id_veiculo, String Placa, Integer cpf, String Modelo) throws ClassNotFoundException, SQLException {

        // Validação da placa
        if (!Placa.matches("[A-Z]{3}-[0-9]{4}")) {
            return "Erro: A placa deve estar no formato AAA-1234.";
        }

        // Validação do CPF
        String cpfString = cpf.toString();
        if (cpfString.length() != 9) {
            return "Erro: O CPF deve ter mais que 8 e menos que 10 dígitos.";
        }

        // Validação do modelo
        if (Modelo == null || Modelo.isEmpty()) {
            return "Erro: O modelo do carro não pode ser vazio.";
        }


        String resultado;

        Connection con = ConnectionFactory.abrirConexao();

        Carro carro = new Carro();
        carro.setIdVeiculo(Id_veiculo);
        carro.setPlacaCarro(Placa);
        carro.setCpf(cpf);


        CarroDAO carroDAO = new CarroDAO(con);
        resultado = carroDAO.inserir(carro);

        // Feche a conexão ANTES do retorno, pois o return encera o algoritmo
        ConnectionFactory.fecharConexao(con);

        return resultado;

    }

    public String alterarCarro(Integer Id_veiculo, String Placa, Integer cpf, String Modelo) throws ClassNotFoundException, SQLException {

        String resultado;

        Connection con = ConnectionFactory.abrirConexao();

        Carro carro = new Carro();
        carro.setIdVeiculo(Id_veiculo);
        carro.setPlacaCarro(Placa);
        carro.setCpf(cpf);
        carro.setModelo(Modelo);

        CarroDAO carroDAO = new CarroDAO(con);
        resultado = carroDAO.alterar(carro);

        // Fechar a conexão ANTES do retorno
        ConnectionFactory.fecharConexao(con);

        return resultado;
    }

    public String excluirCarro(String placa) throws ClassNotFoundException, SQLException {

        String resultado;

        Connection con = ConnectionFactory.abrirConexao();

        Carro carro = new Carro();
        carro.setPlacaCarro(placa);

        CarroDAO carroDAO = new CarroDAO(con);
        resultado = carroDAO.excluir(carro);

        // Feche a conexão ANTES do retorno, pois o return encera o algoritmo
        ConnectionFactory.fecharConexao(con);

        return resultado;

    }

    public String listarUmCarro(String placa) throws ClassNotFoundException, SQLException {

        String resultado;

        Connection con = ConnectionFactory.abrirConexao();

        Carro carro = new Carro();
        carro.setPlacaCarro(placa);

        CarroDAO carroDAO = new CarroDAO(con);
        resultado = carroDAO.listarUm(carro);

        // Feche a conexão ANTES do retorno, pois o return encera o algoritmo
        ConnectionFactory.fecharConexao(con);

        return resultado;

    }

}