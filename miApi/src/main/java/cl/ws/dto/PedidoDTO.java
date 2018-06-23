package cl.ws.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PedidoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("idPedido")
	private Integer idPedido;
	
	@JsonProperty("idClientePeddo")
	private Integer idClientePeddo;
	
	@JsonProperty("comentarioPedido")
	private String comentarioPedido;
	
	public Integer getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}
	public Integer getIdClientePeddo() {
		return idClientePeddo;
	}
	public void setIdClientePeddo(Integer idClientePeddo) {
		this.idClientePeddo = idClientePeddo;
	}
	public String getComentarioPedido() {
		return comentarioPedido;
	}
	public void setComentarioPedido(String comentarioPedido) {
		this.comentarioPedido = comentarioPedido;
	}
	@Override
	public String toString() {
		return "PedidoDTO [idPedido=" + idPedido + ", idClientePeddo=" + idClientePeddo + ", comentarioPedido="
				+ comentarioPedido + "]";
	}
	
	

}
