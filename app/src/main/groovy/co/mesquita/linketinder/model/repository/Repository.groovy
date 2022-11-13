package co.mesquita.linketinder.model.repository

import co.mesquita.linketinder.model.dao.VagasCompetenciasDAO

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.util.logging.Level
import java.util.logging.Logger

class Repository {

    private static Connection connection

    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/linketinder"
    private static final String USER = "postgres"
    private static final String PASSWORD = "stark15"

    static Connection connectRepository() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD)
            return connection
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(VagasCompetenciasDAO.class.getName()).log(Level.SEVERE, null, ex)
        }
    }
}
