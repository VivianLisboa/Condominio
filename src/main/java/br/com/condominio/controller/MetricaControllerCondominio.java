package br.com.condominio.controller;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.condominio.dto.MetricaCondominioDTO;
import br.com.condominio.metricas.EnumSingleton;


@RestController
@RequestMapping(value = "vivi")
public class MetricaControllerCondominio {

	@GetMapping(value = "/metrica")
	public ResponseEntity<MetricaCondominioDTO> obterMetricaCondominio() {
		int counter = EnumSingleton.INSTANCE.getCounter();

		MetricaCondominioDTO metrica = new MetricaCondominioDTO();
		metrica.setCounterCondominio(counter);

		return new ResponseEntity<>(metrica, HttpStatus.OK);

	}

}
