package bci.test.practico.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import bci.test.practico.model.Cliente;

public interface IClienteRepository  extends JpaRepository<Cliente, String>{
	
	
	@Query(value = "SELECT * FROM TBL_CLIENTE A WHERE A.EMAIL = :email", nativeQuery = true)
	Cliente buscarCLienteXcorreo(String email);

}
