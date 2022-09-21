package apl.sh.controller.config;

import apl.sh.controller.ClienteOp;
import apl.sh.controller.ProdutoListaOp;
import apl.sh.controller.ProdutoOp;
import apl.sh.controller.SupermercadoOp;
import apl.sh.controller.interfaces.ClienteDAO;
import apl.sh.controller.interfaces.ProdutoDAO;
import apl.sh.controller.interfaces.ProdutoListaDAO;
import apl.sh.controller.interfaces.SupermercadoDAO;

public class DaoFactory {
	public static ClienteDAO createClienteDAO() {
		return new ClienteOp(BdConnection.getConnection());
	}
	
	public static SupermercadoDAO createSupermercadoDAO() {
		return new SupermercadoOp(BdConnection.getConnection());
	}
	
	public static ProdutoDAO createProdutoDAO() {
		return new ProdutoOp(BdConnection.getConnection());
	}
	
	public static ProdutoListaDAO createProdutoListaDAO() {
		return new ProdutoListaOp(BdConnection.getConnection());
	}
}
