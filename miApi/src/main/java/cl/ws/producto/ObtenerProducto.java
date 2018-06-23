package cl.ws.producto;


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

import cl.ws.dto.ProductoDTO;
import cl.ws.producto.mapper.ProductoDTOMapper;
import cl.ws.util.Constantes;

@Service
@Scope("prototype")
public class ObtenerProducto extends StoredProcedure{
	
	private static final String SP_OBTENER_PRODUCTO = "sp_obtenerProducto";
	
	@Autowired
	public ObtenerProducto(final DataSource dataSource){
		super (dataSource, SP_OBTENER_PRODUCTO);
		
		declareParameter(new SqlParameter("p_id_producto", Types.INTEGER));
		declareParameter(new SqlParameter("p_nombre_producto", Types.VARCHAR));
		declareParameter(new SqlParameter("p_id_modelo_producto", Types.INTEGER));
		
		final RowMapper<ProductoDTO> rowMapper = new ProductoDTOMapper();
		
		declareParameter(new SqlReturnResultSet(Constantes.RESULT_LIST, rowMapper));
		
		compile();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<ProductoDTO> obtenerProducto(ProductoDTO p){
		
		final Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("p_id_producto", p.getIdProducto());
		params.put("p_nombre_producto", p.getNombreProducto());
		params.put("p_id_modelo_producto", p.getIdModeloProducto());
		
		final Map<String, Object> lista = super.execute(params);
		final List<ProductoDTO> listaRetorno = ((List<ProductoDTO>) lista.get(Constantes.RESULT_LIST));
		
		return listaRetorno;
				
	}

}
