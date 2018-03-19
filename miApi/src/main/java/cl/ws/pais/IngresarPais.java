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
public class IngresarPais extends StoredProcedure{

	private static final String SP_INGRESAR_PAIS = "sp_ingresarPais";
	
	@Autowired
	public IngresarPais(DataSource dataSource){		
		super(dataSource, SP_INGRESAR_PAIS);
		
		declareParameter(new SqlParameter("p_pais_nombre", Types.VARCHAR));
		declareParameter(new SqlOutParameter("last_index", Types.INTEGER));
		
		compile();
		
	}
	
	public Integer ingresePais(PaisDTO p){
		Map<String, Object> parametros = new HashMap<>();
		
		parametros.put("p_pais_nombre", p.getPaisNombre());
		
		final Map<String, Object> resultado = execute(parametros);
		
		final Integer nReg = (Integer) resultado.get("last_index");
		
		return nReg;
	}
	
}
