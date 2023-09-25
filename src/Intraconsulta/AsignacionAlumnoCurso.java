package Intraconsulta;

import java.util.ArrayList;

public class AsignacionAlumnoCurso {

	private Alumno alumno;
	private Curso curso;
	private Integer Id;
	private ArrayList <Nota> notas;
	private Integer promedioFinal;
	private static Integer IdSiguiente =1; 

	public AsignacionAlumnoCurso(Alumno alumno, Curso curso) {
		this.alumno = alumno;
		this.curso = curso;
		this.Id=this.IdSiguiente;
		this.IdSiguiente++;
		this.notas = new ArrayList<>();
		this.promedioFinal=0;
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

	public ArrayList<Nota> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<Nota> notas) {
		this.notas = notas;
	}

	public void agregarNota(Nota notaAAsignar) {
		this.notas.add(notaAAsignar);
	}

	
	public Integer getPromedioFinal() {
		return promedioFinal;
	}

	public void setPromedioFinal(Integer promedioFinal) {
		this.promedioFinal = promedioFinal;
	}

	@Override
	public String toString() {
		return "AsignacionAlumnoCurso [alumno=" + alumno + ", curso=" + curso + ", promedioFinal=" + promedioFinal
				+ "]";
	}
	
	
}
