package tonello.estoque.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tonello.estoque.daos.ProdutoDao;
import tonello.estoque.modelos.Produto;

@WebServlet("/produtos")
public class ProdutosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private ProdutoDao produtoDao = new ProdutoDao();

	public ProdutosServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("adicionando/editando produto");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");
		String id = request.getParameter("id");
		if (acao != null && !acao.isEmpty() && acao.equals("adicionar")) {
			request.getRequestDispatcher("sistemas/produtos-pages/form-produto.jsp").forward(request, response);
		} else if (acao != null && !acao.isEmpty() && id != null && !id.isEmpty() && acao.equals("ver")) {
			Produto produtoEscolhido = produtoDao.consultarPorId(Long.parseLong(id));
			if (produtoEscolhido != null) {
				request.setAttribute("produtoEscolhido", produtoEscolhido);
				request.getRequestDispatcher("sistemas/produtos-pages/mostrar-produto.jsp").forward(request, response);
			} else {
				request.setAttribute("erro", "Esse produto não existe.");
				listar(request, response);
			}
		} else if (acao != null && !acao.isEmpty() && id != null && !id.isEmpty() && acao.equals("deletar")) {
			System.out.println("deletar");
		} else if (acao != null && !acao.isEmpty() && id != null && !id.isEmpty() && acao.equals("editar")) {
			Produto produtoEscolhido = produtoDao.consultarPorId(Long.parseLong(id));
			if (produtoEscolhido != null) {
				request.setAttribute("produto", produtoEscolhido);
				request.getRequestDispatcher("sistemas/produtos-pages/form-produto.jsp").forward(request, response);
			} else {
				request.setAttribute("erro", "Esse produto não existe.");
				listar(request, response);
			}
		} else {
			listar(request, response);
		}
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("produtos", produtoDao.listar());
		request.getRequestDispatcher("sistemas/produtos-pages/produtos-index.jsp").forward(request, response);
	}

}
