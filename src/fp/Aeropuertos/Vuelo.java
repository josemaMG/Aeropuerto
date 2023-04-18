package fp.Aeropuertos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Vuelo {
		private LocalDate fecha;
		private LocalTime horaPlanificada;
		private String codigo, ciudad, codigoAeropuerto, companya, modelo, id;
		private EstadoVuelo estado;
		private LocalTime horaEfectiva;
		private DireccionVuelo direccion;
		
		public Vuelo(LocalDate fecha, LocalTime horaPlanificada, String codigo, String ciudad, String codigoAeropuerto,String companya, String modelo,
				String id, EstadoVuelo estado, LocalTime horaEfectiva, DireccionVuelo direccion) {
			this.fecha = fecha;
			this.horaPlanificada = horaPlanificada;
			this.codigo = codigo;
			this.ciudad = ciudad;
			this.codigoAeropuerto = codigoAeropuerto;
			this.companya = companya;
			this.modelo = modelo;
			this.id = id;
			this.estado = estado;
			this.horaEfectiva = horaEfectiva;
			this.direccion = direccion;
		}
		
		public String getCiudad() {
			return ciudad;
		}

		public void setCiudad(String ciudad) {
			this.ciudad = ciudad;
		}

		public LocalDate getFecha() {
			return fecha;
		}

		public LocalTime getHoraPlanificada() {
			return horaPlanificada;
		}

		public String getCodigo() {
			return codigo;
		}

		public String getCodigoAeropuerto() {
			return codigoAeropuerto;
		}

		public String getCompanya() {
			return companya;
		}

		public String getModelo() {
			return modelo;
		}

		public String getId() {
			return id;
		}

		public EstadoVuelo getEstado() {
			return estado;
		}

		public LocalTime getHoraEfectiva() {
			return horaEfectiva;
		}

		public DireccionVuelo getDireccion() {
			return direccion;
		}

		public Long getDiferenciaMinutos() {
			Long result=null;
			if (!(estado.equals(EstadoVuelo.CANCELED))) {
				result=horaPlanificada.until(horaEfectiva, ChronoUnit.MINUTES);
			}
			return result;
		}


		public String toString() {
			return "Vuelo [fecha=" + fecha + ", horaPlanificada=" + horaPlanificada + ", codigo=" + codigo + "]";
		}


		public int hashCode() {
			return Objects.hash(codigo, fecha, horaPlanificada);
		}


		public boolean equals(Object obj) {
			boolean result=false;
			if (getClass() == obj.getClass()) {
			Vuelo other = (Vuelo) obj;
			result= Objects.equals(codigo, other.codigo) && Objects.equals(fecha, other.fecha)&& Objects.equals(horaPlanificada, other.horaPlanificada);
			}
			return result;
		}
		
}
