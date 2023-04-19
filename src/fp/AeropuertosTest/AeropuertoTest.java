package fp.AeropuertosTest;

import fp.Aeropuertos.Aeropuerto;
import fp.Aeropuertos.FactoriaAeropuerto;

public class AeropuertoTest {

	public static void main(String[] args) {
		Aeropuerto Aero= FactoriaAeropuerto.CreaAeropuerto("data/SVQ.csv");
		System.out.println(Aero);
	}

}
