package apl.sh.view;

import java.util.List;
import java.util.Scanner;

import apl.sh.controller.config.DaoFactory;
import apl.sh.controller.interfaces.ClienteDAO;
import apl.sh.controller.interfaces.SupermercadoDAO;
import apl.sh.model.Cliente;
import apl.sh.model.Supermercado;

public class ClienteArea {
	private static final Integer clienteId = 1;
	Scanner sc = new Scanner(System.in);
	ClienteDAO clienteController = new DaoFactory().createClienteDAO();
	SupermercadoDAO supermercadoController = new DaoFactory().createSupermercadoDAO();
	
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
		System.out.println("-----------Supermercados-----------");
		List<Supermercado> supermercados = supermercadoController.ListarTodos();
		for (Supermercado supermercado : supermercados) {
			System.out.println(supermercado);
		}	
		System.out.println("[99] - Voltar");
		System.out.printf("-----------> ");
		int opc = sc.nextInt();
		sc.nextLine();
		
		//EXIBIR PRODUTOS(idEscolhido)
		limparConsole();
		menuPrincipal();
	}
	
	public void limparConsole() {
		for (int i = 0; i < 50; ++i)
			System.out.println();
	}
	
}
