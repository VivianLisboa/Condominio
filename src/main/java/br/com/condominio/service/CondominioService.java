package br.com.condominio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.condominio.domain.Condominio;
import br.com.condominio.dto.CondominioDTO;
import br.com.condominio.repository.CondominioRepository;



@Service
public class CondominioService {

	private CondominioRepository condominioRepository;

	@Autowired
	public CondominioService(CondominioRepository condominioRepository) {
		this.condominioRepository = condominioRepository;
	}

	public void save(CondominioDTO condominioDTO) {
		String nome = condominioDTO.getNome();
		String cnpj = condominioDTO.getCnpj();
		String contato = condominioDTO.getContato();
		
		Condominio condominio = new Condominio(nome, cnpj, contato);
		validarInsertCondominio(condominio);
		this.condominioRepository.saveAndFlush(condominio);
	}

	private void validarInsertCondominio(Condominio condominio) {
		Long numberOfCondominioWithCNPJ = condominioRepository.validateExistClientByCnpj(condominio.getCnpj());
		if (numberOfCondominioWithCNPJ > 0) {
			throw new ServiceException("Condominio já cadastrado");
		}
	}

	public Condominio findByCnpj(String cnpj) {
		Optional<Condominio> condominioEncontrado = condominioRepository.findByCnpj(cnpj);
		if (condominioEncontrado.isPresent()) {
			return condominioEncontrado.get();

		}
		throw new ServiceException("Condominio não encontrado");
	}

	public void deleteAll() {
		this.condominioRepository.deleteAll();
	}

	public void deleteBycnpj(String cnpj) {
		Optional<Condominio> condominio = condominioRepository.findByCnpj(cnpj);
		if(condominio.isPresent()) {
			condominioRepository.deleteById(condominio.get().getId());
		}
	}
	public List<CondominioDTO> findAll() {
		List<CondominioDTO> condominioParaRetorno = new ArrayList<CondominioDTO>();
		List<Condominio> condominios = condominioRepository.findAll();

		for (Condominio condominio : condominios) {
			CondominioDTO condominioDTO = new CondominioDTO();
			condominioDTO.setNome(condominio.getNome());
			condominioDTO.setCnpj(condominio.getCnpj());
			condominioDTO.setContato(condominio.getContato());

			condominioParaRetorno.add(condominioDTO);
		}

		return condominioParaRetorno;
	}

}
