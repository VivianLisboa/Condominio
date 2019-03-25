package br.com.condominio.domain;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Assert;
import org.junit.Test;

public class ContaReceberTest {

	@Test
	public void deveCriarContaReceberESomaBoleto() {
		Condominio vivaVida = new Condominio("vivaVida", "13.383.247/0001-86", "32580644");
		Condomino fatima = new Condomino(vivaVida, "Fátima Rodrigues", "014.958.510-10", "casa 05");
		ContaReceber contaReceber = new ContaReceber(fatima, new Double(50.00), new Double(0.00), new Double(0.00),
				new Double(32.00), new Double(72.00), new Double(300.00), new Double(60.00), new Double(35.00),
				new Double(20.00), new Double(0.00), "100105", new Double(569));

		Assert.assertEquals(vivaVida, fatima.getCondominio());
		Assert.assertEquals(new Double(50.00), contaReceber.getSalaoFesta());
		Assert.assertEquals(new Double(0.0), contaReceber.getDiversos());
		Assert.assertEquals(new Double(0.0), contaReceber.getDevolucoes());
		Assert.assertEquals(new Double(32.00), contaReceber.getConsumoGas());
		Assert.assertEquals(new Double(72.00), contaReceber.getServicoPortaria());
		Assert.assertEquals(new Double(300.00), contaReceber.getTaxaCondominio());
		Assert.assertEquals(new Double(60.00), contaReceber.getConsumoAgua());
		Assert.assertEquals(new Double(35.00), contaReceber.getEnergiaEletrica());
		Assert.assertEquals(new Double(20.00), contaReceber.getAguaCondominio());
		Assert.assertEquals(new Double(0.00), contaReceber.getTaxaExtra());
		Assert.assertEquals("100105", contaReceber.getNossoNumero());
		Assert.assertEquals(new Double(569), contaReceber.getTotalBoleto());

		
	}

	@Test(expected = DominioInvalidoException.class)
	public void deveValidarCriacaoContaReceberNulo() {
		Condomino condomino = null;
		ContaReceber contaReceber = new ContaReceber(condomino, null, null, null, null, null, null, null, null, null,
				null, null, null);
	}

	@Test(expected = DominioInvalidoException.class)
	public void deveValidarCriacaoContaReceberVazio() {
		ContaReceber contaReceber = new ContaReceber(null, null, null, null, null, null, null, null, null, null, null,
				"", null);
	}

}
