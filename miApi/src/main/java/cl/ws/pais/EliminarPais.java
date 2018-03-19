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
public class EliminarPais extends StoredProcedure{
	
	private static final String SP_EIMINAR_PAIS = "sp_eliminarPais";
	
	@Autowired
	public EliminarPais(DataSource dataSource){
		super(dataSource, SP_EIMINAR_PAIS);
		
		declareParameter(new SqlParameter("p_pais_id", Types.INTEGER));
		
		declareParameter(new SqlOutParameter("last_index", Types.INTEGER));
		
		compile();
	}

	public Integer eliminarPais(PaisDTO p){
		
		Map<String, Object> parametros = new HashMap<>();
		
		parametros.put("p_pais_id", p.getPaisId());
		
		Map<String, Object> resultado = super.execute(parametros);
		
		return resultado.get("last_index") == null ? 0 : (Integer) resultado.get("last_index");
		
	}
	
}
