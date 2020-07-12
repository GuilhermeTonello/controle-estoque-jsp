package tonello.estoque.daos;

import java.util.List;

public interface Dao<T> {
	
	public void atualizar(T t);
	
	public void adicionar(T t);
	
	public void deletar(long id);
	
	public List<T> listar();
	
	public T consultar(long id);
	
}
