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
	public void queSePuedaAgregarUnAlumnoAUnCurso() {
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
	public void queNoSePuedaAgregarUnAlumnoSiSuperaLaCantidadMaximaDelAula() {
		Integer dni = 222;
		String nombre = "Lautaro";
		String apellido = "Salazar";
		Integer dni2 = 111;
		String nombre2 = "Matias";
		String apellido2 = "Buda";
		LocalDate FechaNacimiento = LocalDate.parse("2001-04-10");
		Alumno lautaro = new Alumno(dni, nombre, apellido, FechaNacimiento);
		Alumno matias = new Alumno(dni2, nombre2, apellido2, FechaNacimiento);
		nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		
		nombre = "PB2";
		Materia materia = new Materia(nombre);
		unlam.registraMateria(materia);
		
		Integer cantidadLugares = 1;
		Aula aula = new Aula(cantidadLugares);
		unlam.agregarAula(aula);
		
		LocalDate fechaInicio = LocalDate.parse("2023-09-14");
		LocalDate fechaFinalizacion = LocalDate.parse("2023-12-31");
		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-01-01");
		LocalDate fechaFinalizacionInscripcion = LocalDate.parse("2023-12-31");
		CicloLectivo nuevoCicloLectivo = new CicloLectivo(fechaInicio, fechaFinalizacion, fechaInicioInscripcion,
				fechaFinalizacionInscripcion);
		unlam.agregarCicloLectivo(nuevoCicloLectivo);
		
		String dia = "lunes";
		String turno = "noche";
		
		Curso nuevoCurso = new Curso(materia, dia, turno, nuevoCicloLectivo, aula);
		
		unlam.registrarAlumno(lautaro);
		assertTrue(unlam.registrarAlumno(matias));
		
		unlam.agregarCurso(nuevoCurso);
		assertTrue(unlam.inscribirAlumnoACurso(nuevoCurso.getId(), dni));
		assertFalse(unlam.inscribirAlumnoACurso(nuevoCurso.getId(), dni2));
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
	
	@Test
	public void NoSepUedeInscribirUnAlumnoSiNoTieneAprobadasLasCorrelativas() {
//	Nota
		Integer valor1 = 7;
		Integer valor2 =3;		
		ListaExamenes primerParcial = ListaExamenes.PRIMER_PARCIAL;
		Nota nota1 = new Nota(valor1, primerParcial);
		ListaExamenes SegundoParcial = ListaExamenes.SEGUNDO_PARCIAL;
		Nota nota2 = new Nota(valor2, SegundoParcial);
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
		nombre = "PB2";
		Materia materia2 = new Materia(nombre);
//	Aula
		Integer cantidadLugares = 40;
		Aula aula = new Aula(cantidadLugares);
//	CicloLectivo
		LocalDate fechaInicio = LocalDate.parse("2023-03-14");
		LocalDate fechaFinalizacion = LocalDate.parse("2023-06-30");
		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-03-13");
		LocalDate fechaFinalizacionInscripcion = LocalDate.parse("2023-10-15");
		CicloLectivo nuevoCicloLectivo = new CicloLectivo(fechaInicio, fechaFinalizacion, fechaInicioInscripcion,fechaFinalizacionInscripcion);
		LocalDate fechaInicio2 = LocalDate.parse("2023-09-14");
		LocalDate fechaFinalizacion2 = LocalDate.parse("2023-12-31");
		LocalDate fechaInicioInscripcion2 = LocalDate.parse("2023-09-13");
		LocalDate fechaFinalizacionInscripcion2 = LocalDate.parse("2023-10-15");
		CicloLectivo nuevoCicloLectivo2 = new CicloLectivo(fechaInicio2, fechaFinalizacion2, fechaInicioInscripcion2,fechaFinalizacionInscripcion2);
//	Curso
		String dia = "lunes";
		String turno = "noche";
		Curso nuevoCurso = new Curso(materia, dia, turno, nuevoCicloLectivo, aula);
		Curso nuevoCurso2 = new Curso(materia2, dia, turno, nuevoCicloLectivo2, aula);
		
//		ACCIONES
		unlam.registraMateria(materia);
		unlam.registraMateria(materia2);
		unlam.agregarCorrelativaAMateria(materia2.getId(), materia.getId());
		unlam.agregarAula(aula);
		unlam.registrarAlumno(nuevoAlumno);
		unlam.agregarCicloLectivo(nuevoCicloLectivo);
		unlam.agregarCicloLectivo(nuevoCicloLectivo2);

		unlam.agregarCurso(nuevoCurso);
		unlam.agregarCurso(nuevoCurso2);
		
//		VERIFICACION
		assertTrue(unlam.inscribirAlumnoACurso(nuevoCurso.getId(), dni));
		assertTrue(unlam.registrarNota(nuevoCurso.getId(),nuevoAlumno.getDni(),nota1));
		assertTrue(unlam.registrarNota(nuevoCurso.getId(),nuevoAlumno.getDni(),nota2));
		assertTrue(materia2.getCorrelativas().contains(materia));
		assertFalse(unlam.inscribirAlumnoACurso(nuevoCurso2.getId(), dni));
	}
	
	@Test
	public void QueSePuedanVerSoloLasMateriasQueSeHayanCursadoYAprobadoDelAlumno() {
//	Nota
		Integer valor1 = 7;
		Integer valor2 =3;		
		ListaExamenes primerParcial = ListaExamenes.PRIMER_PARCIAL;
		Nota nota1 = new Nota(valor1, primerParcial);
		ListaExamenes segundoParcial = ListaExamenes.SEGUNDO_PARCIAL;
		Nota nota2 = new Nota(valor1, segundoParcial);
		
		Nota nota3 = new Nota(valor2, primerParcial);
		Nota nota4 = new Nota(valor2, segundoParcial);
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
		LocalDate fechaFinalizacionInscripcion = LocalDate.parse("2023-10-15");
		CicloLectivo nuevoCicloLectivo = new CicloLectivo(fechaInicio, fechaFinalizacion, fechaInicioInscripcion,fechaFinalizacionInscripcion);
		LocalDate fechaInicio2 = LocalDate.parse("2023-09-14");
		LocalDate fechaFinalizacion2 = LocalDate.parse("2023-12-31");
		LocalDate fechaInicioInscripcion2 = LocalDate.parse("2023-09-13");
		LocalDate fechaFinalizacionInscripcion2 = LocalDate.parse("2023-10-15");
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
		assertEquals(unlam.materiasAprobadasDelAlumno(dni).size(),1);
		
	}
	
	@Test
	public void QueSePuedanVerSoloLasMateriasQueLeFaltaAprobarAlAlumno() {
//	Nota
		Integer valor1 = 7;
		Integer valor2 =3;		
		ListaExamenes primerParcial = ListaExamenes.PRIMER_PARCIAL;
		Nota nota1 = new Nota(valor1, primerParcial);
		ListaExamenes segundoParcial = ListaExamenes.SEGUNDO_PARCIAL;
		Nota nota2 = new Nota(valor1, segundoParcial);
		
		Nota nota3 = new Nota(valor2, primerParcial);
		Nota nota4 = new Nota(valor2, segundoParcial);
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
		LocalDate fechaFinalizacionInscripcion = LocalDate.parse("2023-10-15");
		CicloLectivo nuevoCicloLectivo = new CicloLectivo(fechaInicio, fechaFinalizacion, fechaInicioInscripcion,fechaFinalizacionInscripcion);
		LocalDate fechaInicio2 = LocalDate.parse("2023-09-14");
		LocalDate fechaFinalizacion2 = LocalDate.parse("2023-12-31");
		LocalDate fechaInicioInscripcion2 = LocalDate.parse("2023-09-13");
		LocalDate fechaFinalizacionInscripcion2 = LocalDate.parse("2023-10-15");
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
		assertEquals(unlam.materiasQueLeFaltaAprobarAlAlumno(dni).size(),2);
		
	}
	
	@Test
	public void NoSepUedeInscribirUnAlumnoSiTieneLaMateriaYaAprobada() {
//	Nota
		Integer valor1 = 7;
		Integer valor2 =7;		
		ListaExamenes primerParcial = ListaExamenes.PRIMER_PARCIAL;
		Nota nota1 = new Nota(valor1, primerParcial);
		ListaExamenes SegundoParcial = ListaExamenes.SEGUNDO_PARCIAL;
		Nota nota2 = new Nota(valor2, SegundoParcial);
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
//	Aula
		Integer cantidadLugares = 40;
		Aula aula = new Aula(cantidadLugares);
//	CicloLectivo
		LocalDate fechaInicio = LocalDate.parse("2023-03-14");
		LocalDate fechaFinalizacion = LocalDate.parse("2023-06-30");
		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-03-13");
		LocalDate fechaFinalizacionInscripcion = LocalDate.parse("2023-10-15");
		CicloLectivo nuevoCicloLectivo = new CicloLectivo(fechaInicio, fechaFinalizacion, fechaInicioInscripcion,fechaFinalizacionInscripcion);
		LocalDate fechaInicio2 = LocalDate.parse("2023-09-14");
		LocalDate fechaFinalizacion2 = LocalDate.parse("2023-12-31");
		LocalDate fechaInicioInscripcion2 = LocalDate.parse("2023-09-13");
		LocalDate fechaFinalizacionInscripcion2 = LocalDate.parse("2023-10-15");
		CicloLectivo nuevoCicloLectivo2 = new CicloLectivo(fechaInicio2, fechaFinalizacion2, fechaInicioInscripcion2,fechaFinalizacionInscripcion2);
//	Curso
		String dia = "lunes";
		String turno = "noche";
		Curso nuevoCurso = new Curso(materia, dia, turno, nuevoCicloLectivo, aula);
		Curso nuevoCurso2 = new Curso(materia, dia, turno, nuevoCicloLectivo2, aula);
		
//		ACCIONES
		unlam.registraMateria(materia);
		unlam.agregarAula(aula);
		unlam.registrarAlumno(nuevoAlumno);
		unlam.agregarCicloLectivo(nuevoCicloLectivo);
		unlam.agregarCicloLectivo(nuevoCicloLectivo2);

		unlam.agregarCurso(nuevoCurso);
		unlam.agregarCurso(nuevoCurso2);
		
		unlam.inscribirAlumnoACurso(nuevoCurso.getId(), dni);
		unlam.registrarNota(nuevoCurso.getId(),nuevoAlumno.getDni(),nota1);
		unlam.registrarNota(nuevoCurso.getId(),nuevoAlumno.getDni(),nota2);
		
//		VERIFICACION
		assertFalse(unlam.inscribirAlumnoACurso(nuevoCurso2.getId(), dni));
	}
}
