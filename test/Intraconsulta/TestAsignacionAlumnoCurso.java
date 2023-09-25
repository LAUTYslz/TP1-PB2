package Intraconsulta;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestAsignacionAlumnoCurso {

	@Test
	public void QueSePuedaCalcularPromedio() {
//	Nota
		Integer valor = 10;
		ListaExamenes primerParcial = ListaExamenes.PRIMER_PARCIAL;
		Integer valor2 = 7;
		ListaExamenes segundoParcial = ListaExamenes.SEGUNDO_PARCIAL;
		Nota nota1 = new Nota(valor, primerParcial);
		Nota nota2 = new Nota(valor2, segundoParcial);
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
		
		unlam.inscribirAlumnoACurso(nuevoCurso.getId(), dni);
		unlam.registrarNota(nuevoCurso.getId(),nuevoAlumno.getDni(),nota1);
		unlam.registrarNota(nuevoCurso.getId(),nuevoAlumno.getDni(),nota2);
		
		AsignacionAlumnoCurso asignacion = unlam.buscarAsignacionConCursoYAlumno(nuevoCurso.getId(),dni);
//		VERIFICACION
		unlam.calcularPromedioDelAlumnoEnCursada(dni,nuevoCurso.getId());
		assertEquals((Integer)9,asignacion.getPromedioFinal());
	}
	
	@Test
	public void QueSePuedaCalcularPromedioCon3Notas() {
//	Nota
		Integer valor = 2;
		ListaExamenes primerParcial = ListaExamenes.PRIMER_PARCIAL;
		Integer valor2 = 10;
		ListaExamenes segundoParcial = ListaExamenes.SEGUNDO_PARCIAL;
		Integer valor3 = 7;
		ListaExamenes recPrimerParcial = ListaExamenes.REC_PRIMER_PARCIAL;
		Nota nota1 = new Nota(valor, primerParcial);
		Nota nota2 = new Nota(valor2, segundoParcial);
		Nota nota3 = new Nota(valor3, recPrimerParcial);
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
		
		unlam.inscribirAlumnoACurso(nuevoCurso.getId(), dni);
		unlam.registrarNota(nuevoCurso.getId(),nuevoAlumno.getDni(),nota1);
		unlam.registrarNota(nuevoCurso.getId(),nuevoAlumno.getDni(),nota2);
		unlam.registrarNota(nuevoCurso.getId(),nuevoAlumno.getDni(),nota3);
		
		AsignacionAlumnoCurso asignacion = unlam.buscarAsignacionConCursoYAlumno(nuevoCurso.getId(),dni);
//		VERIFICACION
		unlam.calcularPromedioDelAlumnoEnCursada(dni,nuevoCurso.getId());
		assertEquals((Integer)9,asignacion.getPromedioFinal());
	}
	
	@Test
	public void QueNoSePuedanIngresar2NotasDelMismoParcial() {
//	Nota
		Integer valor = 2;
		ListaExamenes primerParcial = ListaExamenes.PRIMER_PARCIAL;
		Integer valor2 = 10;
		ListaExamenes primerParcialV2 = ListaExamenes.PRIMER_PARCIAL;
		Nota nota1 = new Nota(valor, primerParcial);
		Nota nota2 = new Nota(valor2, primerParcialV2);
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
		
		unlam.inscribirAlumnoACurso(nuevoCurso.getId(), dni);
		unlam.registrarNota(nuevoCurso.getId(),nuevoAlumno.getDni(),nota1);
		
		
		AsignacionAlumnoCurso asignacion = unlam.buscarAsignacionConCursoYAlumno(nuevoCurso.getId(),dni);
//		VERIFICACION
		assertFalse(unlam.registrarNota(nuevoCurso.getId(),nuevoAlumno.getDni(),nota2));
		assertEquals(asignacion.getNotas().size(),1);
	}
	
	@Test
	public void QueNoSePuedanIngresar2NotasDelTipoRec_Parcial() {
//	Nota
		Integer valor = 2;
		ListaExamenes recPrimerParcial = ListaExamenes.REC_PRIMER_PARCIAL;
		Integer valor2 = 10;
		ListaExamenes recSegundoParcial = ListaExamenes.REC_SEGUNDO_PARCIAL;
		Nota nota1 = new Nota(valor, recPrimerParcial);
		Nota nota2 = new Nota(valor2, recSegundoParcial);
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
		
		unlam.inscribirAlumnoACurso(nuevoCurso.getId(), dni);
		unlam.registrarNota(nuevoCurso.getId(),nuevoAlumno.getDni(),nota1);
		
		
		AsignacionAlumnoCurso asignacion = unlam.buscarAsignacionConCursoYAlumno(nuevoCurso.getId(),dni);
//		VERIFICACION
		assertFalse(unlam.registrarNota(nuevoCurso.getId(),nuevoAlumno.getDni(),nota2));
		assertEquals(asignacion.getNotas().size(),1);
	}
	
	@Test
	public void QueSePuedaObtenerLaNotaFinalDelAlumno() {
//	Nota
		Integer valor = 2;
		ListaExamenes primerParcial = ListaExamenes.PRIMER_PARCIAL;
		Integer valor2 = 10;
		ListaExamenes segundoParcial = ListaExamenes.SEGUNDO_PARCIAL;
		Integer valor3 = 7;
		ListaExamenes recPrimerParcial = ListaExamenes.REC_PRIMER_PARCIAL;
		Nota nota1 = new Nota(valor, primerParcial);
		Nota nota2 = new Nota(valor2, segundoParcial);
		Nota nota3 = new Nota(valor3, recPrimerParcial);
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
		
		unlam.inscribirAlumnoACurso(nuevoCurso.getId(), dni);
		unlam.registrarNota(nuevoCurso.getId(),nuevoAlumno.getDni(),nota1);
		unlam.registrarNota(nuevoCurso.getId(),nuevoAlumno.getDni(),nota2);
		unlam.registrarNota(nuevoCurso.getId(),nuevoAlumno.getDni(),nota3);
		
		AsignacionAlumnoCurso asignacion = unlam.buscarAsignacionConCursoYAlumno(nuevoCurso.getId(),dni);
		unlam.calcularPromedioDelAlumnoEnCursada(dni,nuevoCurso.getId());
//		VERIFICACION
		Integer notaFinal=0;
		notaFinal = unlam.buscarLaNotaFinalDelAlumno(asignacion.getId());
		assertEquals(asignacion.getPromedioFinal(),notaFinal);
	}


}
