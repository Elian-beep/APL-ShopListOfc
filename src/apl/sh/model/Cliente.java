package apl.sh.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {
	private List<ListaCompra> listas = new ArrayList<>();
	
	public Cliente() {}

	public Cliente(Integer id, String nome, String telefone, String email) {
		super(id, nome, telefone, email);
	}

	public List<ListaCompra> getListas() {
		return listas;
	}

	public void adicionarLista(ListaCompra listaCompra) {
		listas.add(listaCompra);
	}

	public void removerLista(ListaCompra listaCompra) {
		listas.remove(listaCompra);
	}

	public void exibirLista() {
			for (ListaCompra listaDaLista : listas) {
				listaDaLista.exibirLista();
				System.out.println();
			}
	}

	@Override
	public String toString() {
		return "Cliente [id=" + super.id + ", nome=" + super.nome + ", telefone=" + super.telefone + ", email="
				+ super.email + "]";
	}
	
	
}
