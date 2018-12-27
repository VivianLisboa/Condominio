package br.com.condominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.condominio.domain.ContaReceber;


@Repository
public interface ContaReceberRepository extends JpaRepository<ContaReceber, Integer>{

//@Query("SETECT r FROM CtaReceber r WHERE r.id_contaReceber_boleto "){
	
}

