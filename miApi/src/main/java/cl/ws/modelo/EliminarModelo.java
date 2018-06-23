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
public class EliminarModelo  extends StoredProcedure{
	
	private static final String SP_EIMINAR_MODELO = "sp_eliminarModelo";
	
	@Autowired
	public EliminarModelo(DataSource dataSource){
		super(dataSource, SP_EIMINAR_MODELO);
		
		declareParameter(new SqlParameter("p_id_modelo", Types.INTEGER));
		
		declareParameter(new SqlOutParameter("last_index", Types.INTEGER));
		
		compile();
	}

	public Integer eliminarModelo(ModeloDTO m){
		
		Map<String, Object> parametros = new HashMap<>();
		
		parametros.put("p_id_modelo", m.getIdModelo());
		
		Map<String, Object> resultado = super.execute(parametros);
		
		return resultado.get("last_index") == null ? 0 : (Integer) resultado.get("last_index");
		
	}
	
}
