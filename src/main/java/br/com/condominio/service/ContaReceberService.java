package br.com.condominio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.condominio.domain.Condominio;
import br.com.condominio.domain.Condomino;
import br.com.condominio.domain.ContaReceber;
import br.com.condominio.dto.CondominoDTO;
import br.com.condominio.dto.ContaReceberDTO;
import br.com.condominio.repository.CondominioRepository;
import br.com.condominio.repository.CondominoRepository;
import br.com.condominio.repository.ContaReceberRepository;

@Service
public class ContaReceberService {

	private ContaReceberRepository contaReceberRepository;
	private CondominoRepository condominoRepository;

	@Autowired
	public ContaReceberService(CondominoRepository condominoRepository, ContaReceberRepository contaReceberRepository) {
		this.contaReceberRepository = contaReceberRepository;
		this.condominoRepository = condominoRepository;
	}

	public void save(ContaReceberDTO contaReceberDTO) {
		Optional<Condomino> condomino = condominoRepository.findByCpf(contaReceberDTO.getCondomino());
		contaReceberRepository.findByIdentificacaoUnidade(contaReceberDTO.getCondomino());
				
		Double salaoFesta = contaReceberDTO.getSalaoFesta();
		Double diversos = contaReceberDTO.getDiversos();
		Double devolucoes = contaReceberDTO.getDevolucoes();
		Double consumoGas = contaReceberDTO.getConsumoGas();
		Double servicoPortaria = contaReceberDTO.getServicoPortaria();
		Double taxaCondominio = contaReceberDTO.getTaxaCondominio();
		Double consumoAgua = contaReceberDTO.getConsumoAgua();
		Double energiaEletrica = contaReceberDTO.getEnergiaEletrica();
		Double aguaCondominio = contaReceberDTO.getAguaCondominio();
		Double taxaExtra = contaReceberDTO.getTaxaExtra();
		String nossoNumero = contaReceberDTO.getNossoNumero();
		Double totalBoleto = contaReceberDTO.getTotalBoleto();

		ContaReceber contaReceber = new ContaReceber(condomino.get(), salaoFesta, diversos, devolucoes, consumoGas,
				servicoPortaria, taxaCondominio, consumoAgua, energiaEletrica, aguaCondominio, taxaExtra, nossoNumero,
				totalBoleto);
		this.contaReceberRepository.saveAndFlush(contaReceber);
		contaReceberDTO.setId(contaReceber.getId());
	}

	public void update(ContaReceberDTO contaReceberDTO) {
		Optional<Condomino> condomino = condominoRepository.findByCpf(contaReceberDTO.getCondomino());
		contaReceberRepository.findByIdentificacaoUnidade(contaReceberDTO.getCondomino());
		Integer id = contaReceberDTO.getId();
		Double salaoFesta = contaReceberDTO.getSalaoFesta();
		Double diversos = contaReceberDTO.getDiversos();
		Double devolucoes = contaReceberDTO.getDevolucoes();
		Double consumoGas = contaReceberDTO.getConsumoGas();
		Double servicoPortaria = contaReceberDTO.getServicoPortaria();
		Double taxaCondominio = contaReceberDTO.getTaxaCondominio();
		Double consumoAgua = contaReceberDTO.getConsumoAgua();
		Double energiaEletrica = contaReceberDTO.getEnergiaEletrica();
		Double aguaCondominio = contaReceberDTO.getAguaCondominio();
		Double taxaExtra = contaReceberDTO.getTaxaExtra();
		String nossoNumero = contaReceberDTO.getNossoNumero();
		Double totalBoleto = contaReceberDTO.getTotalBoleto();

		ContaReceber contaReceber = new ContaReceber(id, condomino.get(), salaoFesta, diversos, devolucoes, consumoGas,
				servicoPortaria, taxaCondominio, consumoAgua, energiaEletrica, aguaCondominio, taxaExtra, nossoNumero,
				totalBoleto);
		this.contaReceberRepository.saveAndFlush(contaReceber);
	}

	public ContaReceber findByIdentificacaoUnidade(String identificacaoUnidade) {
		Optional<ContaReceber> contaReceberEncontrado = contaReceberRepository
				.findByIdentificacaoUnidade(identificacaoUnidade);
		if (contaReceberEncontrado.isPresent()) {
			return contaReceberEncontrado.get();

		}
		throw new ServiceException("Unidade não encontrado");
	}

	public void deleteAll() {
		this.contaReceberRepository.deleteAll();
	}

	public List<ContaReceberDTO> findAll() {
		List<ContaReceberDTO> contaReceberParaRetorno = new ArrayList<ContaReceberDTO>();
		List<ContaReceber> contasReceber = contaReceberRepository.findAll();

		for (ContaReceber contaReceber : contasReceber) {
			ContaReceberDTO contaReceberDTO = new ContaReceberDTO();
			contaReceberDTO.setCondomino(contaReceber.getCondomino().getCpf());
			contaReceberDTO.setSalaoFesta(contaReceber.getSalaoFesta());
			contaReceberDTO.setDiversos(contaReceber.getDiversos());
			contaReceberDTO.setDevolucoes(contaReceber.getDevolucoes());
			contaReceberDTO.setConsumoGas(contaReceber.getConsumoGas());
			contaReceberDTO.setServicoPortaria(contaReceber.getServicoPortaria());
			contaReceberDTO.setTaxaCondominio(contaReceber.getTaxaCondominio());
			contaReceberDTO.setConsumoAgua(contaReceber.getConsumoAgua());
			contaReceberDTO.setEnergiaEletrica(contaReceber.getEnergiaEletrica());
			contaReceberDTO.setAguaCondominio(contaReceber.getAguaCondominio());
			contaReceberDTO.setTaxaExtra(contaReceber.getTaxaExtra());
			contaReceberDTO.setNossoNumero(contaReceber.getNossoNumero());
			contaReceberDTO.setTotalBoleto(contaReceber.getTotalBoleto());

			contaReceberParaRetorno.add(contaReceberDTO);
		}

		return contaReceberParaRetorno;
	}

}
