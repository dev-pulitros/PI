package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Professor;
import service.UsuarioService;

public class ProfessorDAO {
		UsuarioService usuarioService;
		public ProfessorDAO() {
			usuarioService = new UsuarioService();
		}
		
		
		public void criar(Professor professor) {
			usuarioService.criar(professor);
			String sqlInsert = "INSERT INTO professor(professor_id, administrador, matricula) VALUES (?, ?, ?)";
			try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
				stm.setInt(1, professor.getIdUsuario());
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
		
		public ArrayList<Professor> carregar(int id) {
			Professor professor = new Professor();
			ArrayList<Professor> lista = new ArrayList<Professor>();
			String sqlSelect = "SELECT p.professor_id, u.nome, u.email, p.matricula, u.senha FROM professor p LEFT JOIN usuario u ON p.professor_id = u.id WHERE p.professor_id = ?";
			try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
				stm.setInt(1, id);
				try(ResultSet rs = stm.executeQuery();){
					if(rs.next()) {
						professor.setIdProf(id);
						professor.setNome(rs.getString("nome"));
						professor.setEmail(rs.getString("email"));
						professor.setSenha(rs.getString("senha"));
						professor.setMatricula(rs.getString("matricula"));
						lista.add(professor);
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
			return lista;
		}
		
		/*public Professor login(Professor professor) {
			String sqlSelect = "SELECT "
		}*/
		
		public ArrayList<Professor> carregar() {
			ArrayList<Professor> lista = new ArrayList<>();
			String sqlSelect = "SELECT p.professor_id, u.nome, u.email, p.matricula, u.senha FROM professor p LEFT JOIN usuario u ON p.professor_id = u.id";
			try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
				try(ResultSet rs = stm.executeQuery();){
					while(rs.next()) {
						Professor professor = new Professor();
						professor.setIdProf(rs.getInt("professor_id"));
						professor.setNome(rs.getString("nome"));
						professor.setEmail(rs.getString("email"));
						professor.setSenha(rs.getString("senha"));
						professor.setMatricula(rs.getString("matricula"));
						lista.add(professor);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}catch (SQLException e1) {
			e1.getStackTrace();
			}
			return lista;
		}
		
		public Professor carregarP(int id) {
			Professor professor = new Professor();
			String sqlSelect = "SELECT p.professor_id, u.nome, u.email, p.matricula, u.senha FROM professor p LEFT JOIN usuario u ON p.professor_id = u.id WHERE p.professor_id = ?";
			try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
				stm.setInt(1, id);
				try(ResultSet rs = stm.executeQuery();){
					if(rs.next()) {
						professor.setIdProf(id);
						professor.setNome(rs.getString("nome"));
						professor.setEmail(rs.getString("email"));
						professor.setSenha(rs.getString("senha"));
						professor.setMatricula(rs.getString("matricula"));
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
			usuarioService.atualizar(professor);
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
			usuarioService.atualizar(professor);
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
				usuarioService.excluir(professor);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/*public ArrayList<Banca> declararBancas(Professor professor){
			String sqlSelect = "SELECT b.id, b.data, b.sala FROM professor AS p"
					+ " JOIN professores_banca AS pb ON p.id = pb.Professor_id"
					+ " JOIN banca AS b ON pb.banca_id = b.id"
					+ " GROUP BY p.id";
			try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
				stm.setInt(1, id);
				try(ResultSet rs = stm.executeQuery();){
					if(rs.next()) {
						Banca banca = new Banca();
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
		*/
}

