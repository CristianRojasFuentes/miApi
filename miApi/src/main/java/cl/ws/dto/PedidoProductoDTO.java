package cl.ws.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PedidoProductoDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	@JsonProperty("idPP")
	private Integer idPP;
	
	@JsonProperty("idPedidoPP")
	private Integer idPedidoPP;
	
	@JsonProperty("idProductoPP")
	private Integer idProductoPP;
	
	@JsonProperty("cantidadPP")
	private Integer cantidadPP;
	
	@JsonProperty("idModeloPP")
	private Integer idModeloPP;
	
	public Integer getIdPP() {
		return idPP;
	}
	public void setIdPP(Integer idPP) {
		this.idPP = idPP;
	}
	public Integer getIdPedidoPP() {
		return idPedidoPP;
	}
	public void setIdPedidoPP(Integer idPedidoPP) {
		this.idPedidoPP = idPedidoPP;
	}
	public Integer getIdProductoPP() {
		return idProductoPP;
	}
	public void setIdProductoPP(Integer idProductoPP) {
		this.idProductoPP = idProductoPP;
	}
	public Integer getCantidadPP() {
		return cantidadPP;
	}
	public void setCantidadPP(Integer cantidadPP) {
		this.cantidadPP = cantidadPP;
	}
	public Integer getIdModeloPP() {
		return idModeloPP;
	}
	public void setIdModeloPP(Integer idModeloPP) {
		this.idModeloPP = idModeloPP;
	}
	@Override
	public String toString() {
		return "PedidoProducto [idPP=" + idPP + ", idPedidoPP=" + idPedidoPP + ", idProductoPP=" + idProductoPP
				+ ", cantidadPP=" + cantidadPP + ", idModeloPP=" + idModeloPP + "]";
	}
	
	
	
}
