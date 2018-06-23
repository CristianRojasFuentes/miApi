package cl.ws.modelocolor;

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

import cl.ws.dto.ModeloColorDTO;
import cl.ws.modelocolor.mapper.ModeloColorDTOMapper;
import cl.ws.util.Constantes;

@Service
@Scope("prototype")
public class ObtenerModeloColor extends StoredProcedure{
	
	private static final String SP_OBTENER_MODELO_COLOR = "sp_obtenerModeloColor";

	@Autowired
	public ObtenerModeloColor(DataSource dataSource) {
		super(dataSource, SP_OBTENER_MODELO_COLOR);
		
		declareParameter(new SqlParameter("p_id_mc", Types.INTEGER));
		declareParameter(new SqlParameter("p_id_mod_mc", Types.INTEGER));
		declareParameter(new SqlParameter("p_id_col_mc", Types.INTEGER));
		declareParameter(new SqlParameter("p_cantidad_mc", Types.INTEGER));
		declareParameter(new SqlParameter("p_talla_mc", Types.INTEGER));
		
		final RowMapper<ModeloColorDTO> rowMapper = new ModeloColorDTOMapper();
		
		declareParameter(new SqlReturnResultSet(Constantes.RESULT_LIST, rowMapper));
		
		compile();
	}
	
	@SuppressWarnings("unchecked")
	public List<ModeloColorDTO> obtenerModeloColor(ModeloColorDTO mc){
		
		final Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("p_id_mc", mc.getIdMC());
		params.put("p_id_mod_mc", mc.getIdModeloMC());
		params.put("p_id_col_mc", mc.getIdColorMC());
		params.put("p_cantidad_mc", mc.getCantidadMC());
		params.put("p_talla_mc", mc.getTallaMC());
		
		final Map<String, Object> lista = super.execute(params);
		final List<ModeloColorDTO> listaRetorno = ((List<ModeloColorDTO>) lista.get(Constantes.RESULT_LIST));
		
		return listaRetorno;
				
	}
	

}

