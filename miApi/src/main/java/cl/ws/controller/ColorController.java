package cl.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.ws.business.ColorBusiness;
import cl.ws.dto.ColorDTO;
import cl.ws.dto.RespuestaDTO;

@Controller
@RequestMapping("/color")
public class ColorController {
	
	private ColorBusiness colorBusiness;

	
	@RequestMapping(value = "/ingresarColor", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public RespuestaDTO ingresarColor(@RequestBody(required = true) final ColorDTO c){
		
		final RespuestaDTO dto = colorBusiness.ingresarColor(c);
		
		return dto;
	}
	
	@RequestMapping(value = "/obtenerColor", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public RespuestaDTO obtenerColor(@RequestBody(required = true) final ColorDTO c){
		
		final RespuestaDTO dto = colorBusiness.obtenerColor(c);
		
		return dto;
	}
	
	@RequestMapping(value = "/eliminarColor", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public RespuestaDTO eliminarColor(@RequestBody(required = true) final ColorDTO c){
		
		final RespuestaDTO dto = colorBusiness.eliminarColor(c);
		
		return dto;
	}
	
	
	@Autowired
	public void setColorBusiness(ColorBusiness colorBusiness) {
		this.colorBusiness = colorBusiness;
	}
	
	

}
