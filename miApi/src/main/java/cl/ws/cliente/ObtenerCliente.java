package cl.ws.cliente;


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

import cl.ws.cliente.mapper.ClienteDTOMapper;
import cl.ws.dto.ClienteDTO;
import cl.ws.util.Constantes;

@Service
@Scope("prototype")
public class ObtenerCliente extends StoredProcedure{
	
	private static final String SP_OBTENER_CLIENTE = "sp_obtenerCliente";
	
	@Autowired
	public ObtenerCliente(final DataSource dataSource){
		super (dataSource, SP_OBTENER_CLIENTE);
		
		declareParameter(new SqlParameter("p_id_cliente", Types.INTEGER));
		declareParameter(new SqlParameter("p_nombre_cliente", Types.VARCHAR));
		declareParameter(new SqlParameter("p_rut_cliente", Types.VARCHAR));
		declareParameter(new SqlParameter("p_id_canal_cliente", Types.INTEGER));
		
		final RowMapper<ClienteDTO> rowMapper = new ClienteDTOMapper();
		
		declareParameter(new SqlReturnResultSet(Constantes.RESULT_LIST, rowMapper));
		
		compile();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<ClienteDTO> obtenerCliente(ClienteDTO c){
		
		final Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("p_id_cliente", c.getIdCliente());
		params.put("p_nombre_cliente", c.getNombreCliente());
		params.put("p_rut_cliente", c.getRutCliente());
		params.put("p_id_canal_cliente", c.getIdCanalCliente());
		
		final Map<String, Object> lista = super.execute(params);
		final List<ClienteDTO> listaRetorno = ((List<ClienteDTO>) lista.get(Constantes.RESULT_LIST));
		
		return listaRetorno;
				
	}

}
