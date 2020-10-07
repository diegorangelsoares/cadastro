package com.diego.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diego.cadastro.model.Cliente;
import com.diego.cadastro.model.Usuario;

/**
 * Repositório de clientes
 * @author Diego Rangel - diegorangeljpa@gmail.com
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	

	/*
	@Query("SELECT c FROM TAB_CLIENTE c WHERE LOWER(c.id)")
    Cliente findByID(@Param("searchTerm") Integer searchTerm);
	*/
	
	Cliente findByNome(String nome);
	
	Cliente findById(long id);

	Cliente findByCpf(String cpf);

		
	

}
