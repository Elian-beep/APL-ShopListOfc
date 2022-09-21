package apl.sh.model;

import java.util.Objects;

public class ProdutoLista {
	private Integer id;
	private String nome;
	private Double valor;
	private Integer quantidade;
	private Integer supermercadoId;
	
	public ProdutoLista(Integer id, String nome, Double valor, Integer quantidade,
			Integer supermercadoId) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
		this.supermercadoId = supermercadoId;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nomeProduto) {
		this.nome = nomeProduto;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Integer getSupermercadoId() {
		return supermercadoId;
	}
	public void setSupermercadoId(Integer supermercadoId) {
		this.supermercadoId = supermercadoId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, quantidade, supermercadoId, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoLista other = (ProdutoLista) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(quantidade, other.quantidade) && Objects.equals(supermercadoId, other.supermercadoId)
				&& Objects.equals(valor, other.valor);
	}
	
	
	
}
