package cl.ws.canal;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Service;

import cl.ws.canal.mapper.CanalDTOMapper;
import cl.ws.dto.CanalDTO;
import cl.ws.util.Constantes;

@Service
@Scope("prototype")
public class ObtenerCanal extends StoredProcedure{
	
	private static final String SP_OBTENER_CANAL = "sp_obtenerCanal";

	@Autowired
	public ObtenerCanal(DataSource dataSource) {
		super(dataSource, SP_OBTENER_CANAL);
		
		declareParameter(new SqlParameter("p_id_canal", Types.INTEGER));
		declareParameter(new SqlParameter("p_nombre_canal", Types.VARCHAR));
		
		final RowMapper<CanalDTO> rowMapper = new CanalDTOMapper();
		
		declareParameter(new SqlReturnResultSet(Constantes.RESULT_LIST, rowMapper));
		
		compile();
	}
	
	@SuppressWarnings("unchecked")
	public List<CanalDTO> obtenerCanal(CanalDTO c){
		
		final Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("p_id_canal", c.getIdCanal());
		params.put("p_nombre_canal", c.getNombreCanal());
		
		final Map<String, Object> lista = super.execute(params);
		final List<CanalDTO> listaRetorno = ((List<CanalDTO>) lista.get(Constantes.RESULT_LIST));
		
		return listaRetorno;
				
	}
	

}

