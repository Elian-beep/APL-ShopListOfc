package apl.sh.view;

import java.util.List;
import java.util.Scanner;

import apl.sh.controller.config.DaoFactory;
import apl.sh.controller.interfaces.ClienteDAO;
import apl.sh.controller.interfaces.ProdutoDAO;
import apl.sh.controller.interfaces.ProdutoListaDAO;
import apl.sh.controller.interfaces.SupermercadoDAO;
import apl.sh.model.Cliente;
import apl.sh.model.Produto;
import apl.sh.model.Supermercado;

public class ClienteArea {
	private static final Integer clienteId = 1;
	Scanner sc = new Scanner(System.in);
	ClienteDAO clienteController = new DaoFactory().createClienteDAO();
	SupermercadoDAO supermercadoController = new DaoFactory().createSupermercadoDAO();
	ProdutoDAO produtoController = new DaoFactory().createProdutoDAO();
	ProdutoListaDAO produtoListaController = new DaoFactory().createProdutoListaDAO();
	
	public void menuPrincipal() {
		int opc = 0;
		System.out.println("-----------MENU PRINCIPAL-----------");
		System.out.println("[1] - Meu perfil");
		System.out.println("[2] - Ver supermercados");
		System.out.println("[9] - Fechar programa");
		System.out.printf("-----------> ");
		opc = sc.nextInt();
		sc.nextLine();
		
		switch (opc) {
		case 1:
			limparConsole();
			exibirDadosCliente();
			break;
		case 2:
			limparConsole();
			exibirSupermercados();
			break;
		case 9:
			limparConsole();
			System.out.println("PROGRAMA ENCERRADO");
			return;
		default:
			limparConsole();
			System.out.println("<<OPÇÃO INVÁLIDA, DIGITE NOVEMENTE>>");
			menuPrincipal();
		}
	}
	
	public void exibirDadosCliente() {
		System.out.println("-----------MEU PERFIL-----------");
		System.out.println(clienteController.ListarUnico(clienteId));
		
		System.out.println("\n[1] - Alterar os dados");
		System.out.println("[2] - Voltar");
		System.out.printf("-----------> ");
		int opc = sc.nextInt();
		sc.nextLine();
		
		switch (opc) {
		case 1: 
			limparConsole();
			System.out.println(clienteController.ListarUnico(clienteId));
			
			System.out.printf("\nDigite o novo nome: ");
			String nome = sc.nextLine();
			System.out.printf("Digite o novo telefone: ");
			String telefone = sc.nextLine();
			System.out.printf("Digite o novo email: ");
			String email = sc.nextLine();
			int id = clienteController.ListarUnico(1).getId();
			Cliente cli = new Cliente(id, nome, telefone, email);
			clienteController.Alterar(cli);
			
			limparConsole();
			exibirDadosCliente();
			
			break;
		case 2:
			limparConsole();
			menuPrincipal();
			return;
		default:
			limparConsole();
			System.out.println("<<OPÇÃO INVÁLIDA, DIGITE NOVEMENTE>>");
			exibirDadosCliente();
		}
	}
	
	public void exibirSupermercados() {
		System.out.println("-----------SUPERMERCADOS-----------");
		List<Supermercado> supermercados = supermercadoController.ListarTodos();
		for (Supermercado supermercado : supermercados) {
			System.out.println(supermercado);
		}	
		System.out.println("[999] - Voltar");
		System.out.printf("-----------> ");
		boolean find = false;
		int opc = sc.nextInt();
		sc.nextLine();
		if(opc == 999) {
			limparConsole();
			menuPrincipal();
			return;
		}
		for (Supermercado supermercado : supermercados) {
			if (opc == supermercado.getId()) {
				find = true;
				limparConsole();
				exibirProdutos(opc);
			}
		}
		if (!find) {
			limparConsole();
			System.out.println("<<OPÇÃO INVÁLIDA, DIGITE NOVEMENTE>>");
			exibirSupermercados();
		}
	}
	
	public void exibirProdutos(int supermercadoId) {
		Supermercado supermercado = supermercadoController.ListarUnico(supermercadoId);
		System.out.println("-----------PRODUTOS: "+supermercado.getNome()+"-----------");
		List<Produto> produtos = produtoController.ListarPorSupermercado(supermercadoId);
		for (Produto produto : produtos) {
			System.out.println(produto);
		}
		System.out.println();
		System.out.println("[997] - Adicionar produto à lista");
		System.out.println("[998] - Ver minha lista");
		System.out.println("[999] - Voltar");
		System.out.printf("-----------> ");
		int opc = sc.nextInt();
		sc.nextLine();
		if(opc == 999) {
			limparConsole();
			exibirSupermercados();
			return;
		}
		switch (opc) {
			case 997:
				limparConsole();
				selecionarProduto(supermercadoId);
				break;
			case 998:
				limparConsole();
				exibirLista(supermercadoId);
				break;
			default:
				limparConsole();
				System.out.println("<<OPÇÃO INVÁLIDA, DIGITE NOVEMENTE>>");
				exibirProdutos(supermercadoId);
		};
	}
	
	public void selecionarProduto(int supermercadoId) {
		System.out.println("-----------PRODUTOS-----------");
		List<Produto> produtos = produtoController.ListarPorSupermercado(supermercadoId);
		for (Produto produto : produtos) {
			System.out.println(produto);
		}
		System.out.println();
		System.out.println("-----------SELECIONANDO PRODUTOS-----------");
		System.out.printf("Número do produto: ");
		int produtoId = sc.nextInt();
		sc.nextLine();
		boolean find = false;
		for (Produto produto : produtos) {
			if (produtoId == produto.getId()) {
				find = true;
				System.out.printf("Quantidade: ");
				int quantidade = sc.nextInt();
				sc.nextLine();
				
				Produto produtoEscolhido = produtoController.Listar(produtoId);
				Produto NovoProdutoLista = new Produto(null, produtoEscolhido.getNome(), produtoEscolhido.getValor(), quantidade, produtoEscolhido.getSupermercadoId());
				produtoListaController.Cadastrar(NovoProdutoLista);
				limparConsole();
				
				System.out.println("|PRODUTO ADICIONADO NA LISTA|");
				exibirProdutos(supermercadoId);
			}
		}
		if (!find) {
			limparConsole();
			System.out.println("<<OPÇÃO INVÁLIDA, DIGITE NOVEMENTE>>");
			selecionarProduto(supermercadoId);
		}
	}
	
	public void exibirLista(int supermercadoId) {
		Supermercado supermercado = supermercadoController.ListarUnico(supermercadoId);
		System.out.println("-----------LISTA: "+supermercado.getNome()+"-----------");
		List<Produto> produtos = produtoListaController.ListarPorSupermercado(supermercadoId);
		for (Produto produto : produtos) {
			System.out.println(produto);
		}
		
		System.out.println();
		System.out.println("[997] - Gerar total");
		System.out.println("[998] - Remover item");
		System.out.println("[999] - Voltar");
		System.out.printf("-----------> ");
		int opc = sc.nextInt();
		sc.nextLine();
		if(opc == 999) {
			limparConsole();
			exibirProdutos(supermercadoId);
			return;
		}
		switch (opc) {
		case 997:
			//EXIBIR TOTAL
			break;
		case 998:
			//REMOVER ITEM
			break;
		default:
			limparConsole();
			System.out.println("<<OPÇÃO INVÁLIDA, DIGITE NOVEMENTE>>");
			exibirLista(supermercadoId);
		}
	}
	
	public void limparConsole() {
		for (int i = 0; i < 50; ++i)
			System.out.println();
	}
	
}
