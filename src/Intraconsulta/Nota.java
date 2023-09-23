package Intraconsulta;

public class Nota {

	private Integer valor;
	private String examen;
	private Integer Id;
	private static Integer IdSiguiente = 1;

	public Nota(Integer valor, String examen) {
		this.valor = valor;
		this.examen = examen;
		this.Id = this.IdSiguiente;
		this.IdSiguiente++;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public String getExamen() {
		return examen;
	}

	public void setExamen(String examen) {
		this.examen = examen;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

}
