package cl.ws.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cl.ws.dto.ModeloDTO;
import cl.ws.dto.RespuestaDTO;
import cl.ws.modelo.ActualizarModelo;
import cl.ws.modelo.EliminarModelo;
import cl.ws.modelo.IngresarModelo;
import cl.ws.modelo.ObtenerModelo;
import cl.ws.util.Constantes;
import cl.ws.util.Mensaje;

/**
 * esta clase realiza el CRUD de la tabla Pais, negocio
 * @author David Rojas - drojas@mzzo.com
 *
 */

@Component
@Scope("prototype")
public class ModeloBusiness {

	private ObtenerModelo obtenerModelo;
	private IngresarModelo ingresarModelo;
	private ActualizarModelo actualizarModelo;
	private EliminarModelo eliminarModelo;


	public RespuestaDTO obtenerModelo(ModeloDTO m){
		RespuestaDTO resp = new RespuestaDTO();
	
		try{
			List<ModeloDTO> lista = obtenerModelo.obtenerModelo(m);
			
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


	public RespuestaDTO ingresarModelo(ModeloDTO m){
		RespuestaDTO resp = new RespuestaDTO();
		
		if(null == m.getNombreModelo()){
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("error.no.controlado"));
			
			return resp;
		}
		
		try{
			Integer index = ingresarModelo.ingresarModelo(m);
			
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


	public RespuestaDTO actualizarModelo(ModeloDTO m){
		RespuestaDTO resp = new RespuestaDTO();
		
		if(null == m.getIdModelo() || m.getIdModelo() < 1){
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("sin.id"));
			
			return resp;
		}
		
		if(null == m.getNombreModelo()){
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("error.no.controlado"));
			
			return resp;
		}
		
		try{
			Integer retorno = actualizarModelo.actualizarModelo(m);
			
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
	

	public RespuestaDTO eliminarModelo(ModeloDTO m){
		RespuestaDTO resp = new RespuestaDTO();
		
		if(null == m.getIdModelo() || m.getIdModelo() < 1){
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("sin.id"));
			
			return resp;
		}
		
		try{
			Integer retorno = eliminarModelo.eliminarModelo(m);
			
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
	public void setObtenerModelo(ObtenerModelo obtenerModelo) {
		this.obtenerModelo = obtenerModelo;
	}

	@Autowired
	public void setIngresarModelo(IngresarModelo ingresarModelo) {
		this.ingresarModelo = ingresarModelo;
	}

	@Autowired
	public void setActualizarModelo(ActualizarModelo actualizarModelo) {
		this.actualizarModelo = actualizarModelo;
	}

	@Autowired
	public void setEliminarModelo(EliminarModelo eliminarModelo) {
		this.eliminarModelo = eliminarModelo;
	}
		
	
}
