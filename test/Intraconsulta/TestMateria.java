package Intraconsulta;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMateria {

	@Test
	public void queSePuedaCrearUnaMateria() {
		String nombre= "PB1";
		Integer IdEsperado=1;
		Integer IdObtenido;
		Materia nuevo= new Materia(nombre);
		
		IdObtenido=nuevo.getId();
		
		assertNotNull(nuevo);
		assertEquals(IdEsperado,IdObtenido);
	}

	@Test
	public void queElIdDeDosMateriasSeaConsecutivo() {
		String nombre= "PB1";
		Integer IdEsperado=2;
		Integer IdObtenido;
		Materia nuevo= new Materia(nombre);
		Materia nuevo2= new Materia(nombre);
		
		IdObtenido=nuevo2.getId();
		
		assertEquals(IdEsperado,IdObtenido);
	}

}
