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
public class IngresarPedidoProducto extends StoredProcedure{

	private static final String SP_INGRESAR_PP = "sp_ingresarPedidoProducto";
	
	@Autowired
	public IngresarPedidoProducto(DataSource dataSource){		
		super(dataSource, SP_INGRESAR_PP);
		
		declareParameter(new SqlParameter("p_id_pedido_pp", Types.INTEGER));
		declareParameter(new SqlParameter("p_id_producto_pp", Types.INTEGER));
		declareParameter(new SqlParameter("p_cantidad_pp", Types.INTEGER));
		declareParameter(new SqlParameter("p_id_modelo_pp", Types.INTEGER));
		
		declareParameter(new SqlOutParameter("last_index", Types.INTEGER));
		
		compile();
		
	}
	
	public Integer ingresePedidoProducto(PedidoProductoDTO p){
		Map<String, Object> parametros = new HashMap<>();
		
		parametros.put("p_id_pedido_pp", p.getIdPedidoPP());
		parametros.put("p_id_producto_pp", p.getIdProductoPP());
		parametros.put("p_cantidad_pp", p.getCantidadPP());
		parametros.put("p_id_modelo_pp", p.getIdModeloPP());
		
		final Map<String, Object> resultado = execute(parametros);
		
		final Integer nReg = (Integer) resultado.get("last_index");
		
		return nReg;
	}
	
}
