package Intraconsulta;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class CicloLectivoTest {

	@Test
	public void queSePuedaCrearUnCicloLectivo() {
		LocalDate fechaInicio = LocalDate.parse("2023-09-14");
		LocalDate fechaFinalizacion = LocalDate.parse("2023-12-31");
		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-09-13");
		LocalDate fechaFinalizacionInscripcion = LocalDate.parse("2023-09-15");
		Integer IdEsperado = 1;

		CicloLectivo nuevo = new CicloLectivo(fechaInicio, fechaFinalizacion, fechaInicioInscripcion,
				fechaFinalizacionInscripcion);

		assertNotNull(nuevo);
		assertEquals(fechaInicio, nuevo.getFechaInicio());
		assertEquals(fechaFinalizacion, nuevo.getFechaFinalizacion());
		assertEquals(fechaInicioInscripcion, nuevo.getFechaInicioInscripcion());
		assertEquals(fechaFinalizacionInscripcion, nuevo.getFechaFinalizacionInscripcion());
		assertEquals(IdEsperado, nuevo.getId());
	}

	@Test
	public void queAlCrearseDosCiclosLectivosSuIdSeaConsecutivo() {
		LocalDate fechaInicio = LocalDate.parse("2023-09-14");
		LocalDate fechaFinalizacion = LocalDate.parse("2023-12-31");
		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-09-13");
		LocalDate fechaFinalizacionInscripcion = LocalDate.parse("2023-09-15");
		Integer IdEsperado = 2;

		CicloLectivo nuevo = new CicloLectivo(fechaInicio, fechaFinalizacion, fechaInicioInscripcion,
				fechaFinalizacionInscripcion);
		CicloLectivo nuevo2 = new CicloLectivo(fechaInicio, fechaFinalizacion, fechaInicioInscripcion,
				fechaFinalizacionInscripcion);

		assertEquals(IdEsperado, nuevo2.getId());
	}
	
//	Universidad - CicloLectivo
	
	@Test
	public void queSePuedaAgregarUnCicloLectivo() {
		LocalDate fechaInicio = LocalDate.parse("2023-09-14");
		LocalDate fechaFinalizacion = LocalDate.parse("2023-12-31");
		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-09-13");
		LocalDate fechaFinalizacionInscripcion = LocalDate.parse("2023-09-15");

		CicloLectivo nuevoCiclo = new CicloLectivo(fechaInicio, fechaFinalizacion, fechaInicioInscripcion,
				fechaFinalizacionInscripcion);

		String NombreUniversidad = "UNLaM";
		Universidad actual = new Universidad(NombreUniversidad);
		
		
		assertTrue(actual.agregarCicloLectivo(nuevoCiclo));
		assertTrue(actual.getCiclosLectivos().contains(nuevoCiclo));
	}
	
	@Test
	public void queNoSePuedaAgregarUnCicloLectivoSobreOtroQueTengaMismasFechas() {
		LocalDate fechaInicio = LocalDate.parse("2023-09-14");
		LocalDate fechaFinalizacion = LocalDate.parse("2023-12-31");
		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-09-13");
		LocalDate fechaFinalizacionInscripcion = LocalDate.parse("2023-09-15");
		CicloLectivo nuevoCiclo = new CicloLectivo(fechaInicio, fechaFinalizacion, fechaInicioInscripcion,
				fechaFinalizacionInscripcion);
		LocalDate fechaInicio2 = LocalDate.parse("2023-03-14");
		LocalDate fechaFinalizacion2 = LocalDate.parse("2023-09-30");
		LocalDate fechaInicioInscripcion2 = LocalDate.parse("2023-03-13");
		LocalDate fechaFinalizacionInscripcion2 = LocalDate.parse("2023-03-15");
		CicloLectivo nuevoCiclo2 = new CicloLectivo(fechaInicio2, fechaFinalizacion2, fechaInicioInscripcion2,
				fechaFinalizacionInscripcion2);
		String NombreUniversidad = "UNLaM";
		Universidad actual = new Universidad(NombreUniversidad);
		
		actual.agregarCicloLectivo(nuevoCiclo);
		
		
		assertFalse(actual.agregarCicloLectivo(nuevoCiclo2));
	}
}
