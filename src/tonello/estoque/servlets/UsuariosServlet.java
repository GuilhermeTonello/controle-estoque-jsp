package tonello.estoque.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tonello.estoque.daos.UsuarioDao;

@WebServlet("/usuarios")
public class UsuariosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private UsuarioDao usuarioDao = new UsuarioDao();

	public UsuariosServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");
		String id = request.getParameter("id");
		if (acao != null && !acao.isEmpty() && acao.equals("adicionar")) {
			System.out.println("adicionar");
		} else if (acao != null && !acao.isEmpty() && id != null && !id.isEmpty() && acao.equals("deletar")) {
			System.out.println("deletar");
		} else if (acao != null && !acao.isEmpty() && id != null && !id.isEmpty() && acao.equals("editar")) {
			System.out.println("editar");
		} else {
			listar(request, response);
		}
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("usuarios", usuarioDao.listar());
		request.getRequestDispatcher("sistemas/usuarios-pages/usuarios-index.jsp").forward(request, response);
	}

}
