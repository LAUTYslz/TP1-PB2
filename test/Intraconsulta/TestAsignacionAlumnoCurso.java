package Intraconsulta;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

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
		LocalDate fechaFinalizacionInscripcion = LocalDate.parse("2023-12-15");
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
		LocalDate fechaFinalizacionInscripcion = LocalDate.parse("2023-12-15");
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
		unlam.registrarNota(nuevoCurso.getId(),nuevoAlumno.getDni(),nota3);
		unlam.registrarNota(nuevoCurso.getId(),nuevoAlumno.getDni(),nota1);
		unlam.registrarNota(nuevoCurso.getId(),nuevoAlumno.getDni(),nota2);
		
		
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
		LocalDate fechaFinalizacionInscripcion = LocalDate.parse("2023-12-15");
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
		LocalDate fechaFinalizacionInscripcion = LocalDate.parse("2023-12-15");
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
		LocalDate fechaFinalizacionInscripcion = LocalDate.parse("2023-12-15");
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
		ArrayList<Integer> notaFinal= new ArrayList<>();
		notaFinal = unlam.buscarLaNotaFinalDelAlumno(materia.getId(),dni);
		assertTrue(notaFinal.contains(asignacion.getPromedioFinal())); 
		// hicimos un array por que puede haber 2 notas finales de esa misma materia si es que el alumno la recurso 
		// y el assert no dice si ese array de nota final contiene al promedioFinal de asignacion
		
	}
	
