package br.com.condominio.service;

import org.hibernate.service.spi.ServiceException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.condominio.domain.Condominio;
import br.com.condominio.dto.CondominioDTO;
import br.com.condominio.repository.CondominioRepository;
import br.com.condominio.service.CondominioService;


@RunWith(value = SpringRunner.class)
@SpringBootTest
public class CondominioServiceTest {

	@Autowired
	private CondominioService condominioService;
	
	@Autowired
	private CondominioRepository condominioRepository;
	
	@Before
	public void init() {
		condominioRepository.deleteAll();
	}
	
	@Test
	public void deveSalvarUmCondominio() {
		CondominioDTO condominioParaSalvar = new CondominioDTO();
		condominioParaSalvar.setNome("Bravo");
		condominioParaSalvar.setCnpj("13.383.247/0001-86");
		condominioParaSalvar.setContato("32640604");
		
		
		condominioService.save(condominioParaSalvar);
		Condominio condominioSalvo = condominioService.findByCnpj("13.383.247/0001-86");
		
		Assert.assertEquals("Bravo", condominioSalvo.getNome());
		Assert.assertEquals("13.383.247/0001-86", condominioSalvo.getCnpj());
		Assert.assertEquals("32640604", condominioSalvo.getContato());
	}

	@Test(expected=ServiceException.class)
	public void deveValidarCondominioJaCadastradoPeloCnpj() {
		CondominioDTO condominioParaSalvar = new CondominioDTO();
		condominioParaSalvar.setNome("Bravo");
		condominioParaSalvar.setCnpj("13.383.247/0001-86");
		condominioParaSalvar.setContato("32640604");
		condominioService.save(condominioParaSalvar);
		condominioService.save(condominioParaSalvar);
	}
	
}
