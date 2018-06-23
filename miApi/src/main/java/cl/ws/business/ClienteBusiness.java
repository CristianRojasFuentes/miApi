package cl.ws.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cl.ws.cliente.ActualizarCliente;
import cl.ws.cliente.EliminarCliente;
import cl.ws.cliente.IngresarCliente;
import cl.ws.cliente.ObtenerCliente;
import cl.ws.dto.ClienteDTO;
import cl.ws.dto.RespuestaDTO;
import cl.ws.util.Constantes;
import cl.ws.util.Mensaje;

@Component
@Scope("prototype")
public class ClienteBusiness {

	private ObtenerCliente obtenerCliente;
	private IngresarCliente ingresarCliente;
	private ActualizarCliente actualizarCliente;
	private EliminarCliente eliminarCliente;

	
	public RespuestaDTO obtenerCliente(ClienteDTO c){
		RespuestaDTO resp = new RespuestaDTO();
	
		try{
			List<ClienteDTO> lista = obtenerCliente.obtenerCliente(c);
			
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
	

	public RespuestaDTO ingresarCliente(ClienteDTO c){
		RespuestaDTO resp = new RespuestaDTO();
		
		if(null == c.getNombreCliente()){
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("error.no.controlado"));
			
			return resp;
		}
		
		try{
			Integer index = ingresarCliente.ingreseCliente(c);
			
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


	public RespuestaDTO actualizarCliente(ClienteDTO c){
		RespuestaDTO resp = new RespuestaDTO();
		
		if(null == c.getIdCliente() || c.getIdCliente() < 1){
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("sin.id"));
			
			return resp;
		}
		
		if(null == c.getNombreCliente()){
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("error.no.controlado"));
			
			return resp;
		}
		
		try{
			Integer retorno = actualizarCliente.actualizarCliente(c);
			
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
	

	public RespuestaDTO eliminarCliente(ClienteDTO c){
		RespuestaDTO resp = new RespuestaDTO();
		
		if(null == c.getIdCliente() || c.getIdCliente() < 1){
			resp.setEstado(Constantes.NO_OK);
			resp.setMensaje(Mensaje.getAppProperty("sin.id"));
			
			return resp;
		}
		
		try{
			Integer retorno = eliminarCliente.eliminarCliente(c);
			
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
	public void setObtenerCliente(ObtenerCliente obtenerCliente) {
		this.obtenerCliente = obtenerCliente;
	}

	@Autowired
	public void setIngresarCliente(IngresarCliente ingresarCliente) {
		this.ingresarCliente = ingresarCliente;
	}

	@Autowired
	public void setActualizarCliente(ActualizarCliente actualizarCliente) {
		this.actualizarCliente = actualizarCliente;
	}

	@Autowired
	public void setEliminarCliente(EliminarCliente eliminarCliente) {
		this.eliminarCliente = eliminarCliente;
	}
	
	
	
	
	
	
	
		
	
}
