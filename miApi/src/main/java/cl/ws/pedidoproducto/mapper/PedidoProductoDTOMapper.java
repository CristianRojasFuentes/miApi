package cl.ws.pedidoproducto.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.ws.dto.PedidoProductoDTO;

public class PedidoProductoDTOMapper implements RowMapper<PedidoProductoDTO> {

	public PedidoProductoDTO mapRow(ResultSet rs, int index) throws SQLException{
		
		PedidoProductoDTO dto = new PedidoProductoDTO();
		
		dto.setIdPP(rs.getInt("id_pp"));
		dto.setIdPedidoPP(rs.getInt("id_pedido_pp"));
		dto.setIdProductoPP(rs.getInt("id_producto_pp"));
		dto.setCantidadPP(rs.getInt("cantidad_pp"));
		dto.setIdModeloPP(rs.getInt("id_modelo_pp"));

		
		return dto;
		
		
	}
}
