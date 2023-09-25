package Intraconsulta;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestNota {

	@Test
	public void queSePuedaCrearUnaNota() {
		Integer valor = 7;
		ListaExamenes examen = ListaExamenes.PRIMER_PARCIAL;
		Integer IdEsperado = 1;

		Nota nota1 = new Nota(valor, examen);
		
		assertNotNull(nota1);
		assertEquals(valor,nota1.getValor());
		assertEquals(examen,nota1.getExamen());
		assertEquals(IdEsperado, nota1.getId());
	}
	
	@Test
	public void QueAlCrearseDosNotasElIdSeaConsecutivo() {
		Integer valor = 7;
		ListaExamenes examen = ListaExamenes.PRIMER_PARCIAL;
		Integer IdEsperado = 2;

		Nota nota1 = new Nota(valor, examen);
		Nota nota2 = new Nota(valor, examen);
		
		assertEquals(IdEsperado, nota2.getId());
	}
	
//	NOTA-AsigancionAlumnoAcurso////////////////////////////////////////////////////////////
	@Test
	public void QueSePuedaRegistratUnaNota() {
//	Nota
		Integer valor = 7;
		ListaExamenes examen = ListaExamenes.PRIMER_PARCIAL;
		Nota nota = new Nota(valor, examen);
//	Alumno
		Integer dni = 222;
		String nombre= "Lautaro";
		String apellido= "Salazar";
		LocalDate FechaNacimiento = LocalDate.parse("2001-04-10");
		Alumno nuevoAlumno = new Alumno(dni,nombre,apellido,FechaNacimiento);
//	Universidad
		nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
//	Materia
		nombre = "PB2";
		Materia materia = new Materia(nombre);
//	Aula
		Integer cantidadLugares = 40;
		Aula aula = new Aula(cantidadLugares);
//	CicloLectivo
		LocalDate fechaInicio = LocalDate.parse("2023-09-14");
		LocalDate fechaFinalizacion = LocalDate.parse("2023-12-31");
		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-09-13");
		LocalDate fechaFinalizacionInscripcion = LocalDate.parse("2023-10-15");
		CicloLectivo nuevoCicloLectivo = new CicloLectivo(fechaInicio, fechaFinalizacion, fechaInicioInscripcion,fechaFinalizacionInscripcion);
//	Curso
		String dia = "lunes";
		String turno = "noche";
		Curso nuevoCurso = new Curso(materia, dia, turno, nuevoCicloLectivo, aula);
		
//		ACCIONES
		unlam.registraMateria(materia);
		unlam.agregarAula(aula);
		unlam.registrarAlumno(nuevoAlumno);
		unlam.agregarCicloLectivo(nuevoCicloLectivo);

		unlam.agregarCurso(nuevoCurso);
//		VERIFICACION
		assertTrue(unlam.inscribirAlumnoACurso(nuevoCurso.getId(), dni));
		assertTrue(unlam.registrarNota(nuevoCurso.getId(),nuevoAlumno.getDni(),nota));
	}
	
	@Test
	public void QueNoSePuedaRegistratUnaNotaSiElValorNoEsEntre1y10() {
//	Nota
		Integer valor = 11;
		ListaExamenes examen = ListaExamenes.PRIMER_PARCIAL;
		Integer IdEsperado = 2;
		Nota nota = new Nota(valor, examen);
//	Alumno
		Integer dni = 222;
		String nombre= "Lautaro";
		String apellido= "Salazar";
		LocalDate FechaNacimiento = LocalDate.parse("2001-04-10");
		Alumno nuevoAlumno = new Alumno(dni,nombre,apellido,FechaNacimiento);
//	Universidad
		nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
//	Materia
		nombre = "PB2";
		Materia materia = new Materia(nombre);
//	Aula
		Integer cantidadLugares = 40;
		Aula aula = new Aula(cantidadLugares);
//	CicloLectivo
		LocalDate fechaInicio = LocalDate.parse("2023-09-14");
		LocalDate fechaFinalizacion = LocalDate.parse("2023-12-31");
		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-09-13");
		LocalDate fechaFinalizacionInscripcion = LocalDate.parse("2023-10-15");
		CicloLectivo nuevoCicloLectivo = new CicloLectivo(fechaInicio, fechaFinalizacion, fechaInicioInscripcion,fechaFinalizacionInscripcion);
//	Curso
		String dia = "lunes";
		String turno = "noche";
		Curso nuevoCurso = new Curso(materia, dia, turno, nuevoCicloLectivo, aula);
		
//		ACCIONES
		unlam.registraMateria(materia);
		unlam.agregarAula(aula);
		unlam.registrarAlumno(nuevoAlumno);
		unlam.agregarCicloLectivo(nuevoCicloLectivo);

		unlam.agregarCurso(nuevoCurso);
//		VERIFICACION
		assertTrue(unlam.inscribirAlumnoACurso(nuevoCurso.getId(), dni));
		assertFalse(unlam.registrarNota(nuevoCurso.getId(),nuevoAlumno.getDni(),nota));
	}
	
//	@Test
//	public void QueNoSePuedaAsignarUnaNotaMayorOIgualA7SiNoEstanLasCorrelativasAprobadas() {
////	Nota
//		Integer valor = 10;
//		ListaExamenes examen = ListaExamenes.PRIMER_PARCIAL;
//		Integer IdEsperado = 2;
//		Nota nota = new Nota(valor, examen);
////	Alumno
//		Integer dni = 222;
//		String nombre= "Lautaro";
//		String apellido= "Salazar";
//		LocalDate FechaNacimiento = LocalDate.parse("2001-04-10");
//		Alumno nuevoAlumno = new Alumno(dni,nombre,apellido,FechaNacimiento);
////	Universidad
//		nombre = "Unlam";
//		Universidad unlam = new Universidad(nombre);
////	Materia
//		nombre = "PB2";
//		Materia materia = new Materia(nombre);
////	Aula
//		Integer cantidadLugares = 40;
//		Aula aula = new Aula(cantidadLugares);
////	CicloLectivo
//		LocalDate fechaInicio = LocalDate.parse("2023-09-14");
//		LocalDate fechaFinalizacion = LocalDate.parse("2023-12-31");
//		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-09-13");
//		LocalDate fechaFinalizacionInscripcion = LocalDate.parse("2023-10-15");
//		CicloLectivo nuevoCicloLectivo = new CicloLectivo(fechaInicio, fechaFinalizacion, fechaInicioInscripcion,fechaFinalizacionInscripcion);
////	Curso
//		String dia = "lunes";
//		String turno = "noche";
//		Curso nuevoCurso = new Curso(materia, dia, turno, nuevoCicloLectivo, aula);
//		
////		ACCIONES
//		unlam.registraMateria(materia);
//		unlam.agregarAula(aula);
//		unlam.registrarAlumno(nuevoAlumno);
//		unlam.agregarCicloLectivo(nuevoCicloLectivo);
//
//		unlam.agregarCurso(nuevoCurso);
////		VERIFICACION
//		assertTrue(unlam.inscribirAlumnoACurso(nuevoCurso.getId(), dni));
//		assertFalse(unlam.registrarNota(nuevoCurso.getId(),nuevoAlumno.getDni(),nota));
//	}
////////////////////////////////////////////PENDIENTE
	
	
}
