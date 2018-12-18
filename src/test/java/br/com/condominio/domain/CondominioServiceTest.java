package br.com.condominio.domain;

import org.hibernate.service.spi.ServiceException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.condominio.service.CondominioService;

@RunWith(value = SpringRunner.class)
@SpringBootTest
public class CondominioServiceTest {

	@Autowired
	private CondominioService condominioService;

	@Test
	public void deveSalvarCondominioCamposObrigatorios() {
		
		Condominio bravo = new Condominio("Bravo", "20.980.987/0001-80","32640604");
		condominioService.save(bravo);
		
		Condominio condominioSalva = condominioService.findByCnpj("20.980.987/0001-80");
		Assert.assertEquals("Bravo", bravo.getNome());
		Assert.assertEquals("20.980.987/0001-80", bravo.getCnpj());
		Assert.assertEquals("32640604", bravo.getContato());
	}
	
	@Test(expected=ServiceException.class)
	public void deveValidarCondominioJaCadastradoPeloCnpj() {
		Condominio bravo = new Condominio("Bravo", "20.980.987/0001-80","32640604");
		condominioService.save(bravo);
		condominioService.save(bravo);
	}
	
}
