package tonello.estoque.filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import tonello.estoque.db.DBManager;
import tonello.estoque.modelos.Usuario;

@WebFilter(urlPatterns = {
		"/layouts/*", "/sistemas/*",
		"/produtos/*", "/usuarios/*",
		"/pesquisar"
})
public class Filtro implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		Usuario usuarioLogado = (Usuario) session.getAttribute("logado");
		if (usuarioLogado == null) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		chain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {
		try {
			DBManager.getConexao().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	
}
