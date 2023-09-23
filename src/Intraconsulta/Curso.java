package Intraconsulta;

import java.util.Objects;

public class Curso {

	private Aula aula;
	private CicloLectivo cicloLectivo;
	private Horario horario;
	private Materia materia;
	private Integer Id;
	private static Integer IdSiguiente =1; 
	

	public Curso(Materia materia, Horario horario, CicloLectivo nuevoCicloLectivo, Aula aula) {
		this.materia = materia;
		this.horario = horario;
		this.cicloLectivo = nuevoCicloLectivo;
		this.aula = aula;
		this.Id=this.IdSiguiente;
		this.IdSiguiente++;
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


	public Horario getHorario() {
		return horario;
	}


	public void setHorario(Horario horario) {
		this.horario = horario;
	}


	public Materia getMateria() {
		return materia;
	}


	public void setMateria(Materia materia) {
		this.materia = materia;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cicloLectivo, materia);
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
		return Objects.equals(cicloLectivo, other.cicloLectivo) && Objects.equals(materia, other.materia);
	}

}
