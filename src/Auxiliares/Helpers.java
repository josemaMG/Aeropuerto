package Auxiliares;

import java.time.LocalTime;

public class Helpers {
	
	public static LocalTime parseaStringATime(String linea) {
		String[] s= linea.split(":");
		return LocalTime.of(Integer.valueOf(s[0].trim()), Integer.valueOf(s[1].trim()));
	}
	
	
	
}
