package cl.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.ws.business.PedidoBusiness;
import cl.ws.dto.PedidoDTO;
import cl.ws.dto.RespuestaDTO;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

	private PedidoBusiness pedidoBusiness;


	@RequestMapping(value = "/obtenerPedido", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public RespuestaDTO obtenerPedido(@RequestBody(required = true) final PedidoDTO p){
		
		final RespuestaDTO dto = pedidoBusiness.obtenerPedido(p);
		
		return dto;
	}
	
	@RequestMapping(value = "/ingresarPedido", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public RespuestaDTO ingresarPedido(@RequestBody(required = true) final PedidoDTO p){
		
		final RespuestaDTO dto = pedidoBusiness.ingresarPedido(p);
		
		return dto;
	}
	
	@RequestMapping(value = "/actualizarPedido", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public RespuestaDTO actualizarPedido(@RequestBody(required = true) final PedidoDTO p){
		
		final RespuestaDTO dto = pedidoBusiness.actualizarPedido(p);
		
		return dto;
	}
	
	@RequestMapping(value = "/eliminarPedido", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public RespuestaDTO eliminarPedido(@RequestBody(required = true) final PedidoDTO p){
		
		final RespuestaDTO dto = pedidoBusiness.eliminarPedido(p);
		
		return dto;
	}

	@Autowired
	public void setPedidoBusiness(PedidoBusiness pedidoBusiness) {
		this.pedidoBusiness = pedidoBusiness;
	}

}
