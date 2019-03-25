package br.com.condominio.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "condomino")
public class Condomino extends BaseDominio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_condomino")
	private Integer id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_condominio")
	private Condominio condominio;

	@NotNull(message = "Nome não pode ser nulo")
	@NotEmpty(message = "Nome não pode ser vazio")
	private String nome;

	@NotNull(message = " CPF não pode ser nulo")
	@NotEmpty(message = "CPF não pode ser vazio")
	@CPF
	private String cpf;

	@NotNull(message = "A identificação da unidade não pode ser nula")
	@NotEmpty(message = "A identificação da unidade não pode ser vazia")
	@Column(name = "identif_unidade")
	private String identificacaoUnidade;

	private Condomino() {

	}

	public Condomino(Condominio condominio, String nome, String cpf, String identificacaoUnidade) {
		this.condominio = condominio;
		this.nome = nome;
		this.cpf = cpf;
		this.identificacaoUnidade = identificacaoUnidade;
		validarDominio();
	}

	public Condomino(Integer id, Condominio condominio, String nome, String cpf, String identificacaoUnidade) {
		this(condominio, nome, cpf, identificacaoUnidade);
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

	public String getidentificacaoUnidade() {
		return identificacaoUnidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Condomino other = (Condomino) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

}
