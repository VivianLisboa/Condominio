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
import br.com.condominio.repository.CondominioRepository;
import br.com.condominio.repository.CondominoRepository;

@Service
public class CondominoService {

	private CondominoRepository condominoRepository;

	private CondominioRepository condominioRepository;
	
	@Autowired
	public CondominoService(CondominoRepository condominoRepository, CondominioRepository condominioRepository) {
		this.condominoRepository = condominoRepository;
		this.condominioRepository = condominioRepository;
	}

	public void save(CondominoDTO condominoDTO) {
		Optional<Condominio> condominio = condominioRepository.findByCnpj(condominoDTO.getCondominio());
		String nome = condominoDTO.getNome();
		String cpf = condominoDTO.getCpf();
		String identificacaoUnidade = condominoDTO.getIdentificacaoUnidade();

		Condomino condomino = new Condomino(condominio.get(), nome, cpf, identificacaoUnidade);
		validarInsertCondomino(condomino);
		this.condominoRepository.saveAndFlush(condomino);
		condominoDTO.setId(condomino.getId());
	}

	public void update(CondominoDTO condominoDTO) {
		Optional<Condominio> condominio = condominioRepository.findByCnpj(condominoDTO.getCondominio());
		Integer id = condominoDTO.getId();
		String nome = condominoDTO.getNome();
		String cpf = condominoDTO.getCpf();
		String identificacaoUnidade = condominoDTO.getIdentificacaoUnidade();

		Condomino condomino = new Condomino(id, condominio.get(), nome, cpf, identificacaoUnidade);
		this.condominoRepository.saveAndFlush(condomino);
	}

	private void validarInsertCondomino(Condomino condomino) {

		Long numberOfcondominoWitchCpf = condominoRepository.validateExistClientByCpf(condomino.getCpf());
		if (numberOfcondominoWitchCpf > 0) {
			throw new ServiceException("Condomino já cadastrado");
		}
	}

	public CondominoDTO findByCpf(String cpf) {
		Optional<Condomino> condominoEncontrado = condominoRepository.findByCpf(cpf);
		if (condominoEncontrado.isPresent()) {
			Condomino condomino = condominoEncontrado.get();
			CondominoDTO condominoDTO = new CondominoDTO();
			condominoDTO.setId(condomino.getId());
			condominoDTO.setCondominio(condomino.getCondominio().getCnpj());
			condominoDTO.setNome(condomino.getNome());
			condominoDTO.setCpf(condomino.getCpf());
			condominoDTO.setIdentificacaoUnidade(condomino.getidentificacaoUnidade());
			return condominoDTO;
		}
		throw new ServiceException("Condomino não encontrado");
	}

	public void deleteAll() {
		this.condominoRepository.deleteAll();
	}

	public void deleteBycpf(String cpf) {
		Optional<Condomino> condomino = condominoRepository.findByCpf(cpf);
		if (condomino.isPresent()) {
			condominoRepository.deleteById(condomino.get().getId());
		}
	}

	public List<CondominoDTO> findAll() {
		List<CondominoDTO> condominoParaRetorno = new ArrayList<CondominoDTO>();
		List<Condomino> condominos = condominoRepository.findAll();

		for (Condomino condomino : condominos) {
			CondominoDTO condominoDTO = new CondominoDTO();
			condominoDTO.setId(condomino.getId());
			condominoDTO.setCondominio(condomino.getCondominio().getCnpj());
			condominoDTO.setNome(condomino.getNome());
			condominoDTO.setCpf(condomino.getCpf());
			condominoDTO.setIdentificacaoUnidade(condomino.getidentificacaoUnidade());

			condominoParaRetorno.add(condominoDTO);
		}

		return condominoParaRetorno;
	}

}
