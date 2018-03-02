package modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Departamento {

	//campos de la BBDD
	private int id;
	private String nombre;
	
	//relaciones
	private ArrayList<Empleado> empleados;

	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	
}
