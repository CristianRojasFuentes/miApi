package cl.ws.pedido;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Service;

import cl.ws.dto.PedidoDTO;

@Service
@Scope("prototype")
public class ActualizarPedido extends StoredProcedure{

	private static final String SP_ACTUALIZAR_PEDIDO = "sp_actualizarPedido";
	
	@Autowired
	public ActualizarPedido(DataSource dataSource){
		super(dataSource, SP_ACTUALIZAR_PEDIDO);
		
		declareParameter(new SqlParameter("p_id_pedido", Types.INTEGER));
		declareParameter(new SqlParameter("p_id_cliente_pedido", Types.INTEGER));
		declareParameter(new SqlParameter("p_comentario_pedido", Types.VARCHAR));
		
		declareParameter(new SqlOutParameter("last_index", Types.INTEGER));
		
		compile();
	}
	
	public Integer actualizarPedido(PedidoDTO p){
		
		Map<String, Object> parametros = new HashMap<>();
		
		parametros.put("p_id_pedido", p.getIdPedido());
		parametros.put("p_id_cliente_pedido", p.getIdClientePeddo());
		parametros.put("p_comentario_pedido", p.getComentarioPedido());
		
		final Map<String, Object> resultado = execute(parametros);
		
		return resultado.get("last_index") == null ? 0 : (Integer) resultado.get("last_index");
		
	}
	
}
