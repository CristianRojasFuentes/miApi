package cl.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.ws.business.ProductoModeloBusiness;
import cl.ws.dto.ProductoModeloDTO;
import cl.ws.dto.RespuestaDTO;

@Controller
@RequestMapping("/productoModelo")
public class ProductoModeloController {
	
	private ProductoModeloBusiness productoModeloBusiness;

	
	@RequestMapping(value = "/ingresarProductoModelo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public RespuestaDTO ingresarProductoModelo(@RequestBody(required = true) final ProductoModeloDTO pm){
		
		final RespuestaDTO dto = productoModeloBusiness.ingresarProductoModelo(pm);
		
		return dto;
	}
	
	@RequestMapping(value = "/obtenerProductoModelo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public RespuestaDTO obtenerProductoModelo(@RequestBody(required = true) final ProductoModeloDTO pm){
		
		final RespuestaDTO dto = productoModeloBusiness.obtenerProductoModelo(pm);
		
		return dto;
	}
	
	@RequestMapping(value = "/eliminarProductoModelo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public RespuestaDTO eliminarProductoModelo(@RequestBody(required = true) final ProductoModeloDTO pm){
		
		final RespuestaDTO dto = productoModeloBusiness.eliminarProductoModelo(pm);
		
		return dto;
	}
	
	
	@Autowired
	public void setProductoModeloBusiness(ProductoModeloBusiness productoModeloBusiness) {
		this.productoModeloBusiness = productoModeloBusiness;
	}
	
	

}
