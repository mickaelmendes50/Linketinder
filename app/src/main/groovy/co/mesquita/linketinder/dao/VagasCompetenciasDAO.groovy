package co.mesquita.linketinder.dao

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.SQLException
import java.util.logging.Level
import java.util.logging.Logger

import static co.mesquita.linketinder.repository.Repository.connectRepository

class VagasCompetenciasDAO {
    private static Connection connection = connectRepository()

    private static final String SQL_INSERT =
            "INSERT INTO vagas_competencias (id_competencias, id_vagas) VALUES(?,?)"

    static boolean inserir(int id_vaga, int id_competencia) {
        try {
            PreparedStatement stmt = connection.prepareStatement(SQL_INSERT)
            stmt.setInt(1, id_competencia)
            stmt.setInt(2, id_vaga)

            stmt.execute()
            return true
        } catch (SQLException ex) {
            Logger.getLogger(VagasCompetenciasDAO.class.getName()).log(Level.SEVERE, null, ex)
            return false
        }
    }
}
