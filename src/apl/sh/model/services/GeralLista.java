package apl.sh.model.services;

import apl.sh.model.ListaCompra;
import apl.sh.model.Produto;

public class GeralLista {
	
	public double valorTotal(ListaCompra listaCompra) {
		
		double somatorio = 0.0;
		for (Produto produtos : listaCompra.getProdutos()) {
			somatorio += produtos.getQuantidade() * produtos.getValor();
		}
		return somatorio;
	}
}
