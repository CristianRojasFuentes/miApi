package cl.ws.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductoDTO implements Serializable{

	private static final long serialVersionUID = 1;

	@JsonProperty("idProducto")
	private Integer idProducto;
	
	@JsonProperty("nombreProducto")
	private String nombreProducto;
	
	@JsonProperty("idModeloProducto")
	private Integer idModeloProducto;
	
	@JsonProperty("listaPM")
	private List<ProductoModeloDTO> listaPM;
	
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public Integer getIdModeloProducto() {
		return idModeloProducto;
	}
	public void setIdModeloProducto(Integer idModeloProducto) {
		this.idModeloProducto = idModeloProducto;
	}
	
	public List<ProductoModeloDTO> getListaPM() {
		return listaPM;
	}
	public void setListaPM(List<ProductoModeloDTO> listaPM) {
		this.listaPM = listaPM;
	}
	@Override
	public String toString() {
		return "ProductoDTO [idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", idModeloProducto="
				+ idModeloProducto + ", listaPM=" + listaPM + "]";
	}
	
	
	
}
