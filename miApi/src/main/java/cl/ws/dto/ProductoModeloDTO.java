package cl.ws.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductoModeloDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("idPM")
	private Integer idPM;

	@JsonProperty("idProductoPM")
	private Integer idProductoPM;
	
	@JsonProperty("idModeloPM")
	private Integer idModeloPM;
	
	public Integer getIdPM() {
		return idPM;
	}
	public void setIdPM(Integer idPM) {
		this.idPM = idPM;
	}
	public Integer getIdProductoPM() {
		return idProductoPM;
	}
	public void setIdProductoPM(Integer idProductoPM) {
		this.idProductoPM = idProductoPM;
	}
	public Integer getIdModeloPM() {
		return idModeloPM;
	}
	public void setIdModeloPM(Integer idModeloPM) {
		this.idModeloPM = idModeloPM;
	}
	@Override
	public String toString() {
		return "ProductoModeloDTO [idPM=" + idPM + ", idProductoPM=" + idProductoPM + ", idModeloPM=" + idModeloPM
				+ "]";
	}
	
	
	
}
