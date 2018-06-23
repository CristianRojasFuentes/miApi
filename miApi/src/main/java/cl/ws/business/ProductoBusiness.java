package cl.ws.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cl.ws.dto.ProductoDTO;
import cl.ws.dto.ProductoModeloDTO;
import cl.ws.dto.RespuestaDTO;
import cl.ws.producto.ActualizarProducto;
import cl.ws.producto.EliminarProducto;
import cl.ws.producto.IngresarProducto;
import cl.ws.producto.ObtenerProducto;
import cl.ws.productomodelo.IngresarProductoModelo;
import cl.ws.util.Constantes;
import cl.ws.util.Mensaje;

@Component
@Scope("prototype")
public class ProductoBusiness {

	private ObtenerProducto obtenerProducto;
	private IngresarProducto ingresarProducto;
	private ActualizarProducto actualizarProducto;
	private EliminarProducto eliminarProducto;
	

	
	public RespuestaDTO obtenerProducto(ProductoDTO p){
		RespuestaDTO resp = new RespuestaDTO();
	
		try{
			List<ProductoDTO> lista = obtenerProducto.obtenerProducto(p);
			
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
	

	public RespuestaDTO ingresarProducto(ProductoDTO p){
		RespuestaDTO resp = new RespuestaDTO();
		
		if(null == p.getNombreProducto()){
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("error.no.controlado"));
			
			return resp;
		}
		if(null == p.getListaPM() && p.getListaPM().isEmpty()) {
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("lista.no.vacia"));
			
			return resp;
		}
		
		
		try{
			Integer index = ingresarProducto.ingreseProducto(p);
			
			
			
//			for(int i = 0; i < p.getListaPM().size(); i++) {
//			
//				ProductoModeloDTO pm = new ProductoModeloDTO();
//				pm.setIdProductoPM(index);
//				pm.setIdModeloPM(p.getListaPM().get(i).getIdModeloPM());
//				
//				ingresarProductoModelo.ingresaProductoModelo(pm);
//				
//			}
			
			
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


	public RespuestaDTO actualizarProducto(ProductoDTO p){
		RespuestaDTO resp = new RespuestaDTO();
		
		if(null == p.getIdProducto() || p.getIdProducto() < 1){
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("sin.id"));
			
			return resp;
		}
		
		if(null == p.getNombreProducto()){
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("error.no.controlado"));
			
			return resp;
		}
		
		try{
			Integer retorno = actualizarProducto.actualizarProducto(p);
			
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
	

	public RespuestaDTO eliminarProducto(ProductoDTO p){
		RespuestaDTO resp = new RespuestaDTO();
		
		if(null == p.getIdProducto() || p.getIdProducto() < 1){
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("sin.id"));
			
			return resp;
		}
		
		try{
			Integer retorno = eliminarProducto.eliminarProducto(p);
			
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
	public void setObtenerProducto(ObtenerProducto obtenerProducto) {
		this.obtenerProducto = obtenerProducto;
	}

	@Autowired
	public void setIngresarProducto(IngresarProducto ingresarProducto) {
		this.ingresarProducto = ingresarProducto;
	}

	@Autowired
	public void setActualizarProducto(ActualizarProducto actualizarProducto) {
		this.actualizarProducto = actualizarProducto;
	}

	@Autowired
	public void setEliminarProducto(EliminarProducto eliminarProducto) {
		this.eliminarProducto = eliminarProducto;
	}

	
	
}
