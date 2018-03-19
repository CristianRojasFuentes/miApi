package cl.ws.pais;


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
import cl.ws.dto.PaisDTO;
import cl.ws.pais.mapper.PaisDTOMapper;
import cl.ws.util.Constantes;

/**
 * clase obtenerOferta encargada de obtener los registro de la tabla Pais
 * @author David Rojas - drojas@mzzo.com
 *
 */

@Service
@Scope("prototype")
public class ObtenerPaisSP extends StoredProcedure{
	
	private static final String SP_OBTENER_PAIS = "sp_obtenerPais";
	
	@Autowired
	public ObtenerPaisSP(final DataSource dataSource){
		super (dataSource, SP_OBTENER_PAIS);
		
		declareParameter(new SqlParameter("p_pais_id", Types.INTEGER));
		
		final RowMapper<PaisDTO> rowMapper = new PaisDTOMapper();
		
		declareParameter(new SqlReturnResultSet(Constantes.RESULT_LIST, rowMapper));
		
		compile();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<PaisDTO> obtenerPais(PaisDTO p){
		
		final Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("p_pais_id", p.getPaisId());
		
		final Map<String, Object> lista = super.execute(params);
		final List<PaisDTO> listaRetorno = ((List<PaisDTO>) lista.get(Constantes.RESULT_LIST));
		
		return listaRetorno;
				
	}

}
