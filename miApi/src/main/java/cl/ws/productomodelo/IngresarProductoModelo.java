package cl.ws.productomodelo;

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

import cl.ws.dto.ProductoModeloDTO;

@Service
@Scope("prototype")
public class IngresarProductoModelo extends StoredProcedure{
	
	private static final String SP_INGRESAR_PM = "sp_ingresarProductoModelo";

	@Autowired
	public IngresarProductoModelo(DataSource dataSource) {
		super(dataSource, SP_INGRESAR_PM);
		
		declareParameter(new SqlParameter("p_id_producto_pm", Types.INTEGER));
		declareParameter(new SqlParameter("p_id_modelo_pm", Types.INTEGER));
		
		declareParameter(new SqlOutParameter("last_index", Types.INTEGER));
		
		compile();
	}
	
	public Integer ingresaProductoModelo(ProductoModeloDTO pm) {
		Map<String, Object> params = new HashMap<>();
		
		params.put("p_id_producto_pm", pm.getIdProductoPM());
		params.put("p_id_modelo_pm", pm.getIdModeloPM());
		
		final Map<String, Object> resultado = execute(params);
		
		final Integer nRegistros = (Integer) resultado.get("last_index");
		
		return nRegistros;
		
	}
	

}
