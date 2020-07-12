package tonello.estoque.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
	
	private static final String banco = "jdbc:postgresql://localhost:5432/controle-estoque-jsp?autoReconnect=true";
	private static final String user = "postgres";
	private static final String senha = "admin";
	
	private static Connection conexao = null;
	
	private static void conectar() {
		try {
			if (conexao == null) {
				Class.forName("org.postgresql.Driver");
				conexao = DriverManager.getConnection(banco, user, senha);
				conexao.setAutoCommit(false);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public DBManager() {
		conectar();
	}
	
	static {
		conectar();
	}
	
	public static Connection getConexao() {
		return conexao;
	}
	
}
