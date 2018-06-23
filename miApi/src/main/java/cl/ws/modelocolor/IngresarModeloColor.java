package cl.ws.modelocolor;

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

import cl.ws.dto.ModeloColorDTO;

@Service
@Scope("prototype")
public class IngresarModeloColor extends StoredProcedure{
	
	private static final String SP_INGRESAR_MODELO_COLOR = "sp_ingresarModeloColor";

	@Autowired
	public IngresarModeloColor(DataSource dataSource) {
		super(dataSource, SP_INGRESAR_MODELO_COLOR);
		
		declareParameter(new SqlParameter("p_id_mod_mc", Types.INTEGER));
		declareParameter(new SqlParameter("p_id_col_mc", Types.INTEGER));
		declareParameter(new SqlParameter("p_cantidad_mc", Types.INTEGER));
		declareParameter(new SqlParameter("p_talla_mc", Types.INTEGER));
		
		declareParameter(new SqlOutParameter("last_index", Types.INTEGER));
		
		compile();
	}
	
	public Integer ingresarModeloColor(ModeloColorDTO mc) {
		Map<String, Object> params = new HashMap<>();
		
		params.put("p_id_mod_mc", mc.getIdModeloMC());
		params.put("p_id_col_mc", mc.getIdColorMC());
		params.put("p_cantidad_mc", mc.getCantidadMC());
		params.put("p_talla_mc", mc.getTallaMC());
		
		final Map<String, Object> resultado = execute(params);
		
		final Integer nRegistros = (Integer) resultado.get("last_index");
		
		return nRegistros;
		
	}
	

}
