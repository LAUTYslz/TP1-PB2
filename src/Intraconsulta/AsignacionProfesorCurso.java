package Intraconsulta;

public class AsignacionProfesorCurso {

	private Profesor profe;
	private Curso curso;
	private Integer Id;
	private static Integer IdSiguiente =1; 
	

	public AsignacionProfesorCurso(Profesor profe, Curso curso) {
		this.profe=profe;
		this.curso=curso;
		this.Id=this.IdSiguiente;
		this.IdSiguiente++;
		
	}

}
