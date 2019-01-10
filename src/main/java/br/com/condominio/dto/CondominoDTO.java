 package br.com.condominio.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import br.com.condominio.domain.Condominio;

public class CondominoDTO {
	
	private Integer id;

	@NotNull
	private String condominio;

	@NotNull(message = "Nome não pode ser nulo")
	@NotEmpty(message = "Nome não pode ser vazio")
	private String nome;

	@NotNull(message = " CPF não pode ser nulo")
	@NotEmpty(message = "CPF não pode ser vazio")
	@CPF
	private String cpf;

	@NotNull(message = "A identificação da unidade não pode ser nula")
	@NotEmpty(message = "A identificação da unidade não pode ser vazia")
	private String identificacaoUnidade;

	public String getCondominio() {
		return condominio;
	}

	public void setCondominio(String condominio) {
		this.condominio = condominio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getIdentificacaoUnidade() {
		return identificacaoUnidade;
	}

	public void setIdentificacaoUnidade(String identificacaoUnidade) {
		this.identificacaoUnidade = identificacaoUnidade;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
}
