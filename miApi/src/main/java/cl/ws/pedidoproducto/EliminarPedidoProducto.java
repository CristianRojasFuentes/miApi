package cl.ws.pedidoproducto;

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

import cl.ws.dto.PedidoProductoDTO;

@Service
@Scope("prototype")
public class EliminarPedidoProducto extends StoredProcedure{
	
	private static final String SP_EIMINAR_PP = "sp_eliminarPedidoProducto";
	
	@Autowired
	public EliminarPedidoProducto(DataSource dataSource){
		super(dataSource, SP_EIMINAR_PP);
		
		declareParameter(new SqlParameter("p_id_pp", Types.INTEGER));
		declareParameter(new SqlParameter("p_id_pedido", Types.INTEGER));
		
		declareParameter(new SqlOutParameter("last_index", Types.INTEGER));
		
		compile();
	}

	public Integer eliminarPedidoProducto(PedidoProductoDTO p){
		
		Map<String, Object> parametros = new HashMap<>();
		
		parametros.put("p_id_pp", p.getIdPP());
		parametros.put("p_id_pedido", p.getIdPedidoPP());
		
		Map<String, Object> resultado = super.execute(parametros);
		
		return resultado.get("last_index") == null ? 0 : (Integer) resultado.get("last_index");
		
	}
	
}
