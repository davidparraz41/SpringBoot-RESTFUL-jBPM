/**
 * 
 */
package com.rentacar.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase con constantes que se inicializan a partir del archivo de un
 * propiedades
 * 
 * @author David Parra
 *
 */
public class Constantes {

	private static final Logger logger = LoggerFactory.getLogger(Constantes.class);

	private static Properties props = new Properties();

	public static final String URL_SERVER_KIE;
	public static final String DEFAULT_USER_SERVER_KIE;
	public static final String DEFAULT_USER_PASS_SERVER_KIE;
	public static final String PROCESO_SOLICITUD_COTIZACION;
	public static final String ID_CONTENEDOR;

	static {
		init();
		URL_SERVER_KIE = props.getProperty("URL_KIE_SERVER");
		DEFAULT_USER_SERVER_KIE = props.getProperty("DEFAULT_USER_SERVER_KIE");
		DEFAULT_USER_PASS_SERVER_KIE = props.getProperty("DEFAULT_USER_PASS_SERVER_KIE");
		PROCESO_SOLICITUD_COTIZACION = props.getProperty("PROCESO_SOLICITUD_COTIZACION");
		ID_CONTENEDOR = props.getProperty("ID_CONTENEDOR");
	}

	/**
	 * Inicializa las constantes de la clase
	 * 
	 * @param pResourceFile
	 * @throws IOException
	 */
	public static void init() {
		try {
			Properties others = new Properties();
			InputStream inputStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("application.properties");
			others.load(inputStream);
			inputStream.close();
			props.putAll(others);
		} catch (IOException e) {
			logger.error("Error al leer el archivo de propiedades, Detalle > " + e.getCause());
		}
	}

}
