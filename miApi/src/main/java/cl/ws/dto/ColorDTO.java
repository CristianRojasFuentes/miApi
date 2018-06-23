package cl.ws.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ColorDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("idColor")
	private Integer idColor;
	
	@JsonProperty("nombreColor")
	private String nombreColor;
	
	public Integer getIdColor() {
		return idColor;
	}
	public void setIdColor(Integer idColor) {
		this.idColor = idColor;
	}
	public String getNombreColor() {
		return nombreColor;
	}
	public void setNombreColor(String nombreColor) {
		this.nombreColor = nombreColor;
	}
	
	@Override
	public String toString() {
		return "Color [idColor=" + idColor + ", nombreColor=" + nombreColor + "]";
	}
	
}
