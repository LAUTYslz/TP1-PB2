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
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    Materia materia = (Materia) obj;
	    return nombre.equals(materia.nombre);
	}

	@Override
	public int hashCode() {
	    return Objects.hash(nombre);
	}
	
//	public boolean agregarCorrelativa(Materia materia) {
//		if(this.correlativas.contains(materia)||materia.equals(this)) {
//			return false;
//		}
//		return this.correlativas.add(materia);
//	}

//	public boolean eliminarCorrelativa(String nombre) {
//		for(Materia i: correlativas) {
//			if(i.getNombre().equals(nombre)) {
//				this.correlativas.remove(i);
//				return true;
//			}
//		}
//		return false;
//	}


	



}
