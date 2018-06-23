package cl.ws.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cl.ws.dto.PedidoDTO;
import cl.ws.dto.RespuestaDTO;
import cl.ws.pedido.ActualizarPedido;
import cl.ws.pedido.EliminarPedido;
import cl.ws.pedido.IngresarPedido;
import cl.ws.pedido.ObtenerPedido;
import cl.ws.util.Constantes;
import cl.ws.util.Mensaje;

@Component
@Scope("prototype")
public class PedidoBusiness {

	private ObtenerPedido obtenerPedido;
	private IngresarPedido ingresarPedido;
	private ActualizarPedido actualizarPedido;
	private EliminarPedido eliminarPedido;

	
	public RespuestaDTO obtenerPedido(PedidoDTO p){
		RespuestaDTO resp = new RespuestaDTO();
	
		try{
			List<PedidoDTO> lista = obtenerPedido.obtenerPedido(p);
			
			if(null == lista){
				resp.setEstado(Constantes.NO_OK);
				resp.setMensaje(Mensaje.getAppProperty("error.no.controlado"));
				
				return resp;
			}else{
				resp.setEstado(Constantes.OK);
				resp.setMensaje(Mensaje.getAppProperty("operacion.completa"));
				resp.setObjetoRetorno(lista);
				
				return resp;
			}
		}catch (Exception e) {
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("error.no.controlado"));
			
			return resp;
		}
	}
	

	public RespuestaDTO ingresarPedido(PedidoDTO p){
		RespuestaDTO resp = new RespuestaDTO();
		
		if(null == p.getIdClientePeddo()){
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("error.no.controlado"));
			
			return resp;
		}
		
		try{
			Integer index = ingresarPedido.ingresePedido(p);
			
			if(index == null || index < 1){
				resp.setEstado(Constantes.NO_OK);
				resp.setMensaje(Mensaje.getAppProperty("objecto.vacio"));
				
				return resp;
			}else{
				resp.setEstado(Constantes.OK);
				resp.setMensaje(Mensaje.getAppProperty("operacion.completa"));
				resp.setObjetoRetorno(index);
				
				return resp;
			}
			
		}catch (Exception e) {
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("error.no.controlado"));
			
			return resp;
		}
		
	}


	public RespuestaDTO actualizarPedido(PedidoDTO p){
		RespuestaDTO resp = new RespuestaDTO();
		
		if(null == p.getIdPedido() || p.getIdPedido() < 1){
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("sin.id"));
			
			return resp;
		}
		
		try{
			Integer retorno = actualizarPedido.actualizarPedido(p);
			
			if(retorno == null || retorno < 1){
				resp.setEstado(Constantes.NO_OK);
				resp.setMensaje(Mensaje.getAppProperty("objecto.vacio"));
				
				return resp;
			}else{
				resp.setEstado(Constantes.OK);
				resp.setMensaje(Mensaje.getAppProperty("operacion.completa"));
				resp.setObjetoRetorno(retorno);
				
				return resp;
			}
			
		}catch (Exception e) {
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("error.no.controlado"));
			
			return resp;
		}

	}
	

	public RespuestaDTO eliminarPedido(PedidoDTO p){
		RespuestaDTO resp = new RespuestaDTO();
		
		if(null == p.getIdPedido() || p.getIdPedido() < 1){
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("sin.id"));
			
			return resp;
		}
		
		if(null == p.getIdClientePeddo() || p.getIdClientePeddo() < 1){
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("sin.id"));
			
			return resp;
		}
		
		try{
			Integer retorno = eliminarPedido.eliminarPedido(p);
			
			if(retorno == null || retorno < 1){
				resp.setEstado(Constantes.NO_OK);
				resp.setMensaje(Mensaje.getAppProperty("objecto.vacio"));
				
				return resp;
			}else{
				resp.setEstado(Constantes.OK);
				resp.setMensaje(Mensaje.getAppProperty("operacion.completa"));
				resp.setObjetoRetorno(retorno);
				
				return resp;
			}
			
		}catch (Exception e) {
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("error.no.controlado"));
			
			return resp;
		}
	}

	@Autowired
	public void setObtenerPedido(ObtenerPedido obtenerPedido) {
		this.obtenerPedido = obtenerPedido;
	}

	@Autowired
	public void setIngresarPedido(IngresarPedido ingresarPedido) {
		this.ingresarPedido = ingresarPedido;
	}

	@Autowired
	public void setActualizarPedido(ActualizarPedido actualizarPedido) {
		this.actualizarPedido = actualizarPedido;
	}

	@Autowired
	public void setEliminarPedido(EliminarPedido eliminarPedido) {
		this.eliminarPedido = eliminarPedido;
	}

	

	
	
	
	
	
	
	
		
	
}
