package cl.ws.cliente.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.ws.dto.ClienteDTO;

public class ClienteDTOMapper implements RowMapper<ClienteDTO> {

	public ClienteDTO mapRow(ResultSet rs, int index) throws SQLException{
		
		ClienteDTO dto = new ClienteDTO();
		
		dto.setIdCliente(rs.getInt("id_cliente"));
		dto.setNombreCliente(rs.getString("nombre_cliente"));
		dto.setRutCliente(rs.getString("rut_cliente"));
		dto.setFonoCliente(rs.getLong("fono_cliente"));
		dto.setDireccionCliente(rs.getString("direccion_cliente"));
		dto.setCiudadCliente(rs.getString("ciudad_cliente"));
		dto.setIdCanalCliente(rs.getInt("id_canal_cliente"));
		dto.setNombreCanal(rs.getString("nombre_canal"));
		
		
		return dto;
		
		
	}
}
