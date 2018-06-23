package cl.ws.productomodelo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.ws.dto.ProductoModeloDTO;

public class ProductoModeloDTOMapper implements RowMapper<ProductoModeloDTO>{

	public ProductoModeloDTO mapRow(ResultSet rs, int index) throws SQLException{
		
		ProductoModeloDTO pm = new ProductoModeloDTO();
		
		pm.setIdPM(rs.getInt("id_pm"));
		pm.setIdProductoPM(rs.getInt("id_producto_pm"));
		pm.setIdModeloPM(rs.getInt("id_modelo_pm"));
		
		return pm;
		
	}
	
	
}
