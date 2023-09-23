package Intraconsulta;

import static org.junit.Assert.*;

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
		
		actual.agregarDocente(profesor);
		
		assertTrue(actual.getProfesores().contains(profesor));
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
		
		actual.agregarDocente(profesor);
		
		assertFalse(actual.agregarDocente(profesor2));
	}
	
	

}
