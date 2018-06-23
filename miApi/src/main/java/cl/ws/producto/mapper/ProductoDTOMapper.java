package cl.ws.producto.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.ws.dto.ProductoDTO;

public class ProductoDTOMapper implements RowMapper<ProductoDTO> {

	public ProductoDTO mapRow(ResultSet rs, int index) throws SQLException{
		
		ProductoDTO dto = new ProductoDTO();
		
		dto.setIdProducto(rs.getInt("id_producto"));
		dto.setNombreProducto(rs.getString("nombre_producto"));
		dto.setIdModeloProducto(rs.getInt("id_modelo_producto"));
		
		return dto;
		
		
	}
}
