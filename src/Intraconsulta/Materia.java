package Intraconsulta;

import java.util.ArrayList;
import java.util.Objects;

public class Materia {

	private String nombre;
	private Integer Id;
	private static Integer IdSiguiente =1; 
	private ArrayList<Materia> correlativas;

	public Materia(String nombre) {
		this.nombre = nombre;
		this.Id=this.IdSiguiente;
		this.IdSiguiente++;
		this.correlativas=new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	

	public ArrayList<Materia> getCorrelativas() {
		return correlativas;
	}

	public void setCorrelativas(ArrayList<Materia> correlativas) {
		this.correlativas = correlativas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Materia other = (Materia) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Materia [nombre=" + nombre + "]";
	}
	
	
	
	



	



}
