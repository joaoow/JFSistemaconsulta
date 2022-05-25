package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Medico;
import util.BancoDados;

public class MedicoControle {

    public static Medico BuscarPorID(long idMedico) {
        try {
            Connection conn = BancoDados.getConexao();
            String sql = "SELECT * FROM tb_medico WHERE id = ?; ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, idMedico);
            final ResultSet rs = ps.executeQuery();

            Medico c = new Medico();
            if (rs.next()) {
                c.setId(rs.getInt("id"));
                c.setIdEspecialidades(rs.getLong("id_especialidade"));
                c.setNomeCompleto(rs.getString("nome_completo"));
                c.setNumCrm(rs.getString("num_crm"));
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

    public static boolean Cadastrar(Medico cat) {
        try {
            Connection conn = BancoDados.getConexao(); //conectar com o bando de dados e enviar os dados salvos da classe Contato.
            String sql = "INSERT INTO tb_medico";
            sql += " (id_especialidade, nome_completo, num_crm, cpf, data_nascimento, sexo, ddd, telefone) VALUES (?,?,?,?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, cat.getIdEspecialidades());
            ps.setString(2, cat.getNomeCompleto());
            ps.setString(3, cat.getNumCrm());
            ps.setString(4, cat.getCpf());
            ps.setDate(5, cat.getDataNascimento());
            ps.setString(6, cat.getSexo());
            ps.setString(7, cat.getDdd());
            ps.setString(8, cat.getTelefone());
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

    public static List<Medico> ListarMedico() {
        try {

            Connection conn = BancoDados.getConexao();
            String sql = "SELECT * FROM tb_medico; ";
            PreparedStatement ps = conn.prepareStatement(sql);
            List<Medico> lista = new ArrayList();
            final ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Medico p = new Medico();
                p.setId(rs.getInt("id"));
                p.setNomeCompleto(rs.getString("nome_completo"));
                p.setIdEspecialidades(rs.getLong("id_especialidade"));
                p.setCpf(rs.getString("cpf"));
                p.setDataNascimento(rs.getDate("data_nascimento"));
                p.setSexo(rs.getString("sexo"));
                p.setDdd(rs.getString("ddd"));
                p.setTelefone(rs.getString("telefone"));
                p.setNumCrm(rs.getString("num_crm"));
                p.setDataCadastro(rs.getDate("data_cadastro"));
                lista.add(p);
            }
            return lista;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static boolean Atualizar(Medico cat) {
        try {
            Connection conn = BancoDados.getConexao(); //conectar com o bando de dados e enviar os dados salvos da classe Contato.
            String sql = "UPDATE tb_medico ";
            sql += " SET id_especialidade = ?, ";
            sql += " nome_completo = ?, ";
            sql += " num_crm = ?, ";
            sql += " cpf = ?, ";
            sql += " data_nascimento = ?, ";
            sql += " sexo = ?, ";
            sql += " ddd = ?, ";
            sql += " telefone = ? ";
            sql += " WHERE id = ?; "; //2
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, cat.getIdEspecialidades());
            ps.setString(2, cat.getNomeCompleto());
            ps.setString(3, cat.getNumCrm());
            ps.setString(4, cat.getCpf());
            ps.setDate(5, cat.getDataNascimento());
            ps.setString(6, cat.getSexo());
            ps.setString(7, cat.getDdd());
            ps.setString(8, cat.getTelefone());
            ps.setLong(9, cat.getId());
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
            String sql = "DELETE FROM tb_medico  WHERE id = ?; ";
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
