package apl.sh.model.services;

import apl.sh.model.ListaCompra;
import apl.sh.model.ProdutoLista;

public class GeralLista {
	
	public double valorTotal(ListaCompra listaCompra) {
		
		double somatorio = 0.0;
		for (ProdutoLista produtos : listaCompra.getProdutos()) {
			somatorio += produtos.getQuantidade() * produtos.getValor();
		}
		return somatorio;
	}
}
