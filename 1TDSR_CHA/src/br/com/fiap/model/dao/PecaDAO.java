package br.com.fiap.model.dao;
import br.com.fiap.model.dto.Peca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PecaDAO implements IDAO{
    private Connection con;
    private Peca peca;

    public PecaDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public String inserir(Object object) {

        peca = (Peca) object;

        String sql = "insert into sos_peca(id_peca, nome, compatibilidade, estoque) values(?, ?, ?, ?)";

        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, peca.getIdPeca());
            ps.setString(2, peca.getNome());
            ps.setString(3, peca.getCompatibilidade());
            ps.setString(4, peca.getEstoque());

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
        peca = (Peca) object;
        String sql = "update sos_peca set id_peca=?, compatibilidade=?, estoque=? where nome=?";

        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, peca.getIdPeca());
            ps.setString(2, peca.getCompatibilidade());
            ps.setString(3, peca.getEstoque());
            ps.setString(4, peca.getNome());


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

        peca = (Peca) object;

        String sql = "delete from sos_peca where nome=?";

        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setString(1, peca.getNome());

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
        peca = (Peca) object;

        String sql = "select * from sos_peca where nome = ?";

        ResultSet rs = null;
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setString(1, peca.getNome());
            rs = ps.executeQuery();

            if (rs.next()) {
                return "Nome da peça: " + rs.getString("nome")
                        + "\nID_Peca: " + rs.getInt("id_peca")
                        + "\nCompatibilidade: " + rs.getString("compatibilidade")
                        + "\nEstoque: " + rs.getString("estoque");
            } else {
                return "Registro não encontrado!";
            }

        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        } finally {
            // Fechar o ResultSet
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    // Logar o erro
                }
            }
        }
    }
}
