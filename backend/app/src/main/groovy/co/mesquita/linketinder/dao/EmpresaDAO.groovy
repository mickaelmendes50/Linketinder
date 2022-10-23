package co.mesquita.linketinder.dao

import co.mesquita.linketinder.entity.Empresa

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import java.util.logging.Level
import java.util.logging.Logger

class EmpresaDAO {
    private Connection connection

    private final String DATABASE_URL = "jdbc:postgresql://localhost:5432/linketinder"
    private final String USUARIO = "postgres"
    private final String SENHA = "stark15"

    EmpresaDAO() {
        try {
            this.connection = DriverManager.getConnection(DATABASE_URL, USUARIO, SENHA)
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex)
        }
    }

    List<Empresa> listar() {
        final String SQL_SELECT = "SELECT * FROM empresas"
        List<Empresa> empresas = new ArrayList<>()
        try {
            PreparedStatement stmt = connection.prepareStatement(SQL_SELECT)
            ResultSet result = stmt.executeQuery()
            while (result.next()) {
                Empresa empresa = new Empresa(result.getInt("id"),
                        result.getString("nome"),
                        result.getString("email"),
                        result.getString("senha"),
                        result.getString("cnpj"),
                        result.getString("pais"),
                        result.getString("cep"),
                        result.getString("descricao"))
                empresas.add(empresa)
            }
        }  catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex)
        }
        return empresas
    }

    boolean inserir(Empresa empresa) {
        final String SQL_INSERT = "INSERT INTO empresas (nome, email, senha, cnpj, pais, cep, descricao) VALUES(?,?,?,?,?,?,?)"
        try {
            PreparedStatement stmt = connection.prepareStatement(SQL_INSERT)
            stmt.setString(1, empresa.getName())
            stmt.setString(2, empresa.getEmail())
            stmt.setString(3, empresa.getSenha())
            stmt.setString(4, empresa.getDocumento())
            stmt.setString(5, empresa.getCountry())
            stmt.setString(6, empresa.getCep())
            stmt.setString(7, empresa.getDescription())

            stmt.execute()
            return true
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex)
            return false
        }
    }

    boolean alterar(Empresa empresa, int id) {
        final String SQL_UPDATE = "UPDATE empresas SET nome=?, email=?, senha=?, cnpj=?, pais=?, cep=?, descricao=? WHERE id=?"
        try {
            PreparedStatement stmt = connection.prepareStatement(SQL_UPDATE)
            stmt.setString(1, empresa.getName())
            stmt.setString(2, empresa.getEmail())
            stmt.setString(3, empresa.getSenha())
            stmt.setString(4, empresa.getDocumento())
            stmt.setString(5, empresa.getCountry())
            stmt.setString(6, empresa.getCep())
            stmt.setString(7, empresa.getDescription())

            stmt.setInt(8, id)
            stmt.execute()
            return true
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex)
            return false
        }
    }

    boolean remover(int id) {
        final String SQL_DELETE = "DELETE FROM empresas WHERE id=?"
        try {
            PreparedStatement stmt = connection.prepareStatement(SQL_DELETE)
            stmt.setInt(1, id)
            stmt.execute()
            return true
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex)
            return false
        }
    }
}
