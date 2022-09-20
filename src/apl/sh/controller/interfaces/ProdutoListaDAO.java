package apl.sh.controller.interfaces;

import java.util.List;

import apl.sh.model.ProdutoLista;

public interface ProdutoListaDAO {
	public void Cadastrar(ProdutoLista produtoLista);
	public void Excluir(Integer id);
	public List<ProdutoLista> ListarTodos();
}
