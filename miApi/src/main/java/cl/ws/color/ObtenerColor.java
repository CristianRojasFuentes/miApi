package cl.ws.color;

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

import cl.ws.color.mapper.ColorDTOMapper;
import cl.ws.dto.ColorDTO;
import cl.ws.util.Constantes;

@Service
@Scope("prototype")
public class ObtenerColor extends StoredProcedure{
	
	private static final String SP_OBTENER_COLOR = "sp_obtenerColor";

	@Autowired
	public ObtenerColor(DataSource dataSource) {
		super(dataSource, SP_OBTENER_COLOR);
		
		declareParameter(new SqlParameter("p_id_color", Types.INTEGER));
		declareParameter(new SqlParameter("p_nombre_color", Types.VARCHAR));		
		
		final RowMapper<ColorDTO> rowMapper = new ColorDTOMapper();
		
		declareParameter(new SqlReturnResultSet(Constantes.RESULT_LIST, rowMapper));
		
		compile();
	}
	
	@SuppressWarnings("unchecked")
	public List<ColorDTO> obtenerColor(ColorDTO c){
		
		final Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("p_id_color", c.getIdColor());
		params.put("p_nombre_color", c.getNombreColor());
		
		final Map<String, Object> lista = super.execute(params);
		final List<ColorDTO> listaRetorno = ((List<ColorDTO>) lista.get(Constantes.RESULT_LIST));
		
		return listaRetorno;
				
	}
	

}

