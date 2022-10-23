package co.mesquita.linketinder.dao

import co.mesquita.linketinder.entity.Competencia

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import java.util.logging.Level
import java.util.logging.Logger

class CompetenciaDAO {
    private Connection connection

    private final String DATABASE_URL = "jdbc:postgresql://localhost:5432/linketinder"
    private final String USUARIO = "postgres"
    private final String SENHA = "stark15"

    CompetenciaDAO() {
        try {
            this.connection = DriverManager.getConnection(DATABASE_URL, USUARIO, SENHA)
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CompetenciaDAO.class.getName()).log(Level.SEVERE, null, ex)
        }
    }

    List<Competencia> listar() {
        final String SQL_SELECT = "SELECT * FROM competencias"
        List<Competencia> competencias = new ArrayList<>()
        try {
            PreparedStatement stmt = connection.prepareStatement(SQL_SELECT)
            ResultSet result = stmt.executeQuery()
            while (result.next()) {
                Competencia competencia = new Competencia(result.getInt("id"),
                        result.getString("nome"))
                competencias.add(competencia)
            }
        }  catch (SQLException ex) {
            Logger.getLogger(CompetenciaDAO.class.getName()).log(Level.SEVERE, null, ex)
        }
        return competencias
    }

    boolean inserir(Competencia competencia) {
        final String SQL_INSERT = "INSERT INTO competencias (nome) VALUES(?)"
        try {
            PreparedStatement stmt = connection.prepareStatement(SQL_INSERT)
            stmt.setString(1, competencia.getNome())

            stmt.execute()
            return true
        } catch (SQLException ex) {
            Logger.getLogger(CompetenciaDAO.class.getName()).log(Level.SEVERE, null, ex)
            return false
        }
    }

    boolean alterar(Competencia competencia, int id) {
        final String SQL_UPDATE = "UPDATE competencias SET nome=? WHERE id=?"
        try {
            PreparedStatement stmt = connection.prepareStatement(SQL_UPDATE)
            stmt.setString(1, competencia.getNome())

            stmt.setInt(2, id)
            stmt.execute()
            return true
        } catch (SQLException ex) {
            Logger.getLogger(CompetenciaDAO.class.getName()).log(Level.SEVERE, null, ex)
            return false
        }
    }

    boolean remover(int id) {
        final String SQL_DELETE = "DELETE FROM competencias WHERE id=?"
        try {
            PreparedStatement stmt = connection.prepareStatement(SQL_DELETE)
            stmt.setInt(1, id)
            stmt.execute()
            return true
        } catch (SQLException ex) {
            Logger.getLogger(CompetenciaDAO.class.getName()).log(Level.SEVERE, null, ex)
            return false
        }
    }
}
