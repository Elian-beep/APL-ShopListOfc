package apl.sh.model;

import java.util.ArrayList;
import java.util.List;

public class ListaCompra {
	private List<Produto> produtos = new ArrayList<>();
	
	public ListaCompra() {}

	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public void inserirProduto(Produto produto) {
		produtos.add(produto);
	}
	
	public void removerProduto(Produto produto) {
		produtos.remove(produto);
	}

	public void exibirLista() {
		for (Produto produtoDaLista : produtos) {
			System.out.println(produtoDaLista.getNome()+" - "+produtoDaLista.getValor());
		}
	}
	
	
	
	
}
