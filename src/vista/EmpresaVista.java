package vista;

import java.util.Scanner;

public class EmpresaVista extends Vista {

	public static final int MENU_EMPLEADOS = 1;
	public static final int MENU_DEPARTAMENTOS = 2;
	public static final int MENU_CARGOS = 3;

	public void menu() {
		int opcion;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println();
			System.out.println("*********************************");
			System.out.println("* GESTOR DE PERSONAL DE EMPRESA *");
			System.out.println("*********************************");
			System.out.println(MENU_EMPLEADOS + " - gestor de empleado");
			System.out.println(MENU_DEPARTAMENTOS + " - gestor de departamentos");
			System.out.println(MENU_CARGOS + " - gestor de cargos");
			System.out.println(SALIR + " - salir");

			opcion = Integer.parseInt(scan.nextLine());
			switch (opcion) {
			case MENU_EMPLEADOS:
				EmpleadoVista empleadoVista = new EmpleadoVista();
				empleadoVista.menu();
				break;
			case MENU_DEPARTAMENTOS:
				DepartamentoVista departamentoVista = new DepartamentoVista();
				departamentoVista.menu();
				break;

			case MENU_CARGOS:
				CargoVista cargoVista = new CargoVista();
				cargoVista.menu();
				break;

			default:
				break;
			}
		} while (opcion != SALIR);
	}

}
