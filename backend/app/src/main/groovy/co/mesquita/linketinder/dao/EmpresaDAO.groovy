package co.mesquita.linketinder.dao

import co.mesquita.linketinder.entity.Empresa

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class EmpresaDAO {
    private Connection connection;

    public EmpresaDAO() {
        try {
            String DATABASE_URL = "jdbc:postgresql://localhost:5432/linketinder";
            String usuario = "postgres";
            String senha = "stark15";

            this.connection = DriverManager.getConnection(DATABASE_URL, usuario, senha);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Empresa> listar() {
        String sql = "SELECT * FROM empresas";
        List<Empresa> empresas = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                Empresa empresa = new Empresa(result.getInt("id"),
                        result.getString("nome"),
                        result.getString("email"),
                        result.getString("senha"),
                        result.getString("cnpj"),
                        result.getString("pais"),
                        result.getString("cep"),
                        result.getString("descricao"));
                empresas.add(empresa);
            }
        }  catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empresas;
    }

    public boolean inserir(Empresa empresa) {
        String sql = "INSERT INTO empresas (nome, email, senha, cnpj, pais, cep, descricao) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, empresa.getName());
            stmt.setString(2, empresa.getEmail());
            stmt.setString(3, empresa.getSenha());
            stmt.setString(4, empresa.getDocumento());
            stmt.setString(5, empresa.getCountry());
            stmt.setString(6, empresa.getCep());
            stmt.setString(7, empresa.getDescription());

            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean alterar(Empresa empresa, int id) {
        String sql = "UPDATE empresas SET nome=?, email=?, senha=?, cnpj=?, pais=?, cep=?, descricao=? WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, empresa.getName());
            stmt.setString(2, empresa.getEmail());
            stmt.setString(3, empresa.getSenha());
            stmt.setString(4, empresa.getDocumento());
            stmt.setString(5, empresa.getCountry());
            stmt.setString(6, empresa.getCep());
            stmt.setString(7, empresa.getDescription());

            stmt.setInt(8, id);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean remover(int id) {
        String sql = "DELETE FROM empresas WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
