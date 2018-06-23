package cl.ws.color;

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

import cl.ws.dto.ColorDTO;

@Service
@Scope("prototype")
public class IngresarColor extends StoredProcedure{
	
	private static final String SP_INGRESAR_COLOR = "sp_ingresarColor";

	@Autowired
	public IngresarColor(DataSource dataSource) {
		super(dataSource, SP_INGRESAR_COLOR);
		
		declareParameter(new SqlParameter("p_nombre_color", Types.VARCHAR));
		
		declareParameter(new SqlOutParameter("last_index", Types.INTEGER));
		
		compile();
	}
	
	public Integer ingresaColor(ColorDTO color) {
		Map<String, Object> params = new HashMap<>();
		
		params.put("p_nombre_color", color.getNombreColor());
		
		final Map<String, Object> resultado = execute(params);
		
		final Integer nRegistros = (Integer) resultado.get("last_index");
		
		return nRegistros;
		
	}
	

}
