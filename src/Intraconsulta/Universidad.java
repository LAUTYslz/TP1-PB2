package Intraconsulta;

import java.time.LocalDate;
import java.util.ArrayList;

public class Universidad {

	private String nombre;
	private ArrayList<Alumno> alumnosInscriptos;
	private ArrayList<Profesor> profesoresInscriptos;
	private ArrayList<Materia> materias;
	private ArrayList<CicloLectivo> ciclosLectivos;
	private ArrayList<Aula> aulas;
	private ArrayList<Curso> cursos;
	private ArrayList<AsignacionAlumnoCurso> asignacionesCursosAlumno;
	private ArrayList<AsignacionProfesorCurso> asignacionesCursosProfe;

	public Universidad(String nombreUniversidad) {
		this.nombre = nombreUniversidad;
		this.alumnosInscriptos = new ArrayList<>();
		this.materias = new ArrayList<>();
		this.ciclosLectivos = new ArrayList<>();
		this.aulas = new ArrayList<>();
		this.cursos = new ArrayList<>();
		this.asignacionesCursosAlumno = new ArrayList<>();
		this.profesoresInscriptos = new ArrayList<>();
		this.asignacionesCursosProfe = new ArrayList<>();
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

	public ArrayList<Profesor> getProfesoresInscriptos() {
		return profesoresInscriptos;
	}

	public void setProfesoresInscriptos(ArrayList<Profesor> profesores) {
		this.profesoresInscriptos = profesores;
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

	public ArrayList<AsignacionAlumnoCurso> getAsignacionesCursos() {
		return asignacionesCursosAlumno;
	}

	public void setAsignacionesCursos(ArrayList<AsignacionAlumnoCurso> asignacionesCursos) {
		this.asignacionesCursosAlumno = asignacionesCursos;
	}

	public Boolean registrarAlumno(Alumno nuevoAlumno) {
		if (nuevoAlumno == null) {
			return false;
		}
		if (buscarAlumnoPorDni(nuevoAlumno.getDni()) == null) {
			nuevoAlumno.setFechaDeIngreso(LocalDate.now());
			return this.alumnosInscriptos.add(nuevoAlumno);
		}
		return false;

	}

	private Alumno buscarAlumnoPorDni(Integer dni) {
		for (int i = 0; i < alumnosInscriptos.size(); i++) {
			if (this.alumnosInscriptos.get(i).getDni().equals(dni))
				return this.alumnosInscriptos.get(i);
		}

		return null;
	}

	public boolean registraMateria(Materia materia) {
		if (materia == null) {
			return false;
		}

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

	public Boolean agregarProfesor(Profesor profesor) {
		if (profesor == null) {
			return false;
		}
		for (Profesor i : profesoresInscriptos)
			if (i.getDni().equals(profesor.getDni()))
				return false;

		return this.profesoresInscriptos.add(profesor);

	}

	public Boolean agregarCicloLectivo(CicloLectivo nuevoCiclo) {
		if (nuevoCiclo == null) {
			return false;
		}
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

	public Boolean agregarAula(Aula aula) {
		if (aula == null) {
			return false;
		}
		return this.aulas.add(aula);
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

	public Boolean inscribirAlumnoACurso(Integer idCurso, Integer dni) {
		Alumno alumno = this.buscarAlumnoPorDni(dni);
		Curso curso = this.buscarCursoPorId(idCurso);
//		Hay que hacer un if es nulo (el curso no pertenece a la universidad)

		if (curso == null || alumno == null) {
			return false;
//			que alumno y curso este de alta
		}
		Boolean tieneCorrelativas = this.materiaTieneCorrelativas(curso.getMateria());
		if (tieneCorrelativas) {
			Boolean aproboCorrelativas = this.tieneCorrelativasAprobadas(alumno, curso.getMateria());
			if (!aproboCorrelativas)
				return false;
		}
		if (LocalDate.now().isBefore(curso.getCicloLectivo().getFechaInicioInscripcion())
				|| LocalDate.now().isAfter(curso.getCicloLectivo().getFechaFinalizacionInscripcion())) {
			return false;
//			que este dentro de la fecha de inscripcion
		}
		Integer cantidadDeAlumnosInscriptos = curso.getAlumnosInscriptos();
		if (cantidadDeAlumnosInscriptos >= curso.getAula().getCantidadDeLugares()) {
			return false;
//			que haya lugar
		}
		ArrayList<Curso> cursosDelAlumno = this.buscarCursosDelAlumnoPorDni(dni);
		if (cursosDelAlumno != null) {
			for (Curso i : cursosDelAlumno) {
				String dia = i.getDia();
				String turno = i.getTurno();
				LocalDate inicioCurso = i.getCicloLectivo().getFechaInicio();
				LocalDate finCurso = i.getCicloLectivo().getFechaFinalizacion();

				if (dia.equals(curso.getDia()) && turno.equals(curso.getTurno())
						&& inicioCurso.equals(curso.getCicloLectivo().getFechaInicio())
						&& finCurso.equals(curso.getCicloLectivo().getFechaFinalizacion())) {
					return false;
				}
			}
		}
//		que no este cursando el mismo dia y mismo ciclo
		Materia materia = curso.getMateria();
		Boolean yaLaAprobo = this.yaAproboEstaMateria(materia, dni);
		if (yaLaAprobo) {
			return false;
		}
//		que no la haya aprobado
		AsignacionAlumnoCurso nuevaAsignacion = new AsignacionAlumnoCurso(alumno, curso);
		curso.sumarAlumnosInscriptos();
		return asignacionesCursosAlumno.add(nuevaAsignacion);

	}

	private Boolean yaAproboEstaMateria(Materia materia, Integer dni) {
		ArrayList<Materia> materiasAprobadas = this.materiasAprobadasDelAlumno(dni);
		if (materiasAprobadas.contains(materia))
			return true;
		return false;
	}

	private Boolean tieneCorrelativasAprobadas(Alumno alumno, Materia materia) {
		ArrayList<Curso> cursosDelAlumno = this.buscarCursosDelAlumnoPorDni(alumno.getDni());
		ArrayList<Materia> correlativas = materia.getCorrelativas();
		ArrayList<Materia> correlativasAprobadas = new ArrayList<>();
		for (Materia f : correlativas) {
			for (Curso i : cursosDelAlumno)
				if (i.getMateria().equals(f)) {
					Boolean estaAprobada = this.estaAprobada(i, alumno);
					if (estaAprobada)
						correlativasAprobadas.add(f);
				}
		}
		if (correlativasAprobadas.equals(correlativas)) {
			return true;
		}
		return false;
	}

	private Boolean estaAprobada(Curso curso, Alumno alumno) {
		AsignacionAlumnoCurso asignacion = this.buscarAsignacionConCursoYAlumno(curso.getId(), alumno.getDni());
		ArrayList<Nota> notas = asignacion.getNotas();
		Boolean parcial1 = false;
		Boolean parcial2 = false;
		Boolean recParcial1 = false;
		Boolean recParcial2 = false;
		for (Nota i : notas) {
			if (i.getExamen().equals(ListaExamenes.PRIMER_PARCIAL) && i.getValor() >= 4) {
				parcial1 = true;
			}
			if (i.getExamen().equals(ListaExamenes.SEGUNDO_PARCIAL) && i.getValor() >= 4) {
				parcial2 = true;
			}
			if (i.getExamen().equals(ListaExamenes.REC_PRIMER_PARCIAL) && i.getValor() >= 4) {
				recParcial1 = true;
			}
			if (i.getExamen().equals(ListaExamenes.REC_SEGUNDO_PARCIAL) && i.getValor() >= 4) {
				recParcial2 = true;
			}
		}
		if ((parcial1 && parcial2) || (parcial1 && recParcial2) || (recParcial1 && parcial2)) {
			this.calcularPromedioDelAlumnoEnCursada(alumno.getDni(), curso.getId());
			return true;
		}
		return false;
	}

	private Boolean materiaTieneCorrelativas(Materia materia) {
		Boolean tieneCorrelativas = false;
		if (!materia.getCorrelativas().isEmpty())
			tieneCorrelativas = true;
		return tieneCorrelativas;
	}

	private ArrayList<Curso> buscarCursosDelAlumnoPorDni(Integer dni) {
		ArrayList<Curso> cursosAlumno = new ArrayList<>();
		for (AsignacionAlumnoCurso i : asignacionesCursosAlumno)
			if (i != null && i.getAlumno().getDni().equals(dni))
				cursosAlumno.add(i.getCurso());
		return cursosAlumno;
	}

	private Curso buscarCursoPorId(Integer idCurso) {
		for (Curso i : cursos)
			if (i.getId().equals(idCurso))
				return i;
		return null;

	}

	public Boolean registrarNota(Integer idCurso, Integer dniAlumno, Nota notaAAsignar) {
		AsignacionAlumnoCurso asignacion = this.buscarAsignacionConCursoYAlumno(idCurso, dniAlumno);
		Boolean tieneValorValido = this.NotaTieneValorValido(notaAAsignar);
		Boolean yaExisteNotaParaEseParcial = this.notaYaAsignadaAEsteParcial(asignacion, notaAAsignar);
		Boolean yaHayOtroRecuperatorioCargado = this.hayNotaCargadaEnOtroRecuperatorio(asignacion, notaAAsignar);
		if (!tieneValorValido) {
			return false;
		}
		if (yaExisteNotaParaEseParcial) {
			return false;
		}
		if (yaHayOtroRecuperatorioCargado) {
			return false;
		}
		asignacion.agregarNota(notaAAsignar);
		return true;
	}

	private Boolean hayNotaCargadaEnOtroRecuperatorio(AsignacionAlumnoCurso asignacion, Nota notaAAsignar) {
		ListaExamenes examen = notaAAsignar.getExamen();
		ArrayList<Nota> notasCargadas = asignacion.getNotas();
		if (examen.equals(ListaExamenes.REC_PRIMER_PARCIAL) || examen.equals(ListaExamenes.REC_SEGUNDO_PARCIAL)) {
			for (Nota i : notasCargadas) {
				if (i.getExamen().equals(ListaExamenes.REC_PRIMER_PARCIAL)
						|| i.getExamen().equals(ListaExamenes.REC_SEGUNDO_PARCIAL)) {
					return true;
				}
			}
		}

		return false;
	}

	private Boolean notaYaAsignadaAEsteParcial(AsignacionAlumnoCurso asignacion, Nota notaAAsignar) {
		ListaExamenes examen = notaAAsignar.getExamen();
		ArrayList<Nota> notasCargadas = asignacion.getNotas();
		for (Nota i : notasCargadas) {
			if (i.getExamen().equals(examen)) {
				return true;
			}
		}

		return false;
	}

	private Boolean NotaTieneValorValido(Nota nota) {
		if (nota != null)
			if (nota.getValor() >= 1 && nota.getValor() <= 10)
				return true;
		return false;
	}

	public AsignacionAlumnoCurso buscarAsignacionConCursoYAlumno(Integer cursoId, Integer alumnoDni) {
		Curso curso = this.buscarCursoPorId(cursoId);
		Alumno alumno = this.buscarAlumnoPorDni(alumnoDni);
		if (curso != null && alumno != null)
			for (AsignacionAlumnoCurso i : asignacionesCursosAlumno)
				if (i.getCurso().equals(curso) && i.getAlumno().equals(alumno))
					return i;
		return null;
	}

	public ArrayList<Materia> materiasAprobadasDelAlumno(Integer dni) {
		Alumno alumno = this.buscarAlumnoPorDni(dni);
		ArrayList<Curso> cursosDelAlumno = this.buscarCursosDelAlumnoPorDni(alumno.getDni());
		ArrayList<Materia> materias = this.getMaterias();
		ArrayList<Materia> materiasAprobadas = new ArrayList<>();
		for (Materia f : materias) {
			for (Curso i : cursosDelAlumno)
				if (i.getMateria().equals(f)) {
					Boolean estaAprobada = this.estaAprobada(i, alumno);
					if (estaAprobada)
						materiasAprobadas.add(f);
				}
		}
		return materiasAprobadas;
	}

	public ArrayList<Materia> materiasQueLeFaltaAprobarAlAlumno(Integer dni) {
		ArrayList<Materia> materias = this.getMaterias();
		ArrayList<Materia> materiasAprobadas = this.materiasAprobadasDelAlumno(dni);
		ArrayList<Materia> materiasQueLeFaltaAprobar = new ArrayList<>();
		if (materiasAprobadas.size() == 0) {
			return materias;
		}
		for (Materia i : materias) {
			for (Materia f : materiasAprobadas) {
				if (!i.equals(f)) {
					materiasQueLeFaltaAprobar.add(i);
				}
			}
		}
		return materiasQueLeFaltaAprobar;
	}

	public boolean inscribirProfesorACurso(Integer id, Integer dni) {
		Profesor profe = this.buscarProfesorPorDni(dni);
		Curso curso = this.buscarCursoPorId(id);
// que no sea nulo
		if (curso == null || profe == null) {
			return false;
		}
// que se cumpla 1 profe cada 20 alumnos
		Integer cantidadDeProfesoresNecesarios = curso.profesoresNecesarios();
		Integer cantidadDeProfesoresEnCurso = curso.getProfesoresInscriptos();
		if (cantidadDeProfesoresEnCurso == cantidadDeProfesoresNecesarios) {
			return false;
		}

// que no pueda anotarse a otro curso el mismo dia, horario y ciclolectivo
		ArrayList<Curso> cursosDelProfesor = this.buscarCursosDelProfesorPorDni(dni);
		if (cursosDelProfesor != null) {
			for (Curso i : cursosDelProfesor) {
				String dia = i.getDia();
				String turno = i.getTurno();
				LocalDate inicioCurso = i.getCicloLectivo().getFechaInicio();
				LocalDate finCurso = i.getCicloLectivo().getFechaFinalizacion();
//			que no este cursando el mismo dia y mismo ciclo
				if (dia.equals(curso.getDia()) && turno.equals(curso.getTurno())
						&& inicioCurso.equals(curso.getCicloLectivo().getFechaInicio())
						&& finCurso.equals(curso.getCicloLectivo().getFechaFinalizacion())) {
					return false;
				}
			}
		}
		AsignacionProfesorCurso nuevaAsignacion = new AsignacionProfesorCurso(profe, curso);
		curso.sumarProfesoresInscriptos();
		return asignacionesCursosProfe.add(nuevaAsignacion);
	}

	private ArrayList<Curso> buscarCursosDelProfesorPorDni(Integer dni) {
		ArrayList<Curso> cursosProf = new ArrayList<>();
		for (AsignacionProfesorCurso i : asignacionesCursosProfe)
			if (i != null && i.getProfesor().getDni().equals(dni))
				cursosProf.add(i.getCurso());
		return cursosProf;
	}

	private Profesor buscarProfesorPorDni(Integer dni) {
		for (int i = 0; i < profesoresInscriptos.size(); i++) {
			if (this.profesoresInscriptos.get(i).getDni().equals(dni))
				return this.profesoresInscriptos.get(i);
		}

		return null;
	}

	public void calcularPromedioDelAlumnoEnCursada(Integer dni, Integer idCurso) {
		AsignacionAlumnoCurso asignacion = this.buscarAsignacionConCursoYAlumno(idCurso, dni);
		ArrayList<Nota> notas = asignacion.getNotas();
		Integer Promedio = 0;
		Double sumaDeNotas = 0.0;
		Integer notaPrimerParcial = 0;
		Integer notaSegundoParcial = 0;
		Integer notaRecPrimerParcial = 0;
		Integer notaRecSegundoParcial = 0;

		if (notas.size() == 2) {
			for (Nota i : notas) {
				sumaDeNotas += i.getValor();
			}
			Promedio = (int) Math.round(sumaDeNotas / 2);
		}

		if (notas.size() == 3) {
			for (Nota i : notas) {
				if (i.getExamen().equals(ListaExamenes.PRIMER_PARCIAL))
					notaPrimerParcial = i.getValor();
				if (i.getExamen().equals(ListaExamenes.SEGUNDO_PARCIAL))
					notaSegundoParcial = i.getValor();
				if (i.getExamen().equals(ListaExamenes.REC_PRIMER_PARCIAL))
					notaRecPrimerParcial = i.getValor();
				if (i.getExamen().equals(ListaExamenes.REC_SEGUNDO_PARCIAL))
					notaRecSegundoParcial = i.getValor();
			}

			if (notaRecPrimerParcial == 0) {
				sumaDeNotas = (double) (notaPrimerParcial + notaRecSegundoParcial);
			} else if (notaRecSegundoParcial == 0) {
				sumaDeNotas = (double) (notaSegundoParcial + notaRecPrimerParcial);
			}
			Promedio = (int) Math.round(sumaDeNotas / 2);
		}
		if (notas.size() == 1) {
			Promedio = 1;
		}

		asignacion.setPromedioFinal(Promedio);

	}

	public ArrayList<Integer> buscarLaNotaFinalDelAlumno(Integer idMateria, Integer dni) {
		ArrayList<Curso> cursosDelAlumno = this.buscarCursosDelAlumnoPorDni(dni);
		ArrayList<Integer> notaFinalDelCurso = new ArrayList<>();
		for (Curso i : cursosDelAlumno) {
			if (i.getMateria().getId().equals(idMateria)) {
				AsignacionAlumnoCurso asignacion = this.buscarAsignacionConCursoYAlumno(i.getId(), dni);
				notaFinalDelCurso.add(asignacion.getPromedioFinal());
			}
		}

		return notaFinalDelCurso;
	}

	private AsignacionAlumnoCurso buscarAsignacionPorId(Integer id) {
		for (AsignacionAlumnoCurso i : asignacionesCursosAlumno) {
			if (i.getId().equals(id)) {
				return i;
			}
		}
		return null;
	}

	public ArrayList<AsignacionAlumnoCurso> ObtenerReporteDeNotasDeAlumnosDeCurso(Integer idCurso) {
		ArrayList<AsignacionAlumnoCurso> asignaciones = this.getAsignacionesCursos();
		ArrayList<AsignacionAlumnoCurso> asignacionesDelCursoBuscado = new ArrayList<>();
		Curso curso = this.buscarCursoPorId(idCurso);
		if (curso != null) {
			for (AsignacionAlumnoCurso i : asignaciones) {
				if (i.getCurso().getId().equals(idCurso)) {
					asignacionesDelCursoBuscado.add(i);
				}
			}
		}
		return asignacionesDelCursoBuscado;
	}

	public ArrayList<AsignacionAlumnoCurso> ObtenerListadoMateriasAprobadasParaUnAlumno(Integer dni) {
		Alumno alumno = this.buscarAlumnoPorDni(dni);
		ArrayList<AsignacionAlumnoCurso> asignaciones = this.getAsignacionesCursos();
		ArrayList<Materia> materiasAprobadasDelAlumno = this.materiasAprobadasDelAlumno(dni);
		ArrayList<AsignacionAlumnoCurso> asignacionesDelAlumnoConMateriaAprobada = new ArrayList<>();
		for (AsignacionAlumnoCurso i : asignaciones) {
			for (Materia f : materiasAprobadasDelAlumno)
				if (i.getCurso().getMateria().equals(f) && this.estaAprobada(i.getCurso(), alumno)
						&& i.getAlumno().getDni().equals(dni))
					asignacionesDelAlumnoConMateriaAprobada.add(i);
		}
		return asignacionesDelAlumnoConMateriaAprobada;
	}

}
