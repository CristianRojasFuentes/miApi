package cl.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.ws.business.ProductoBusiness;
import cl.ws.dto.ProductoDTO;
import cl.ws.dto.RespuestaDTO;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	private ProductoBusiness productoBusiness;


	@RequestMapping(value = "/obtenerProducto", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public RespuestaDTO obtenerProducto(@RequestBody(required = true) final ProductoDTO p){
		
		final RespuestaDTO dto = productoBusiness.obtenerProducto(p);
		
		return dto;
	}
	
	@RequestMapping(value = "/ingresarProducto", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public RespuestaDTO ingresarProducto(@RequestBody(required = true) final ProductoDTO p){
		
		final RespuestaDTO dto = productoBusiness.ingresarProducto(p);
		
		return dto;
	}
	
	@RequestMapping(value = "/actualizarProducto", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public RespuestaDTO actualizarProducto(@RequestBody(required = true) final ProductoDTO p){
		
		final RespuestaDTO dto = productoBusiness.actualizarProducto(p);
		
		return dto;
	}
	
	@RequestMapping(value = "/eliminarProducto", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public RespuestaDTO eliminarProducto(@RequestBody(required = true) final ProductoDTO p){
		
		final RespuestaDTO dto = productoBusiness.eliminarProducto(p);
		
		return dto;
	}

	@Autowired
	public void setProductoBusiness(ProductoBusiness productoBusiness) {
		this.productoBusiness = productoBusiness;
	}

}
