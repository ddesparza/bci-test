package bci.test.practico.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bci.test.practico.model.Cliente;
import bci.test.practico.repository.IClienteRepository;
import bci.test.practico.services.ICliente;
import bci.test.practico.services.imple.ClienteServices;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
@RestController
public class GenerarToken {
	
	@Autowired
	IClienteRepository clienteRepository;
	
	@Autowired
	ICliente clienteServices;
	
	private static final Logger logger = LoggerFactory.getLogger(GenerarToken.class);
	
	@PostMapping("/token/user/{username}/{password}")
	public Map<String, String> login(@PathVariable String username, @PathVariable String password) {
		 logger.info("Datos obtencion token ");
		 logger.info("password : "+ password);
		 logger.info("username : "+ username);
		
		Cliente clienteXcorreo = null;
		 clienteXcorreo = clienteRepository.buscarCLienteXcorreo(username);
		
		 
		 logger.info("Usuario obtenido : " + clienteXcorreo.toString());

		if (clienteXcorreo.getPassword().equals(password)) {
			String token = getJWTToken(username);
			
			Map<String, String> respuestaToken = new HashMap<>();
			respuestaToken.put("username", clienteXcorreo.getEmail());
			respuestaToken.put("token", token);
			
			 logger.info("Actualizando fecha de ultimo ingreso : " + clienteXcorreo.toString());
			 clienteXcorreo.setLastLogin(new Date ());
			 

			 
			 clienteServices.actualizaCliente(clienteXcorreo);
			 
			return respuestaToken;
		}
		
		Map<String, String> respuestaToken = new HashMap<>();
		respuestaToken.put("code", "503");
		respuestaToken.put("Obs", "CLave o correo erroneo");
		return respuestaToken;
		
	}

	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}
