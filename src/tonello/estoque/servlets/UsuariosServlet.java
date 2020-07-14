package tonello.estoque.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tonello.estoque.daos.UsuarioDao;
import tonello.estoque.modelos.Usuario;

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
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Usuario usuario = new Usuario();
		if (id != null && !id.isEmpty())
			usuario.setId(Long.parseLong(id));
		usuario.setNome(nome);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		if (nome == null || nome.isEmpty() 
				|| login == null || login.isEmpty()
				|| senha == null || senha.isEmpty()) {
			voltarFormUsuario(request, response, "null-input");
		} else {
			if (usuarioDao.validar(usuario.getLogin())) {
				String mensagem;
				if (id == null || id.isEmpty()) {
					usuarioDao.adicionar(usuario);
					mensagem = "Usuário " + usuario.getNome() + " adicionado com sucesso.";
				} else {
					usuarioDao.atualizar(usuario);
					mensagem = "Usuário " + usuario.getNome() + " editado com sucesso.";
				}
				request.setAttribute("sucesso", mensagem);
				listar(request, response);
			} else {
				voltarFormUsuario(request, response, "ja-existe");
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");
		String id = request.getParameter("id");
		if (acao != null && !acao.isEmpty() && acao.equals("adicionar")) {
			request.getRequestDispatcher("sistemas/usuarios-pages/form-usuario.jsp").forward(request, response);
		} else if (acao != null && !acao.isEmpty() && id != null && !id.isEmpty() && acao.equals("deletar")) {
			Usuario usuarioEscolhido = usuarioDao.consultarPorId(Long.parseLong(id));
			if (usuarioEscolhido != null) {
				request.setAttribute("sucesso", "Usuário " + usuarioEscolhido.getNome() + " deletado com sucesso");
				usuarioDao.deletar(Long.parseLong(id));
				listar(request, response);
			} else {
				request.setAttribute("erro", "Esse usuário não existe.");
				listar(request, response);
			}
		} else if (acao != null && !acao.isEmpty() && id != null && !id.isEmpty() && acao.equals("editar")) {
			Usuario usuarioEscolhido = usuarioDao.consultarPorId(Long.parseLong(id));
			if (usuarioEscolhido != null) {
				request.setAttribute("usuario", usuarioEscolhido);
				request.getRequestDispatcher("sistemas/usuarios-pages/form-usuario.jsp").forward(request, response);
			} else {
				request.setAttribute("erro", "Esse usuário não existe.");
				listar(request, response);
			}
		} else {
			listar(request, response);
		}
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("usuarios", usuarioDao.listar());
		request.getRequestDispatcher("sistemas/usuarios-pages/usuarios-index.jsp").forward(request, response);
	}
	
	private void voltarFormUsuario(HttpServletRequest request, HttpServletResponse response, String erro) throws ServletException, IOException {
		if (request.getParameter("id") == null || request.getParameter("id").isEmpty()) {
			response.sendRedirect("usuarios?acao=adicionar&erro=" + erro);
		} else {
			response.sendRedirect("usuarios?acao=editar&id=" + request.getParameter("id") + "&erro=" + erro);
		}
	}

}
