package br.com.condominio.domain;

import org.junit.Assert;
import org.junit.Test;



public class CondominioTest {
	
	@Test
	public void deveCriarCadastroCondominio() {
		Condominio bravo = new Condominio("Bravo", "13.383.247/0001-86","32640604");
		
		Assert.assertEquals("Bravo", bravo.getNome());
		Assert.assertEquals("13.383.247/0001-86", bravo.getCnpj());
		Assert.assertEquals("32640604", bravo.getContato());
	}
	@Test(expected = DominioInvalidoException.class)
	public void deveValidarCriacaoDeCondominioNulo() {
		new Condominio(null, null, null);
	}
	@Test(expected = DominioInvalidoException.class)
	public void deveValidarCriacaoDeCondominioVazio() {
		new Condominio("", "", "");
	}

}
