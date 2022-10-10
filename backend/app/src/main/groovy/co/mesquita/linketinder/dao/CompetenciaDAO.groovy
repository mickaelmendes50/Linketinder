package co.mesquita.linketinder.dao

import co.mesquita.linketinder.entity.Competencia
import co.mesquita.linketinder.entity.Competencia
import co.mesquita.linketinder.entity.Competencia

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class CompetenciaDAO {
    private Connection connection;

    public CompetenciaDAO() {
        try {
            String DATABASE_URL = "jdbc:postgresql://localhost:5432/linketinder";
            String usuario = "postgres";
            String senha = "stark15";

            this.connection = DriverManager.getConnection(DATABASE_URL, usuario, senha);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CompetenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Competencia> listar() {
        String sql = "SELECT * FROM competencias";
        List<Competencia> competencias = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                Competencia competencia = new Competencia(result.getInt("id"),
                        result.getString("nome"));
                competencias.add(competencia);
            }
        }  catch (SQLException ex) {
            Logger.getLogger(CompetenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return competencias;
    }

    public boolean inserir(Competencia competencia) {
        String sql = "INSERT INTO competencias (nome) VALUES(?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, competencia.getNome());

            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CompetenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean alterar(Competencia competencia, int id) {
        String sql = "UPDATE competencias SET nome=? WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, competencia.getNome());

            stmt.setInt(2, id);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CompetenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean remover(int id) {
        String sql = "DELETE FROM competencias WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CompetenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
