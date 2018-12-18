package br.com.condominio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.condominio.domain.Condomino;



@Repository
public interface CondominoRepository extends JpaRepository<Condomino, Integer>{
	
	@Query("SELECT COUNT(1) AS existe FROM Condomino c WHERE c.cpf = :cpf")
	public Long validateExistClientByCpf(@Param("cpf") String cpf);

	@Query("SELECT c FROM Condomino c WHERE c.cpf = :cpf")
	public Optional<Condomino> findByCpf(@Param("cpf") String cpf);
}
