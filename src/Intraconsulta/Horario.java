package Intraconsulta;

public class Horario {
	

	private ListaTurnos turno;
	private ListaDias dias;

	public Horario(ListaTurnos turno, ListaDias dias) {
		this.turno = turno;
		this.dias = dias;
	}

	public ListaTurnos getTurno() {
		return turno;
	}

	public void setTurno(ListaTurnos turno) {
		this.turno = turno;
	}

	public ListaDias getDias() {
		return dias;
	}

	public void setDias(ListaDias dias) {
		this.dias = dias;
	}

	

}
