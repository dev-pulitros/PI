package projeto_pi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class AvaliacaoDAO {
	public void criar(Avaliacao avaliacao) {
		String sqlInsert = "INSERT INTO avaliacao(entrega_id, turma_aluno_id, nota, dt_avaliacao, comentarios) VALUES (?, ?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
		stm.setInt(1, avaliacao.getEntregaId());
		stm.setInt(2, avaliacao.getTurmaAlunoId());
		stm.setDouble(3, avaliacao.getNota());
		stm.setDate(4, new Date(avaliacao.getDtAvaliacao().getTime()));
		stm.setString(5, avaliacao.getComentario());
		stm.execute();
		String sqlQuery = "SELECT LAST_INSERT_ID()";
		try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
		ResultSet rs = stm2.executeQuery();) {
			if(rs.next()){
				avaliacao.setAvaliacaoId(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (SQLException e) {
		e.printStackTrace();
	 }
   }
	
	public Avaliacao carregar(int id) {
		Avaliacao avaliacao = new Avaliacao();
		String sqlSelect = "SELECT entrega_id, turma_aluno_id, nota, dt_avaliacao, comentarios FROM avaliacao WHERE avaliacao.id = ?";
		try(Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setInt(1, id);
			try(ResultSet rs = stm.executeQuery();){
				if(rs.next()) {
					avaliacao.setEntregaId(rs.getInt("entrega_id"));
					avaliacao.setTurmaAlunoId(rs.getInt("turma_aluno_id"));
					avaliacao.setNota(rs.getDouble("nota"));
					avaliacao.setDtAvaliacao(rs.getDate("dt_Avaliacao"));
					avaliacao.setComentario(rs.getString("comentarios"));
				}else {
					avaliacao.setAvaliacaoId(-1);
					avaliacao.setEntregaId(-1);
					avaliacao.setTurmaAlunoId(-1);
					avaliacao.setNota(-1);
					avaliacao.setDtAvaliacao(null);
					avaliacao.setComentario(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}catch (SQLException e1) {
		e1.getStackTrace();
		}
		return avaliacao;
	}
	
	public void atualizar(Avaliacao avaliacao) {
		String sqlUpdate = "UPDATE avaliacao SET nota=?, comentarios=? WHERE professor_id=?";
				try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
					stm.setDouble(1, avaliacao.getNota());
					stm.setString(2, avaliacao.getComentario());
					stm.setInt(3, avaliacao.getAvaliacaoId());
					stm.execute();
				} catch (Exception e) {
					e.printStackTrace();
	            }
	 
	}
	
	public void excluir(Avaliacao avaliacao) {
		String sqlDelete = "DELETE FROM usuario WHERE id=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlDelete);){
			stm.setInt(1, avaliacao.getAvaliacaoId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
