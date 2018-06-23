package cl.ws.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cl.ws.canal.ObtenerCanal;
import cl.ws.dto.CanalDTO;
import cl.ws.dto.RespuestaDTO;
import cl.ws.util.Constantes;
import cl.ws.util.Mensaje;

@Component
@Scope("prototype")
public class CanalBusiness {

	private ObtenerCanal obtenerCanal;
	
	
	public RespuestaDTO obtenerCanal(CanalDTO c){
		RespuestaDTO resp = new RespuestaDTO();
	
		try{
			List<CanalDTO> lista = obtenerCanal.obtenerCanal(c);
			
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

	@Autowired
	public void setObtenerCanal(ObtenerCanal obtenerCanal) {
		this.obtenerCanal = obtenerCanal;
	}
	
	
		
	
	
}
