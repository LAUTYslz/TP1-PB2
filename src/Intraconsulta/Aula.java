package Intraconsulta;

public class Aula {
	private Integer Nro;
	private Integer cantidadDeLugares;
	private static Integer NroSiguiente =1; 

	public Aula(Integer cantidadLugares) {
		this.cantidadDeLugares=cantidadLugares;
		this.Nro=this.NroSiguiente;
		this.NroSiguiente++;
	}

	public Integer getNro() {
		return Nro;
	}

	public void setNro(Integer nro) {
		Nro = nro;
	}

	public Integer getCantidadDeLugares() {
		return cantidadDeLugares;
	}

	public void setCantidadDeLugares(Integer cantidadDeLugares) {
		this.cantidadDeLugares = cantidadDeLugares;
	}

}