//	@Test
//	public void QueSePuedanObtenerLasMateriasDelAlumnoQueSeHayanAprobado() {
////	Nota
//		Integer valor1 = 7;
//		ListaExamenes primerParcial = ListaExamenes.PRIMER_PARCIAL;
//		Nota nota1 = new Nota(valor1, primerParcial);
//		ListaExamenes segundoParcial = ListaExamenes.SEGUNDO_PARCIAL;
//		Nota nota2 = new Nota(valor1, segundoParcial);
//		
//		
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
//		nombre = "PB1";
//		Materia materia = new Materia(nombre);
//		nombre = "MATES";
//		Materia materia2 = new Materia(nombre);
//		nombre = "Info";
//		Materia materia3 = new Materia(nombre);
////	Aula
//		Integer cantidadLugares = 40;
//		Aula aula = new Aula(cantidadLugares);
////	CicloLectivo
//		LocalDate fechaInicio = LocalDate.parse("2023-03-14");
//		LocalDate fechaFinalizacion = LocalDate.parse("2023-06-30");
//		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-03-13");
//		LocalDate fechaFinalizacionInscripcion = LocalDate.parse("2023-10-15");
//		CicloLectivo nuevoCicloLectivo = new CicloLectivo(fechaInicio, fechaFinalizacion, fechaInicioInscripcion,fechaFinalizacionInscripcion);
//		LocalDate fechaInicio2 = LocalDate.parse("2023-09-14");
//		LocalDate fechaFinalizacion2 = LocalDate.parse("2023-12-31");
//		LocalDate fechaInicioInscripcion2 = LocalDate.parse("2023-09-13");
//		LocalDate fechaFinalizacionInscripcion2 = LocalDate.parse("2023-10-15");
//		CicloLectivo nuevoCicloLectivo2 = new CicloLectivo(fechaInicio2, fechaFinalizacion2, fechaInicioInscripcion2,fechaFinalizacionInscripcion2);
////	Curso
//		String dia = "lunes";
//		String turno = "noche";
//		String dia2 = "martes";
//		Curso nuevoCurso = new Curso(materia, dia, turno, nuevoCicloLectivo, aula);
//		Curso nuevoCurso2 = new Curso(materia2, dia, turno, nuevoCicloLectivo2, aula);
//		Curso nuevoCurso3 = new Curso(materia2, dia2, turno, nuevoCicloLectivo2, aula);
//		
////		ACCIONES
//		unlam.registraMateria(materia);
//		unlam.registraMateria(materia2);
//		unlam.registraMateria(materia3);
//		
//		unlam.agregarAula(aula);
//		unlam.registrarAlumno(nuevoAlumno);
//		unlam.agregarCicloLectivo(nuevoCicloLectivo);
//		unlam.agregarCicloLectivo(nuevoCicloLectivo2);
//
//		unlam.agregarCurso(nuevoCurso);
//		unlam.agregarCurso(nuevoCurso2);
//		unlam.agregarCurso(nuevoCurso3);
//		
//		unlam.inscribirAlumnoACurso(nuevoCurso.getId(), dni);
//		unlam.inscribirAlumnoACurso(nuevoCurso2.getId(), dni);
//		unlam.inscribirAlumnoACurso(nuevoCurso3.getId(), dni);
//		
//		unlam.registrarNota(nuevoCurso.getId(),nuevoAlumno.getDni(),nota1);
//		unlam.registrarNota(nuevoCurso.getId(),nuevoAlumno.getDni(),nota2);
//		
//		unlam.registrarNota(nuevoCurso2.getId(),nuevoAlumno.getDni(),nota1);
//		unlam.registrarNota(nuevoCurso2.getId(),nuevoAlumno.getDni(),nota2);
//		
//		unlam.registrarNota(nuevoCurso3.getId(),nuevoAlumno.getDni(),nota1);
//		unlam.registrarNota(nuevoCurso3.getId(),nuevoAlumno.getDni(),nota2);
//		
//		
//		
////		VERIFICACION
//		ArrayList<Materia> materiasAprobadas = unlam.materiasAprobadasDelAlumno(dni);
//		assertEquals(materiasAprobadas.size(),3);
//		
//	}
	
	@Test
	public void QueSePuedanVerSoloLasMateriasQueLeFaltaAprobarAlAlumno() {
//	Nota
		
		Integer valor =3;		
		ListaExamenes primerParcial = ListaExamenes.PRIMER_PARCIAL;
		Nota nota1 = new Nota(valor, primerParcial);
		ListaExamenes segundoParcial = ListaExamenes.SEGUNDO_PARCIAL;
		Nota nota2 = new Nota(valor, segundoParcial);
		
		Nota nota3 = new Nota(valor, primerParcial);
		Nota nota4 = new Nota(valor, segundoParcial);
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
		nombre = "PB1";
		Materia materia = new Materia(nombre);
		nombre = "MATES";
		Materia materia2 = new Materia(nombre);
		nombre = "Info";
		Materia materia3 = new Materia(nombre);
//	Aula
		Integer cantidadLugares = 40;
		Aula aula = new Aula(cantidadLugares);
//	CicloLectivo
		LocalDate fechaInicio = LocalDate.parse("2023-03-14");
		LocalDate fechaFinalizacion = LocalDate.parse("2023-06-30");
		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-03-13");
		LocalDate fechaFinalizacionInscripcion = LocalDate.parse("2023-12-15");
		CicloLectivo nuevoCicloLectivo = new CicloLectivo(fechaInicio, fechaFinalizacion, fechaInicioInscripcion,fechaFinalizacionInscripcion);
		LocalDate fechaInicio2 = LocalDate.parse("2023-09-14");
		LocalDate fechaFinalizacion2 = LocalDate.parse("2023-12-31");
		LocalDate fechaInicioInscripcion2 = LocalDate.parse("2023-09-13");
		LocalDate fechaFinalizacionInscripcion2 = LocalDate.parse("2023-12-15");
		CicloLectivo nuevoCicloLectivo2 = new CicloLectivo(fechaInicio2, fechaFinalizacion2, fechaInicioInscripcion2,fechaFinalizacionInscripcion2);
//	Curso
		String dia = "lunes";
		String turno = "noche";
		Curso nuevoCurso = new Curso(materia, dia, turno, nuevoCicloLectivo, aula);
		Curso nuevoCurso2 = new Curso(materia2, dia, turno, nuevoCicloLectivo2, aula);
		
//		ACCIONES
		unlam.registraMateria(materia);
		unlam.registraMateria(materia2);
		unlam.registraMateria(materia3);
		
		unlam.agregarAula(aula);
		unlam.registrarAlumno(nuevoAlumno);
		unlam.agregarCicloLectivo(nuevoCicloLectivo);
		unlam.agregarCicloLectivo(nuevoCicloLectivo2);

		unlam.agregarCurso(nuevoCurso);
		unlam.agregarCurso(nuevoCurso2);
		
		unlam.inscribirAlumnoACurso(nuevoCurso.getId(), dni);
		unlam.inscribirAlumnoACurso(nuevoCurso2.getId(), dni);
		
		unlam.registrarNota(nuevoCurso.getId(),nuevoAlumno.getDni(),nota1);
		unlam.registrarNota(nuevoCurso.getId(),nuevoAlumno.getDni(),nota2);
		unlam.registrarNota(nuevoCurso2.getId(),nuevoAlumno.getDni(),nota3);
		unlam.registrarNota(nuevoCurso2.getId(),nuevoAlumno.getDni(),nota4);
		
		
		
//		VERIFICACION
		ArrayList<Materia> materiasFaltantes = new ArrayList<>();
		materiasFaltantes.add(materia);
		materiasFaltantes.add(materia2);
		materiasFaltantes.add(materia3);
		assertEquals(unlam.materiasQueLeFaltaAprobarAlAlumno(dni).size(),3);
		assertEquals(materiasFaltantes,unlam.materiasQueLeFaltaAprobarAlAlumno(dni));
		
	}
	
	@Test
	public void QueSePuedaVerElReporteDeNotasDeAlumnosDeUnCurso() {
//	Nota
		Integer valor =3;		
		ListaExamenes primerParcial = ListaExamenes.PRIMER_PARCIAL;
		Nota nota1 = new Nota(valor, primerParcial);
		ListaExamenes segundoParcial = ListaExamenes.SEGUNDO_PARCIAL;
		Nota nota2 = new Nota(valor, segundoParcial);
		Nota nota3 = new Nota(valor, primerParcial);
		Nota nota4 = new Nota(valor, segundoParcial);
		Nota nota5 = new Nota(valor, primerParcial);
		Nota nota6 = new Nota(valor, segundoParcial);
//	Alumno
		Integer dni = 222;
		Integer dni2 = 223;
		Integer dni3 = 224;		
		String nombre= "Lautaro";
		String apellido= "Salazar";
		LocalDate FechaNacimiento = LocalDate.parse("2001-04-10");
		Alumno alumno1 = new Alumno(dni,nombre,apellido,FechaNacimiento);
		Alumno alumno2 = new Alumno(dni2,nombre,apellido,FechaNacimiento);
		Alumno alumno3 = new Alumno(dni3,nombre,apellido,FechaNacimiento);
//	Universidad
		nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
//	Materia
		nombre = "PB1";
		Materia materia = new Materia(nombre);
//	Aula
		Integer cantidadLugares = 40;
		Aula aula = new Aula(cantidadLugares);
//	CicloLectivo
		LocalDate fechaInicio = LocalDate.parse("2023-03-14");
		LocalDate fechaFinalizacion = LocalDate.parse("2023-06-30");
		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-03-13");
		LocalDate fechaFinalizacionInscripcion = LocalDate.parse("2023-12-15");
		CicloLectivo nuevoCicloLectivo = new CicloLectivo(fechaInicio, fechaFinalizacion, fechaInicioInscripcion,fechaFinalizacionInscripcion);
//	Curso
		String dia = "lunes";
		String turno = "noche";
		Curso nuevoCurso = new Curso(materia, dia, turno, nuevoCicloLectivo, aula);
		
//		ACCIONES
		unlam.registraMateria(materia);
		
		unlam.agregarAula(aula);
		unlam.registrarAlumno(alumno1);
		unlam.registrarAlumno(alumno2);
		unlam.registrarAlumno(alumno3);
		unlam.agregarCicloLectivo(nuevoCicloLectivo);
		
		unlam.agregarCurso(nuevoCurso);
		
		unlam.inscribirAlumnoACurso(nuevoCurso.getId(), dni);
		unlam.inscribirAlumnoACurso(nuevoCurso.getId(), dni2);
		unlam.inscribirAlumnoACurso(nuevoCurso.getId(), dni3);
		
		unlam.registrarNota(nuevoCurso.getId(),alumno1.getDni(),nota1);
		unlam.registrarNota(nuevoCurso.getId(),alumno1.getDni(),nota2);
		unlam.registrarNota(nuevoCurso.getId(),alumno2.getDni(),nota3);
		unlam.registrarNota(nuevoCurso.getId(),alumno2.getDni(),nota4);
		unlam.registrarNota(nuevoCurso.getId(),alumno3.getDni(),nota5);
		unlam.registrarNota(nuevoCurso.getId(),alumno3.getDni(),nota6);

		
		ArrayList<AsignacionAlumnoCurso> ReporteNotasCurso = new ArrayList<>();
		ReporteNotasCurso = unlam.ObtenerReporteDeNotasDeAlumnosDeCurso(nuevoCurso.getId());
		int cantidadDeReportesEsperados = 3;
//		VERIFICACION
		
		assertEquals(ReporteNotasCurso.size(),cantidadDeReportesEsperados);
		
		
	}
	
	@Test
	public void QueSePuedaVerElListadoDeMateriasAprobadasDelAlumno() {
//	Nota
		Integer valor =7;		
		ListaExamenes primerParcial = ListaExamenes.PRIMER_PARCIAL;
		Nota nota1 = new Nota(valor, primerParcial);
		ListaExamenes segundoParcial = ListaExamenes.SEGUNDO_PARCIAL;
		Nota nota2 = new Nota(valor, segundoParcial);
		Nota nota3 = new Nota(valor, primerParcial);
		Nota nota4 = new Nota(valor, segundoParcial);
		Nota nota5 = new Nota(valor, primerParcial);
		Nota nota6 = new Nota(valor, segundoParcial);
		valor = 3;
		Nota nota7 = new Nota(valor, primerParcial);
		Nota nota8 = new Nota(valor, segundoParcial);
//	Alumno
		Integer dni = 222;		
		String nombre= "Lautaro";
		String apellido= "Salazar";
		LocalDate FechaNacimiento = LocalDate.parse("2001-04-10");
		Alumno alumno1 = new Alumno(dni,nombre,apellido,FechaNacimiento);
//	Universidad
		nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
//	Materia
		nombre = "PB1";
		Materia materia1 = new Materia(nombre);
		nombre = "MATES";
		Materia materia2 = new Materia(nombre);
		nombre = "Info";
		Materia materia3 = new Materia(nombre);
		nombre = "Compu";
		Materia materia4 = new Materia(nombre);
//	Aula
		Integer cantidadLugares = 40;
		Aula aula = new Aula(cantidadLugares);
//	CicloLectivo
		LocalDate fechaInicio = LocalDate.parse("2023-03-14");
		LocalDate fechaFinalizacion = LocalDate.parse("2023-06-30");
		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-03-13");
		LocalDate fechaFinalizacionInscripcion = LocalDate.parse("2023-12-15");
		CicloLectivo nuevoCicloLectivo = new CicloLectivo(fechaInicio, fechaFinalizacion, fechaInicioInscripcion,fechaFinalizacionInscripcion);
//	Curso
		String dia = "lunes";
		String turno = "noche";
		Curso nuevoCurso1 = new Curso(materia1, dia, turno, nuevoCicloLectivo, aula);
		 dia = "martes";
		Curso nuevoCurso2 = new Curso(materia2, dia, turno, nuevoCicloLectivo, aula);
		 dia = "miercoles";
		Curso nuevoCurso3 = new Curso(materia3, dia, turno, nuevoCicloLectivo, aula);
		 dia = "jueves";
		Curso nuevoCurso4 = new Curso(materia4, dia, turno, nuevoCicloLectivo, aula);
		
//		ACCIONES
		unlam.registraMateria(materia1);
		unlam.registraMateria(materia2);
		unlam.registraMateria(materia3);
		unlam.registraMateria(materia4);
		
		unlam.agregarAula(aula);
		unlam.registrarAlumno(alumno1);
		unlam.agregarCicloLectivo(nuevoCicloLectivo);
		
		unlam.agregarCurso(nuevoCurso1);
		unlam.agregarCurso(nuevoCurso2);
		unlam.agregarCurso(nuevoCurso3);
		unlam.agregarCurso(nuevoCurso4);
		
		unlam.inscribirAlumnoACurso(nuevoCurso1.getId(), dni);
		unlam.inscribirAlumnoACurso(nuevoCurso2.getId(), dni);
		unlam.inscribirAlumnoACurso(nuevoCurso3.getId(), dni);
		unlam.inscribirAlumnoACurso(nuevoCurso4.getId(), dni);
		
		unlam.registrarNota(nuevoCurso1.getId(),alumno1.getDni(),nota1);
		unlam.registrarNota(nuevoCurso1.getId(),alumno1.getDni(),nota2);
		unlam.registrarNota(nuevoCurso2.getId(),alumno1.getDni(),nota3);
		unlam.registrarNota(nuevoCurso2.getId(),alumno1.getDni(),nota4);
		unlam.registrarNota(nuevoCurso3.getId(),alumno1.getDni(),nota5);
		unlam.registrarNota(nuevoCurso3.getId(),alumno1.getDni(),nota6);
		unlam.registrarNota(nuevoCurso3.getId(),alumno1.getDni(),nota7);
		unlam.registrarNota(nuevoCurso3.getId(),alumno1.getDni(),nota8);
		
		
		ArrayList<AsignacionAlumnoCurso> reporteMateriasAprobadasDelAlumno = new ArrayList<>();
		reporteMateriasAprobadasDelAlumno = unlam.ObtenerListadoMateriasAprobadasParaUnAlumno(dni);
		int cantidadDeReportesEsperados = 3;
//		VERIFICACION
		assertEquals(reporteMateriasAprobadasDelAlumno.size(),cantidadDeReportesEsperados);		
	}


}
