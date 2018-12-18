package br.com.condominio.service;

import org.hibernate.service.spi.ServiceException;
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
import br.com.condominio.repository.CondominioRepository;

@RunWith(value = SpringRunner.class)
@SpringBootTest
public class CondominoServiceTest {

	@Autowired
	private CondominoService condominoService;

	@Autowired
	private CondominioRepository condominioRepository;
	private Condominio vivaVida;

	@Before
	public void init() {
		vivaVida = new Condominio("vivaVida", "13.383.247/0001-86", "32580644");
		condominioRepository.saveAndFlush(vivaVida);
	}
	
	
	@After
	public void finalizar() {
		condominoService.deleteAll();
	}

	@Test
	public void deveSalvarCondominoCamposObrigatorios() {

		Condomino fatima = new Condomino(vivaVida, "Fátima Rodrigues", "014.958.510-10", "casa 05");
		condominoService.save(fatima);

		Condomino condominoSalva = condominoService.findByCpf("014.958.510-10");
		Assert.assertEquals(vivaVida, condominoSalva.getCondominio());
		Assert.assertEquals("Fátima Rodrigues", fatima.getNome());
		Assert.assertEquals("014.958.510-10", fatima.getCpf());
		Assert.assertEquals("casa 05", fatima.getIdentifUnidade());
	}

	@Test

	public void deveFazerUpdateCondomino() {
		Condomino fatima = new Condomino(vivaVida, "Fátima Rodrigues", "014.958.510-10", "casa 05");
		condominoService.save(fatima);

		Condomino fatimaSalvo = condominoService.findByCpf("014.958.510-10");

		Condomino novoCondomino = new Condomino(fatimaSalvo.getId(), vivaVida, "Fátima Rodrigues", "014.958.510-10",
				"casa 16");
		condominoService.upadate(fatima);

		Condomino atualizado = condominoService.findByCpf("014.958.510-10");

	}

	@Test
	public void deveExcluirCondomino() {
		Condomino fatima = new Condomino(vivaVida, "Fátima Rodrigues", "014.958.510-10", "casa 05");
		condominoService.save(fatima);
		condominoService.deletar(fatima);

	}

	@Test(expected = ServiceException.class)
	public void deveValidarCondominoJaCadastradoPeloCpf() {
		Condomino fatima = new Condomino(vivaVida, "Fátima Rodrigues", "014.958.510-10", "casa 05");
		condominoService.save(fatima);
		condominoService.save(fatima);

	}
}
