package cl.ws.producto;

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

import cl.ws.dto.ProductoDTO;

@Service
@Scope("prototype")
public class EliminarProducto extends StoredProcedure{
	
	private static final String SP_EIMINAR_PRODUCTO = "sp_eliminarProducto";
	
	@Autowired
	public EliminarProducto(DataSource dataSource){
		super(dataSource, SP_EIMINAR_PRODUCTO);
		
		declareParameter(new SqlParameter("p_id_producto", Types.INTEGER));
		declareParameter(new SqlParameter("p_nombre_producto", Types.VARCHAR));
		
		declareParameter(new SqlOutParameter("last_index", Types.INTEGER));
		
		compile();
	}

	public Integer eliminarProducto(ProductoDTO p){
		
		Map<String, Object> parametros = new HashMap<>();
		
		parametros.put("p_id_producto", p.getIdProducto());
		parametros.put("p_nombre_producto", p.getNombreProducto());
		
		Map<String, Object> resultado = super.execute(parametros);
		
		return resultado.get("last_index") == null ? 0 : (Integer) resultado.get("last_index");
		
	}
	
}
