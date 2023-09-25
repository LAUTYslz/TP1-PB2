package Intraconsulta;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestProfesor {

	@Test
	public void queSePuedaCrearUnProfesor() {
		String nombre = "Alejandro";
		String apellido = "Salazar";
		Integer dni = 2223;
		
		Profesor nuevo = new Profesor(dni, nombre, apellido);
		
		assertNotNull(nuevo);
		assertEquals(dni,nuevo.getDni());
		assertEquals(nombre,nuevo.getNombre());
		assertEquals(apellido,nuevo.getApellido());

	}
	
//	Universidad - Profesor
	
	@Test
	public void queSePuedaAgregarUnProfesor() {
		String nombre = "Alejandro";
		String apellido = "Salazar";
		Integer dni = 2223;
		Profesor profesor = new Profesor(dni, nombre, apellido);
		String NombreUniversidad = "UNLaM";
		Universidad actual = new Universidad(NombreUniversidad);
		
		actual.agregarProfesor(profesor);
		
		assertTrue(actual.getProfesoresInscriptos().contains(profesor));
	}
	
	@Test
	public void queNoSePuedaAgregarUnProfesorConMismoDni() {
		String nombre = "Alejandro";
		String apellido = "Salazar";
		Integer dni = 2223;
		Profesor profesor = new Profesor(dni, nombre, apellido);
		String nombre2 = "Juan";
		String apellido2 = "Perez";
		Profesor profesor2 = new Profesor(dni,nombre2,apellido2);
		String NombreUniversidad = "UNLaM";
		Universidad actual = new Universidad(NombreUniversidad);
		
		actual.agregarProfesor(profesor);
		
		assertFalse(actual.agregarProfesor(profesor2));
	}
	
	@Test
	public void queSePuedaAgregarUnProfesorAUnCurso() {
//Profe
		Integer dni = 777;
		String nombre= "Juan";
		String apellido= "Monteagudo";
		Profesor profe = new Profesor(dni,nombre,apellido);
		
//Uni	
		nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		
//Materia
		nombre = "PB2";
		Materia materia = new Materia(nombre);
		unlam.registraMateria(materia);
		
//Aula
		Integer cantidadLugares = 40;
		Aula aula = new Aula(cantidadLugares);
		unlam.agregarAula(aula);
		
//Ciclo	
		LocalDate fechaInicio = LocalDate.parse("2023-09-14");
		LocalDate fechaFinalizacion = LocalDate.parse("2023-12-31");
		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-09-13");
		LocalDate fechaFinalizacionInscripcion = LocalDate.parse("2023-10-15");
		CicloLectivo nuevoCicloLectivo = new CicloLectivo(fechaInicio, fechaFinalizacion, fechaInicioInscripcion,fechaFinalizacionInscripcion);
		unlam.agregarCicloLectivo(nuevoCicloLectivo);
	
//Curso	
		String dia = "lunes";
		String turno = "noche";
		Curso nuevoCurso = new Curso(materia, dia, turno, nuevoCicloLectivo, aula);
	
//ACCIONES	
		unlam.agregarProfesor(profe);
		unlam.agregarCurso(nuevoCurso);
		
//VERIFICACIONES	
		assertTrue(unlam.inscribirProfesorACurso(nuevoCurso.getId(), dni));

	}	
	
	@Test
	public void queNoSePuedanAgregarDosProfesoresAUnCursoSiNoHayMasDe20Alumnos() {
//Profe
		Integer dni = 777;
		String nombre= "Juan";
		String apellido= "Monteagudo";
		Profesor profe = new Profesor(dni,nombre,apellido);
		Integer dni2 = 778;
		String nombre2= "Juan";
		String apellido2= "Monteagudo";
		Profesor profe2 = new Profesor(dni2,nombre2,apellido2);
		
//Alumno
		Integer dniAlumno = 222;
		String nombreAlumno= "Lautaro";
		String apellidoAlumno= "Salazar";
		LocalDate FechaNacimiento = LocalDate.parse("2001-04-10");
		
//Uni	
		nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		
//Materia
		nombre = "PB2";
		Materia materia = new Materia(nombre);
		unlam.registraMateria(materia);
		
//Aula
		Integer cantidadLugares = 40;
		Aula aula = new Aula(cantidadLugares);
		unlam.agregarAula(aula);
		
//Ciclo	
		LocalDate fechaInicio = LocalDate.parse("2023-09-14");
		LocalDate fechaFinalizacion = LocalDate.parse("2023-12-31");
		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-09-13");
		LocalDate fechaFinalizacionInscripcion = LocalDate.parse("2023-10-15");
		CicloLectivo nuevoCicloLectivo = new CicloLectivo(fechaInicio, fechaFinalizacion, fechaInicioInscripcion,fechaFinalizacionInscripcion);
		unlam.agregarCicloLectivo(nuevoCicloLectivo);
	
//Curso	
		String dia = "lunes";
		String turno = "noche";
		Curso nuevoCurso = new Curso(materia, dia, turno, nuevoCicloLectivo, aula);
		

//ACCIONES	
		unlam.agregarProfesor(profe);
		unlam.agregarProfesor(profe2);
		unlam.agregarCurso(nuevoCurso);

//Alumno
			Alumno nuevoAlumno = new Alumno(dniAlumno,nombreAlumno,apellidoAlumno,FechaNacimiento);
			assertTrue(unlam.registrarAlumno(nuevoAlumno));
			assertTrue(unlam.inscribirAlumnoACurso(nuevoCurso.getId(), dniAlumno));
			
		
//VERIFICACIONES	
		assertTrue(unlam.inscribirProfesorACurso(nuevoCurso.getId(), dni));
		assertFalse(unlam.inscribirProfesorACurso(nuevoCurso.getId(), dni2));

	}	
	
	

}
