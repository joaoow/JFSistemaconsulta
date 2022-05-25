package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Paciente;
import util.BancoDados;

public class PacienteControle {

    public static Paciente BuscarPorID(long idPaciente) {
        try {
            Connection conn = BancoDados.getConexao();
            String sql = "SELECT * FROM tb_paciente WHERE id = ?; ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, idPaciente);
            final ResultSet rs = ps.executeQuery();

            Paciente c = new Paciente();
            if (rs.next()) {
                c.setId(rs.getInt("id"));
                c.setNomeCompleto(rs.getString("nome_completo"));
                c.setNumIdent(rs.getString("num_ident"));
                c.setCpf(rs.getString("cpf"));
                c.setDataNascimento(rs.getDate("data_nascimento"));
                c.setSexo(rs.getString("sexo"));
                c.setDdd(rs.getString("ddd"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("email"));
                c.setDataCadastro(rs.getDate("data_cadastro"));
            }
            return c;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static boolean Cadastrar(Paciente cat) {
        try {
            Connection conn = BancoDados.getConexao(); //conectar com o bando de dados e enviar os dados salvos da classe Contato.
            String sql = "INSERT INTO tb_paciente";
            sql += " (nome_completo, num_ident, cpf, data_nascimento, sexo, ddd, telefone, email) VALUES (?,?,?,?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cat.getNomeCompleto());
            ps.setString(2, cat.getNumIdent());
            ps.setString(3, cat.getCpf());
            ps.setDate(4, cat.getDataNascimento());
            ps.setString(5, cat.getSexo());
            ps.setString(6, cat.getDdd());
            ps.setString(7, cat.getTelefone());
            ps.setString(8, cat.getEmail());
            int linhasafetadas = ps.executeUpdate();
            if (linhasafetadas > 0) {
                final ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    final int lastId = rs.getInt(1);
                    System.out.println("O numero do id é:"
                            + lastId);
                    return true;

                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static List<Paciente> ListarPaciente() {
        try {

            Connection conn = BancoDados.getConexao();
            String sql = "SELECT * FROM tb_paciente; ";
            PreparedStatement ps = conn.prepareStatement(sql);
            List<Paciente> lista = new ArrayList();
            final ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Paciente p = new Paciente();
                p.setId(rs.getInt("id"));
                p.setNomeCompleto(rs.getString("nome_completo"));
                p.setNumIdent(rs.getString("num_ident"));
                p.setCpf(rs.getString("cpf"));
                p.setDataNascimento(rs.getDate("data_nascimento"));
                p.setSexo(rs.getString("sexo"));
                p.setDdd(rs.getString("ddd"));
                p.setTelefone(rs.getString("telefone"));
                p.setDataCadastro(rs.getDate("data_cadastro"));
                lista.add(p);
            }
            return lista;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public static boolean Atualizar(Paciente cat) {
        try {
            Connection conn = BancoDados.getConexao(); //conectar com o bando de dados e enviar os dados salvos da classe Contato.
            String sql = "UPDATE tb_paciente ";
            sql += " SET nome_completo = ?, ";
            sql += " num_ident = ?, ";
            sql += " cpf = ?, ";
            sql += " data_nascimento = ?, ";
            sql += " sexo = ?, ";
            sql += " ddd = ?, ";
            sql += " telefone = ? ";    
            sql += " WHERE id = ?; ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cat.getNomeCompleto());
            ps.setString(2, cat.getNumIdent());
            ps.setString(3, cat.getCpf());
            ps.setDate(4, cat.getDataNascimento());
            ps.setString(5, cat.getSexo());
            ps.setString(6, cat.getDdd());
            ps.setString(7, cat.getTelefone());
            ps.setLong(8, cat.getId());
            int linhasafetadas = ps.executeUpdate();
            if (linhasafetadas > 0) {
                System.out.println("atualizou!");
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        }
    }
    
    public static boolean Excluir(long id) {
        try {
            Connection conn = BancoDados.getConexao(); 
            String sql = "DELETE FROM tb_paciente  WHERE id = ?; ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            int linhasafetadas = ps.executeUpdate();
            if (linhasafetadas > 0) {
                System.out.println("Apagou!!");
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        }
    }

}
