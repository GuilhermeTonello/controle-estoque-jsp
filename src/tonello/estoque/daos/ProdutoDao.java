package tonello.estoque.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tonello.estoque.db.DBManager;
import tonello.estoque.modelos.Produto;

public class ProdutoDao implements Dao<Produto> {
	
	private Connection conexao = null;
	
	public ProdutoDao() {
		conexao = DBManager.getConexao();
	}
	
	@Override
	public void atualizar(Produto t) {
		String sql = "UPDATE produtos SET nome = ?, descricao = ?, quantidade = ?, valor = ? WHERE id = ?";
		try (PreparedStatement ps = conexao.prepareStatement(sql)) {
			ps.setString(1, t.getNome());
			ps.setString(2, t.getDescricao());
			ps.setInt(3, t.getQuantidade());
			ps.setDouble(4, t.getValor());
			ps.setLong(5, t.getId());
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
	public void adicionar(Produto t) {
		String sql = "INSERT INTO produtos(nome, descricao, quantidade, valor) VALUES(?, ?, ?, ?)";
		try (PreparedStatement ps = conexao.prepareStatement(sql)) {
			ps.setString(1, t.getNome());
			ps.setString(2, t.getDescricao());
			ps.setInt(3, t.getQuantidade());
			ps.setDouble(4, t.getValor());
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
		String sql = "DELETE FROM produtos WHERE id = ?";
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
	public List<Produto> listar() {
		String sql = "SELECT * FROM produtos";
		return consultarTudo(sql);
	}
	
	@Override
	public List<Produto> listar(String nome) {
		String sql = "SELECT * FROM produtos WHERE lower(nome) LIKE lower(?)";
		try (PreparedStatement ps = conexao.prepareStatement(sql)) {
			ps.setString(1, "%" + nome + "%");
			return consultarTudo(ps.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Produto> consultarTudo(String sql) {
		try (PreparedStatement ps = conexao.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			List<Produto> produtosEncontrados = new ArrayList<>();
			while (rs.next()) {
				Produto produtoEncontrado = new Produto();
				produtoEncontrado.setId(rs.getLong("id"));
				produtoEncontrado.setNome(rs.getString("nome"));
				produtoEncontrado.setQuantidade(rs.getInt("quantidade"));
				produtoEncontrado.setDescricao(rs.getString("descricao"));
				produtoEncontrado.setValor(rs.getDouble("valor"));
				produtosEncontrados.add(produtoEncontrado);
			}
			return produtosEncontrados;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Produto consultarPorId(long id) {
		String sql = "SELECT * FROM produtos WHERE id = ?";
		try (PreparedStatement ps = conexao.prepareStatement(sql)) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Produto produtoEncontrado = new Produto();
				produtoEncontrado.setId(rs.getLong("id"));
				produtoEncontrado.setNome(rs.getString("nome"));
				produtoEncontrado.setQuantidade(rs.getInt("quantidade"));
				produtoEncontrado.setDescricao(rs.getString("descricao"));
				produtoEncontrado.setValor(rs.getDouble("valor"));
				return produtoEncontrado;
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean validar(String t) {
		String sql = "SELECT COUNT(1) AS qtd FROM usuario WHERE nome = ?";
		try (PreparedStatement ps = conexao.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			ps.setString(1, t);
			return rs.getInt("qtd") <= 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
