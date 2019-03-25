package br.com.condominio.dto;




import javax.persistence.Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.condominio.domain.Condomino;

public class ContaReceberDTO {

	@Id
	private Integer id;

	@NotNull
	private String condomino;

	@NotNull
	private Double salaoFesta;

	@NotNull
	private Double diversos;

	@NotNull
	private Double devolucoes;

	@NotNull
	private Double consumoGas;

	@NotNull
	private Double servicoPortaria;

	@NotNull
	private Double taxaCondominio;

	@NotNull
	private Double consumoAgua;

	@NotNull
	private Double energiaEletrica;

	@NotNull
	private Double aguaCondominio;

	@NotNull
	private Double taxaExtra;

	@NotNull
	@NotEmpty
	private String nossoNumero;

	private Double totalBoleto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCondomino() {
		return condomino;
	}

	public void setCondomino(String condomino) {
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
