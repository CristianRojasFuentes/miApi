package cl.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.ws.business.ModeloColorBusiness;
import cl.ws.dto.ModeloColorDTO;
import cl.ws.dto.RespuestaDTO;

/**
 * Clase que se encargara de recibir peticiones y enviar peticiones solicitadas
 * @author Cristian Rojas - crojas.root@gmail.com
 *
 */
@Controller
@RequestMapping("/modeloColor")
public class ModeloColorController {

	private ModeloColorBusiness modeloColorBusiness;


	@RequestMapping(value = "/obtenerModeloColor", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public RespuestaDTO obtenerModeloColor(@RequestBody(required = true) final ModeloColorDTO m){
		
		final RespuestaDTO dto = modeloColorBusiness.obtenerModeloColor(m);
		
		return dto;
	}
	

	@RequestMapping(value = "/ingresarModeloColor", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public RespuestaDTO ingresarModeloColor(@RequestBody(required = true) final ModeloColorDTO m){
		
		final RespuestaDTO dto = modeloColorBusiness.ingresarModeloColor(m);
		
		return dto;
	}
	
	@RequestMapping(value = "/eliminarModeloColor", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public RespuestaDTO eliminarModeloColor(@RequestBody(required = true) final ModeloColorDTO m){
		
		final RespuestaDTO dto = modeloColorBusiness.eliminarModeloColor(m);
		
		return dto;
	}

	@Autowired
	public void setModeloColorBusiness(ModeloColorBusiness modeloColorBusiness) {
		this.modeloColorBusiness = modeloColorBusiness;
	}
	
}
