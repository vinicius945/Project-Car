package br.com.fiap.model.dao;

import br.com.fiap.model.dto.Problema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProblemaDAO {
    private Connection con;
    private Problema problema;

    public ProblemaDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public String inserir(Object object) {

        problema = (Problema) object;

        String sql = "insert into sos_problema(id_problema, descricao_1, causa_raiz, solucao) values(?, ?, ?, ?)";

        try (PreparedStatement ps = getCon().prepareStatement(sql)) {

            ps.setInt(1, problema.getIdProblema());
            ps.setString(2, problema.getDescricao());  // Alterado para String
            ps.setString(3, problema.getCausaRaiz());
            ps.setString(4, problema.getSolucao());

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
