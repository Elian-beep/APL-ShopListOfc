package apl.sh.app;

import java.util.List;

import apl.sh.controller.config.DaoFactory;
import apl.sh.controller.interfaces.ClienteDAO;
import apl.sh.controller.interfaces.SupermercadoDAO;
import apl.sh.model.Cliente;
import apl.sh.model.ListaCompra;
import apl.sh.model.Produto;
import apl.sh.model.ProdutoLista;
import apl.sh.model.Supermercado;
import apl.sh.model.services.GeralLista;

public class MainTest {

	public static void main(String[] args) {
		
		
		//SUPERMERCADOS E SEUS PRODUTOS DEVEM EXISTIR NA APLICAÇÃO
		Produto produtoNovinha = new Produto(1, "Arroz", 5.46, 50, 1);
		Produto produtoNovinha2 = new Produto(2, "Macarrão", 3.20, 50, 1);
		Produto produtoDM = new Produto(2, "Arroz", 4.35, 35, 2);
		Produto produtoDM2 = new Produto(2, "Macarrão", 2.90, 35, 2);
		
		//UM CLIENTE DEVE EXISTIR PARA DESENVOLVER A LISTA
		Cliente cliente = new Cliente(null, "usuario teste", "92985878449", "elianoliver101@gmail.com");
		
		//O PRODUTO ESCOLHIDO PARA IR PARA AS LISTAS DEVE SER UM NOVO OBJETO
		ProdutoLista itemNovinha = new ProdutoLista(1, "Arroz", 5.46, 2, 1);
		ProdutoLista itemNovinha2 = new ProdutoLista(2, "Macarrão", 3.20, 1, 1);
		ProdutoLista itemDM = new ProdutoLista(3, "Arroz", 4.35, 2, 1);
		
		//CRIANDO UMA LISTA PARA CADA SUPERMERCADO DIFERENTE
		ListaCompra listaNovinha = new ListaCompra("Novinha");
		listaNovinha.inserirProduto(itemNovinha);
		listaNovinha.inserirProduto(itemNovinha2);
		ListaCompra listaDM = new ListaCompra("DM");
		listaDM.inserirProduto(itemDM);
		
		System.out.println("-------------------EXIBINDO OS PRODUTOS-------------------");
		System.out.println("Lista Novinha: ");
		listaNovinha.exibirLista();
		System.out.println("\nLista DM: ");
		listaDM.exibirLista();
		System.out.println("----------------------------------------------------------");
		
		cliente.adicionarLista(listaNovinha);
		cliente.adicionarLista(listaDM);
		
		System.out.println("-------------------EXIBINDO AS LISTAS-------------------");
		cliente.exibirLista();
		System.out.println("----------------------------------------------------------");
		
		System.out.println("-------------------EXIBINDO O TOTAL DAS LISTAS------------");
		System.out.println("Total Novinha: "+ String.format("%.2f", new GeralLista().valorTotal(listaNovinha)));
		System.out.println("Total DM: "+ String.format("%.2f", new GeralLista().valorTotal(listaDM)));
		System.out.println("----------------------------------------------------------");
	}

}
