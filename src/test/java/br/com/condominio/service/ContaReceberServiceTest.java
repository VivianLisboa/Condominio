package br.com.condominio.service;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.condominio.domain.Condominio;
import br.com.condominio.domain.Condomino;
import br.com.condominio.domain.ContaReceber;
import br.com.condominio.dto.ContaReceberDTO;
import br.com.condominio.repository.CondominioRepository;
import br.com.condominio.repository.CondominoRepository;


@RunWith(value = SpringRunner.class)
@SpringBootTest
public class ContaReceberServiceTest {
	
	@Autowired
	private ContaReceberService contaReceberService;
	
	@Autowired
	private CondominioRepository condominioRepository;
	
	@Autowired
	private CondominoRepository condominoRepository;
	
	private Condomino fatima;
	private Condominio vivaVida;
	
	@Before
	public void init() {
		vivaVida = new Condominio("vivaVida", "13.383.247/0001-86", "32580644");
		condominioRepository.saveAndFlush(vivaVida);
		
		fatima = new Condomino(vivaVida, "Fátima Rodrigues", "014.958.510-10", "casa 05");
		condominoRepository.saveAndFlush(fatima);
	}
	
	@After
	public void finalizar() {
		contaReceberService.deleteAll();
		condominoRepository.deleteAll();
		condominioRepository.deleteAll();
	}
	
	@Test
	public void deveSalvarContaReceberDTO() {
		
		ContaReceberDTO contaReceberDTO = new ContaReceberDTO();
		contaReceberDTO.setCondomino("014.958.510-10");
		contaReceberDTO.setSalaoFesta(new Double (50.00));
		contaReceberDTO.setDiversos(new Double (0.00));
		contaReceberDTO.setDevolucoes(new Double (0.00));
		contaReceberDTO.setConsumoGas(new Double (32.00));
		contaReceberDTO.setServicoPortaria(new Double (72.00));
		contaReceberDTO.setTaxaCondominio(new Double (300.00));
		contaReceberDTO.setConsumoAgua(new Double (60.00));
		contaReceberDTO.setEnergiaEletrica(new Double (35.00));
		contaReceberDTO.setAguaCondominio(new Double (20.00));
		contaReceberDTO.setTaxaExtra(new Double (0.00));
		contaReceberDTO.setNossoNumero("100105");
		contaReceberDTO.setTotalBoleto(new Double (569.00));

		contaReceberService.save(contaReceberDTO);
		contaReceberService.findByIdentificacaoUnidade(fatima.getidentificacaoUnidade());
		
				
		Assert.assertEquals(vivaVida, fatima.getCondominio());
		Assert.assertEquals(new Double(50.00), contaReceberDTO.getSalaoFesta());
		Assert.assertEquals(new Double(0.0), contaReceberDTO.getDiversos());
		Assert.assertEquals(new Double(0.0), contaReceberDTO.getDevolucoes());
		Assert.assertEquals(new Double(32.00), contaReceberDTO.getConsumoGas());
		Assert.assertEquals(new Double(72.00), contaReceberDTO.getServicoPortaria());
		Assert.assertEquals(new Double(300.00), contaReceberDTO.getTaxaCondominio());
		Assert.assertEquals(new Double(60.00), contaReceberDTO.getConsumoAgua());
		Assert.assertEquals(new Double(35.00), contaReceberDTO.getEnergiaEletrica());
		Assert.assertEquals(new Double(20.00), contaReceberDTO.getAguaCondominio());
		Assert.assertEquals(new Double(0.00), contaReceberDTO.getTaxaExtra());
		Assert.assertEquals("100105", contaReceberDTO.getNossoNumero());
		Assert.assertEquals(new Double(569), contaReceberDTO.getTotalBoleto());


	}

			@Test
		
			public void deveFazerUpdateContaReceber() {
	
				ContaReceberDTO contaReceberDTO = new ContaReceberDTO();
				contaReceberDTO.setCondomino("014.958.510-10");
				contaReceberDTO.setSalaoFesta(new Double (50.00));
				contaReceberDTO.setDiversos(new Double (0.00));
				contaReceberDTO.setDevolucoes(new Double (0.00));
				contaReceberDTO.setConsumoGas(new Double (32.00));
				contaReceberDTO.setServicoPortaria(new Double (72.00));
				contaReceberDTO.setTaxaCondominio(new Double (300.00));
				contaReceberDTO.setConsumoAgua(new Double (60.00));
				contaReceberDTO.setEnergiaEletrica(new Double (35.00));
				contaReceberDTO.setAguaCondominio(new Double (20.00));
				contaReceberDTO.setTaxaExtra(new Double (0.00));
				contaReceberDTO.setNossoNumero("100105");
				contaReceberDTO.setTotalBoleto(new Double (569.00));
				
				contaReceberService.save(contaReceberDTO);
								
				
//				ContaReceberDTO contaReceberSalvo = contaReceberService.findByIdentificacaoUnidade("casa 05");
//				contaReceberSalvo.setSalaoFesta(0.00);
//				contaReceberSalvo.setConsumoAgua(120.00);
//				contaReceberSalvo.setTaxaExtra(20.50);
//				Assert.assertEquals(new Double(0.00),contaReceberSalvo.getSalaoFesta());
//				Assert.assertEquals(new Double(120.00),contaReceberSalvo.getConsumoAgua());
//				Assert.assertEquals(new Double(20.50), contaReceberSalvo.getTaxaExtra());
//				
//				contaReceberService.update(contaReceberSalvo);
//		
//				ContaReceber atualizado = contaReceberService.findByIdentificacaoUnidade("casa 05");
				
			}
		
			@Test
			public void deveExcluirContaReceber() {
				
				ContaReceberDTO contaReceberParaSalvar = new ContaReceberDTO();
				contaReceberParaSalvar.setCondomino("014.958.510-10");
				contaReceberParaSalvar.setSalaoFesta(new Double (50.00));
				contaReceberParaSalvar.setDiversos(new Double (0.00));
				contaReceberParaSalvar.setDevolucoes(new Double (0.00));
				contaReceberParaSalvar.setConsumoGas(new Double (32.00));
				contaReceberParaSalvar.setServicoPortaria(new Double (72.00));
				contaReceberParaSalvar.setTaxaCondominio(new Double (300.00));
				contaReceberParaSalvar.setConsumoAgua(new Double (60.00));
				contaReceberParaSalvar.setEnergiaEletrica(new Double (35.00));
				contaReceberParaSalvar.setAguaCondominio(new Double (20.00));
				contaReceberParaSalvar.setTaxaExtra(new Double (0.00));
				contaReceberParaSalvar.setNossoNumero("100105");
				contaReceberParaSalvar.setTotalBoleto(new Double (569.00));
				
				contaReceberService.save(contaReceberParaSalvar);
				contaReceberService.findByIdentificacaoUnidade(contaReceberParaSalvar.getCondomino());
		
			}

	
}
