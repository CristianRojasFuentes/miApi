package cl.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.ws.business.PaisBusiness;
import cl.ws.dto.PaisDTO;
import cl.ws.dto.RespuestaDTO;

/**
 * Clase que se encargara de recibir peticiones y enviar peticiones solicitadas
 * @author Cristian Rojas - crojas.root@gmail.com
 *
 */
@Controller
@RequestMapping("/pais")
public class PaisController {

	private PaisBusiness paisBusiness;

	/**
	 * metodo obtienePais, es encargada de obtener los registros desde la BD.
	 * @param p
	 * @return List<PaisDTO> dto
	 */
	@RequestMapping(value = "/obtenerPais", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public RespuestaDTO obtenerPais(@RequestBody(required = true) final PaisDTO p){
		
		final RespuestaDTO dto = paisBusiness.obtenerPais(p);
		
		return dto;
	}
	
	/**
	 * metodo encargada de registrar un pais en la BD
	 * @param p
	 * @return dto
	 */
	@RequestMapping(value = "/ingresarPais", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public RespuestaDTO ingresarPais(@RequestBody(required = true) final PaisDTO p){
		
		final RespuestaDTO dto = paisBusiness.ingresarPais(p);
		
		return dto;
	}
	
	/**
	 * metodo encargada de actualizar un pais en la BD
	 * @param p
	 * @return dto
	 */
	@RequestMapping(value = "/actualizarPais", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public RespuestaDTO actualizarPais(@RequestBody(required = true) final PaisDTO p){
		
		final RespuestaDTO dto = paisBusiness.actualizarPais(p);
		
		return dto;
	}
	
	/**
	 * metodo encargada de eliminar un pais en la BD, eliminado logico
	 * @param p
	 * @return dto
	 */
	@RequestMapping(value = "/eliminarPais", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public RespuestaDTO eliminarPais(@RequestBody(required = true) final PaisDTO p){
		
		final RespuestaDTO dto = paisBusiness.eliminarPais(p);
		
		return dto;
	}

	@Autowired
	public void setPaisBusiness(PaisBusiness paisBusiness) {
		this.paisBusiness = paisBusiness;
	}
		
	
}
