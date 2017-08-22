package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Contato;

/**
 *
 * @author 08023674617
 */
public class ContatoDAO {

    private static final ContatoDAO instance = new ContatoDAO();

    private ContatoDAO() {
    }

    public static ContatoDAO getInstance() {
        return instance;
    }

    public void save(Contato contato) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into contato (nome, email)"
                    + " values ('" + contato.getNome() + "', '" + contato.getEmail() + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

    }

    public void alterar(Contato contato) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("UPDATE contato "
                    + " SET nome = '" + contato.getNome() + "', email - '" + contato.getEmail() + "'"
                    + "WHERE codigo = " + contato.getCodigo());
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void excluir(int codigo) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("DELETE FROM contatos WHERE codigo = ?");
            st.setInt(1, codigo);
            st.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public Contato ler(int codigo) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("SELECT * FROM contatos WHERE codigo = ?");
            st.setInt(1, codigo);
            rs = st.executeQuery();

            if (rs.next()) {
                return new Contato(
                        rs.getInt("codigo"),
                        rs.getString("nome"),
                        rs.getString("email")
                );
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return null;
    }

    private void closeResources(Connection conn, Statement st) {
        try {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }

        } catch (SQLException ex) {

        }

    }
}
