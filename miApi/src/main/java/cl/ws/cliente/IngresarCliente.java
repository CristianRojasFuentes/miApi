package cl.ws.cliente;

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

import cl.ws.dto.ClienteDTO;

@Service
@Scope("prototype")
public class IngresarCliente extends StoredProcedure{

	private static final String SP_INGRESAR_CLIENTE = "sp_ingresarCliente";
	
	@Autowired
	public IngresarCliente(DataSource dataSource){		
		super(dataSource, SP_INGRESAR_CLIENTE);
		
		declareParameter(new SqlParameter("p_nombre_cliente", Types.VARCHAR));
		declareParameter(new SqlParameter("p_rut_cliente", Types.VARCHAR));
		declareParameter(new SqlParameter("p_fono_cliente", Types.BIGINT));
		declareParameter(new SqlParameter("p_direccion_cliente", Types.VARCHAR));
		declareParameter(new SqlParameter("p_ciudad_cliente", Types.VARCHAR));
		declareParameter(new SqlParameter("p_id_canal_cliente", Types.INTEGER));
		
		declareParameter(new SqlOutParameter("last_index", Types.INTEGER));
		
		compile();
		
	}
	
	public Integer ingreseCliente(ClienteDTO c){
		Map<String, Object> parametros = new HashMap<>();
		
		parametros.put("p_nombre_cliente", c.getNombreCliente());
		parametros.put("p_rut_cliente", c.getRutCliente());
		parametros.put("p_fono_cliente", c.getFonoCliente());
		parametros.put("p_direccion_cliente", c.getDireccionCliente());
		parametros.put("p_ciudad_cliente", c.getCiudadCliente());
		parametros.put("p_id_canal_cliente", c.getIdCanalCliente());
		
		final Map<String, Object> resultado = execute(parametros);
		
		final Integer nReg = (Integer) resultado.get("last_index");
		
		return nReg;
	}
	
}
