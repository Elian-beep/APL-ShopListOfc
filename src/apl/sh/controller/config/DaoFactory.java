package apl.sh.controller.config;

import apl.sh.controller.ClienteOp;
import apl.sh.controller.SupermercadoOp;
import apl.sh.controller.interfaces.ClienteDAO;
import apl.sh.controller.interfaces.SupermercadoDAO;

public class DaoFactory {
	public static ClienteDAO createClienteDAO() {
		return new ClienteOp(BdConnection.getConnection());
	}
	
	public static SupermercadoDAO createSupermercadoDAO() {
		return new SupermercadoOp(BdConnection.getConnection());
	}
}
