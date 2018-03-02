package vista;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import modelo.Departamento;
import modelo.DepartamentoModelo;
import modelo.Empleado;


public class DepartamentoVista extends Vista {

	public static final int LISTAR_GASTOS_DEPARTAMENTOS = 1;

	public void menu() {
		
		DepartamentoModelo departamentoModelo = new DepartamentoModelo();
		int opcion;
	
		
		Scanner scan = new Scanner(System.in);
		
		do {
			System.out.println();
			System.out.println("- MENU DE GESTION DE DEPARTAMENTOS -");
			System.out.println("------------------------------------");
			System.out.println(LISTAR_GASTOS_DEPARTAMENTOS + " - listar departamentos con sus gastos");
			System.out.println(SALIR + " - salir");

			opcion = Integer.parseInt(scan.nextLine());
			switch (opcion) {
			case LISTAR_GASTOS_DEPARTAMENTOS:
				//TODO listar el nombre de todos los departametos con su gasto en sueldos
				
				// en este arrayList departamentos almacenara la informacion de departamentos con los empleados que pertenecen a cada departamento
				// y esa informacion conseguiremos con el metodo selectConGastos
				ArrayList<Departamento> departamentos = departamentoModelo.selectConGastos();
				
				// con este metodo mostraremos la informacion del departamento y los gastos que tiene cada departamento
				mostrarDepartamentosConGastos(departamentos);
				break;

			default:
				break;
			}
		} while (opcion != SALIR);

	}

	private void mostrarDepartamentosConGastos(ArrayList<Departamento> departamentos) {
		
		Iterator<Departamento> i = departamentos.iterator();
		
		System.out.println("Nombre de departamento  :  Gastos en sueldos");
		// En este primer while recorreremos todos los departamentos que almacena el arrayList
		while(i.hasNext()){
			Departamento departamento = i.next();
			
			ArrayList<Empleado> empleados = departamento.getEmpleados();
			
			Iterator<Empleado> i2 = empleados.iterator();
			double suma_sueldos = 0;
			// con este otro while recorreremos los empleados que pertenecen al departamento que aparece en i.next()
			while(i2.hasNext()){
				Empleado empleado = i2.next();
				
				// con suma_sueldos sumaremos todos los sueldos de los empleados que pertenecen al arrayList empleados que cogeremos desde la tabla
				//cargos 
				suma_sueldos = (double)suma_sueldos + empleado.getCargo().getSueldo();
			}
			
			System.out.println(departamento.getNombre() + "  :  " + suma_sueldos);
			
		}
		
	}

}
