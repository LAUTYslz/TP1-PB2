package Intraconsulta;

import java.util.ArrayList;

public class Universidad {

	private String nombre;
	private ArrayList<Alumno> alumnosInscriptos;
	private ArrayList<Materia> materias;
	private ArrayList<Profesor> profesores;
	private ArrayList<CicloLectivo> ciclosLectivos;
	private ArrayList<Aula> aulas;
	private ArrayList<Curso> cursos;

	public Universidad(String nombreUniversidad) {
		this.nombre = nombreUniversidad;
		this.alumnosInscriptos = new ArrayList<>();
		this.materias = new ArrayList<>();
		this.profesores = new ArrayList<>();
		this.ciclosLectivos = new ArrayList<>();
		this.aulas = new ArrayList<>();
		this.cursos = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Alumno> getAlumnosInscriptos() {
		return alumnosInscriptos;
	}

	public void setAlumnosInscriptos(ArrayList<Alumno> alumnosInscriptos) {
		this.alumnosInscriptos = alumnosInscriptos;
	}

	public ArrayList<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(ArrayList<Materia> materias) {
		this.materias = materias;
	}

	public ArrayList<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(ArrayList<Profesor> profesores) {
		this.profesores = profesores;
	}

	public ArrayList<CicloLectivo> getCiclosLectivos() {
		return ciclosLectivos;
	}

	public void setCiclosLectivos(ArrayList<CicloLectivo> ciclosLectivos) {
		this.ciclosLectivos = ciclosLectivos;
	}

	public ArrayList<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(ArrayList<Aula> aulas) {
		this.aulas = aulas;
	}

	public ArrayList<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
	}

	public Boolean registrar(Alumno nuevoAlumno) {
		if (buscarAlumnoPorDni(nuevoAlumno.getDni()) == null)

			return this.alumnosInscriptos.add(nuevoAlumno);

		return false;

	}

	private Object buscarAlumnoPorDni(Integer dni) {
		for (int i = 0; i < alumnosInscriptos.size(); i++) {
			if (this.alumnosInscriptos.get(i).getDni().equals(dni))
				return this.alumnosInscriptos.get(i);
		}

		return null;
	}

	public boolean registraMateria(Materia materia) {
		for (Materia existeMateria : materias) {
			if (existeMateria.getNombre().equals(materia.getNombre())) {
				return false; // La materia con el mismo nombre ya existe
			}
		}
		materias.add(materia);
		return true; // La materia se registró con éxito
	}

	private Materia buscarMateriaPorNombre(String nombre) {
		for (int i = 0; i < this.materias.size(); i++) {
			if (this.materias.get(i).getNombre().equals(nombre)) {
				return this.materias.get(i);
			}
		}
		return null;
	}

	public Boolean agregarDocente(Profesor profesor) {
		for (Profesor i : profesores)
			if (i.getDni().equals(profesor.getDni()))
				return false;

		return this.profesores.add(profesor);

	}

	public Boolean agregarCicloLectivo(CicloLectivo nuevoCiclo) {
		for (CicloLectivo i : ciclosLectivos) {
			if (i.getFechaInicio().isBefore(nuevoCiclo.getFechaInicio())
					&& i.getFechaFinalizacion().isAfter(nuevoCiclo.getFechaInicio())
					|| i.getFechaInicio().isBefore(nuevoCiclo.getFechaFinalizacion())
							&& i.getFechaFinalizacion().isAfter(nuevoCiclo.getFechaFinalizacion())) {
				return false;
			}
		}
		return this.ciclosLectivos.add(nuevoCiclo);

	}

	public boolean agregarCorrelativaAMateria(Integer idMateria, Integer idCorrelativa) {
		Materia materiaBuscada = buscarMateriaPorId(idMateria);
		Materia correlativaBuscada = buscarMateriaPorId(idCorrelativa);
		if (materiaBuscada == null || correlativaBuscada == null || idMateria == idCorrelativa
				|| materiaBuscada.getCorrelativas().contains(correlativaBuscada)) {
			return false;
		}
		return materiaBuscada.getCorrelativas().add(correlativaBuscada);
	}

	private Materia buscarMateriaPorId(Integer idMateria) {
		for (Materia i : materias) {
			if (i.getId().equals(idMateria))
				return i;
		}

		return null;
	}

	public Boolean eliminarCorrelativaDeMateria(Integer idMateria, Integer idCorrelativa) {
		Materia MateriaBuscada = this.buscarMateriaPorId(idMateria);
		for (Materia i : MateriaBuscada.getCorrelativas()) {
			if (i.getId().equals(idCorrelativa)) {
				MateriaBuscada.getCorrelativas().remove(i);
				return true;
			}
		}
		return false;
	}

	public void agregarAula(Aula aula) {
		this.aulas.add(aula);
	}

//	public void agregarCurso(Integer idMateria, Horario horario, Integer idCicloLectivo, Integer nroAula) {
//		Materia materia = this.buscarMateriaPorId(idMateria);
//		String dia = horario.getDias(), turno = horario.getTurno();
//		CicloLectivo cicloLectivo = buscarCicloLectivoPorId(idCicloLectivo);
//		Aula aula = buscarAulaPorNro(nroAula);
//		ArrayList<ListaDias> dias = new ArrayList<>();
//		ArrayList<ListaTurnos> turnos = new ArrayList<>();
//		if(materia==null || !dias.contains(dia) || !turnos.contains(turno) || cicloLectivo==null || aula==null) {
//			
//		}
//	}
	public Boolean agregarCurso(Curso curso) {
		Materia materia = this.buscarMateriaPorId(curso.getMateria().getId());
		String dia = curso.getDia();
		String turno = curso.getTurno();
		CicloLectivo cicloLectivo = this.buscarCicloLectivoPorId(curso.getCicloLectivo().getId());
		Aula aula = this.buscarAulaPorNro(curso.getAula().getNro());

		Boolean existe = buscarSiExisteCurso(curso);
		Boolean sePudoAgregar = false;

		if (materia != null && dia != null && turno != null && cicloLectivo != null && aula != null && existe != true) {
			cursos.add(curso);
			sePudoAgregar = true;
		}
		return sePudoAgregar;
	}

	private Boolean buscarSiExisteCurso(Curso curso) {

		if (cursos.contains(curso)) {
			return true;

		}
		return false;
	}

//		if(materia==null || dias.contains(dia))
//			que los dias sean los de la lista, que los turnos sean los de la lista, q todos los id tengan obeto
//	}

	private Aula buscarAulaPorNro(Integer nroAula) {
		for (Aula i : aulas)
			if (i.getNro().equals(nroAula))
				return i;
		return null;
	}

	private CicloLectivo buscarCicloLectivoPorId(Integer idCicloLectivo) {
		for (CicloLectivo i : ciclosLectivos)
			if (i.getId().equals(idCicloLectivo))
				return i;
		return null;
	}

}
