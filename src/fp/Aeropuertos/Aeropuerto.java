package fp.Aeropuertos;

import java.time.DayOfWeek;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Aeropuerto {
	private SortedSet<Vuelo> vuelos;

	public SortedSet<Vuelo> getVuelos() {
		return new TreeSet<>(vuelos);
	}

	public Aeropuerto() {
		vuelos = new TreeSet<>();
	}
	
	public Aeropuerto(Stream<Vuelo> a) {
		vuelos =  new TreeSet<>(a.collect(Collectors.toSet()));
	}

	public String toString() {
		return "Aeropuerto [vuelos=" + vuelos.size() + "]";
	}
	
	public void añadirVuelo(Vuelo v) {
		vuelos.add(v);
	}
	
	public Boolean existeVueloDestino(String ciudad) {
		return vuelos.stream().anyMatch(e->e.getCiudad().equals(ciudad));
	}
	
	public Boolean todosVuelosCompañiaSinRetraso(String compañia) {
		return vuelos.stream().filter(e->e.getCompanya().equals(compañia)).allMatch(e->e.getDiferenciaMinutos()>=0);
	}
	
	public Long getNumeroVuelosSalida() {
		return vuelos.stream().filter(e->e.getDireccion().equals(DireccionVuelo.OUT)).count();
	}
	
	public Long getNumeroVuelosDestino(String ciudad) {
		return vuelos.stream().filter(e->e.getDireccion().equals(DireccionVuelo.OUT) && e.getCiudad().equals(ciudad)).count();
	}
	
	public Long getNumeroVuelosCancelados() {
		return vuelos.stream().filter(e->e.getEstado().equals(EstadoVuelo.CANCELED)).count();
	}
	
	public Long getNumeroVuelosCompañia(String compañia) {
		return vuelos.stream().filter(e->e.getCompanya().equals(compañia)).count();
	}
	
	public Long getNumeroVuelosConRetraso() {
		return vuelos.stream().filter(e->!(e.getEstado().equals(EstadoVuelo.CANCELED) && e.getDiferenciaMinutos()<0)).count();
	}
	
	public Set<String> getCompañiasVuelos() {
		return vuelos.stream().map(Vuelo::getCompanya).collect(Collectors.toSet());
	}
	
	public Long getNumeroCiudadesDestino() {
		return vuelos.stream().map(Vuelo::getCiudad).collect(Collectors.toSet()).stream().count();
	}
	
	public Set<String> getModelosAvionesCompañia(String compañia) {
		return vuelos.stream().filter(e->e.getCompanya().equals(compañia)).map(Vuelo::getModelo).collect(Collectors.toSet());
	}
	
	public Long getMinutosRetrasoAcumuladosCompañia(String compañia) {
		return vuelos.stream().filter(e->e.getCompanya().equals(compañia) && e.getDiferenciaMinutos()<0).mapToLong(Vuelo::getDiferenciaMinutos).sum();
	}
	
	public Long getMediaMinutosRetrasoCiudad(String ciudad) {
		return Double.doubleToLongBits(vuelos.stream().filter(e->e.getCiudad().equals(ciudad) && !(e.getEstado().equals(EstadoVuelo.CANCELED))).filter(e->e.getDiferenciaMinutos()<0).mapToLong(Vuelo::getDiferenciaMinutos).average().orElse(0.));
	}
	
	public Set<DayOfWeek> getDiasSemanaConVuelosDestino(String ciudad) {
		return vuelos.stream().filter(e->e.getCiudad().equals(ciudad)).map(e->e.getFecha().getDayOfWeek()).collect(Collectors.toSet());
	}
	
	public Vuelo getVueloMayorRetraso() {
		Long limite=vuelos.stream().mapToLong(Vuelo::getDiferenciaMinutos).min().getAsLong();
		return vuelos.stream().filter(e->e.getDiferenciaMinutos().equals(limite)).sorted().toList().get(0);
	}
	
	public Vuelo getVueloMasTempranoDestino(String ciudad) {
		return vuelos.stream().filter(e->e.getCiudad().equals(ciudad) && e.getDiferenciaMinutos()>0);
	}
	
}
