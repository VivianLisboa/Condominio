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
import br.com.condominio.dto.CondominoDTO;
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
	public void deveSalvarCondominoDTO() {

		CondominoDTO condominoDTO = new CondominoDTO();
		condominoDTO.setCondominio("13.383.247/0001-86");
		condominoDTO.setNome("Fátima Rodrigues");
		condominoDTO.setCpf("014.958.510-10");
		condominoDTO.setIdentificacaoUnidade("casa 05");

		condominoService.save(condominoDTO);
		CondominoDTO condomino = condominoService.findByCpf("014.958.510-10");

		Assert.assertEquals(vivaVida, condomino.getCondominio());
		Assert.assertEquals("Fátima Rodrigues", condomino.getNome());
		Assert.assertEquals("014.958.510-10", condomino.getCpf());
		Assert.assertEquals("casa 05", condomino.getIdentificacaoUnidade());

	}

	@Test

	public void deveFazerUpdateCondomino() {
		CondominoDTO condominoDTO = new CondominoDTO();
		condominoDTO.setCondominio("13.383.247/0001-86");
		condominoDTO.setNome("Fátima Rodrigues");
		condominoDTO.setCpf("014.958.510-10");
		condominoDTO.setIdentificacaoUnidade("casa 05");
		condominoService.save(condominoDTO);

		CondominoDTO fatimaSalvo = condominoService.findByCpf("014.958.510-10");
		fatimaSalvo.setIdentificacaoUnidade("casa 16");
		condominoService.update(fatimaSalvo);

		CondominoDTO atualizado = condominoService.findByCpf("014.958.510-10");
		Assert.assertEquals("casa 16", atualizado.getIdentificacaoUnidade());
	}
	
	@Test
	public void deveExcluirCondomino() {
		CondominoDTO condominoParaSalvar = new CondominoDTO();
		condominoParaSalvar.setCondominio("13.383.247/0001-86");
		condominoParaSalvar.setNome("Fátima Rodrigues");
		condominoParaSalvar.setCpf("014.958.510-10");
		condominoParaSalvar.setIdentificacaoUnidade("casa 05");
		condominoService.save(condominoParaSalvar);
		condominoService.deleteBycpf(condominoParaSalvar.getCpf());
	}

	@Test(expected = ServiceException.class)
	public void deveValidarCondominoJaCadastradoPeloCpf() {
		CondominoDTO condominoParaSalvar = new CondominoDTO();
		condominoParaSalvar.setCondominio("13.383.247/0001-86");
		condominoParaSalvar.setNome("Fátima Rodrigues");
		condominoParaSalvar.setCpf("014.958.510-10");
		condominoParaSalvar.setIdentificacaoUnidade("casa 05");
		condominoService.save(condominoParaSalvar);
		condominoService.save(condominoParaSalvar);

	}
}
