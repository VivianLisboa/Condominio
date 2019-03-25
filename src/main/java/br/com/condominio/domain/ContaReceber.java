package br.com.condominio.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "conta_receber_boleto")
public class ContaReceber extends BaseDominio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_conta_receber_boleto")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_condomino")
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
	
	@Column(name = "total_Boleto")
	private Double totalBoleto;

	private ContaReceber(){
		
	}

	public ContaReceber(Condomino condomino, Double salaoFesta, Double diversos, Double devolucoes, Double consumoGas,
			Double servicoPortaria, Double taxaCondominio, Double consumoAgua, Double energiaEletrica,
			Double aguaCondominio, Double taxaExtra,String nossoNumero,Double totalBoleto) {

		this.condomino = condomino;
		this.salaoFesta = salaoFesta;
		this.diversos = diversos;
		this.devolucoes = devolucoes;
		this.consumoGas = consumoGas;
		this.servicoPortaria = servicoPortaria;
		this.taxaCondominio = taxaCondominio;
		this.consumoAgua = consumoAgua;
		this.energiaEletrica = energiaEletrica;
		this.aguaCondominio = aguaCondominio;
		this.taxaExtra = taxaExtra;
		this.nossoNumero = nossoNumero;
		this.totalBoleto = totalBoleto;
		validarDominio();
	}

	public ContaReceber(Integer id, Condomino condomino, Double salaoFesta, Double diversos, Double devolucoes,
			Double consumoGas, Double servicoPortaria, Double taxaCondominio, Double consumoAgua,
			Double energiaEletrica, Double aguaCondominio, Double taxaExtra,String nossoNumero, Double totalBoleto) {
		this(condomino, salaoFesta, diversos, devolucoes, consumoGas, servicoPortaria, taxaCondominio, consumoAgua,
				energiaEletrica, aguaCondominio, taxaExtra,nossoNumero,totalBoleto);
		this.id = id;

	}
	

	public Integer getId() {
		return id;
	}

	public Condomino getCondomino() {
		return condomino;
	}

	public Double getSalaoFesta() {
		return salaoFesta;
	}

	public Double getDiversos() {
		return diversos;
	}

	public Double getDevolucoes() {
		return devolucoes;
	}

	public Double getConsumoGas() {
		return consumoGas;
	}

	public Double getServicoPortaria() {
		return servicoPortaria;
	}

	public Double getTaxaCondominio() {
		return taxaCondominio;
	}

	public Double getConsumoAgua() {
		return consumoAgua;
	}

	public Double getEnergiaEletrica() {
		return energiaEletrica;
	}

	public Double getAguaCondominio() {
		return aguaCondominio;
	}

	public String getNossoNumero() {
		return nossoNumero;
	}
	

	public Double getTaxaExtra() {
		return taxaExtra;
	}

	public Double getTotalBoleto() {
		totalBoleto = salaoFesta+diversos+devolucoes+consumoGas+servicoPortaria +taxaCondominio+consumoAgua+energiaEletrica+aguaCondominio+taxaExtra;
		return totalBoleto;
	}

	

}
