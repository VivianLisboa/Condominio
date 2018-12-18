package br.com.condominio.domain;

import org.junit.Test;

public class CondominoTest {
	
	@Test
	public void deveCriarCadastroCondomino() {
		Condominio  vivaVida = new Condominio("vivaVida", "20.345.917/0001-65", "32580644");
		Condomino fatima = new Condomino(vivaVida, "Fátima Rodrigues", "014.958.510-10", "casa 05");
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
