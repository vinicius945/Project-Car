package br.com.fiap.controller;

import br.com.fiap.model.dao.AgendamentoDAO;
import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dto.Agendamento;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class AgendamentoController {
    public static String Inserir(Integer Id_agendamento, String cliente, String veiculo, Date data_hora, String tipo_servico) throws ClassNotFoundException, SQLException {

        String resultado;

        Connection con = ConnectionFactory.abrirConexao();

        Agendamento agendamento = new Agendamento();
        agendamento.setIdAgendamento(Id_agendamento);
        agendamento.setCliente(cliente);
        agendamento.setVeiculo(veiculo);
        agendamento.setData(data_hora);
        agendamento.setTipoServico(tipo_servico);


        AgendamentoDAO agendamentoDAO = new AgendamentoDAO(con);
        resultado = agendamentoDAO.inserir(agendamento);

        ConnectionFactory.fecharConexao(con);

        return resultado;

    }
}
