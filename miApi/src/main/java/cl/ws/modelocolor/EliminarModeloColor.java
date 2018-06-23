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
public class EliminarModeloColor  extends StoredProcedure{
	
	private static final String SP_EIMINAR_MODELO_COLOR = "sp_eliminarModeloColor";
	
	@Autowired
	public EliminarModeloColor(DataSource dataSource){
		super(dataSource, SP_EIMINAR_MODELO_COLOR);
		
		declareParameter(new SqlParameter("p_id_mc", Types.INTEGER));
		declareParameter(new SqlParameter("p_id_mod_mc", Types.INTEGER));		
		
		declareParameter(new SqlOutParameter("last_index", Types.INTEGER));
		
		compile();
	}

	public Integer eliminarModeloColor(ModeloColorDTO mc){
		
		Map<String, Object> parametros = new HashMap<>();
		
		parametros.put("p_id_mc", mc.getIdMC());
		parametros.put("p_id_mod_mc", mc.getIdModeloMC());
		
		Map<String, Object> resultado = super.execute(parametros);
		
		return resultado.get("last_index") == null ? 0 : (Integer) resultado.get("last_index");
		
	}
	
}
