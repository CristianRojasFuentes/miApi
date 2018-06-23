package cl.ws.pedido;


import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Service;
import cl.ws.dto.PedidoDTO;
import cl.ws.pedido.mapper.PedidoDTOMapper;
import cl.ws.util.Constantes;

@Service
@Scope("prototype")
public class ObtenerPedido extends StoredProcedure{
	
	private static final String SP_OBTENER_PEDIDO = "sp_obtenerPedido";
	
	@Autowired
	public ObtenerPedido(final DataSource dataSource){
		super (dataSource, SP_OBTENER_PEDIDO);
		
		declareParameter(new SqlParameter("p_id_pedido", Types.INTEGER));
		declareParameter(new SqlParameter("p_id_cliente_pedido", Types.INTEGER));
		declareParameter(new SqlParameter("p_comentario_pedido", Types.VARCHAR));
		
		final RowMapper<PedidoDTO> rowMapper = new PedidoDTOMapper();
		
		declareParameter(new SqlReturnResultSet(Constantes.RESULT_LIST, rowMapper));
		
		compile();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<PedidoDTO> obtenerPedido(PedidoDTO p){
		
		final Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("p_id_pedido", p.getIdPedido());
		params.put("p_id_cliente_pedido", p.getIdClientePeddo());
		params.put("p_comentario_pedido", p.getComentarioPedido());
		
		final Map<String, Object> lista = super.execute(params);
		final List<PedidoDTO> listaRetorno = ((List<PedidoDTO>) lista.get(Constantes.RESULT_LIST));
		
		return listaRetorno;
				
	}

}
