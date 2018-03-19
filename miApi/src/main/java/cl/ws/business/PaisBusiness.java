package cl.ws.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cl.ws.dto.PaisDTO;
import cl.ws.dto.RespuestaDTO;
import cl.ws.pais.ActualizarPais;
import cl.ws.pais.EliminarPais;
import cl.ws.pais.IngresarPais;
import cl.ws.pais.ObtenerPaisSP;
import cl.ws.util.Constantes;
import cl.ws.util.Mensaje;

/**
 * esta clase realiza el CRUD de la tabla Pais, negocio
 * @author David Rojas - drojas@mzzo.com
 *
 */

@Component
@Scope("prototype")
public class PaisBusiness {

	private ObtenerPaisSP obtenerPaisSP;
	private IngresarPais ingresarPais;
	private ActualizarPais actualizarPais;
	private EliminarPais eliminarPais;

	
	/**
	 * metodo obtenerPais
	 * 
	 * @param p
	 * @return resp
	 */
	public RespuestaDTO obtenerPais(PaisDTO p){
		RespuestaDTO resp = new RespuestaDTO();
	
		try{
			List<PaisDTO> lista = obtenerPaisSP.obtenerPais(p);
			
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
	
	/**
	 * metodo ingresarPais
	 * 
	 * @param p
	 * @return resp
	 */
	public RespuestaDTO ingresarPais(PaisDTO p){
		RespuestaDTO resp = new RespuestaDTO();
		
		if(null == p.getPaisNombre()){
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("error.no.controlado"));
			
			return resp;
		}
		
		try{
			Integer index = ingresarPais.ingresePais(p);
			
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

	/**
	 * metodo actualizarPais
	 * 
	 * @param p
	 * @return resp
	 */
	public RespuestaDTO actualizarPais(PaisDTO p){
		RespuestaDTO resp = new RespuestaDTO();
		
		if(null == p.getPaisId() || p.getPaisId() < 1){
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("sin.id"));
			
			return resp;
		}
		
		if(null == p.getPaisNombre()){
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("error.no.controlado"));
			
			return resp;
		}
		
		try{
			Integer retorno = actualizarPais.actualizarPais(p);
			
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
	
	/**
	 * metodo eliminarPais
	 * 
	 * @param p
	 * @return resp
	 */
	public RespuestaDTO eliminarPais(PaisDTO p){
		RespuestaDTO resp = new RespuestaDTO();
		
		if(null == p.getPaisId() || p.getPaisId() < 1){
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("sin.id"));
			
			return resp;
		}
		
		try{
			Integer retorno = eliminarPais.eliminarPais(p);
			
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
	public void setObtenerPaisSP(ObtenerPaisSP obtenerPaisSP) {
		this.obtenerPaisSP = obtenerPaisSP;
	}

	@Autowired
	public void setIngresarPais(IngresarPais ingresarPais) {
		this.ingresarPais = ingresarPais;
	}

	@Autowired
	public void setActualizarPais(ActualizarPais actualizarPais) {
		this.actualizarPais = actualizarPais;
	}

	@Autowired
	public void setEliminarPais(EliminarPais eliminarPais) {
		this.eliminarPais = eliminarPais;
	}
	
	
	
		
	
}
