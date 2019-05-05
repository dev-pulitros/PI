package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

public class UsuarioDAO {
	public void criar(Usuario usuario) {
		String sqlInsert = "INSERT INTO usuario(nome, email, senha) VALUES (?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
		stm.setString(1, usuario.getNome());
		stm.setString(2, usuario.getEmail());
		stm.setString(3, usuario.getSenha());
		stm.execute();
		String sqlQuery = "SELECT LAST_INSERT_ID()";
		try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
		ResultSet rs = stm2.executeQuery();) {
			if(rs.next()){
				usuario.setIdUsuario(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (SQLException e) {
		e.printStackTrace();
	 }
   }
	
	public void atualizar(Usuario usuario) {
		String sqlUpdate = "UPDATE usuario SET nome=?, email=?, senha=? WHERE id=?";	
				try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
					stm.setString(1, usuario.getNome());
					stm.setString(2, usuario.getEmail());
					stm.setString(3, usuario.getSenha());
					stm.setInt(4, usuario.getIdUsuario());
					stm.execute();
				} catch (Exception e) {
					e.printStackTrace();
	            }
	 
	}
	
	public void excluir(Usuario usuario) {
		String sqlDelete = "DELETE FROM usuario WHERE id=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlDelete);){
			stm.setInt(1, usuario.getIdUsuario());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
