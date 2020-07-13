package tonello.estoque.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tonello.estoque.db.DBManager;
import tonello.estoque.modelos.Usuario;

public class UsuarioDao implements Dao<Usuario> {
	
	private Connection conexao = null;
	
	public UsuarioDao() {
		conexao = DBManager.getConexao();
	}
	
	@Override
	public void atualizar(Usuario t) {
		String sql = "UPDATE usuarios SET login = ?, nome = ?, senha = ? WHERE id = ?";
		try (PreparedStatement ps = conexao.prepareStatement(sql)) {
			ps.setString(1, t.getLogin());
			ps.setString(2, t.getNome());
			ps.setString(3, t.getSenha());
			ps.setLong(4, t.getId());
			ps.executeUpdate();
			conexao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conexao.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void adicionar(Usuario t) {
		String sql = "INSERT INTO usuarios(nome, login, senha) VALUES(?, ?, ?)";
		try (PreparedStatement ps = conexao.prepareStatement(sql)) {
			ps.setString(1, t.getNome());
			ps.setString(2, t.getLogin());
			ps.setString(3, t.getSenha());
			ps.executeUpdate();
			conexao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conexao.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public void deletar(long id) {
		String sql = "DELETE FROM usuarios WHERE id = ?";
		try (PreparedStatement ps = conexao.prepareStatement(sql)) {
			ps.setLong(1, id);
			ps.executeUpdate();
			conexao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conexao.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public List<Usuario> listar() {
		String sql = "SELECT * FROM usuarios";
		try (PreparedStatement ps = conexao.prepareStatement(sql)) {
			return consultarTudo(ps.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Usuario> listar(String nome) {
		String sql = "SELECT * FROM usuarios WHERE lower(nome) LIKE lower(?)";
		try (PreparedStatement ps = conexao.prepareStatement(sql)) {
			ps.setString(1, "%" + nome + "%");
			return consultarTudo(ps.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Usuario> consultarTudo(String sql) {
		try (PreparedStatement ps = conexao.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			List<Usuario> usuariosEncontrados = new ArrayList<>();
			while (rs.next()) {
				Usuario usuarioEncontrado = new Usuario();
				usuarioEncontrado.setId(rs.getLong("id"));
				usuarioEncontrado.setNome(rs.getString("nome"));
				usuarioEncontrado.setLogin(rs.getString("login"));
				usuarioEncontrado.setSenha(rs.getString("senha"));
				usuariosEncontrados.add(usuarioEncontrado);
			}
			return usuariosEncontrados;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Usuario consultarPorId(long id) {
		String sql = "SELECT * FROM usuarios WHERE id = ?";
		try (PreparedStatement ps = conexao.prepareStatement(sql)) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Usuario usuarioEncontrado = new Usuario();
				usuarioEncontrado.setId(rs.getLong("id"));
				usuarioEncontrado.setNome(rs.getString("nome"));
				usuarioEncontrado.setLogin(rs.getString("login"));
				usuarioEncontrado.setSenha(rs.getString("senha"));
				return usuarioEncontrado;
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean validar(String t) {
		String sql = "SELECT COUNT(1) AS qtd FROM usuarios WHERE login = ?";
		try (PreparedStatement ps = conexao.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			ps.setString(1, t);
			return rs.getInt("qtd") <= 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean autenticar(Usuario t) {
		String sql = "SELECT login, senha FROM administradores WHERE login = ? AND senha = ?";
		try (PreparedStatement ps = conexao.prepareStatement(sql)) {
			ps.setString(1, t.getLogin());
			ps.setString(2, t.getSenha());
			return ps.executeQuery().next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
