package cl.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.ws.business.ModeloBusiness;
import cl.ws.dto.ModeloDTO;
import cl.ws.dto.RespuestaDTO;

/**
 * Clase que se encargara de recibir peticiones y enviar peticiones solicitadas
 * @author Cristian Rojas - crojas.root@gmail.com
 *
 */
@Controller
@RequestMapping("/modelo")
public class ModeloController {

	private ModeloBusiness modeloBusiness;


	@RequestMapping(value = "/obtenerModelo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public RespuestaDTO obtenerModelo(@RequestBody(required = true) final ModeloDTO m){
		
		final RespuestaDTO dto = modeloBusiness.obtenerModelo(m);
		
		return dto;
	}
	

	@RequestMapping(value = "/ingresarModelo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public RespuestaDTO ingresarModelo(@RequestBody(required = true) final ModeloDTO m){
		
		final RespuestaDTO dto = modeloBusiness.ingresarModelo(m);
		
		return dto;
	}
	
	@RequestMapping(value = "/actualizarModelo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public RespuestaDTO actualizarModelo(@RequestBody(required = true) final ModeloDTO m){
		
		final RespuestaDTO dto = modeloBusiness.actualizarModelo(m);
		
		return dto;
	}
	
	@RequestMapping(value = "/eliminarModelo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public RespuestaDTO eliminarModelo(@RequestBody(required = true) final ModeloDTO m){
		
		final RespuestaDTO dto = modeloBusiness.eliminarModelo(m);
		
		return dto;
	}

	@Autowired
	public void setModeloBusiness(ModeloBusiness modeloBusiness) {
		this.modeloBusiness = modeloBusiness;
	}
	
}
