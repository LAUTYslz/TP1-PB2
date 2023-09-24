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
		LocalDate fechaFinalizacionInscripcion = LocalDate.parse("2023-10-15");
		CicloLectivo nuevoCicloLectivo = new CicloLectivo(fechaInicio, fechaFinalizacion, fechaInicioInscripcion,fechaFinalizacionInscripcion);
		unlam.agregarCicloLectivo(nuevoCicloLectivo);
		String dia = "lunes";
		String turno = "noche";
		Curso nuevoCurso = new Curso(materia, dia, turno, nuevoCicloLectivo, aula);
		unlam.registrarAlumno(nuevoAlumno);

		unlam.agregarCurso(nuevoCurso);
		
		assertTrue(unlam.inscribirAlumnoACurso(nuevoCurso.getId(), dni));

	}
	
	@Test
	public void queNoSePuedanAgregarUnAlumnoAUnCursoSiElAlumnoYElCursoNoEstanDadosDeAlta() {
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
//		unlam.registrarAlumno(nuevoAlumno);

		unlam.agregarCurso(nuevoCurso);
		
		assertFalse(unlam.inscribirAlumnoACurso(nuevoCurso.getId(), dni));

	}
	
	@Test
	public void queNoSePuedaAgregarUnAlumnoSiNoEstaDentroDeLaFechaDeInscripcion() {
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
//		AL SER LA FECHA DE HOY LA COMPARADA VA A DAR FALSO
		CicloLectivo nuevoCicloLectivo = new CicloLectivo(fechaInicio, fechaFinalizacion, fechaInicioInscripcion,fechaFinalizacionInscripcion);
		unlam.agregarCicloLectivo(nuevoCicloLectivo);
		String dia = "lunes";
		String turno = "noche";
		Curso nuevoCurso = new Curso(materia, dia, turno, nuevoCicloLectivo, aula);
		
		unlam.registrarAlumno(nuevoAlumno);
		unlam.agregarCurso(nuevoCurso);
		
		assertFalse(unlam.inscribirAlumnoACurso(nuevoCurso.getId(), dni));

	}
	
	@Test
	public void queNoSePuedaAgregarUnAlumnoSiNoEstaCursandoElMismoDiaYTurno() {
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
		nombre = "Base de Datos 1";
		
		Materia materia2 = new Materia(nombre);
		unlam.registraMateria(materia2);
		
		Integer cantidadLugares = 40;
		Aula aula = new Aula(cantidadLugares);
		unlam.agregarAula(aula);
		
		LocalDate fechaInicio = LocalDate.parse("2023-09-14");
		LocalDate fechaFinalizacion = LocalDate.parse("2023-12-31");
		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-09-13");
		LocalDate fechaFinalizacionInscripcion = LocalDate.parse("2023-10-15");
		CicloLectivo nuevoCicloLectivo = new CicloLectivo(fechaInicio, fechaFinalizacion, fechaInicioInscripcion,fechaFinalizacionInscripcion);
		unlam.agregarCicloLectivo(nuevoCicloLectivo);
		
		String dia = "lunes";
		String turno = "noche";
		Curso nuevoCurso = new Curso(materia, dia, turno, nuevoCicloLectivo, aula);
		Curso nuevoCurso2 = new Curso(materia2, dia, turno, nuevoCicloLectivo, aula);
		
		
		unlam.registrarAlumno(nuevoAlumno);
		unlam.agregarCurso(nuevoCurso);
		unlam.agregarCurso(nuevoCurso2);
		
		assertTrue(unlam.inscribirAlumnoACurso(nuevoCurso.getId(), dni));
		assertFalse(unlam.inscribirAlumnoACurso(nuevoCurso2.getId(), dni));

	}


}
