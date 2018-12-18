package br.com.condominio.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "condomino")
public class Condomino extends BaseDominio {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="id_condomino")
	private Integer id;
	
	@OneToMany
	@JoinColumn(name = "id_condominio")
	private Condominio condominio;
	
	@NotNull(message ="Nome não pode ser nulo")
	@NotEmpty(message = "Nome não pode ser vazio")
	private String nome;
	
	@NotNull(message = " CPF não pode ser nulo")
	@NotEmpty(message = "CPF não pode ser vazio")
	@CPF
	private String cpf;
	
	@NotNull(message = "A identificação da unidade não pode ser nula")
	@NotEmpty(message = "A identificação da unidade não pode ser vazia")
	private String identifUnidade;

	public Condomino(Condominio condominio,String nome, String cpf, String identifUnidade) {

		this.nome = nome;
		this.cpf = cpf;
		this.identifUnidade = identifUnidade;
		validarDominio();
	}

	public Condomino(Integer id, Condominio condominio,String nome, String cpf, String identifUnidade) {
		this(condominio,nome, cpf, identifUnidade);
		this.id = id;

	}

	public Condominio getCondominio() {
		return condominio;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getIdentifUnidade() {
		return identifUnidade;
	}
	
}
