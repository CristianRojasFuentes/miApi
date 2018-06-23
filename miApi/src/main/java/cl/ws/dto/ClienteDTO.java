package cl.ws.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClienteDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("idCliente")
	private Integer idCliente;
	
	@JsonProperty("nombreCliente")
	private String nombreCliente;
	
	@JsonProperty("rutCliente")
	private String rutCliente;
	
	@JsonProperty("fonoCliente")
	private Long  fonoCliente;
	
	@JsonProperty("direccionCliente")
	private String direccionCliente;
	
	@JsonProperty("ciudadCliente")
	private String ciudadCliente;
	
	@JsonProperty("idCanalCliente")
	private Integer idCanalCliente;
	
	@JsonProperty("nombreCanal")
	private String nombreCanal;	
	
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getRutCliente() {
		return rutCliente;
	}
	public void setRutCliente(String rutCliente) {
		this.rutCliente = rutCliente;
	}
	public Long getFonoCliente() {
		return fonoCliente;
	}
	public void setFonoCliente(Long fonoCliente) {
		this.fonoCliente = fonoCliente;
	}
	public String getDireccionCliente() {
		return direccionCliente;
	}
	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}
	public String getCiudadCliente() {
		return ciudadCliente;
	}
	public void setCiudadCliente(String ciudadCliente) {
		this.ciudadCliente = ciudadCliente;
	}
	public Integer getIdCanalCliente() {
		return idCanalCliente;
	}
	public void setIdCanalCliente(Integer idCanalCliente) {
		this.idCanalCliente = idCanalCliente;
	}
	public String getNombreCanal() {
		return nombreCanal;
	}
	public void setNombreCanal(String nombreCanal) {
		this.nombreCanal = nombreCanal;
	}
	@Override
	public String toString() {
		return "ClienteDTO [idCliente=" + idCliente + ", nombreCliente=" + nombreCliente + ", rutCliente=" + rutCliente
				+ ", fonoCliente=" + fonoCliente + ", direccionCliente=" + direccionCliente + ", ciudadCliente="
				+ ciudadCliente + ", idCanalCliente=" + idCanalCliente + ", nombreCanal=" + nombreCanal + "]";
	}
	
	
}
