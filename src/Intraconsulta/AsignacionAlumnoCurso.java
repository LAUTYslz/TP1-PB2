package Intraconsulta;

import java.util.ArrayList;

public class AsignacionAlumnoCurso {

	private Alumno alumno;
	private Curso curso;
	private Integer Id;
	private ArrayList <Nota> notas;
	private static Integer IdSiguiente =1; 

	public AsignacionAlumnoCurso(Alumno alumno, Curso curso) {
		this.alumno = alumno;
		this.curso = curso;
		this.Id=this.IdSiguiente;
		this.IdSiguiente++;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}
	
}
