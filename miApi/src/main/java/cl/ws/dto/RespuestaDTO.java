package cl.ws.dto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RespuestaDTO implements Serializable {

	private static final long serialVersionUID = -4734521614247079507L;

	@JsonProperty("estado")
	private String estado;
	
	@JsonProperty("mensaje")
	private String mensaje;
	
	@JsonProperty("objetoRetorno")
	private Object objetoRetorno;
	
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Object getObjetoRetorno() {
		return objetoRetorno;
	}
	public void setObjetoRetorno(Object objetoRetorno) {
		this.objetoRetorno = objetoRetorno;
	}
	
	@Override
	public String toString() {
		return "   {\"estado\":\"" + estado + "\","
				+ " \"mensaje\":\"" + mensaje + "\","
				+ " \"objetoRetorno\":\"" + objetoRetorno + "\"}";
	} 
}