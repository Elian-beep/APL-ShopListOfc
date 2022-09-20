package apl.sh.model;

public class Produto {
	private Integer id;
	private String nome;
	private Double valor;
	private Integer quantidade;
	private Integer supermercadoId;
	
	public Produto(Integer id, String nome, Double valor, Integer quantidade, Integer supermercadoId) {
		super();
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
	public void setNome(String nome) {
		this.nome = nome;
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
}
