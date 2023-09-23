package Intraconsulta;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestAlumno {

	@Test
	public void queSePuedaCrearUnAlumno() {
		Integer dni = 222;
		String nombre= "Lautaro";
		String apellido= "Salazar";
		LocalDate FechaNacimiento = LocalDate.parse("2001-04-10");
		
		Alumno nuevo = new Alumno(dni,nombre,apellido,FechaNacimiento);
		
		assertNotNull(nuevo);
		assertEquals(dni,nuevo.getDni());
		assertEquals(apellido,nuevo.getApellido());
		assertEquals(nombre,nuevo.getNombre());
		assertEquals(nuevo.getFechaNacimiento(),FechaNacimiento);
	}
	
	@Test
	public void queSePuedaAgregarUnAlumno() {
		Integer dni = 222;
		String nombre= "Lautaro";
		String apellido= "Salazar";
		LocalDate FechaNacimiento = LocalDate.parse("2001-04-10");
		
		Alumno nuevoAlumno = new Alumno(dni,nombre,apellido,FechaNacimiento);
		nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		nombre = "PB2";
		Materia materia = new Materia(nombre);
		unlam.registraMateria(materia);
		Integer cantidadLugares = 40;
		Aula aula = new Aula(cantidadLugares);
		unlam.agregarAula(aula);
		LocalDate fechaInicio = LocalDate.parse("2023-09-14");
		LocalDate fechaFinalizacion = LocalDate.parse("2023-12-31");
		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-09-13");
		LocalDate fechaFinalizacionInscripcion = LocalDate.parse("2023-09-15");
		CicloLectivo nuevoCicloLectivo = new CicloLectivo(fechaInicio, fechaFinalizacion, fechaInicioInscripcion,fechaFinalizacionInscripcion);
		unlam.agregarCicloLectivo(nuevoCicloLectivo);
		String dia = "lunes";
		String turno = "noche";
		Curso nuevoCurso = new Curso(materia, dia, turno, nuevoCicloLectivo, aula);

		unlam.agregarCurso(nuevoCurso);
		
		assertTrue(unlam.inscribirAlumnoACurso(nuevoCurso.getId(), dni));

	}

}
