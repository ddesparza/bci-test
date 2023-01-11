package bci.test.practico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import bci.test.practico.model.Cliente;

public interface ICliente {
	
	public List<Cliente> listaCliente ();
	
	
	public Optional<Cliente> crearCliente (Cliente cliente);
	
	
	public Optional<Cliente> actualizaCliente (Cliente cliente);

}
