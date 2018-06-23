package cl.ws.modelocolor.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.ws.dto.ModeloColorDTO;

public class ModeloColorDTOMapper implements RowMapper<ModeloColorDTO>{

	public ModeloColorDTO mapRow(ResultSet rs, int index) throws SQLException{
		
		ModeloColorDTO m = new ModeloColorDTO();
		
		m.setIdMC(rs.getInt("id_mc"));
		m.setIdModeloMC(rs.getInt("id_mod_mc"));
		m.setIdColorMC(rs.getInt("id_col_mc"));
		m.setCantidadMC(rs.getInt("cantidad_mc"));
		m.setTallaMC(rs.getInt("talla_mc"));
		
		return m;
		
	}
	
	
}
