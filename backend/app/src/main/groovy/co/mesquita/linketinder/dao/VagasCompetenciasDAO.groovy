package co.mesquita.linketinder.dao

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.SQLException
import java.util.logging.Level
import java.util.logging.Logger

class VagasCompetenciasDAO {
    private Connection connection

    private final String DATABASE_URL = "jdbc:postgresql://localhost:5432/linketinder"
    private final String USUARIO = "postgres"
    private final String SENHA = "stark15"

    VagasCompetenciasDAO() {
        try {
            this.connection = DriverManager.getConnection(DATABASE_URL, USUARIO, SENHA)
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(VagasCompetenciasDAO.class.getName()).log(Level.SEVERE, null, ex)
        }
    }

    boolean inserir(int id_vaga, int id_competencia) {
        String SQL_INSERT = "INSERT INTO vagas_competencias (id_competencias, id_vagas) VALUES(?,?)"
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
