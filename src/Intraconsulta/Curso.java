package Intraconsulta;

import java.util.Objects;

public class Curso {

	private Aula aula;
	private CicloLectivo cicloLectivo;
	private String turno;
	private String dia;
	private Materia materia;
	private Integer Id;
	private Integer alumnosInscriptos;
	private Integer profesoresInscriptos;
	private static Integer IdSiguiente =1; 
	

	public Curso(Materia materia,String dia ,String turno ,CicloLectivo nuevoCicloLectivo, Aula aula) {
		this.materia = materia;
		this.dia = dia;
		this.turno = turno;
		this.cicloLectivo = nuevoCicloLectivo;
		this.aula = aula;
		this.Id=this.IdSiguiente;
		this.IdSiguiente++;
		this.alumnosInscriptos =0;
		this.profesoresInscriptos =0;
	}


	public Integer getId() {
		return Id;
	}


	public void setId(Integer id) {
		Id = id;
	}


	public Aula getAula() {
		return aula;
	}


	public void setAula(Aula aula) {
		this.aula = aula;
	}


	public CicloLectivo getCicloLectivo() {
		return cicloLectivo;
	}


	public void setCicloLectivo(CicloLectivo cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}


	public Materia getMateria() {
		return materia;
	}


	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	
	


	public String getTurno() {
		return turno;
	}


	public void setTurno(String turno) {
		this.turno = turno;
	}


	public String getDia() {
		return dia;
	}


	public void setDia(String dia) {
		this.dia = dia;
	}
	
	


	public Integer getAlumnosInscriptos() {
		return alumnosInscriptos;
	}


	public void setAlumnosInscriptos(Integer alumnosInscriptos) {
		this.alumnosInscriptos = alumnosInscriptos;
	}
	
	public void sumarAlumnosInscriptos() {
		this.alumnosInscriptos++;		
	}
	
	public Integer profesoresNecesarios() {
		Double alumnos = (double)this.alumnosInscriptos;
		Double aRedondear = alumnos/20;
		Integer profesores = (int)(Math.ceil(aRedondear));
		return profesores;
	}

	public Integer getProfesoresInscriptos() {
		return profesoresInscriptos;
	}


	public void setProfesoresInscriptos(Integer profesoresInscriptos) {
		this.profesoresInscriptos = profesoresInscriptos;
	}


	public void sumarProfesoresInscriptos() {
		profesoresInscriptos++;
	
	}



	@Override
	public int hashCode() {
		return Objects.hash(cicloLectivo, dia, materia, turno);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return Objects.equals(cicloLectivo, other.cicloLectivo) && Objects.equals(dia, other.dia)
				&& Objects.equals(materia, other.materia) && Objects.equals(turno, other.turno);
	}


	@Override
	public String toString() {
		return "Curso [cicloLectivo=" + cicloLectivo + ", materia=" + materia + "]";
	}


	
	
	


	


	


	
}
