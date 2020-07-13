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
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		String quantidade = request.getParameter("quantidade");
		String valor = request.getParameter("valor");
		
		try {
			Produto produto = new Produto();
			if (id != null && !id.isEmpty())
				produto.setId(Long.parseLong(id));
			produto.setNome(nome);
			produto.setDescricao(descricao);
			
			if (quantidade != null && !quantidade.isEmpty())
				produto.setQuantidade(Integer.parseInt(quantidade));
			if (valor != null && !valor.isEmpty())
				produto.setValor(Double.parseDouble(valor.replace(',', '.')));
			if (nome == null || nome.isEmpty() 
					|| descricao == null || descricao.isEmpty()
					|| quantidade == null || quantidade.isEmpty()
					|| valor == null || valor.isEmpty()) {
				voltarFormProduto(request, response, "null-input");
			} else {
				if (produtoDao.validar(produto.getNome())) {
					String mensagem;
					if (id == null || id.isEmpty()) {
						produtoDao.adicionar(produto);
						mensagem = "Produto " + produto.getNome() + " adicionado com sucesso.";
					} else {
						produtoDao.atualizar(produto);
						mensagem = "Produto " + produto.getNome() + " editado com sucesso.";
					}
					request.setAttribute("sucesso", mensagem);
					listar(request, response);
				} else {
					voltarFormProduto(request, response, "ja-existe");
				}
			}
		} catch (Exception e) {
			voltarFormProduto(request, response, "no-numeric");
		}
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
			Produto produtoEscolhido = produtoDao.consultarPorId(Long.parseLong(id));
			if (produtoEscolhido != null) {
				request.setAttribute("sucesso", "Produto " + produtoEscolhido.getNome() + " deletado com sucesso");
				produtoDao.deletar(Long.parseLong(id));
				listar(request, response);
			} else {
				request.setAttribute("erro", "Esse produto não existe.");
				listar(request, response);
			}
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
	
	private void voltarFormProduto(HttpServletRequest request, HttpServletResponse response, String erro) throws ServletException, IOException {
		if (request.getParameter("id") == null || request.getParameter("id").isEmpty()) {
			response.sendRedirect("produtos?acao=adicionar&erro=" + erro);
		} else {
			response.sendRedirect("produtos?acao=editar&id=" + request.getParameter("id") + "&erro=" + erro);
		}
	}

}
