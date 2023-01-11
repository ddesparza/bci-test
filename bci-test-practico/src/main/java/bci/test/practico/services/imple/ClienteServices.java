package bci.test.practico.services.imple;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import bci.test.practico.model.Cliente;
import bci.test.practico.model.Phones;
import bci.test.practico.repository.IClienteRepository;
import bci.test.practico.repository.IPhonesRepository;
import bci.test.practico.services.ICliente;
import bci.test.practico.services.IPhone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ClienteServices implements ICliente{
	
	
	private static final Logger logger = LoggerFactory.getLogger(ClienteServices.class);
	
	@Autowired
	IClienteRepository repoCliente;
	@Autowired
	IPhonesRepository repoPhones;

	@Override
	public List<Cliente> listaCliente() {
		logger.info("Obteniendo lista de cliente");
		// TODO Auto-generated method stub
		List<Cliente> clientes = repoCliente.findAll();
		if (!clientes.isEmpty()) {
			return clientes;
		}
		
		 throw new RuntimeException("Sin clientes");
	}

	@Override
	public Optional<Cliente> crearCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		Date  dNow = new Date ();

		Cliente buscarCliente = null;
		 buscarCliente = repoCliente.buscarCLienteXcorreo(cliente.getEmail());
		
		 
		 
		 
		if (buscarCliente == null) {
			logger.info("Cliente valido, creado... " + cliente.toString());

			cliente.setCreated(dNow);
			Cliente clientenew = repoCliente.save(cliente);
			
			List<Phones> phones = cliente.getPhones();
			phones.forEach(p -> p.setCliente(clientenew));
			
			
			repoPhones.saveAll(phones);
			Optional<Cliente> clienteFinal =null;
			clienteFinal = repoCliente.findById(clientenew.getId());
			
			return clienteFinal;
		}
		
		logger.info("El correo ya registrado");
		throw new RuntimeException("El correo ya registrado");
		
		
		
	}

	@Override
	public Optional<Cliente> actualizaCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		
		Cliente buscarCliente = null;
		
		 buscarCliente = repoCliente.buscarCLienteXcorreo(cliente.getEmail());
		 
				logger.info("Cliente valido, actualizando..... " + cliente.toString());

				cliente.setModified(new Date());
				
				
				Cliente clientenew = repoCliente.save(cliente);
				
				List<Phones> phones = cliente.getPhones();
				phones.forEach(p -> p.setCliente(clientenew));
				
				
				repoPhones.saveAll(phones);
				Optional<Cliente> clienteFinal =null;
				clienteFinal = repoCliente.findById(clientenew.getId());
				
				return clienteFinal;
			
			

	}

}
