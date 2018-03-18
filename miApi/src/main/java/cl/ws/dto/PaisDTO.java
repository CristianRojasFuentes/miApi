package cl.ws.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaisDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	@JsonProperty("paisId")
	private Integer paisId;
	
	@JsonProperty("paisNombre")
	private String paisNombre;

	public Integer getPaisId() {
		return paisId;
	}

	public void setPaisId(Integer paisId) {
		this.paisId = paisId;
	}

	public String getPaisNombre() {
		return paisNombre;
	}

	public void setPaisNombre(String paisNombre) {
		this.paisNombre = paisNombre;
	}

	@Override
	public String toString() {
		return "PaisDTO [paisId=" + paisId + ", paisNombre=" + paisNombre + "]";
	}
	
	
		

}
