package Auxiliares;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class Fichero {
	
	public static List<String> leeFichero(String path) {
		List<String> result=new LinkedList<>();
		try {
			result=Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
