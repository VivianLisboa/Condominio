package br.com.condominio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.condominio.dto.CondominioDTO;
import br.com.condominio.metricas.EnumSingleton;
import br.com.condominio.service.CondominioService;

@RestController
@RequestMapping(value = "vivi")
public class CondominioController {

	public CondominioService condominioService;

	@Autowired
	public CondominioController(CondominioService condominioService) {
		this.condominioService = condominioService;
	}

	@GetMapping(value = "/condominio")
	public ResponseEntity<List<CondominioDTO>> obterCondominio() {
		EnumSingleton.INSTANCE.inc();
		List<CondominioDTO> condominios = condominioService.findAll();
		return new ResponseEntity<List<CondominioDTO>>(condominios, HttpStatus.OK);
	}

	@PostMapping(value = "/condominio")
	public ResponseEntity<?> salvar(@RequestBody @Valid CondominioDTO condominioDTO) {
		this.condominioService.save(condominioDTO);
		return new ResponseEntity<>(HttpStatus.OK);

	}
	@DeleteMapping(value = "/condominio/{cnpj}")
	public ResponseEntity<?>delete(@PathVariable("cnpj") String cnpj) {
		this.condominioService.deleteBycnpj(cnpj);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
