package cl.ws.canal.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.ws.dto.CanalDTO;

public class CanalDTOMapper implements RowMapper<CanalDTO>{

	public CanalDTO mapRow(ResultSet rs, int index) throws SQLException{
		
		CanalDTO c = new CanalDTO();
		
		c.setIdCanal(rs.getInt("id_canal"));
		c.setNombreCanal(rs.getString("nombre_canal"));
		
		return c;
		
	}
	
	
}
