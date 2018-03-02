package vista;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import modelo.Empleado;
import modelo.EmpleadoModelo;


public class EmpleadoVista extends Vista {

	public static final int ELIMINAR_EMPLEADO = 1;
	public static final int LISTAR_EMPLEADOS = 2;

	@Override
	public void menu() {
		
		EmpleadoModelo empleadoModelo = new EmpleadoModelo();
		int opcion;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println();
			System.out.println("- MENU DE GESTION DE EMPLEADOS -");
			System.out.println("--------------------------------");
			System.out.println(ELIMINAR_EMPLEADO + " - eliminar empleado");
			System.out.println(LISTAR_EMPLEADOS + " - listar empledos con departamento y cargo");
			System.out.println(SALIR + " - salir");

			opcion = Integer.parseInt(scan.nextLine());

			switch (opcion) {
			case ELIMINAR_EMPLEADO:
				//TODO pedir un dni y eliminar el empleado con ese dni
				
				System.out.println("Introduce el dni que quieres eliminar:");
				String dni = scan.nextLine();
				
				//Creamos el objeto empleado para luego pasar como parametro al metodo deleteEmpleado
				
				Empleado empleado = new Empleado();
				empleado.setDni(dni);
				
				//con esta llamada al metodo deleteEmpleado eliminaremos el empleado que tiene como dni el introducido por teclado que sera el objeto empleado
				empleadoModelo.deleteEmpleado(empleado);
				
				break;

			case LISTAR_EMPLEADOS:
				//TODO listar todos los empleados con nombre de departamento y nobre de cargo
				ArrayList<Empleado> empleados = new ArrayList();
				
				// llamando a este metodo recogeremos toda la informacion de la tabla empleados, departamentos y cargos y lo meteremos en el
				// arrayList empleados
				empleados = empleadoModelo.selectAll();
				
				// con este metodo mostraremos el contenido de ese arrayList que sera la informacion de la tabla empleados mas el nombre de cargo
				// y el nombre de departamento en este caso
				mostrarEmpleados(empleados);
				break;

			default:
				break;
			}
		} while (opcion != SALIR);

	}
	
	/**
	 * 
	 * @param empleados
	 */

	private void mostrarEmpleados(ArrayList<Empleado> empleados) {
		
		Iterator<Empleado> i = empleados.iterator();
		
		System.out.println("dni  :  nombre  :  nombre de cargo  :  nombre de departamento");
		
		while(i.hasNext()){
			Empleado empleado = i.next();
			
			System.out.println(empleado.getDni() + "  :  " + empleado.getNombre() + "  :  " + empleado.getCargo().getNombre() + "  :  " + 
			empleado.getDepartamento().getNombre());
		}
		
	}

}
