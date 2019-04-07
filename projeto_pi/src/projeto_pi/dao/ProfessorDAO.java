package projeto_pi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfessorDAO {
		UsuarioDAO usuario;
		public void criar(Professor professor) {
			usuario.criar(professor);
			String sqlInsert = "INSERT INTO professor(professor_id, administrador, matricula) VALUES (?, ?, ?)";
			try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, professor.getIdProf());
			stm.setInt(2, professor.getAdministrador());
			stm.setString(3, professor.getMatricula());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
			ResultSet rs = stm2.executeQuery();) {
				if(rs.next()){
					professor.setIdUsuario(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		 }
	   }
		
		public Professor carregar(int id) {
			Professor professor = new Professor();
			String sqlSelect = "SELECT nome, email, senha FROM professor WHERE professor.id = ?";
			try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
				stm.setInt(1, id);
				try(ResultSet rs = stm.executeQuery();){
					if(rs.next()) {
						professor.setNome(rs.getString("nome"));
						professor.setEmail(rs.getString("email"));
						professor.setSenha(rs.getString("senha"));
					}else {
						professor.setIdUsuario(-1);
						professor.setNome(null);
						professor.setEmail(null);
						professor.setSenha(null);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}catch (SQLException e1) {
			e1.getStackTrace();
			}
			return professor;
		}
		
		public void atualizar(Professor professor) {
			usuario.atualizar(professor);
			String sqlUpdate = "UPDATE professor SET administrador=?, matricula=? WHERE professor_id=?";
					try (Connection conn = ConnectionFactory.obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
						stm.setInt(1, professor.getAdministrador());
						stm.setString(2, professor.getMatricula());
						stm.setInt(3, professor.getIdUsuario());
						stm.execute();
					} catch (Exception e) {
						e.printStackTrace();
		            }
		 
		}
		
		public void atualizarAdmin(Professor professor) {
			usuario.atualizar(professor);
			String sqlUpdate = "UPDATE professor SET administrador=? WHERE professor_id=?";
					try (Connection conn = ConnectionFactory.obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
						stm.setInt(1, professor.getAdministrador());
						stm.setInt(2, professor.getIdUsuario());
						stm.execute();
					} catch (Exception e) {
						e.printStackTrace();
		            }
		 
		}
		
		public void excluir(Professor professor) {
			String sqlDelete = "DELETE FROM usuario WHERE id=?";
			try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);){
				stm.setInt(1, professor.getIdProf());
				stm.execute();
				usuario.excluir(professor);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public ArrayList<Banca> declararBancas(Professor professor){
			String sqlSelect = "SELECT a.nome, g.nome, p.nome, b.data, b.local FROM professor AS p"
					+ " LEFT JOIN grupo AS g ON p.professor_id = g.orientador_id"
					+ " INNER JOIN turma_aluno AS t ON g.grupo_id = t.grupo_id "
					+ " INNER JOIN aluno AS a ON t.aluno_id = a.aluno_id"
					+ " RIGHT JOIN professor_banca AS r on p.professor_id = b.professor_id"
					+ " RIGHT JOIN banca AS b ON r.banca_id = b.id WHERE professor.id = ?";
			try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
				stm.setInt(1, id);
				try(ResultSet rs = stm.executeQuery();){
					if(rs.next()) {
						
					}else {
						professor.setIdUsuario(-1);
						professor.setNome(null);
						professor.setEmail(null);
						professor.setSenha(null);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}catch (SQLException e1) {
			e1.getStackTrace();
			}
		}
		
}

