package apl.sh.controller.interfaces;

import java.util.List;

import apl.sh.model.Produto;

public interface ProdutoDAO {
	public Produto Listar(Integer id);
	public List<Produto> ListarPorSupermercado(Integer id);
	public List<Produto> Listartodos();
}
