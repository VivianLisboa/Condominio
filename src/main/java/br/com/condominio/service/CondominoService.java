package br.com.condominio.service;

import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.condominio.domain.Condomino;
import br.com.condominio.repository.CondominoRepository;

@Service
public class CondominoService {

	private CondominoRepository condominoRepository;

	@Autowired
	public CondominoService(CondominoRepository condominoRepository) {
		this.condominoRepository = condominoRepository;

	}
	public void save(Condomino condomino) {
		validarInsertCondomino(condomino);
		this.condominoRepository.saveAndFlush(condomino);
	}
	
	public void upadate(Condomino condomino) {
		this.condominoRepository.saveAndFlush(condomino);
	}
	
	private void validarInsertCondomino(Condomino condomino) {

		Long numberOfcondominoWitchCpf = condominoRepository.validateExistClientByCpf(condomino.getCpf());
		if(numberOfcondominoWitchCpf >0) {
			throw new ServiceException("Condomino já cadastrado");
		}
	}
	
	public Condomino findByCpf(String cpf) {
		Optional<Condomino>condominoEncontrado = condominoRepository.findByCpf(cpf);
		if(condominoEncontrado.isPresent()) {
			return condominoEncontrado.get();
		}
		throw new ServiceException("Condomino não encontrado");
	}
	public void deleteAll() {
		this.condominoRepository.deleteAll();
	}
	public void deletar(Condomino fatima) {
		this.condominoRepository.delete(fatima);
	}
	
}
	
