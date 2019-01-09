package br.com.condominio.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.condominio.domain.Condomino;

public class ContaReceberDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_conta_receber_boleto")
	private Integer id;

	@NotNull
	private Condomino condomino;

	@NotNull
	@Column(name = "salao_festa", columnDefinition = "decimal")
	private Double salaoFesta;

	@NotNull
	@Column(columnDefinition = "decimal")
	private Double diversos;

	@NotNull
	@Column(columnDefinition = "decimal")
	private Double devolucoes;

	@NotNull
	@Column(name = "consumo_gas", columnDefinition = "decimal")
	private Double consumoGas;

	@NotNull
	@Column(name = "serv_portaria", columnDefinition = "decimal")
	private Double servicoPortaria;

	@NotNull
	@Column(name = "tx_condominio", columnDefinition = "decimal")
	private Double taxaCondominio;

	@NotNull
	@Column(name = "cons_agua", columnDefinition = "decimal")
	private Double consumoAgua;

	@NotNull
	@Column(name = "energia_eletrica", columnDefinition = "decimal")
	private Double energiaEletrica;

	@NotNull
	@Column(name = "agua_condominio", columnDefinition = "decimal")
	private Double aguaCondominio;

	@NotNull
	@Column(name = "taxa_extra", columnDefinition = "decimal")
	private Double taxaExtra;

	@NotNull
	@NotEmpty
	@Column(name = "nosso_numero")
	private String nossoNumero;

	@Transient
	private Double totalBoleto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Condomino getCondomino() {
		return condomino;
	}

	public void setCondomino(Condomino condomino) {
		this.condomino = condomino;
	}

	public Double getSalaoFesta() {
		return salaoFesta;
	}

	public void setSalaoFesta(Double salaoFesta) {
		this.salaoFesta = salaoFesta;
	}

	public Double getDiversos() {
		return diversos;
	}

	public void setDiversos(Double diversos) {
		this.diversos = diversos;
	}

	public Double getDevolucoes() {
		return devolucoes;
	}

	public void setDevolucoes(Double devolucoes) {
		this.devolucoes = devolucoes;
	}

	public Double getConsumoGas() {
		return consumoGas;
	}

	public void setConsumoGas(Double consumoGas) {
		this.consumoGas = consumoGas;
	}

	public Double getServicoPortaria() {
		return servicoPortaria;
	}

	public void setServicoPortaria(Double servicoPortaria) {
		this.servicoPortaria = servicoPortaria;
	}

	public Double getTaxaCondominio() {
		return taxaCondominio;
	}

	public void setTaxaCondominio(Double taxaCondominio) {
		this.taxaCondominio = taxaCondominio;
	}

	public Double getConsumoAgua() {
		return consumoAgua;
	}

	public void setConsumoAgua(Double consumoAgua) {
		this.consumoAgua = consumoAgua;
	}

	public Double getEnergiaEletrica() {
		return energiaEletrica;
	}

	public void setEnergiaEletrica(Double energiaEletrica) {
		this.energiaEletrica = energiaEletrica;
	}

	public Double getAguaCondominio() {
		return aguaCondominio;
	}

	public void setAguaCondominio(Double aguaCondominio) {
		this.aguaCondominio = aguaCondominio;
	}

	public Double getTaxaExtra() {
		return taxaExtra;
	}

	public void setTaxaExtra(Double taxaExtra) {
		this.taxaExtra = taxaExtra;
	}

	public String getNossoNumero() {
		return nossoNumero;
	}

	public void setNossoNumero(String nossoNumero) {
		this.nossoNumero = nossoNumero;
	}

	public Double getTotalBoleto() {
		return totalBoleto;
	}

	public void setTotalBoleto(Double totalBoleto) {
		this.totalBoleto = totalBoleto;
	}

}
