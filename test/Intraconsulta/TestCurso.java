package Intraconsulta;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

public class TestCurso {
	@Test
	public void queSePuedaCrearUnCurso() {
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		nombre = "PB1";
		Materia pb1 = new Materia(nombre);
		unlam.registraMateria(pb1);
		nombre = "PB2";
		Materia materia = new Materia(nombre);
		unlam.registraMateria(materia);
		unlam.agregarCorrelativaAMateria(materia.getId(), pb1.getId());
		Integer cantidadLugares = 40;
		Aula aula = new Aula(cantidadLugares);
		unlam.agregarAula(aula);
		LocalDate fechaInicio = LocalDate.parse("2023-09-14");
		LocalDate fechaFinalizacion = LocalDate.parse("2023-12-31");
		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-09-13");
		LocalDate fechaFinalizacionInscripcion = LocalDate.parse("2023-09-15");
		CicloLectivo nuevoCicloLectivo = new CicloLectivo(fechaInicio, fechaFinalizacion, fechaInicioInscripcion,
				fechaFinalizacionInscripcion);
		//
		String dia = "lunes";
		String turno = "noche";

		Curso nuevoCurso = new Curso(materia, dia, turno, nuevoCicloLectivo, aula);

//		unlam.agregarCurso(materia.getId(),horario,nuevoCicloLectivo.getId(),aula.getNro());
		assertNotNull(nuevoCurso);
	}

	@Test
	public void queSePuedaAgregarUnCurso() {
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		nombre = "PB1";
		Materia pb1 = new Materia(nombre);
		unlam.registraMateria(pb1);
		nombre = "PB2";
		Materia materia = new Materia(nombre);
		unlam.registraMateria(materia);
		unlam.agregarCorrelativaAMateria(materia.getId(), pb1.getId());
		Integer cantidadLugares = 40;
		Aula aula = new Aula(cantidadLugares);
		unlam.agregarAula(aula);
		LocalDate fechaInicio = LocalDate.parse("2023-09-14");
		LocalDate fechaFinalizacion = LocalDate.parse("2023-12-31");
		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-09-13");
		LocalDate fechaFinalizacionInscripcion = LocalDate.parse("2023-09-15");
		CicloLectivo nuevoCicloLectivo = new CicloLectivo(fechaInicio, fechaFinalizacion, fechaInicioInscripcion,
				fechaFinalizacionInscripcion);
		unlam.agregarCicloLectivo(nuevoCicloLectivo);
		String dia = "lunes";
		String turno = "noche";

		Curso nuevoCurso = new Curso(materia, dia, turno, nuevoCicloLectivo, aula);

		assertTrue(unlam.agregarCurso(nuevoCurso));

		assertNotNull(nuevoCurso);
		assertTrue(unlam.getCursos().contains(nuevoCurso));
	}

	@Test
	public void queNoSePuedaAgregarUnCursoQueYaExista() {
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		nombre = "PB1";
		Materia pb1 = new Materia(nombre);
		unlam.registraMateria(pb1);
		nombre = "PB2";
		Materia materia = new Materia(nombre);
		unlam.registraMateria(materia);
		unlam.agregarCorrelativaAMateria(materia.getId(), pb1.getId());
		Integer cantidadLugares = 40;
		Aula aula = new Aula(cantidadLugares);
		unlam.agregarAula(aula);
		LocalDate fechaInicio = LocalDate.parse("2023-09-14");
		LocalDate fechaFinalizacion = LocalDate.parse("2023-12-31");
		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-09-13");
		LocalDate fechaFinalizacionInscripcion = LocalDate.parse("2023-09-15");
		CicloLectivo nuevoCicloLectivo = new CicloLectivo(fechaInicio, fechaFinalizacion, fechaInicioInscripcion,
				fechaFinalizacionInscripcion);
		unlam.agregarCicloLectivo(nuevoCicloLectivo);
		
		String dia = "lunes";
		String turno = "noche";

		Curso nuevoCurso = new Curso(materia, dia, turno, nuevoCicloLectivo, aula);
		Curso Duplicado = new Curso(materia, dia, turno, nuevoCicloLectivo, aula);

		unlam.agregarCurso(nuevoCurso);

		
		assertFalse(unlam.agregarCurso(Duplicado));
		assertEquals(unlam.getCursos().size(), 1);

	}

//	Universidad - Curso

}
