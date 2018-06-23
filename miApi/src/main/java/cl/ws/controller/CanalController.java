package cl.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.ws.business.CanalBusiness;
import cl.ws.dto.CanalDTO;
import cl.ws.dto.RespuestaDTO;

@Controller
@RequestMapping("/canal")
public class CanalController {
	
	private CanalBusiness canalBusiness;

	
	@RequestMapping(value = "/obtenerCanal", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public RespuestaDTO obtenerCanal(@RequestBody(required = true) final CanalDTO c){
		
		final RespuestaDTO dto = canalBusiness.obtenerCanal(c);
		
		return dto;
	}
	
	@Autowired
	public void setCanalBusiness(CanalBusiness canalBusiness) {
		this.canalBusiness = canalBusiness;
	}
	
	

}
