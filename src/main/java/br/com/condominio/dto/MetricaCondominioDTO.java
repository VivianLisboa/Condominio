package br.com.condominio.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MetricaCondominioDTO {
	@NotNull
	@NotEmpty
	private Integer counterCondominio;

	public void setCounterCondominio(int counter) {
		this.counterCondominio = counter;

	}

	public Integer getCounterCondominio() {
		return counterCondominio;
	}

}
