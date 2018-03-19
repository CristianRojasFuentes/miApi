package cl.ws.pais;

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

import cl.ws.dto.PaisDTO;

@Service
@Scope("prototype")
public class ActualizarPais extends StoredProcedure{

	private static final String SP_ACTUALIZAR_PAIS = "sp_actualizarPais";
	
	@Autowired
	public ActualizarPais(DataSource dataSource){
		super(dataSource, SP_ACTUALIZAR_PAIS);
		
		declareParameter(new SqlParameter("p_pais_id", Types.INTEGER));
		declareParameter(new SqlParameter("p_pais_nombre", Types.VARCHAR));
		
		declareParameter(new SqlOutParameter("last_index", Types.INTEGER));
		
		compile();
	}
	
	public Integer actualizarPais(PaisDTO p){
		
		Map<String, Object> parametros = new HashMap<>();
		
		parametros.put("p_pais_id", p.getPaisId());
		parametros.put("p_pais_nombre", p.getPaisNombre());
		
		final Map<String, Object> resultado = execute(parametros);
		
		return resultado.get("last_index") == null ? 0 : (Integer) resultado.get("last_index");
		
	}
	
}
