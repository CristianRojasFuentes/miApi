package cl.ws.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cl.ws.dto.ProductoModeloDTO;
import cl.ws.dto.RespuestaDTO;
import cl.ws.productomodelo.EliminarProductoModelo;
import cl.ws.productomodelo.IngresarProductoModelo;
import cl.ws.productomodelo.ObtenerProductoModelo;
import cl.ws.util.Constantes;
import cl.ws.util.Mensaje;

@Component
@Scope("prototype")
public class ProductoModeloBusiness {

	private IngresarProductoModelo ingresarProductoModelo;
	private ObtenerProductoModelo obtenerProductoModelo;
	private EliminarProductoModelo eliminarProductoModelo;
	
	public RespuestaDTO ingresarProductoModelo(ProductoModeloDTO pm) {
		RespuestaDTO resp = new RespuestaDTO();
		
		if(null == pm.getIdProductoPM() || "".equals(pm.getIdProductoPM()) ){
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("error.no.controlado"));
			
			return resp;
		}
		if(null == pm.getIdModeloPM() || "".equals(pm.getIdModeloPM()) ){
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("error.no.controlado"));
			
			return resp;
		}
		
		try{
			Integer index = ingresarProductoModelo.ingresaProductoModelo(pm);
			
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

	public RespuestaDTO obtenerProductoModelo(ProductoModeloDTO pm){
		RespuestaDTO resp = new RespuestaDTO();
	
		try{
			List<ProductoModeloDTO> lista = obtenerProductoModelo.obtenerProductoModelo(pm);
			
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
	
	
	public RespuestaDTO eliminarProductoModelo(ProductoModeloDTO pm){
		RespuestaDTO resp = new RespuestaDTO();
	
		try{
			Integer retorno = eliminarProductoModelo.eliminarProductoModelo(pm);
			
			if(null == retorno){
				resp.setEstado(Constantes.NO_OK);
				resp.setMensaje(Mensaje.getAppProperty("error.no.controlado"));
				
				return resp;
			}else{
				resp.setEstado(Constantes.OK);
				resp.setMensaje(Mensaje.getAppProperty("operacion.completa"));
				
				return resp;
			}
		}catch (Exception e) {
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("error.no.controlado"));
			
			return resp;
		}
	}

	@Autowired
	public void setIngresarProductoModelo(IngresarProductoModelo ingresarProductoModelo) {
		this.ingresarProductoModelo = ingresarProductoModelo;
	}

	@Autowired
	public void setObtenerProductoModelo(ObtenerProductoModelo obtenerProductoModelo) {
		this.obtenerProductoModelo = obtenerProductoModelo;
	}

	@Autowired
	public void setEliminarProductoModelo(EliminarProductoModelo eliminarProductoModelo) {
		this.eliminarProductoModelo = eliminarProductoModelo;
	}
	
	
		
}
