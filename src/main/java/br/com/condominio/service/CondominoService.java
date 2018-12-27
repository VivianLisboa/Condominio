package br.com.condominio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.condominio.domain.Condominio;
import br.com.condominio.domain.Condomino;

import br.com.condominio.dto.CondominoDTO;

import br.com.condominio.repository.CondominoRepository;

@Service
public class CondominoService {

	private CondominoRepository condominoRepository;

	@Autowired
	public CondominoService(CondominoRepository condominoRepository) {
		this.condominoRepository = condominoRepository;

	}

	public void save(CondominoDTO condominoDTO) {
		Condominio condominio = condominoDTO.getCondominio();
		String nome = condominoDTO.getNome();
		String cpf = condominoDTO.getCpf();
		String identificacaoUnidade = condominoDTO.getIdentificacaoUnidade();

		Condomino condomino = new Condomino(condominio, nome, cpf, identificacaoUnidade);
		validarInsertCondomino(condomino);
		this.condominoRepository.saveAndFlush(condomino);
		condominoDTO.setId(condomino.getId());
	}

	public void update(Condomino condomino) {
		this.condominoRepository.saveAndFlush(condomino);
	}

	private void validarInsertCondomino(Condomino condomino) {

		Long numberOfcondominoWitchCpf = condominoRepository.validateExistClientByCpf(condomino.getCpf());
		if (numberOfcondominoWitchCpf > 0) {
			throw new ServiceException("Condomino já cadastrado");
		}
	}

	public Condomino findByCpf(String cpf) {
		Optional<Condomino> condominoEncontrado = condominoRepository.findByCpf(cpf);
		if (condominoEncontrado.isPresent()) {
			return condominoEncontrado.get();
		}
		throw new ServiceException("Condomino não encontrado");
	}

	public void deleteAll() {
		this.condominoRepository.deleteAll();
	}

	public void deletar(CondominoDTO fatima) {
		this.condominoRepository.deleteById(fatima.getId());
	}

	public List<CondominoDTO> findAll() {
		List<CondominoDTO> condominoParaRetorno = new ArrayList<CondominoDTO>();
		List<Condomino> condominos = condominoRepository.findAll();

		for (Condomino condomino : condominos) {
			CondominoDTO condominoDTO = new CondominoDTO();
			condominoDTO.setCondominio(condomino.getCondominio());
			condominoDTO.setNome(condomino.getNome());
			condominoDTO.setCpf(condomino.getCpf());
			condominoDTO.setIdentificacaoUnidade(condomino.getidentificacaoUnidade());

			condominoParaRetorno.add(condominoDTO);
		}

		return condominoParaRetorno;
	}

}
