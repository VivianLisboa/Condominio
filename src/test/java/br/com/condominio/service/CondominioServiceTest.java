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
import br.com.condominio.service.CondominioService;

@RunWith(value = SpringRunner.class)
@SpringBootTest
public class CondominioServiceTest {

	@Autowired
	private CondominioService condominioService;

	@Test
	public void deveSalvarCondominioCamposObrigatorios() {
		
		Condominio bravo = new Condominio("Bravo", "13.383.247/0001-86","32640604");
		condominioService.save(bravo);
		
		Condominio condominioSalva = condominioService.findByCnpj("13.383.247/0001-86");
		Assert.assertEquals("Bravo", bravo.getNome());
		Assert.assertEquals("13.383.247/0001-86", bravo.getCnpj());
		Assert.assertEquals("32640604", bravo.getContato());
	}
	
	@Test(expected=ServiceException.class)
	public void deveValidarCondominioJaCadastradoPeloCnpj() {
		Condominio bravo = new Condominio("Bravo", "13.383.247/0001-86","32640604");
		condominioService.save(bravo);
		condominioService.save(bravo);
	}
	
}
