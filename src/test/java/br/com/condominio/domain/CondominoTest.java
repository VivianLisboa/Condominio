package br.com.condominio.domain;

import org.junit.Test;

public class CondominoTest {
	
	@Test
	public void deveCriarCadastroCondomino() {
		Condominio  vivaVida = new Condominio("vivaVida", "20.345.917/0001-65", "32580644");
		Condomino fatima = new Condomino(vivaVida, "Fátima Rodrigues", "041.867.300-98", "casa 05");
	}

}
