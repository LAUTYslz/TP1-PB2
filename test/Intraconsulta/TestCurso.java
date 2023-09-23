package Intraconsulta;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;


public class TestCurso {
	@Test
	public void queSePuedaCrearUnCurso() {
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		nombre = "PB1";
		Materia pb1 = new Materia(nombre);
		unlam.registraMateria(pb1);
		nombre = "PB2";
		Materia materia = new Materia(nombre);
		unlam.registraMateria(materia);
		unlam.agregarCorrelativaAMateria(materia.getId(),pb1.getId());
		ListaTurnos turno = ListaTurnos.MAÑANA;
		ListaDias  dias= ListaDias.MARTES;
		Horario horario = new Horario (turno,dias);
		Integer cantidadLugares=40;
		Aula aula = new Aula(cantidadLugares);
		unlam.agregarAula(aula);
		LocalDate fechaInicio = LocalDate.parse("2023-09-14");
		LocalDate fechaFinalizacion = LocalDate.parse("2023-12-31");
		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-09-13");
		LocalDate fechaFinalizacionInscripcion = LocalDate.parse("2023-09-15");
		CicloLectivo nuevoCicloLectivo = new CicloLectivo(fechaInicio, fechaFinalizacion, fechaInicioInscripcion,fechaFinalizacionInscripcion);
		
		Curso nuevoCurso = new Curso (materia,horario,nuevoCicloLectivo,aula);
		
//		unlam.agregarCurso(materia.getId(),horario,nuevoCicloLectivo.getId(),aula.getNro());
		assertNotNull(nuevoCurso);
	}

	@Test
	public void queSePuedaAgregarUnCurso() {
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		nombre = "PB1";
		Materia pb1 = new Materia(nombre);
		unlam.registraMateria(pb1);
		nombre = "PB2";
		Materia materia = new Materia(nombre);
		unlam.registraMateria(materia);
		unlam.agregarCorrelativaAMateria(materia.getId(),pb1.getId());
		ListaTurnos turno = ListaTurnos.MAÑANA;
		ListaDias  dias= ListaDias.MARTES;
		Horario horario = new Horario (turno,dias);
		Integer cantidadLugares=40;
		Aula aula = new Aula(cantidadLugares);
		unlam.agregarAula(aula);
		LocalDate fechaInicio = LocalDate.parse("2023-09-14");
		LocalDate fechaFinalizacion = LocalDate.parse("2023-12-31");
		LocalDate fechaInicioInscripcion = LocalDate.parse("2023-09-13");
		LocalDate fechaFinalizacionInscripcion = LocalDate.parse("2023-09-15");
		CicloLectivo nuevoCicloLectivo = new CicloLectivo(fechaInicio, fechaFinalizacion, fechaInicioInscripcion,fechaFinalizacionInscripcion);
		unlam.agregarCicloLectivo(nuevoCicloLectivo);
		
		Curso nuevoCurso = new Curso (materia,horario,nuevoCicloLectivo,aula);
		
		unlam.agregarCurso(nuevoCurso);
		
		assertNotNull(nuevoCurso);
		assertTrue(unlam.getCursos().contains(nuevoCurso));
	}
	
	@Test
    public void queNoSePuedaAgregarUnCursoQueYaExista() {
        String nombre = "Unlam";
        Universidad unlam = new Universidad(nombre);
        nombre = "PB1";
        Materia pb1 = new Materia(nombre);
        unlam.registraMateria(pb1);
        nombre = "PB2";
        Materia materia = new Materia(nombre);
        unlam.registraMateria(materia);
        unlam.agregarCorrelativaAMateria(materia.getId(),pb1.getId());
        ListaTurnos turno = ListaTurnos.MAÑANA;
        ListaDias  dias= ListaDias.MARTES;
        Horario horario = new Horario (turno,dias);
        Integer cantidadLugares=40;
        Aula aula = new Aula(cantidadLugares);
        unlam.agregarAula(aula);
        LocalDate fechaInicio = LocalDate.parse("2023-09-14");
        LocalDate fechaFinalizacion = LocalDate.parse("2023-12-31");
        LocalDate fechaInicioInscripcion = LocalDate.parse("2023-09-13");
        LocalDate fechaFinalizacionInscripcion = LocalDate.parse("2023-09-15");
        CicloLectivo nuevoCicloLectivo = new CicloLectivo(fechaInicio, fechaFinalizacion, fechaInicioInscripcion,fechaFinalizacionInscripcion);
        unlam.agregarCicloLectivo(nuevoCicloLectivo);

        Curso nuevoCurso = new Curso (materia,horario,nuevoCicloLectivo,aula);
        Curso Duplicado = new Curso (materia,horario,nuevoCicloLectivo,aula);


        unlam.agregarCurso(nuevoCurso);

        assertNotNull(nuevoCurso);
        assertNotNull(Duplicado);
        assertFalse(unlam.agregarCurso(Duplicado));

        //assertTrue(unlam.getCursos().contains(nuevoCurso));
        assertEquals(unlam.getCursos().size(),1);

    }
	
//	Universidad - Curso
	
	

}
