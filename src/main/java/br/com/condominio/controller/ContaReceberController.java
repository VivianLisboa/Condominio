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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.condominio.dto.ContaReceberDTO;
import br.com.condominio.service.ContaReceberService;

@RestController
@RequestMapping(value = "vivi")
public class ContaReceberController {

	public ContaReceberService contaReceberService;

	@Autowired
	public ContaReceberController(ContaReceberService contaReceberService) {
		this.contaReceberService = contaReceberService;
	}

	@GetMapping(value = "/conta_receber_boleto")
	public ResponseEntity<List<ContaReceberDTO>> obterBoleto() {
		List<ContaReceberDTO> boletos = contaReceberService.findAll();
		return new ResponseEntity<List<ContaReceberDTO>>(boletos, HttpStatus.OK);
	}

	@PostMapping(value = "/conta_receber_boleto")
	public ResponseEntity<?> salvar(@RequestBody @Valid ContaReceberDTO contaReceberDTO) {
		this.contaReceberService.save(contaReceberDTO);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@PutMapping(value = "/conta_receber_boleto/{identificacaoUnidade}")
	public ResponseEntity<?> update(@RequestBody ContaReceberDTO contaReceberDTO) {
		this.contaReceberService.update(contaReceberDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/conta_receber_boleto/{identificacaoUnidade}")
	public ResponseEntity<?> delete(@PathVariable("identificacaoUnidade") String identificacaoUnidade) {
		this.contaReceberService.findByIdentificacaoUnidade(identificacaoUnidade);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
