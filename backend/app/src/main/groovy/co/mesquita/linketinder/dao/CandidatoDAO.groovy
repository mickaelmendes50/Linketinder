package co.mesquita.linketinder.dao

import co.mesquita.linketinder.entity.Candidato

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement
import java.util.logging.Level
import java.util.logging.Logger

class CandidatoDAO {
    private Connection connection

    private final String DATABASE_URL = "jdbc:postgresql://localhost:5432/linketinder"
    private final String USUARIO = "postgres"
    private final String SENHA = "stark15"

    CandidatoDAO() {
        try {
            this.connection = DriverManager.getConnection(DATABASE_URL, USUARIO, SENHA)
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CandidatoDAO.class.getName()).log(Level.SEVERE, null, ex)
        }
    }

    List<Candidato> listar() {
        final String SQL_SELECT = "SELECT * FROM candidatos"
        List<Candidato> candidatos = new ArrayList<>()
        try {
            PreparedStatement stmt = connection.prepareStatement(SQL_SELECT)
            ResultSet result = stmt.executeQuery()
            while (result.next()) {
                Candidato candidato = new Candidato(result.getInt("id"),
                        result.getString("nome"),
                        result.getString("sobrenome"),
                        result.getString("email"),
                        result.getString("senha"),
                        result.getString("cpf"),
                        result.getString("nascimento"),
                        result.getString("pais"),
                        result.getString("cep"),
                        result.getString("descricao"))
                candidatos.add(candidato)
            }
        }  catch (SQLException ex) {
            Logger.getLogger(CandidatoDAO.class.getName()).log(Level.SEVERE, null, ex)
        }
        return candidatos
    }

    int inserir(Candidato candidato) {
        final String SQL_INSERT = "INSERT INTO candidatos (nome, sobrenome, email, senha, cpf, nascimento, pais, cep, descricao) VALUES(?,?,?,?,?,?,?,?,?)"
        try {
            PreparedStatement stmt = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)
            stmt.setString(1, candidato.getName())
            stmt.setString(2, candidato.getSobrenome())
            stmt.setString(3, candidato.getEmail())
            stmt.setString(4, candidato.getSenha())
            stmt.setString(5, candidato.getDocumento())
            stmt.setString(6, candidato.getAge())
            stmt.setString(7, candidato.getEstate())
            stmt.setString(8, candidato.getCep())
            stmt.setString(9, candidato.getDescription())

            stmt.execute()
            ResultSet rs = stmt.getGeneratedKeys()
            if (rs.next())
                return rs.getInt("id")
        } catch (SQLException ex) {
            Logger.getLogger(CandidatoDAO.class.getName()).log(Level.SEVERE, null, ex)
            return -1
        }
    }

    boolean alterar(Candidato candidato, int id) {
        final String SQL_UPDATE = "UPDATE candidatos SET nome=?, sobrenome=?, email=?, senha=?, cpf=?, nascimento=?, pais=?, cep=?, descricao=? WHERE id=?"
        try {
            PreparedStatement stmt = connection.prepareStatement(SQL_UPDATE)
            stmt.setString(1, candidato.getName())
            stmt.setString(2, candidato.getSobrenome())
            stmt.setString(3, candidato.getEmail())
            stmt.setString(4, candidato.getSenha())
            stmt.setString(5, candidato.getDocumento())
            stmt.setString(6, candidato.getAge())
            stmt.setString(7, candidato.getEstate())
            stmt.setString(8, candidato.getCep())
            stmt.setString(9, candidato.getDescription())

            stmt.setInt(10, id)
            stmt.execute()
            return true
        } catch (SQLException ex) {
            Logger.getLogger(CandidatoDAO.class.getName()).log(Level.SEVERE, null, ex)
            return false
        }
    }

    boolean remover(int id) {
        final String SQL_DELETE = "DELETE FROM candidatos WHERE id=?"
        try {
            PreparedStatement stmt = connection.prepareStatement(SQL_DELETE)
            stmt.setInt(1, id)
            stmt.execute()
            return true
        } catch (SQLException ex) {
            Logger.getLogger(CandidatoDAO.class.getName()).log(Level.SEVERE, null, ex)
            return false
        }
    }
}
