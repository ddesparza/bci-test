package bci.test.practico.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bci.test.practico.model.Cliente;
import bci.test.practico.model.ErrorGenerico;
import bci.test.practico.services.ICliente;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Valid
@RestController
@Api(value = "InfoCliente", description = "InfoCliente")
public class InfoCliente {
	
	
	@Autowired
	ICliente clientesServicies;

	@ApiOperation(value = "Se obtienen datos del Cliente indica informacion (name, email, password, phones)", nickname = "getlistacodigos", notes = ""
			+ "| 400 | `error_en_formato_invalido` | Parametros enviados invalidos |\r\n"
			+ "| 400 | `error_casteo` | Se recibe error HttpServerErrorException |\r\n"
			+ "| 400 | `ERROR_TIMEOUT` | Se recibe error ResourceAccessException |\r\n"
			+ "| 400 | `error_interno` | Se recibe error InternalServerError |\r\n"
			+ "| 500 | `error_no_controlado` | Error no controlado |\r\n"
			+ "| 504 | `error_gateway_socket` | Se recibe error SocketException |", response = ErrorGenerico.class, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Operacion exitosa", response = ErrorGenerico.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorGenerico.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorGenerico.class) })
	@RequestMapping(value = "/api/v1/cliente", produces = { "application/json" }, method = RequestMethod.GET)
	List<Cliente> clienteInfo() {
		return clientesServicies.listaCliente();
	}
	
	
	
	@ApiOperation(value = "Se crea Cliente indica informacion (name, email, password, phones)", nickname = "getlistacodigos", notes = ""
			+ "| 400 | `error_en_formato_invalido` | Parametros enviados invalidos |\r\n"
			+ "| 400 | `error_casteo` | Se recibe error HttpServerErrorException |\r\n"
			+ "| 400 | `ERROR_TIMEOUT` | Se recibe error ResourceAccessException |\r\n"
			+ "| 400 | `error_interno` | Se recibe error InternalServerError |\r\n"
			+ "| 500 | `error_no_controlado` | Error no controlado |\r\n"
			+ "| 504 | `error_gateway_socket` | Se recibe error SocketException |", response = ErrorGenerico.class, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Operacion exitosa", response = ErrorGenerico.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorGenerico.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorGenerico.class) })
	@RequestMapping(value = "/api/v1/cliente", produces = { "application/json" }, method = RequestMethod.POST)
	Optional<Cliente> clienteCrear(
			@ApiParam(value = "Datos rqueridos name, email, password, phones",
			example = "Cliente", required = true) @Valid @RequestBody Cliente cliente) {
		return clientesServicies.crearCliente(cliente);
	}

	@ApiOperation(value = "Se crea Cliente indica informacion (name, email, password, phones)", nickname = "getlistacodigos", notes = ""
			+ "| 400 | `error_en_formato_invalido` | Parametros enviados invalidos |\r\n"
			+ "| 400 | `error_casteo` | Se recibe error HttpServerErrorException |\r\n"
			+ "| 400 | `ERROR_TIMEOUT` | Se recibe error ResourceAccessException |\r\n"
			+ "| 400 | `error_interno` | Se recibe error InternalServerError |\r\n"
			+ "| 500 | `error_no_controlado` | Error no controlado |\r\n"
			+ "| 504 | `error_gateway_socket` | Se recibe error SocketException |", response = ErrorGenerico.class, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Operacion exitosa", response = ErrorGenerico.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorGenerico.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorGenerico.class) })
	@RequestMapping(value = "/api/v1/cliente", produces = { "application/json" }, method = RequestMethod.PUT)
	Optional<Cliente> clienteActualizar(
			@ApiParam(value = "Datos rqueridos name, email, password, phones",
			example = "Cliente", required = true) @Valid @RequestBody Cliente cliente) {
		return clientesServicies.actualizaCliente(cliente);
	}

}
