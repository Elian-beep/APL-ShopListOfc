package apl.sh.model;

import java.util.Objects;

public class ProdutoLista {
	private Integer id;
	private String nomeProduto;
	private Double valor;
	private Integer quantidade;
	private Integer supermercadoId;
	
	public ProdutoLista(Integer id, String nomeProduto, Double valor, Integer quantidade,
			Integer supermercadoId) {
		this.id = id;
		this.nomeProduto = nomeProduto;
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
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
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
		return Objects.hash(id, nomeProduto, quantidade, supermercadoId, valor);
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
		return Objects.equals(id, other.id) && Objects.equals(nomeProduto, other.nomeProduto)
				&& Objects.equals(quantidade, other.quantidade) && Objects.equals(supermercadoId, other.supermercadoId)
				&& Objects.equals(valor, other.valor);
	}
	
	
	
}
