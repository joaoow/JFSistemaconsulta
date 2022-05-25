package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Consulta;
import util.BancoDados;

public class ConsultaControle {

    public static Consulta BuscarPorID(long idConsulta) {
        try {
            Connection conn = BancoDados.getConexao();
            String sql = "SELECT * FROM tb_consulta WHERE id = ?; ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, idConsulta);
            final ResultSet rs = ps.executeQuery();

            Consulta c = new Consulta();
            if (rs.next()) {
                c.setId(rs.getInt("id"));
                c.setIdmedico(rs.getLong("id_medico"));
                c.setIdpaciente(rs.getLong("id_paciente"));
                c.setIdusuario(rs.getLong("id_usuario"));
                c.setDataEntrada(rs.getDate("data_entrada"));
                c.setDataSaida(rs.getDate("data_saida"));
                c.setValorConsulta(rs.getDouble("valor_consulta"));
                c.setDataCadastro(rs.getDate("data_cadastro"));
            }
            return c;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static boolean Cadastrar(Consulta cat) {
        try {
            Connection conn = BancoDados.getConexao(); //conectar com o bando de dados e enviar os dados salvos da classe Contato.
            String sql = "INSERT INTO tb_consulta ";
            sql += " (id_medico, id_paciente, id_usuario, data_entrada, data_saida, valor_consulta) VALUES (?,?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, cat.getIdmedico());
            ps.setLong(2, cat.getIdpaciente());
            ps.setLong(3, cat.getIdusuario());
            ps.setDate(4, cat.getDataEntrada());
            ps.setDate(5, cat.getDataSaida());
            ps.setDouble(6, cat.getValorConsulta());
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

    public static List<Consulta> ListarConsulta() {
        try {

            Connection conn = BancoDados.getConexao();
            String sql = "SELECT * FROM tb_consulta; ";
            PreparedStatement ps = conn.prepareStatement(sql);
            List<Consulta> lista = new ArrayList();
            final ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Consulta p = new Consulta();
                p.setId(rs.getInt("id"));
                p.setIdmedico(rs.getLong("id_medico"));
                p.setIdpaciente(rs.getLong("id_paciente"));
                p.setIdusuario(rs.getLong("id_usuario"));
                p.setDataEntrada(rs.getDate("data_entrada"));
                p.setDataSaida(rs.getDate("data_saida"));
                p.setValorConsulta(rs.getDouble("valor_consulta"));
                p.setDataCadastro(rs.getDate("data_cadastro"));
                lista.add(p);
            }
            return lista;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public static boolean Atualizar(Consulta cat) {
        try {
            Connection conn = BancoDados.getConexao(); //conectar com o bando de dados e enviar os dados salvos da classe Contato.
            String sql = "UPDATE tb_consulta ";
            sql += " SET id_medico = ?, ";
            sql += " id_paciente = ? ";
            sql += " id_usuario = ? ";
            sql += " data_entrada = ? ";
            sql += " data_saida = ? ";
            sql += " valor_consulta = ? ";
            sql += " WHERE id = ?; ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, cat.getIdmedico());
            ps.setLong(2, cat.getIdpaciente());
            ps.setLong(3, cat.getIdusuario());
            ps.setDate(4, cat.getDataEntrada());
            ps.setDate(5, cat.getDataSaida());
            ps.setDouble(6, cat.getValorConsulta());
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
            String sql = "DELETE FROM tb_Consulta  WHERE id = ?; ";
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
