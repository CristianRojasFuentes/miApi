package cl.ws.pedidoproducto;


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

import cl.ws.dto.PedidoProductoDTO;
import cl.ws.pedidoproducto.mapper.PedidoProductoDTOMapper;
import cl.ws.util.Constantes;

@Service
@Scope("prototype")
public class ObtenerPedidoProducto extends StoredProcedure{
	
	private static final String SP_OBTENER_PP = "sp_obtenerPedidoProducto";
	
	@Autowired
	public ObtenerPedidoProducto(final DataSource dataSource){
		super (dataSource, SP_OBTENER_PP);
		
		declareParameter(new SqlParameter("p_id_pp", Types.INTEGER));
		declareParameter(new SqlParameter("p_id_pedido_pp", Types.INTEGER));
		declareParameter(new SqlParameter("p_id_producto_pp", Types.INTEGER));
		declareParameter(new SqlParameter("p_cantidad_pp", Types.INTEGER));
		declareParameter(new SqlParameter("p_id_modelo_pp", Types.INTEGER));
		
		final RowMapper<PedidoProductoDTO> rowMapper = new PedidoProductoDTOMapper();
		
		declareParameter(new SqlReturnResultSet(Constantes.RESULT_LIST, rowMapper));
		
		compile();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<PedidoProductoDTO> obtenerPedidoProducto(PedidoProductoDTO p){
		
		final Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("p_id_pp", p.getIdPP());
		params.put("p_id_pedido_pp", p.getIdPedidoPP());
		params.put("p_id_producto_pp", p.getIdProductoPP());
		params.put("p_cantidad_pp", p.getCantidadPP());
		params.put("p_id_modelo_pp", p.getIdModeloPP());
		
		final Map<String, Object> lista = super.execute(params);
		final List<PedidoProductoDTO> listaRetorno = ((List<PedidoProductoDTO>) lista.get(Constantes.RESULT_LIST));
		
		return listaRetorno;
				
	}

}
