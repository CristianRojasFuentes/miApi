package cl.ws.color.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.ws.dto.ColorDTO;

public class ColorDTOMapper implements RowMapper<ColorDTO>{

	public ColorDTO mapRow(ResultSet rs, int index) throws SQLException{
		
		ColorDTO c = new ColorDTO();
		
		c.setIdColor(rs.getInt("id_color"));
		c.setNombreColor(rs.getString("nombre_color"));
		
		return c;
		
	}
	
	
}
