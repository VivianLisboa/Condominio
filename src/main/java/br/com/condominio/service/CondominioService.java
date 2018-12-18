package br.com.condominio.service;

import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.condominio.domain.Condominio;
import br.com.condominio.repository.CondominioRepository;

@Service
public class CondominioService {

	private CondominioRepository condominioRepository;

	@Autowired
	public CondominioService(CondominioRepository condominioRepository) {
		this.condominioRepository = condominioRepository;
	}

	public void save(Condominio condominio) {
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

}
