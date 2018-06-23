package cl.ws.productomodelo;

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

import cl.ws.dto.ProductoModeloDTO;
import cl.ws.productomodelo.mapper.ProductoModeloDTOMapper;
import cl.ws.util.Constantes;

@Service
@Scope("prototype")
public class ObtenerProductoModelo extends StoredProcedure{
	
	private static final String SP_OBTENER_PM = "sp_obtenerProductoModelo";

	@Autowired
	public ObtenerProductoModelo(DataSource dataSource) {
		super(dataSource, SP_OBTENER_PM);
		
		declareParameter(new SqlParameter("p_id_pm", Types.INTEGER));
		declareParameter(new SqlParameter("p_id_producto_pm", Types.INTEGER));
		declareParameter(new SqlParameter("p_id_modelo_pm", Types.INTEGER));
		
		final RowMapper<ProductoModeloDTO> rowMapper = new ProductoModeloDTOMapper();
		
		declareParameter(new SqlReturnResultSet(Constantes.RESULT_LIST, rowMapper));
		
		compile();
	}
	
	@SuppressWarnings("unchecked")
	public List<ProductoModeloDTO> obtenerProductoModelo(ProductoModeloDTO pm){
		
		final Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("p_id_pm", pm.getIdPM());
		params.put("p_id_producto_pm", pm.getIdProductoPM());
		params.put("p_id_modelo_pm", pm.getIdModeloPM());
		
		final Map<String, Object> lista = super.execute(params);
		final List<ProductoModeloDTO> listaRetorno = ((List<ProductoModeloDTO>) lista.get(Constantes.RESULT_LIST));
		
		return listaRetorno;
				
	}
	

}

