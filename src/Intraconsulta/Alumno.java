package Intraconsulta;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Alumno {

	private Integer dni;
	private String nombre;
	private String apellido;
//	private LocalDate FechaNacimiento;
	private LocalDate FechaNacimiento;
	private LocalDate FechaDeIngreso;

//	public static DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy/MM/dd");

	public Alumno(Integer dni, String nombre, String apellido, LocalDate fechaNacimiento) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido= apellido;
//		LocalDate fecha = LocalDate.parse(fechaNacimiento, formato);
		this.FechaNacimiento = fechaNacimiento;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

//	public LocalDate getFechaNacimiento() {
//		return FechaNacimiento;
//	}
//
//	public void setFechaNacimiento(LocalDate fechaNacimiento) {
//		FechaNacimiento = fechaNacimiento;
//	}
	public LocalDate getFechaNacimiento() {
		return FechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}
	
	public LocalDate getFechaDeIngreso() {
		return FechaDeIngreso;
	}

	public void setFechaDeIngreso(LocalDate fechaDeIngreso) {
		FechaDeIngreso = fechaDeIngreso;
	}

	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	
	

	
	
}
