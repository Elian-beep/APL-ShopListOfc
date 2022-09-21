package apl.sh.view;

import java.util.Locale;
import java.util.Scanner;

import apl.sh.controller.config.DaoFactory;
import apl.sh.controller.interfaces.ClienteDAO;

public class ClienteArea {
	Scanner sc = new Scanner(System.in);
	ClienteDAO clienteController = new DaoFactory().createClienteDAO();
	
	public void menuPrincipal() {
		int opc = 0;
		limparConsole();
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
			//Menu dos Restaurantes
			break;
		case 9:
			limparConsole();
			System.out.println("PROGRAMA ENCERRADO");
			return;
		default:
			//LIMPAR TERMINAL
			System.out.println("OPÇÃO INVÁLIDA, DIGITE NOVEMENTE");
			menuPrincipal();
		}
	}
	
	public void exibirDadosCliente() {
		System.out.println(clienteController.ListarUnico(1));
		System.out.printf("\nVoltar [y]: ");
		char opc = sc.next().charAt(0);
		if (opc == 'y') {
			limparConsole();
			menuPrincipal();
		}
	}
	
	public void limparConsole() {
		for (int i = 0; i < 50; ++i)
			System.out.println();
	}
	
}
