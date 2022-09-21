package apl.sh.controller.interfaces;

import java.util.List;

import apl.sh.model.Produto;
import apl.sh.model.ProdutoLista;

public interface ProdutoListaDAO {
	public void Cadastrar(Produto produto);
	public void Excluir(Integer id);
	public List<Produto> ListarPorSupermercado(Integer id);
	public List<Produto> ListarTodos();
}
