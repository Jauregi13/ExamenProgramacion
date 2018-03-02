package vista;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import modelo.Cargo;
import modelo.CargoModelo;
import utils.CargoComparator;

public class CargoVista extends Vista {

	public static final int CAMBIAR_SUELDO = 1;
	public static final int LISTAR_CARGOS = 2;

	public void menu() {
		
		CargoModelo cargoModelo = new CargoModelo();
		

		int opcion;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println();
			System.out.println("- MENU DE GESTION DE CARGOS -");
			System.out.println("-----------------------------");
			System.out.println(CAMBIAR_SUELDO + " - cambiar sueldo a cargo");
			System.out.println(LISTAR_CARGOS + " - listar cargos");
			System.out.println(SALIR + " - salir");

			opcion = Integer.parseInt(scan.nextLine());
			switch (opcion) {
			case CAMBIAR_SUELDO:
				// TODO cambiar sueldo del cargo
				
				System.out.println("Introduce el nombre del cargo que quieres actualizar:");			
				String nombre = scan.nextLine();
				
				System.out.println("Introduce el nuevo sueldo del cargo introducido:");
				Double sueldo_nuevo = Double.parseDouble(scan.nextLine());
				
				
				
				//creamos el objeto cargo con los datos introducidos por teclado para pasarle de parametro al metodo de UpdateCargo
				Cargo cargo = cargoModelo.selectPorNombre(nombre);
				cargo.setNombre(nombre);
				cargo.setSueldo(sueldo_nuevo);
				
				//llamamos al metodo updateCargo para actualizar el cargo
				cargoModelo.updateCargo(cargo);
				break;
			case LISTAR_CARGOS:
				// TODO listar cargos en orden alfabetico
				ArrayList<Cargo> cargos = cargoModelo.selectAll();
				
				//creamos el objeto comparador que sera de la clase CargoComparator para utilizar el sort
				CargoComparator comparador = new CargoComparator();
				
				cargos.sort(comparador);
				
				mostrarCargos(cargos);
				break;
			default:
				break;
			}
		} while (opcion != SALIR);
	}
	
	/**
	 * Este metodo muestra el listado de los cargos ordenados alfabeticamente
	 * @param cargos
	 */

	private void mostrarCargos(ArrayList<Cargo> cargos) {
		
		Iterator<Cargo> i = cargos.iterator();
		
		System.out.println("Nombre  :  Sueldo");
		while(i.hasNext()){
			Cargo cargo = i.next();
			
			System.out.println(cargo.getNombre() + "  :  " + cargo.getSueldo());
		}
		
	}

}
