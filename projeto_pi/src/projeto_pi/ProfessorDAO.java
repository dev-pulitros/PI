package projeto_pi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		
		public void declararBancas(Professor professor){
			String sqlSelect = "SELECT b.id, b.data, b.sala FROM professor AS p"
					+ " JOIN professores_banca AS pb ON p.id = pb.Professor_id"
					+ " JOIN banca AS b ON pb.banca_id = b.id"
					+ " WHERE p.id = " + professor.getIdProf()
					+ " GROUP BY p.id";
			try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
				stm.setInt(1, professor.getIdProf());
				try(ResultSet rs = stm.executeQuery();){
					if(rs.next()) {
						Banca banca = new Banca();
						banca.setIdBanca(rs.getInt("b.id"));
						banca.setData(rs.getDate("b.data"));
						banca.setSala(rs.getString("b.sala"));
						professor.listaBanca.add(banca);
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

