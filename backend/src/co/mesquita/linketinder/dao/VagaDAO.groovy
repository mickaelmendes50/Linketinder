package co.mesquita.linketinder.dao

import co.mesquita.linketinder.entity.Vaga

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class VagaDAO {
    private Connection connection;

    public VagaDAO() {
        try {
            String DATABASE_URL = "jdbc:postgresql://localhost:5432/linketinder";
            String usuario = "postgres";
            String senha = "stark15";

            this.connection = DriverManager.getConnection(DATABASE_URL, usuario, senha);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Vaga> listar() {
        String sql = "SELECT * FROM vagas";
        List<Vaga> vagas = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                Vaga vaga = new Vaga(result.getInt("id"),
                        result.getString("id_empresas"),
                        result.getString("nome"),
                        result.getString("descricao"),
                        result.getString("local"));
                vagas.add(vaga);
            }
        }  catch (SQLException ex) {
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vagas;
    }

    public boolean inserir(Vaga vaga) {
        String sql = "INSERT INTO vagas (id_empresas, nome, descricao, local) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, vaga.getIdEmpresa());
            stmt.setString(2, vaga.getNome());
            stmt.setString(3, vaga.getDescricao());
            stmt.setString(4, vaga.getLocal());

            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean alterar(Vaga vaga, int id) {
        String sql = "UPDATE vagas SET id_empresas=?, nome=?, descricao=?, local=? WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, vaga.getIdEmpresa());
            stmt.setString(2, vaga.getNome());
            stmt.setString(3, vaga.getDescricao());
            stmt.setString(4, vaga.getLocal());

            stmt.setInt(5, id);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean remover(int id) {
        String sql = "DELETE FROM vagas WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
