package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;
import util.BancoDados;

public class UsuarioControle {

    public static Usuario BuscarPorID(long idUsuario) {
        try {
            Connection conn = BancoDados.getConexao();
            String sql = "SELECT * FROM tb_usuario WHERE id = ?; ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, idUsuario);
            final ResultSet rs = ps.executeQuery();

            Usuario c = new Usuario();
            if (rs.next()) {
                c.setId(rs.getInt("id"));
                c.setNomeUsuario(rs.getString("nome_usuario"));
                c.setLogin(rs.getString("login"));
                c.setSenha(rs.getString("senha"));
                c.setDataCadastro(rs.getDate("data_cadastro"));
            }
            return c;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static long ExisteUsuario(String login,
            String senha) {

        try {
            Connection conn = BancoDados.getConexao();
            String sql = "SELECT id FROM tb_usuario ";
            sql += " WHERE login = ? ";
            sql += " AND senha = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                long cod = rs.getInt("id");
                if (cod > 0) {
                    return cod;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    
    public static List<Usuario> ListarUsuario() {
        try {

            Connection conn = BancoDados.getConexao();
            String sql = "SELECT * FROM tb_usuario; ";
            PreparedStatement ps = conn.prepareStatement(sql);
            List<Usuario> lista = new ArrayList();
            final ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Usuario p = new Usuario();
                p.setId(rs.getInt("id"));
                p.setNomeUsuario(rs.getString("nome_usuario"));
                lista.add(p);
            }
            return lista;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
