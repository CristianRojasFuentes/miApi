package cl.ws.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cl.ws.dto.ModeloColorDTO;
import cl.ws.dto.RespuestaDTO;
import cl.ws.modelocolor.EliminarModeloColor;
import cl.ws.modelocolor.IngresarModeloColor;
import cl.ws.modelocolor.ObtenerModeloColor;
import cl.ws.util.Constantes;
import cl.ws.util.Mensaje;

/**
 * esta clase realiza el CRUD de la tabla Pais, negocio
 * @author David Rojas - drojas@mzzo.com
 *
 */

@Component
@Scope("prototype")
public class ModeloColorBusiness {

	private ObtenerModeloColor obtenerModeloColor;
	private IngresarModeloColor ingresarModeloColor;
	private EliminarModeloColor eliminarModeloColor;


	public RespuestaDTO obtenerModeloColor(ModeloColorDTO m){
		RespuestaDTO resp = new RespuestaDTO();
	
		try{
			List<ModeloColorDTO> lista = obtenerModeloColor.obtenerModeloColor(m);
			
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


	public RespuestaDTO ingresarModeloColor(ModeloColorDTO m){
		RespuestaDTO resp = new RespuestaDTO();
		
		if(null == m.getCantidadMC() && null == m.getTallaMC()){
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("error.no.controlado"));
			
			return resp;
		}
		
		try{
			Integer index = ingresarModeloColor.ingresarModeloColor(m);
			
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


	

	public RespuestaDTO eliminarModeloColor(ModeloColorDTO m){
		RespuestaDTO resp = new RespuestaDTO();
		
		if(null == m.getIdMC() || m.getIdMC() < 1){
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("sin.id"));
			
			return resp;
		}
		if(null == m.getIdModeloMC() || m.getIdModeloMC() < 1){
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("sin.id"));
			
			return resp;
		}
		
		
		try{
			Integer retorno = eliminarModeloColor.eliminarModeloColor(m);
			
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
	public void setObtenerModeloColor(ObtenerModeloColor obtenerModeloColor) {
		this.obtenerModeloColor = obtenerModeloColor;
	}

	@Autowired
	public void setIngresarModeloColor(IngresarModeloColor ingresarModeloColor) {
		this.ingresarModeloColor = ingresarModeloColor;
	}

	@Autowired
	public void setEliminarModeloColor(EliminarModeloColor eliminarModeloColor) {
		this.eliminarModeloColor = eliminarModeloColor;
	}

	

	
}
