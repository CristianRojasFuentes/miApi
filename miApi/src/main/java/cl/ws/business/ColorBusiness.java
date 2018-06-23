package cl.ws.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cl.ws.color.EliminarColor;
import cl.ws.color.IngresarColor;
import cl.ws.color.ObtenerColor;
import cl.ws.dto.ColorDTO;
import cl.ws.dto.RespuestaDTO;
import cl.ws.util.Constantes;
import cl.ws.util.Mensaje;

@Component
@Scope("prototype")
public class ColorBusiness {

	private IngresarColor ingresarColor;
	private ObtenerColor obtenerColor;
	private EliminarColor eliminarColor;
	
	public RespuestaDTO ingresarColor(ColorDTO c) {
		RespuestaDTO resp = new RespuestaDTO();
		
		if(null == c.getNombreColor() || "".equals(c.getNombreColor()) ){
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("error.no.controlado"));
			
			return resp;
		}
		
		try{
			Integer index = ingresarColor.ingresaColor(c);
			
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

	public RespuestaDTO obtenerColor(ColorDTO c){
		RespuestaDTO resp = new RespuestaDTO();
	
		try{
			List<ColorDTO> lista = obtenerColor.obtenerColor(c);
			
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
	
	
	public RespuestaDTO eliminarColor(ColorDTO c){
		RespuestaDTO resp = new RespuestaDTO();
	
		try{
			Integer retorno = eliminarColor.eliminarColor(c);
			
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
	public void setIngresarColor(IngresarColor ingresarColor) {
		this.ingresarColor = ingresarColor;
	}
	
	@Autowired
	public void setObtenerColor(ObtenerColor obtenerColor) {
		this.obtenerColor = obtenerColor;
	}

	@Autowired
	public void setEliminarColor(EliminarColor eliminarColor) {
		this.eliminarColor = eliminarColor;
	}
	
	
	
	
}
