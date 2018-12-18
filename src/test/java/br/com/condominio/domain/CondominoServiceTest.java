package br.com.condominio.domain;

import org.hibernate.service.spi.ServiceException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.condominio.repository.CondominioRepository;
import br.com.condominio.service.CondominioService;
import br.com.condominio.service.CondominoService;

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
		vivaVida = new Condominio("vivaVida", "20.345.917/0001-65", "32580644");
		condominioRepository.saveAndFlush(vivaVida);
	}

	@Test
	public void deveSalvarCondominoCamposObrigatorios() {

		Condomino fatima = new Condomino(vivaVida, "Fátima Rodrigues", "041.867.300-98", "casa 05");
		condominoService.save(fatima);
			

		Condomino condominoSalva = condominoService.findByCpf("041.867.300-98");
		Assert.assertEquals(vivaVida, condominoSalva.getCondominio());
		Assert.assertEquals("Fátima Rodrigues", fatima.getNome());
		Assert.assertEquals("041.867.300-98", fatima.getCpf());
		Assert.assertEquals("casa 05", fatima.getIdentifUnidade());
	}
	
	
	 @Test

	 public void deveFazerUpdateCondomino() {
	Condomino fatima = new Condomino(vivaVida, "Fátima Rodrigues", "041.867.300-98", "casa 05");
	condominoService.save(fatima);
	
	Condomino fatimaSalvo = condominoService.findByCpf("041.867.300-98");
	
	Condomino novoCondomino = new Condomino (fatimaSalvo.getId(), vivaVida, "Fátima Rodrigues", "041.867.300-98","casa 16");
	condominoService.upadate(fatima);
	
	Condomino atualizado = condominoService.findByCpf("041.867.300-98");

	 }
	 
	 @Test
	 public void deveExcluirCondomino() {
		 Condomino fatima = new Condomino(vivaVida, "Fátima Rodrigues", "041.867.300-98", "casa 05");
		 condominoService.save(fatima);
		 condominoService.deletar(fatima);
		 
	 }
	@Test(expected = ServiceException.class)
	public void deveValidarCondominoJaCadastradoPeloCpf() {
		Condomino fatima = new Condomino(vivaVida, "Fátima Rodrigues", "041.867.300-98", "casa 05");
		condominoService.save(fatima);
		condominoService.save(fatima);

	}
}
