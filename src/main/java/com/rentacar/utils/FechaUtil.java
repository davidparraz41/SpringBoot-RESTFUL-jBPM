/**
 * 
 */
package com.rentacar.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

/**
 * Clase con utilidades
 * 
 * @author David Parra
 *
 */
public class FechaUtil {

	private FechaUtil() {

	}

	/**
	 * Convierte una fecha de tipo Java.util.Date a String dado el patron
	 * dia/mes/año
	 * 
	 * @param fecha
	 * @return
	 */
	public static String convertirDateAString(Date fecha) {
		if (fecha == null)
			return null;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return format.format(fecha);
	}

	/**
	 * Convierte una fecha en formato string con un patron compatible con
	 * <strong><a href=
	 * "https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html">DateTimeFormatter</a></strong>
	 * en una fecha de tipo LocalDate <br>
	 * 
	 * @param fecha
	 * @return LocalDate
	 */
	public static LocalDate convertStringToLocalDate(String fecha, String patron) throws DateTimeParseException {
		DateTimeFormatter formatter;
		if (fecha == null || fecha.isEmpty())
			return null;

		if (patron == null || patron.isEmpty()) {
			formatter = DateTimeFormatter.ofPattern("dd/LLLL/yyyy");
		} else {
			formatter = DateTimeFormatter.ofPattern(patron);
		}

		return LocalDate.parse(fecha, formatter);
	}

}
