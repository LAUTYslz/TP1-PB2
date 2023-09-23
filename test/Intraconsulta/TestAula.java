package Intraconsulta;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAula {

	@Test
	public void queSePuedaCrearUnAula() {
		Integer nroEsperado=1;
		Integer cantidadLugares=40;
		
		Aula nueva = new Aula(cantidadLugares);
		
		assertNotNull(nueva);
		assertEquals(nueva.getNro(),nroEsperado);
	}
	
	
	@Test
	public void queAlCrearseDosAulasElNroSeaConsecutivo() {
		Integer nroEsperado=2;
		Integer cantidadLugares=40;
		
		Aula nueva = new Aula(cantidadLugares);
		Aula nueva2 = new Aula(cantidadLugares);

		assertEquals(nroEsperado,nueva2.getNro());
	}
	
	@Test
	public void queSeAgregarUnAulaALaUniversidad() {
		Integer nroEsperado=1;
		Integer cantidadLugares=40;
		Aula aula = new Aula(cantidadLugares);
		
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		
		unlam.agregarAula(aula);
		
		assertTrue(unlam.getAulas().contains(aula));
	}
}
