package co.mesquita.linketinder.dao

import co.mesquita.linketinder.entity.Candidato

import java.sql.Connection
import java.sql.DriverManager;
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import java.util.logging.Level;
import java.util.logging.Logger;

class CandidatoDAO {
    private Connection connection;

    public CandidatoDAO() {
        try {
            String DATABASE_URL = "jdbc:postgresql://localhost:5432/linketinder";
            String usuario = "postgres";
            String senha = "stark15";

            this.connection = DriverManager.getConnection(DATABASE_URL, usuario, senha);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CandidatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Candidato> listar() {
        String sql = "SELECT * FROM candidatos";
        List<Candidato> candidatos = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
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
                        result.getString("descricao"));
                candidatos.add(candidato);
            }
        }  catch (SQLException ex) {
            Logger.getLogger(CandidatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return candidatos;
    }

    public boolean inserir(Candidato candidato) {
        String sql = "INSERT INTO candidatos (nome, sobrenome, email, senha, cpf, nascimento, pais, cep, descricao) VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, candidato.getName());
            stmt.setString(2, candidato.getSobrenome());
            stmt.setString(3, candidato.getEmail());
            stmt.setString(4, candidato.getSenha());
            stmt.setString(5, candidato.getDocumento());
            stmt.setString(6, candidato.getAge());
            stmt.setString(7, candidato.getEstate());
            stmt.setString(8, candidato.getCep());
            stmt.setString(9, candidato.getDescription());

            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
