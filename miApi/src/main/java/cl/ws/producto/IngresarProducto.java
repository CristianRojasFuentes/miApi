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
public class IngresarProducto extends StoredProcedure{

	private static final String SP_INGRESAR_PRODUCTO = "sp_ingresarProducto";
	
	@Autowired
	public IngresarProducto(DataSource dataSource){		
		super(dataSource, SP_INGRESAR_PRODUCTO);
		
		declareParameter(new SqlParameter("p_nombre_producto", Types.VARCHAR));
		declareParameter(new SqlParameter("p_id_modelo_producto", Types.INTEGER));
		
		declareParameter(new SqlOutParameter("last_index", Types.INTEGER));
		
		compile();
		
	}
	
	public Integer ingreseProducto(ProductoDTO p){
		Map<String, Object> parametros = new HashMap<>();
		
		parametros.put("p_nombre_producto", p.getNombreProducto());
		parametros.put("p_id_modelo_producto", p.getIdModeloProducto());
		
		final Map<String, Object> resultado = execute(parametros);
		
		final Integer nReg = (Integer) resultado.get("last_index");
		
		return nReg;
	}
	
}
