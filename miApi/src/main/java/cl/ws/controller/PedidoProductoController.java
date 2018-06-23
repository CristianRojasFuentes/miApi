package cl.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.ws.business.PedidoProductoBusiness;
import cl.ws.dto.PedidoProductoDTO;
import cl.ws.dto.RespuestaDTO;

@Controller
@RequestMapping("/pedidoProducto")
public class PedidoProductoController {

	private PedidoProductoBusiness pedidoProductoBusiness;


	@RequestMapping(value = "/obtenerPedidoProducto", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public RespuestaDTO obtenerPedidoProducto(@RequestBody(required = true) final PedidoProductoDTO p){
		
		final RespuestaDTO dto = pedidoProductoBusiness.obtenerPedidoProducto(p);
		
		return dto;
	}
	
	@RequestMapping(value = "/ingresarPedidoProducto", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public RespuestaDTO ingresarPedidoProducto(@RequestBody(required = true) final PedidoProductoDTO p){
		
		final RespuestaDTO dto = pedidoProductoBusiness.ingresarPedidoProducto(p);
		
		return dto;
	}
	
	@RequestMapping(value = "/eliminarPedidoProducto", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public RespuestaDTO eliminarPedidoProducto(@RequestBody(required = true) final PedidoProductoDTO p){
		
		final RespuestaDTO dto = pedidoProductoBusiness.eliminarPedidoProducto(p);
		
		return dto;
	}

	@Autowired
	public void setPedidoProductoBusiness(PedidoProductoBusiness pedidoProductoBusiness) {
		this.pedidoProductoBusiness = pedidoProductoBusiness;
	}

}
