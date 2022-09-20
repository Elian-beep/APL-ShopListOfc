package apl.sh.controller.interfaces;

import java.util.List;

import apl.sh.model.Supermercado;

public interface SupermercadoDAO {
	public Supermercado ListarUnico(Integer id);
	public List<Supermercado> ListarTodos();
}
