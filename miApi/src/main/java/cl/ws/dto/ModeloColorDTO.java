package cl.ws.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ModeloColorDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("idMC")
	private Integer idMC;
	
	@JsonProperty("idModeloMC")
	private Integer idModeloMC;
	
	@JsonProperty("idColorMC")
	private Integer idColorMC;
	
	@JsonProperty("cantidadMC")
	private Integer cantidadMC;
	
	@JsonProperty("tallaMC")
	private Integer tallaMC;
	
	public Integer getIdMC() {
		return idMC;
	}
	public void setIdMC(Integer idMC) {
		this.idMC = idMC;
	}
	public Integer getIdModeloMC() {
		return idModeloMC;
	}
	public void setIdModeloMC(Integer idModeloMC) {
		this.idModeloMC = idModeloMC;
	}
	public Integer getIdColorMC() {
		return idColorMC;
	}
	public void setIdColorMC(Integer idColorMC) {
		this.idColorMC = idColorMC;
	}
	public Integer getCantidadMC() {
		return cantidadMC;
	}
	public void setCantidadMC(Integer cantidadMC) {
		this.cantidadMC = cantidadMC;
	}
	public Integer getTallaMC() {
		return tallaMC;
	}
	public void setTallaMC(Integer tallaMC) {
		this.tallaMC = tallaMC;
	}
	
	@Override
	public String toString() {
		return "ModeloColorDTO [idMC=" + idMC + ", idModeloMC=" + idModeloMC + ", idColorMC=" + idColorMC
				+ ", cantidadMC=" + cantidadMC + ", tallaMC=" + tallaMC + "]";
	}
	
}
