package cl.ws.modelo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.ws.dto.ModeloDTO;

public class ModeloDTOMapper implements RowMapper<ModeloDTO>{

	public ModeloDTO mapRow(ResultSet rs, int index) throws SQLException{
		
		ModeloDTO m = new ModeloDTO();
		
		m.setIdModelo(rs.getInt("id_modelo"));
		m.setNombreModelo(rs.getString("nombre_modelo"));
		
		return m;
		
	}
	
	
}
