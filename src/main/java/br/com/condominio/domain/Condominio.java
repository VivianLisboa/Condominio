package br.com.condominio.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;

@Entity
@Table(name = "condominio")
public class Condominio extends BaseDominio{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_condominio")
	private Integer id;

	@NotNull(message = "Nome não pode ser nulo")
	@NotEmpty(message = "Nome não pode se vazio")
	private String nome;

	@NotNull(message = "CNPJ não pode ser nulo")
	@NotEmpty(message = "CNPJ não pode se vazio")
	@CNPJ
	private String cnpj;

	private String contato;
	private String endereco;

	public Condominio(String nome, String cnpj, String contato) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.contato = contato;
		validarDominio();
	}

	public Condominio(Integer id, String nome, String cnpj, String contato, String endereco) {
		this(nome, cnpj, contato);
		this.id = id;
		this.endereco = endereco;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getContato() {
		return contato;
	}

	public String getEndereco() {
		return endereco;
	}

}
