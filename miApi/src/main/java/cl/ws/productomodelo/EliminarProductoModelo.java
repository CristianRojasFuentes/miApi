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
public class EliminarProductoModelo  extends StoredProcedure{
	
	private static final String SP_EIMINAR_PM = "sp_eliminarProductoModelo";
	
	@Autowired
	public EliminarProductoModelo(DataSource dataSource){
		super(dataSource, SP_EIMINAR_PM);
		
		declareParameter(new SqlParameter("p_id_pm", Types.INTEGER));
		declareParameter(new SqlParameter("p_id_producto_pm", Types.INTEGER));
		
		declareParameter(new SqlOutParameter("last_index", Types.INTEGER));
		
		compile();
	}

	public Integer eliminarProductoModelo(ProductoModeloDTO pm){
		
		Map<String, Object> params = new HashMap<>();
		
		params.put("p_id_pm", pm.getIdPM());
		params.put("p_id_producto_pm", pm.getIdProductoPM());
		
		Map<String, Object> resultado = super.execute(params);
		
		return resultado.get("last_index") == null ? 0 : (Integer) resultado.get("last_index");
		
	}
	
}
