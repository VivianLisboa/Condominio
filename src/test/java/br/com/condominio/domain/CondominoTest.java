package br.com.condominio.domain;

import org.junit.Assert;
import org.junit.Test;

public class CondominoTest {
	
	@Test
	public void deveCriarCadastroCondomino() {
		Condominio  vivaVida = new Condominio("vivaVida", "13.383.247/0001-86", "32580644");
		Condomino fatima = new Condomino(vivaVida, "Fátima Rodrigues", "014.958.510-10", "casa 05");
		
		Assert.assertEquals(vivaVida, fatima.getCondominio());
		Assert.assertEquals("Fátima Rodrigues", fatima.getNome());
		Assert.assertEquals("014.958.510-10", fatima.getCpf());
		Assert.assertEquals("casa 05", fatima.getidentificacaoUnidade());
	}
	@Test(expected = DominioInvalidoException.class)
	public void deveValidarCriacaoDeCondominoNulo() {
		new Condomino(null, null, null,null);
	}
	@Test(expected = DominioInvalidoException.class)
	public void deveValidarCriacaoDeCondominoVazio() {
		new Condomino(null, "", "","");
	}

}
