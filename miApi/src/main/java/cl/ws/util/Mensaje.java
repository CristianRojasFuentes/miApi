package cl.ws.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Mensaje {


	
	private static Map<String, String> configApp = new HashMap<String, String>();
	
	static {
		try {
			InputStream inStreamApp = Mensaje.class.getClassLoader().getResourceAsStream("mensajes.properties");
			
			
			Properties appProperties = new Properties();
			
			appProperties.load(inStreamApp);
			
			inStreamApp.close();

			configApp = new HashMap(appProperties);
			
		} catch (Exception e) {

		
		}
	}
	
	public static String getAppProperty(String key) {
		String result = configApp.get(key);
		
		if (result==null){

			
		}

		return result;
	}

}