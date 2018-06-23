package cl.ws.pedido.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.ws.dto.PedidoDTO;

public class PedidoDTOMapper implements RowMapper<PedidoDTO> {

	public PedidoDTO mapRow(ResultSet rs, int index) throws SQLException{
		
		PedidoDTO dto = new PedidoDTO();
		
		dto.setIdPedido(rs.getInt("id_pedido"));
		dto.setIdClientePeddo(rs.getInt("id_cliente_pedido"));
		dto.setComentarioPedido(rs.getString("comentario_pedido"));
		
		
		return dto;
		
		
	}
}
