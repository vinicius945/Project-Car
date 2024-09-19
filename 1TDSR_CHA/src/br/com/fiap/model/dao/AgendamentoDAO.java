package br.com.fiap.model.dao;

import br.com.fiap.model.dto.Agendamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AgendamentoDAO {
    private Connection con;
    private Agendamento agendamento;

    public AgendamentoDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public String inserir(Object object) {


        agendamento = (Agendamento) object;

        String sql = "insert into sos_agendamento(id_agendamento, cliente, veiculo, data_hora, tipo_servico) values(?, ?, ?, ?, ?)";

        try (PreparedStatement ps = getCon().prepareStatement(sql)) {

            ps.setInt(1, agendamento.getIdAgendamento());
            ps.setString(2, agendamento.getCliente());
            ps.setString(3, agendamento.getVeiculo());
            ps.setDate(4, agendamento.getData());
            ps.setString(5, ((Agendamento) object).getTipoServico());

            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso!";
            } else {
                return "Erro ao inserir.";
            }

        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }
}
