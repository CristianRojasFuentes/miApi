package cl.ws.modelo;

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

import cl.ws.dto.ModeloDTO;

@Service
@Scope("prototype")
public class IngresarModelo extends StoredProcedure{
	
	private static final String SP_INGRESAR_MODELO = "sp_ingresarModelo";

	@Autowired
	public IngresarModelo(DataSource dataSource) {
		super(dataSource, SP_INGRESAR_MODELO);
		
		declareParameter(new SqlParameter("p_nombre_modelo", Types.VARCHAR));
		
		declareParameter(new SqlOutParameter("last_index", Types.INTEGER));
		
		compile();
	}
	
	public Integer ingresarModelo(ModeloDTO m) {
		Map<String, Object> params = new HashMap<>();
		
		params.put("p_nombre_modelo", m.getNombreModelo());
		
		final Map<String, Object> resultado = execute(params);
		
		final Integer nRegistros = (Integer) resultado.get("last_index");
		
		return nRegistros;
		
	}
	

}
