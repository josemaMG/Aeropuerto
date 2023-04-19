package fp.Aeropuertos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import Auxiliares.Fichero;
import Auxiliares.Helpers;

public class FactoriaAeropuerto {

	private static Vuelo parseaLinea(String s) {
		String[] trozos= s.split(",");
		LocalTime tiempoFinal=null;
		EstadoVuelo a=EstadoVuelo.valueOf(trozos[8].trim().toUpperCase());
		if (!(a.equals(EstadoVuelo.CANCELED))) {
			tiempoFinal=Helpers.parseaStringATime(trozos[9].trim());
		}
		return new Vuelo(LocalDate.parse(trozos[0].trim(), DateTimeFormatter.ofPattern("dd/M/yyyy")), 
				Helpers.parseaStringATime(trozos[1].trim()), trozos[2].trim(), trozos[3].trim(), trozos[4].trim(), 
				trozos[5].trim(), trozos[6].trim(), trozos[7].trim(), a, 
				tiempoFinal, DireccionVuelo.valueOf(trozos[10].trim().toUpperCase()));
	}
	
	public static Aeropuerto CreaAeropuerto(String path) {
		Aeropuerto result= new Aeropuerto();
		List<String> lista=Fichero.leeFichero(path);
		lista.remove(0);
		for (String e:lista) {
			result.añadirVuelo(parseaLinea(e));
		}
		return result;
	}
	
}
