package Intraconsulta;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestNota {

	@Test
	public void queSePuedaCrearUnaNota() {
		Integer valor = 7;
		String examen = "PrimerParcial";
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
		String examen = "PrimerParcial";
		Integer IdEsperado = 2;

		Nota nota1 = new Nota(valor, examen);
		Nota nota2 = new Nota(valor, examen);
		
		assertEquals(IdEsperado, nota2.getId());
	}

}
