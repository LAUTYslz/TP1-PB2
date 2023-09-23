package Intraconsulta;

import java.time.LocalDate;
import java.util.Objects;

public class CicloLectivo {

	private LocalDate fechaInicio;
	private LocalDate fechaFinalizacion;
	private LocalDate fechaInicioInscripcion;
	private LocalDate fechaFinalizacionInscripcion;
	private Integer Id;
	private static Integer IdSiguiente=1;

	public CicloLectivo(LocalDate fechaInicio, LocalDate fechaFinalizacion, LocalDate fechaInicioInscripcion,
			LocalDate fechaFinalizacionInscripcion) {
		this.fechaInicio = fechaInicio;
		this.fechaFinalizacion = fechaFinalizacion;
		this.fechaInicioInscripcion = fechaInicioInscripcion;
		this.fechaFinalizacionInscripcion = fechaFinalizacionInscripcion;

		this.Id = this.IdSiguiente;
		this.IdSiguiente++;
	}

	

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}



	public LocalDate getFechaInicio() {
		return fechaInicio;
	}



	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}



	public LocalDate getFechaFinalizacion() {
		return fechaFinalizacion;
	}



	public void setFechaFinalizacion(LocalDate fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}



	public LocalDate getFechaInicioInscripcion() {
		return fechaInicioInscripcion;
	}



	public void setFechaInicioInscripcion(LocalDate fechaInicioInscripcion) {
		this.fechaInicioInscripcion = fechaInicioInscripcion;
	}



	public LocalDate getFechaFinalizacionInscripcion() {
		return fechaFinalizacionInscripcion;
	}



	public void setFechaFinalizacionInscripcion(LocalDate fechaFinalizacionInscripcion) {
		this.fechaFinalizacionInscripcion = fechaFinalizacionInscripcion;
	}



	@Override
	public int hashCode() {
		return Objects.hash(fechaFinalizacion, fechaFinalizacionInscripcion, fechaInicio, fechaInicioInscripcion);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CicloLectivo other = (CicloLectivo) obj;
		return Objects.equals(fechaFinalizacion, other.fechaFinalizacion)
				&& Objects.equals(fechaFinalizacionInscripcion, other.fechaFinalizacionInscripcion)
				&& Objects.equals(fechaInicio, other.fechaInicio)
				&& Objects.equals(fechaInicioInscripcion, other.fechaInicioInscripcion);
	}

}
