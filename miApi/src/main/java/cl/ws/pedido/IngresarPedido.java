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
public class IngresarPedido extends StoredProcedure{

	private static final String SP_INGRESAR_PEDIDO = "sp_ingresarPedido";
	
	@Autowired
	public IngresarPedido(DataSource dataSource){		
		super(dataSource, SP_INGRESAR_PEDIDO);
		
		declareParameter(new SqlParameter("p_id_cliente_pedido", Types.INTEGER));
		declareParameter(new SqlParameter("p_comentario_pedido", Types.VARCHAR));
		
		declareParameter(new SqlOutParameter("last_index", Types.INTEGER));
		
		compile();
		
	}
	
	public Integer ingresePedido(PedidoDTO p){
		Map<String, Object> parametros = new HashMap<>();
		
		parametros.put("p_id_cliente_pedido", p.getIdClientePeddo());
		parametros.put("p_comentario_pedido", p.getComentarioPedido());
		
		final Map<String, Object> resultado = execute(parametros);
		
		final Integer nReg = (Integer) resultado.get("last_index");
		
		return nReg;
	}
	
}
