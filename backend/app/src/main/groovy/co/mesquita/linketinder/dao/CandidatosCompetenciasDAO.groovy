package co.mesquita.linketinder.dao

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.SQLException
import java.util.logging.Level
import java.util.logging.Logger

class CandidatosCompetenciasDAO {

    private Connection connection;

    CandidatosCompetenciasDAO() {
        try {
            String DATABASE_URL = "jdbc:postgresql://localhost:5432/linketinder";
            String usuario = "postgres";
            String senha = "stark15";

            this.connection = DriverManager.getConnection(DATABASE_URL, usuario, senha);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(VagasCompetenciasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean inserir(int id_candidato, int id_competencia) {
        String sql = "INSERT INTO candidatos_competencias (id_candidatos, id_competencias) VALUES(?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql)
            stmt.setInt(1, id_candidato)
            stmt.setInt(2, id_competencia)

            stmt.execute()
            return true
        } catch (SQLException ex) {
            Logger.getLogger(CandidatosCompetenciasDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false
        }
    }
}
