package br.com.fiap.model.dao;

import br.com.fiap.model.dto.Carro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarroDAO implements IDAO {

    private Connection con;
    private Carro carro;

    public CarroDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public String inserir(Object object) {


        // Conversão implícita -> Converter objeto genérico para carro
        carro = (Carro) object;



        String sql = "insert into sos_veiculo(id_veiculo, placa_carro, cpf, modelo) values(?, ?, ?, ?)";

        try (PreparedStatement ps = getCon().prepareStatement(sql)) {

            ps.setInt(1, carro.getIdVeiculo());
            ps.setString(2, carro.getPlacaCarro());  // Alterado para String
            ps.setInt(3, carro.getCpf());
            ps.setString(4, carro.getModelo());

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


        carro = (Carro) object;

        String sql = "update sos_veiculo set id_veiculo=?, modelo=?, cpf=? where placa_carro=?";

        try (PreparedStatement ps = getCon().prepareStatement(sql)) {

            ps.setInt(1, carro.getIdVeiculo());
            ps.setString(2, carro.getModelo());
            ps.setInt(3, carro.getCpf());
            ps.setString(4, carro.getPlacaCarro());

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


        carro = (Carro) object;

        String sql = "delete from sos_veiculo where placa_carro=?";  // Alterado para placa_carro

        try (PreparedStatement ps = getCon().prepareStatement(sql)) {

            ps.setString(1, carro.getPlacaCarro());  // Alterado para String

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


        carro = (Carro) object;

        String sql = "select * from sos_veiculo where placa_carro = ?";  // Alterado para placa_carro

        try (PreparedStatement ps = getCon().prepareStatement(sql)) {

            ps.setString(1, carro.getPlacaCarro());  // Alterado para String
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return "Placa: " + rs.getString("placa_carro")
                        + "\nID_VEICULO: " + rs.getInt("id_veiculo")
                        + "\nModelo: " + rs.getString("modelo")
                        + "\nCPF: " + rs.getInt("cpf");
            } else {
                return "Registro não encontrado!";
            }

        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }
}