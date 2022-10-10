package co.mesquita.linketinder.dao

import co.mesquita.linketinder.entity.Competencia

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.SQLException
import java.util.logging.Level
import java.util.logging.Logger

class VagasCompetenciasDAO {
    private Connection connection;

    VagasCompetenciasDAO() {
        try {
            String DATABASE_URL = "jdbc:postgresql://localhost:5432/linketinder";
            String usuario = "postgres";
            String senha = "stark15";

            this.connection = DriverManager.getConnection(DATABASE_URL, usuario, senha);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(VagasCompetenciasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean inserir(int id_vaga, int id_competencia) {
        String sql = "INSERT INTO vagas_competencias (id_competencias, id_vagas) VALUES(?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql)
            stmt.setInt(1, id_competencia)
            stmt.setInt(2, id_vaga)

            stmt.execute()
            return true
        } catch (SQLException ex) {
            Logger.getLogger(VagasCompetenciasDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false
        }
    }
}
