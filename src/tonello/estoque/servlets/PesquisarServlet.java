package tonello.estoque.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tonello.estoque.daos.ProdutoDao;
import tonello.estoque.daos.UsuarioDao;
import tonello.estoque.modelos.Produto;
import tonello.estoque.modelos.Usuario;

@WebServlet("/pesquisar")
public class PesquisarServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo = request.getParameter("tipo");
		String pesquisa = request.getParameter("pesquisa");
		
		if (!pesquisa.trim().isEmpty() && pesquisa != null) {
			if (tipo.equals("produto")) {
				List<Produto> produtosPesquisados = new ProdutoDao().listar(pesquisa);
				request.setAttribute("produtos", produtosPesquisados);
				request.getRequestDispatcher("sistemas/produtos-pages/produtos-index.jsp").forward(request, response);
			} else {
				List<Usuario> usuariosPesquisados = new UsuarioDao().listar(pesquisa);
				request.setAttribute("usuarios", usuariosPesquisados);
				request.getRequestDispatcher("sistemas/usuarios-pages/usuarios-index.jsp").forward(request, response);
			}
		} else {
			response.sendRedirect(tipo.equals("produto") ? "produtos" : "usuarios");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
