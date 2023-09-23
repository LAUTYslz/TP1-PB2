package Intraconsulta;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;


public class TestUniversidad {

	@Test
	public void queSePuedaCrearUniversidad() {
		String NombreUniversidad = "UNLaM";
		Universidad actual = new Universidad(NombreUniversidad);
		
		assertNotNull(actual);
	}
	
//	Inscripcion Alumno Uni
	@Test
	public void QueSePuedaInscribirUnAlumno() {
		String NombreUniversidad = "UNLaM";
		Universidad actual = new Universidad(NombreUniversidad);
		Integer dni = 222;
		String nombre= "Lautaro";
		String apellido= "Salazar";
		LocalDate FechaNacimiento = LocalDate.parse("2001-04-10");
		Alumno nuevoAlumno = new Alumno(dni,nombre,apellido,FechaNacimiento);
		Boolean registroObtenido=false;
		
		registroObtenido = actual.registrarAlumno(nuevoAlumno);
		
		assertTrue(registroObtenido);
		assertEquals(1,actual.getAlumnosInscriptos().size());
	}
	
	@Test
	public void QueSePuedanInscribirDosAlumnos() {
		String NombreUniversidad = "UNLaM";
		Universidad actual = new Universidad(NombreUniversidad);
		Integer dni = 222;
		String nombre= "Lautaro";
		String apellido= "Salazar";
		LocalDate FechaNacimiento = LocalDate.parse("2001-04-10");
		Alumno nuevoAlumno = new Alumno(dni,nombre,apellido,FechaNacimiento);
		Boolean registroObtenido=false;
		
		actual.registrarAlumno(nuevoAlumno);
		
		Integer dni2 = 223;
		String nombre2= "Lautaro";
		String apellido2= "Salazar";
		LocalDate FechaNacimiento2= LocalDate.parse("2001-04-10");
		Alumno nuevoAlumno2 = new Alumno(dni2,nombre,apellido,FechaNacimiento);
		
		registroObtenido = actual.registrarAlumno(nuevoAlumno2);
		
		assertTrue(registroObtenido);
		assertEquals(2,actual.getAlumnosInscriptos().size());
	}
	
	@Test
	public void QueNoSePuedaInscribirUnAlumnoConMismoDNI() {
		String NombreUniversidad = "UNLaM";
		Universidad actual = new Universidad(NombreUniversidad);
		Integer dni = 222;
		String nombre= "Lautaro";
		String apellido= "Salazar";
		LocalDate FechaNacimiento = LocalDate.parse("2001-04-10");
		Alumno nuevoAlumno = new Alumno(dni,nombre,apellido,FechaNacimiento);
		Boolean registroObtenido=false;
		
		Integer dni2 = 222;
		Alumno nuevoAlumno2 = new Alumno(dni2,nombre,apellido,FechaNacimiento);
		
		actual.registrarAlumno(nuevoAlumno);
		registroObtenido = actual.registrarAlumno(nuevoAlumno2);

		
		assertFalse(registroObtenido);
		assertEquals(1,actual.getAlumnosInscriptos().size());
	}
	
//	Materia
	@Test
	public void queSePuedaRegistrarUnaMateriaAUnaUniversidad() {
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		nombre = "PB2 ";
		Materia pb2 = new Materia(nombre);
		assertTrue(unlam.registraMateria(pb2));
	}
	
	@Test
	public void queNoSePuedaRegistrarUnaMateriaConMismoNombreAUnaUniversidad() {
		String nombreUni = "Unlam";
		Universidad unlam = new Universidad(nombreUni);
		String nombreMateria;
		nombreMateria = "PB2";
		Materia pb2 = new Materia("PB2");
		Materia pb3 = new Materia("PB2");
		assertTrue(unlam.registraMateria(pb3));
	}
	
//	@Test
//	public void queSePuedaAsociarUnaMateriaCorrelativaAOtraMateria() {
//		String nombre = "Unlam";
//		Universidad unlam = new Universidad(nombre);
//		nombre = "PB1";
//		Materia pb1 = new Materia(nombre);
//		unlam.registraMateria(pb1);
//		nombre = "PB2";
//
//		Materia pb2 = new Materia(nombre);
//		pb2.agregarCorrelativa(pb1);
//		unlam.registraMateria(pb2);
//
//		ArrayList<Materia> correlativas2 = pb2.getCorrelativas();
//
//		assertTrue(correlativas2.contains(pb1));
//	}
	
