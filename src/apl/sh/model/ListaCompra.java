package apl.sh.model;

import java.util.ArrayList;
import java.util.List;

public class ListaCompra {
	private String nomeSupermercado;
	private List<ProdutoLista> produtos = new ArrayList<>();
	
	public ListaCompra(String nomeSupermercado) {
		super();
		this.nomeSupermercado = nomeSupermercado;
	}

	public String getNomeSupermercado() {
		return nomeSupermercado;
	}

	public void setNomeSupermercado(String nomeSupermercado) {
		this.nomeSupermercado = nomeSupermercado;
	}

	public List<ProdutoLista> getProdutos() {
		return produtos;
	}
	
	public void inserirProduto(ProdutoLista produtoLista) {
		produtos.add(produtoLista);
	}
	
	public void removerProduto(ProdutoLista produtoLista) {
		produtos.remove(produtoLista);
	}

	public void exibirLista() {
		for (ProdutoLista produtoDaLista : produtos) {
			System.out.println(produtoDaLista.getNomeProduto()+" - "+produtoDaLista.getValor());
		}
	}
	
	
}
