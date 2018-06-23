package cl.ws.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ModeloDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("idModelo")
	private Integer idModelo;
	
	@JsonProperty("nombreModelo")
	private String nombreModelo;
	
	public Integer getIdModelo() {
		return idModelo;
	}
	public void setIdModelo(Integer idModelo) {
		this.idModelo = idModelo;
	}
	public String getNombreModelo() {
		return nombreModelo;
	}
	public void setNombreModelo(String nombreModelo) {
		this.nombreModelo = nombreModelo;
	}
	@Override
	public String toString() {
		return "ModeloDTO [idModelo=" + idModelo + ", nombreModelo=" + nombreModelo + "]";
	}
	
	

}
