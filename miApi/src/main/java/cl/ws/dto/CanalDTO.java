package cl.ws.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CanalDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	@JsonProperty("idCanal")
	private Integer idCanal;
	
	@JsonProperty("nombreCanal")
	private String nombreCanal;
	
	public Integer getIdCanal() {
		return idCanal;
	}
	public void setIdCanal(Integer idCanal) {
		this.idCanal = idCanal;
	}
	public String getNombreCanal() {
		return nombreCanal;
	}
	public void setNombreCanal(String nombreCanal) {
		this.nombreCanal = nombreCanal;
	}
	@Override
	public String toString() {
		return "CanalDTO [idCanal=" + idCanal + ", nombreCanal=" + nombreCanal + "]";
	}
	
	
}