	@Test
	public void queSePuedaAsociarUnaMateriaCorrelativaAOtraMateriaId() {
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		nombre = "PB1";
		Materia pb1 = new Materia(nombre);
		unlam.registraMateria(pb1);
		nombre = "PB2";

		Materia pb2 = new Materia(nombre);
		unlam.registraMateria(pb2);
		unlam.agregarCorrelativaAMateria(pb2.getId(),pb1.getId());
	

		ArrayList<Materia> correlativas2 = pb2.getCorrelativas();

		assertEquals(correlativas2.size(),1);
		assertTrue(correlativas2.contains(pb1));
	}
	
//	@Test
//	public void queNoSePuedaAsociarUnaMateriaCorrelativaAOtraMateriaPorqueYaExiste() {
//		String nombre = "Unlam";
//		Universidad unlam = new Universidad(nombre);
//
//		nombre = "PB1";
//		Integer codigo = 1;
//		Materia pb1 = new Materia(nombre);
//		unlam.registraMateria(pb1);
//		nombre = "PB2";
//		ArrayList<Materia> correlativas = new ArrayList<>();
//		correlativas.add(pb1);
//		Materia pb2 = new Materia(nombre);
//		pb2.agregarCorrelativa(pb1);
//		unlam.registraMateria(pb2);
//		
//		assertFalse(pb2.agregarCorrelativa(pb1));
//	}
	
	@Test
	public void queNoSePuedaAsociarUnaMateriaCorrelativaAOtraMateriaPorqueYaExisteId() {
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);

		nombre = "PB1";
		Materia pb1 = new Materia(nombre);
		unlam.registraMateria(pb1);
		nombre = "PB2";
		Materia pb2 = new Materia(nombre);
		unlam.registraMateria(pb2);
		unlam.agregarCorrelativaAMateria(pb2.getId(),pb1.getId());
		
		
		assertFalse(unlam.agregarCorrelativaAMateria(pb2.getId(),pb1.getId()));
	}
	
//	@Test
//	public void queNoSePuedaAsociarLaMismaMateriaComoCorrelativa() {
//		String nombre = "Unlam";
//		Universidad unlam = new Universidad(nombre);
//		nombre = "PB1";
//		Materia pb1 = new Materia(nombre);
//		unlam.registraMateria(pb1);
//		
//		assertFalse(pb1.agregarCorrelativa(pb1));
//	}
	
	@Test
	public void queNoSePuedaAsociarLaMismaMateriaComoCorrelativaId() {
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		nombre = "PB1";
		Materia pb1 = new Materia(nombre);
		unlam.registraMateria(pb1);
		
		assertFalse(unlam.agregarCorrelativaAMateria(pb1.getId(), pb1.getId()));
	}
	
	
//	@Test
//	public void queSePuedaEliminarUnaCorrelativaDeUnaMateria() {
//		String nombre = "Unlam";
//		Universidad unlam = new Universidad(nombre);
//		nombre = "PB1";
//		Materia pb1 = new Materia(nombre);
//		unlam.registraMateria(pb1);
//		nombre = "PB2";
//
//		Materia pb2 = new Materia(nombre);
//		pb2.agregarCorrelativa(pb1);
//		unlam.registraMateria(pb2);
//		
//		pb2.eliminarCorrelativa("PB1");
//
//		ArrayList<Materia> correlativas2 = pb2.getCorrelativas();
//
//		assertFalse(correlativas2.contains(pb1));
//	}
	
	@Test
	public void queSePuedaEliminarUnaCorrelativaDeUnaMateriaId() {
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		nombre = "PB1";
		Materia pb1 = new Materia(nombre);
		unlam.registraMateria(pb1);
		nombre = "PB2";

		Materia pb2 = new Materia(nombre);
		unlam.registraMateria(pb2);
		unlam.agregarCorrelativaAMateria(pb2.getId(), pb1.getId());
		
		unlam.eliminarCorrelativaDeMateria(pb2.getId(),pb1.getId());

		ArrayList<Materia> correlativas2 = pb2.getCorrelativas();

		assertFalse(correlativas2.contains(pb1));
	}

}
