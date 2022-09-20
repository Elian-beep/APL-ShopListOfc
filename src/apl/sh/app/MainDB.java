package apl.sh.app;

import apl.sh.controller.config.DaoFactory;
import apl.sh.controller.interfaces.ClienteDAO;
import apl.sh.controller.interfaces.SupermercadoDAO;
import apl.sh.model.Cliente;

public class MainDB {

	public static void main(String[] args) {
		// CONTROLLERS[
		ClienteDAO clienteController = DaoFactory.createClienteDAO();
		SupermercadoDAO supermercadoController = DaoFactory.createSupermercadoDAO();
	
		//---------------------Cliente---------------------
		
		//CADASTRO
//		clienteController.Cadastrar(new Cliente(null, "Novo cliente", "92191329", "e@e.com"));
//		clienteController.Alterar(new Cliente(2, "Cliente alterado", "92191329", "e@e.com"));
//		clienteController.Excluir(2);
//		clienteController.Excluir(3);
//		System.out.println("Meus dados:\n"+clienteController.ListarUnico(1));
		
	}

}
