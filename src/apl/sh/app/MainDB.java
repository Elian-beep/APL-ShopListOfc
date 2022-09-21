package apl.sh.app;

import apl.sh.controller.config.DaoFactory;
import apl.sh.controller.interfaces.ClienteDAO;
import apl.sh.controller.interfaces.ProdutoDAO;
import apl.sh.controller.interfaces.ProdutoListaDAO;
import apl.sh.controller.interfaces.SupermercadoDAO;
import apl.sh.model.Cliente;
import apl.sh.model.ListaCompra;
import apl.sh.model.Produto;

public class MainDB {

	public static void main(String[] args) {
		// CONTROLLERS[
		ClienteDAO clienteController = DaoFactory.createClienteDAO();
		SupermercadoDAO supermercadoController = DaoFactory.createSupermercadoDAO();
		ProdutoDAO produtoController = DaoFactory.createProdutoDAO();
		ProdutoListaDAO produtoListaController = DaoFactory.createProdutoListaDAO();
	
		//---------------------Cliente---------------------
//		clienteController.Cadastrar(new Cliente(null, "Novo cliente", "92191329", "e@e.com"));
//		clienteController.Alterar(new Cliente(2, "Cliente alterado", "92191329", "e@e.com"));
//		clienteController.Excluir(2);
//		clienteController.Excluir(3);
//		System.out.println("Meus dados:\n"+clienteController.ListarUnico(1));
		
		//---------------------Supermercado----------------
//		System.out.println(supermercadoController.ListarUnico(1));
//		System.out.println(supermercadoController.ListarTodos());
		
		//---------------------Produto---------------------
//		System.out.println(produtoController.Listartodos());
//		System.out.println(produtoController.ListarPorSupermercado(1));
//		System.out.println(produtoController.Listar(2));
		
		//---------------------ProdutoLista----------------
//		Produto prod = produtoController.Listar(1);
//		produtoListaController.Cadastrar(prod);
//		produtoListaController.Excluir(2);
//		System.out.println(produtoListaController.ListarPorSupermercado(1));
//		ListaCompra listaDeCompras = produtoListaController.ListarPorSupermercado(4);
//		listaDeCompras.exibirLista();
	}

}
