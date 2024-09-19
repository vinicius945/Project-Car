package br.com.fiap.model.dao;

import br.com.fiap.model.dto.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {
    private Connection con;
    private Cliente cliente;

    public ClienteDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public String inserir(Object object) {


        cliente = (Cliente) object;

        String sql = "insert into sos_cliente(id_cliente, cpf, nome, genero, motivo_de_contato, veiculo_id_carro) values(?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = getCon().prepareStatement(sql)) {

            ps.setInt(1, cliente.getIdCliente());
            ps.setString(2, cliente.getCPF());
            ps.setString(3, cliente.getNome());
            ps.setString(4, cliente.getGenero());
            ps.setString(5, cliente.getMotivoDeContato());
            ps.setInt(6, cliente.getVeiculoIdCarro());

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


        cliente = (Cliente) object;

        String sql = "update sos_cliente set id_cliente=?, motivo_de_contato=?, nome=?, genero=?,  veiculo_id_carro=? where cpf=?";

        try (PreparedStatement ps = getCon().prepareStatement(sql)) {

            ps.setInt(1, cliente.getIdCliente());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getGenero());
            ps.setString(4, cliente.getMotivoDeContato());

            if (cliente.getVeiculoIdCarro() != null) {
                ps.setInt(5, cliente.getVeiculoIdCarro());
            } else {
                ps.setNull(5, java.sql.Types.INTEGER); // Ou outro tipo conforme o banco
            }

            ps.setString(6, cliente.getCPF());


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


        cliente = (Cliente) object;

        String sql = "delete from sos_cliente where cpf=?";

        try (PreparedStatement ps = getCon().prepareStatement(sql)) {

            ps.setString(1, cliente.getCPF());

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


        cliente = (Cliente) object;

        String sql = "select * from sos_cliente where cpf = ?";

        try (PreparedStatement ps = getCon().prepareStatement(sql)) {

            ps.setString(1, cliente.getCPF());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return "CPF: " + rs.getString("cpf")
                        + "\nID_CLIENTE: " + rs.getInt("id_cliente")
                        + "\nNome: " + rs.getString("nome")
                        + "\nGenero: " + rs.getString("genero")
                        + "\nMotivo de contato: " + rs.getString("motivo_de_contato");
            } else {
                return "Registro não encontrado!";
            }

        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }
}

