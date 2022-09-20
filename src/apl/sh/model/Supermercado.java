package apl.sh.model;

public class Supermercado {
	private Integer id;
	private String nome;
	private String cnpj;
	private String endereco;
	private String telefone;
	private String email;
	
	public Supermercado(Integer id, String nome, String cnpj, String endereco, String telefone, String email) {
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
	}
	
	public Supermercado() {
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
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Supermercado [id=" + id + ", nome=" + nome + ", cnpj=" + cnpj + ", endereco=" + endereco + ", telefone="
				+ telefone + ", email=" + email + "]";
	}
	
	
}
