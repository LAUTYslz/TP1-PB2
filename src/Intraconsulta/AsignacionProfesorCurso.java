package Intraconsulta;

public class AsignacionProfesorCurso {

	private Profesor profesor;
	private Curso curso;
	private Integer Id;
	private static Integer IdSiguiente =1; 
	

	public AsignacionProfesorCurso(Profesor profe, Curso curso) {
		this.profesor=profe;
		this.curso=curso;
		this.Id=this.IdSiguiente;
		this.IdSiguiente++;
		
	}


	public Profesor getProfesor() {
		return profesor;
	}


	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
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
