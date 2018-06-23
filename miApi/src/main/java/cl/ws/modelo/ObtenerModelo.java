package cl.ws.modelo;

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

import cl.ws.dto.ModeloDTO;
import cl.ws.modelo.mapper.ModeloDTOMapper;
import cl.ws.util.Constantes;

@Service
@Scope("prototype")
public class ObtenerModelo extends StoredProcedure{
	
	private static final String SP_OBTENER_MODELO = "sp_obtenerModelo";

	@Autowired
	public ObtenerModelo(DataSource dataSource) {
		super(dataSource, SP_OBTENER_MODELO);
		
		declareParameter(new SqlParameter("p_id_modelo", Types.INTEGER));
		declareParameter(new SqlParameter("p_nombre_modelo", Types.VARCHAR));		
		
		final RowMapper<ModeloDTO> rowMapper = new ModeloDTOMapper();
		
		declareParameter(new SqlReturnResultSet(Constantes.RESULT_LIST, rowMapper));
		
		compile();
	}
	
	@SuppressWarnings("unchecked")
	public List<ModeloDTO> obtenerModelo(ModeloDTO m){
		
		final Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("p_id_modelo", m.getIdModelo());
		params.put("p_nombre_modelo", m.getNombreModelo());
		
		final Map<String, Object> lista = super.execute(params);
		final List<ModeloDTO> listaRetorno = ((List<ModeloDTO>) lista.get(Constantes.RESULT_LIST));
		
		return listaRetorno;
				
	}
	

}

