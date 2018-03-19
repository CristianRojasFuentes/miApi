package cl.ws.pais.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.ws.dto.PaisDTO;

public class PaisDTOMapper implements RowMapper<PaisDTO> {

	public PaisDTO mapRow(ResultSet rs, int index) throws SQLException{
		
		PaisDTO dto = new PaisDTO();
		
		dto.setPaisId(rs.getInt("id_pais"));
		dto.setPaisNombre(rs.getString("nombre_pais"));
		
		
		return dto;
		
		
	}
}
