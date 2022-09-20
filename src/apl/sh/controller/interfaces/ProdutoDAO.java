package apl.sh.controller.interfaces;

import java.util.List;

import apl.sh.model.Produto;

public interface ProdutoDAO {
	public void Cadastrar(Produto produto);
	public void Alterar(Integer id);
	public void Excluir(Integer id);
	public Produto ListarUnico(Integer id);
	public List<Produto> Listartodos();
}
