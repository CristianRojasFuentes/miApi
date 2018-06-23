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
public class EliminarCliente extends StoredProcedure{
	
	private static final String SP_EIMINAR_CLIENTE = "sp_eliminarCliente";
	
	@Autowired
	public EliminarCliente(DataSource dataSource){
		super(dataSource, SP_EIMINAR_CLIENTE);
		
		declareParameter(new SqlParameter("p_id_cliente", Types.INTEGER));
		
		declareParameter(new SqlOutParameter("last_index", Types.INTEGER));
		
		compile();
	}

	public Integer eliminarCliente(ClienteDTO c){
		
		Map<String, Object> parametros = new HashMap<>();
		
		parametros.put("p_id_cliente", c.getIdCliente());
		
		Map<String, Object> resultado = super.execute(parametros);
		
		return resultado.get("last_index") == null ? 0 : (Integer) resultado.get("last_index");
		
	}
	
}
