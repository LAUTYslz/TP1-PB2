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

}
