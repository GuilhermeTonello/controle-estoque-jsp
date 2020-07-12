package tonello.estoque.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		
	}

	@Override
	public void adicionar(Usuario t) {
		
	}

	@Override
	public void deletar(long id) {
		
	}

	@Override
	public List<Usuario> listar() {
		return null;
	}

	@Override
	public Usuario consultar(long id) {
		return null;
	}
	
	public boolean autenticar(Usuario t) {
		String sql = "SELECT login, senha FROM usuarios WHERE login = ? AND senha = ?";
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
