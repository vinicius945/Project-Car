package br.com.fiap.model.dao;

import br.com.fiap.model.dto.Mecanico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MecanicoDAO implements IDAO {

    private Connection con;
    private Mecanico mecanico;

    public MecanicoDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public String inserir(Object object) {


        mecanico = (Mecanico) object;

        String sql = "insert into sos_mecanico(id_mecanico, cpf, nome, informacao_de_contato, numero_proposta_comercial) values(?, ?, ?, ?, ?)";

        try (PreparedStatement ps = getCon().prepareStatement(sql)) {

            ps.setInt(1, mecanico.getIdMecanico());
            ps.setInt(2, mecanico.getCpf());
            ps.setString(3, mecanico.getNome());
            ps.setString(4, mecanico.getInfContato());
            ps.setInt(5, mecanico.getNumPropostaComercial());

            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso!";
            } else {
                return "Erro ao inserir.";
            }

        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }

    public String alterar(Object object) {


        mecanico = (Mecanico) object;

        String sql = "update sos_mecanico set id_mecanico=?, nome, informacao_de_contato, numero_proposta_comercial where cpf=?";

        try (PreparedStatement ps = getCon().prepareStatement(sql)) {

            ps.setInt(1, mecanico.getIdMecanico());
            ps.setString(2, mecanico.getNome());
            ps.setString(3, mecanico.getInfContato());
            ps.setInt(4, mecanico.getNumPropostaComercial());
            ps.setInt(5, mecanico.getCpf());

            if (ps.executeUpdate() > 0) {
                return "Alterado com sucesso!";
            } else {
                return "Erro ao alterar.";
            }

        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }

    public String excluir(Object object) {


        mecanico = (Mecanico) object;

        String sql = "delete from sos_mecanico where cpf=?";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {

            ps.setInt(1, mecanico.getCpf());

            if (ps.executeUpdate() > 0) {
                return "Excluído com sucesso!";
            } else {
                return "Erro ao excluir.";
            }

        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }

    public String listarUm(Object object) {


        mecanico = (Mecanico) object;

        String sql = "select * from sos_mecanico where cpf = ?";

        try (PreparedStatement ps = getCon().prepareStatement(sql)) {

            ps.setInt(1, mecanico.getCpf());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return "Cpf: " + rs.getString("cpf")
                        + "\nID_MECANICO: " + rs.getInt("id_mecanico")
                        + "\nNome: " + rs.getString("nome")
                        +"\nInformação de contato: " + rs.getString("informacao_de_contato") +"\nNumero de proposta comercial: " + rs.getInt("numero_proposta_comercial");

            } else {
                return "Registro não encontrado!";
            }

        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }

}
