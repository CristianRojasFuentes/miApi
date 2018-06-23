package cl.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.ws.business.ClienteBusiness;
import cl.ws.dto.ClienteDTO;
import cl.ws.dto.RespuestaDTO;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	private ClienteBusiness clienteBusiness;


	@RequestMapping(value = "/obtenerCliente", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public RespuestaDTO obtenerCliente(@RequestBody(required = true) final ClienteDTO c){
		
		final RespuestaDTO dto = clienteBusiness.obtenerCliente(c);
		
		return dto;
	}
	
	@RequestMapping(value = "/ingresarCliente", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public RespuestaDTO ingresarCliente(@RequestBody(required = true) final ClienteDTO c){
		
		final RespuestaDTO dto = clienteBusiness.ingresarCliente(c);
		
		return dto;
	}
	
	@RequestMapping(value = "/actualizarCliente", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public RespuestaDTO actualizarCliente(@RequestBody(required = true) final ClienteDTO c){
		
		final RespuestaDTO dto = clienteBusiness.actualizarCliente(c);
		
		return dto;
	}
	
	@RequestMapping(value = "/eliminarCliente", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public RespuestaDTO eliminarCliente(@RequestBody(required = true) final ClienteDTO c){
		
		final RespuestaDTO dto = clienteBusiness.eliminarCliente(c);
		
		return dto;
	}

	@Autowired
	public void setClienteBusiness(ClienteBusiness clienteBusiness) {
		this.clienteBusiness = clienteBusiness;
	}

}
