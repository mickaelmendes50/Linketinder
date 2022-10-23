package co.mesquita.linketinder.dao

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.SQLException
import java.util.logging.Level
import java.util.logging.Logger

import static co.mesquita.linketinder.repository.Repository.connectRepository

class CandidatosCompetenciasDAO {
    private static Connection connection = connectRepository()

    private static final String SQL_INSERT =
            "INSERT INTO candidatos_competencias (id_candidatos, id_competencias) VALUES(?,?)"

    static boolean inserir(int id_candidato, int id_competencia) {
        try {
            PreparedStatement stmt = connection.prepareStatement(SQL_INSERT)
            stmt.setInt(1, id_candidato)
            stmt.setInt(2, id_competencia)

            stmt.execute()
            return true
        } catch (SQLException ex) {
            Logger.getLogger(CandidatosCompetenciasDAO.class.getName()).log(Level.SEVERE, null, ex)
            return false
        }
    }
}
