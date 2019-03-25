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

import br.com.condominio.dto.CondominoDTO;

import br.com.condominio.service.CondominoService;

@RestController
@RequestMapping(value = "vivi")
public class CondominoController {

	public CondominoService condominoService;

	@Autowired
	public CondominoController(CondominoService condominoService) {
		this.condominoService = condominoService;
	}

	@GetMapping(value = "/condomino")
	public ResponseEntity<List<CondominoDTO>> obterCondomino() {
		List<CondominoDTO> condominos = condominoService.findAll();
		return new ResponseEntity<List<CondominoDTO>>(condominos, HttpStatus.OK);
	}

	@PostMapping(value = "/condomino")
	public ResponseEntity<?> salvar(@RequestBody @Valid CondominoDTO condominoDTO) {
		this.condominoService.save(condominoDTO);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@PutMapping(value = "/condomino/{identicacaoUnidade}")
	public ResponseEntity<?> update(@RequestBody CondominoDTO condominoDTO) {
		this.condominoService.update(condominoDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/condomino/{cpf}")
	public ResponseEntity<?> delete(@PathVariable("cpf") String cpf) {
		this.condominoService.deleteBycpf(cpf);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
