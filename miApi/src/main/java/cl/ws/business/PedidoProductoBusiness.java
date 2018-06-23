package cl.ws.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cl.ws.dto.PedidoProductoDTO;
import cl.ws.dto.RespuestaDTO;
import cl.ws.pedidoproducto.EliminarPedidoProducto;
import cl.ws.pedidoproducto.IngresarPedidoProducto;
import cl.ws.pedidoproducto.ObtenerPedidoProducto;
import cl.ws.util.Constantes;
import cl.ws.util.Mensaje;

@Component
@Scope("prototype")
public class PedidoProductoBusiness {

	private ObtenerPedidoProducto obtenerPedidoProducto;
	private IngresarPedidoProducto ingresarPedidoProducto;
	private EliminarPedidoProducto eliminarPedidoProducto;

	
	public RespuestaDTO obtenerPedidoProducto(PedidoProductoDTO p){
		RespuestaDTO resp = new RespuestaDTO();
	
		try{
			List<PedidoProductoDTO> lista = obtenerPedidoProducto.obtenerPedidoProducto(p);
			
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
	

	public RespuestaDTO ingresarPedidoProducto(PedidoProductoDTO p){
		RespuestaDTO resp = new RespuestaDTO();
		
		if(null == p.getIdPedidoPP() && p.getIdPedidoPP() > 0){
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("error.no.controlado"));
			
			return resp;
		}
		
		if(null == p.getIdProductoPP() && p.getIdProductoPP() > 0){
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("error.no.controlado"));
			
			return resp;
		}
		if(null == p.getCantidadPP() && p.getCantidadPP() > 0){
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("error.no.controlado"));
			
			return resp;
		}
		if(null == p.getIdModeloPP() && p.getIdModeloPP() > 0){
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("error.no.controlado"));
			
			return resp;
		}
		
		try{
			Integer index = ingresarPedidoProducto.ingresePedidoProducto(p);
			
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

	public RespuestaDTO eliminarPedidoProducto(PedidoProductoDTO p){
		RespuestaDTO resp = new RespuestaDTO();
		
		if(null == p.getIdPedidoPP() || p.getIdPedidoPP() < 1){
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("sin.id"));
			
			return resp;
		}
		
		if(null == p.getIdPP() || p.getIdPP() < 1){
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("sin.id"));
			
			return resp;
		}
		
		try{
			Integer retorno = eliminarPedidoProducto.eliminarPedidoProducto(p);
			
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
	public void setObtenerPedidoProducto(ObtenerPedidoProducto obtenerPedidoProducto) {
		this.obtenerPedidoProducto = obtenerPedidoProducto;
	}

	@Autowired
	public void setIngresarPedidoProducto(IngresarPedidoProducto ingresarPedidoProducto) {
		this.ingresarPedidoProducto = ingresarPedidoProducto;
	}

	@Autowired
	public void setEliminarPedidoProducto(EliminarPedidoProducto eliminarPedidoProducto) {
		this.eliminarPedidoProducto = eliminarPedidoProducto;
	}

	

	
	
	
	
	
	
	
		
	
}
