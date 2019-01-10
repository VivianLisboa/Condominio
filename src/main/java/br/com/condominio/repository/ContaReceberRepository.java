package br.com.condominio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.condominio.domain.ContaReceber;
import br.com.condominio.dto.CondominoDTO;

@Repository
public interface ContaReceberRepository extends JpaRepository<ContaReceber, Integer> {

	@Query("SELECT c FROM ContaReceber c WHERE c.condomino.identificacaoUnidade = :identificacaoUnidade")
	public Optional<ContaReceber> findByIdentificacaoUnidade(@Param("identificacaoUnidade") String identificacaoUnidade);

	
}