package co.mesquita.linketinder.dao

import co.mesquita.linketinder.entity.Vaga

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.Statement
import java.sql.ResultSet
import java.sql.SQLException
import java.util.logging.Level
import java.util.logging.Logger

import static co.mesquita.linketinder.repository.Repository.connectRepository

class VagaDAO {
    private static Connection connection = connectRepository()

    private static final String SQL_SELECT =
            "SELECT * FROM vagas"
    private static final String SQL_INSERT =
            "INSERT INTO vagas (id_empresas, nome, descricao, local) VALUES(?,?,?,?)"
    private static final String SQL_UPDATE =
            "UPDATE vagas SET id_empresas=?, nome=?, descricao=?, local=? WHERE id=?"
    private static final String SQL_DELETE =
            "DELETE FROM vagas WHERE id=?"

    static List<Vaga> listar() {
        List<Vaga> vagas = new ArrayList<>()
        try {
            PreparedStatement stmt = connection.prepareStatement(SQL_SELECT)
            ResultSet result = stmt.executeQuery()
            while (result.next()) {
                Vaga vaga = new Vaga(result.getInt("id"),
                        result.getString("id_empresas"),
                        result.getString("nome"),
                        result.getString("descricao"),
                        result.getString("local"))
                vagas.add(vaga)
            }
        }  catch (SQLException ex) {
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex)
        }
        return vagas
    }

    static int inserir(Vaga vaga) {
        try {
            PreparedStatement stmt = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)
            stmt.setInt(1, vaga.getIdEmpresa())
            stmt.setString(2, vaga.getNome())
            stmt.setString(3, vaga.getDescricao())
            stmt.setString(4, vaga.getLocal())

            stmt.execute()
            ResultSet rs = stmt.getGeneratedKeys()
            if (rs.next())
                return rs.getInt("id")
        } catch (SQLException ex) {
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex)
            return -1
        }
    }

    static boolean alterar(Vaga vaga, int id) {
        try {
            PreparedStatement stmt = connection.prepareStatement(SQL_UPDATE)
            stmt.setInt(1, vaga.getIdEmpresa())
            stmt.setString(2, vaga.getNome())
            stmt.setString(3, vaga.getDescricao())
            stmt.setString(4, vaga.getLocal())

            stmt.setInt(5, id)
            stmt.execute()
            return true
        } catch (SQLException ex) {
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex)
            return false
        }
    }

    static boolean remover(int id) {
        try {
            PreparedStatement stmt = connection.prepareStatement(SQL_DELETE)
            stmt.setInt(1, id)
            stmt.execute()
            return true
        } catch (SQLException ex) {
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex)
            return false
        }
    }
}
