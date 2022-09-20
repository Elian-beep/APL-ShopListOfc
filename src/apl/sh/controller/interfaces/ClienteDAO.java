package apl.sh.controller.interfaces;

import java.util.List;

import apl.sh.model.Cliente;

public interface ClienteDAO {
	void Cadastrar(Cliente cliente);
	void Alterar(Cliente cliente);
	void Excluir(Integer id);
	Cliente ListarUnico(Integer id);
	List<Cliente> ListarTodos();
}
