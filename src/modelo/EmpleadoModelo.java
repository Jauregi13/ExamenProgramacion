package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmpleadoModelo extends Conector {

	/**
	 * Metodo que elimina un empleado y que se pasa como parametro el empleado teniendo como propiedad el dni que sera introducido por teclado
	 * @param empleado
	 */
	public void deleteEmpleado(Empleado empleado) {

		try {
			PreparedStatement pst = super.conexion.prepareStatement("DELETE FROM empleados WHERE dni = ?");

			pst.setString(1, empleado.getDni());

			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Este metodo recoge la informacion de la tabla empleados que esta en la base de datos y lo mete en un arrayList empleados
	 * que es lo que se devolverá
	 * @return ArrayList<Empleado>
	 */
	public ArrayList<Empleado> selectAll() {

		CargoModelo cargoModelo = new CargoModelo();
		DepartamentoModelo departamentoModelo = new DepartamentoModelo();
		ArrayList<Empleado> empleados = new ArrayList();
		try {
			Statement st = super.conexion.createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM empleados");

			while (rs.next()) {
				Empleado empleado = new Empleado();
				empleado.setId(rs.getInt("id"));
				empleado.setDni(rs.getString("dni"));
				empleado.setNombre(rs.getString("nombre"));
				empleado.setCargo(cargoModelo.selectPorId(rs.getInt("id_cargo")));
				empleado.setDepartamento(departamentoModelo.selectPorId(rs.getInt("id_departamento")));

				empleados.add(empleado);
			}
			return empleados;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Metodo que muestra los empleados que pertenecen al departamento  que se pasa como parametro id_departamento
	 * y devuelve un arrayList empleados con la informacion de cada empleado incluyendo el cargo
	 * @param id_departamento
	 * @return
	 */
	public ArrayList<Empleado> selectPorIdDepartamento(int id_departamento) {

		ArrayList<Empleado> empleados = new ArrayList();
		CargoModelo cargoModelo = new CargoModelo();
		try {
			PreparedStatement pst = super.conexion
					.prepareStatement("SELECT * FROM empleados WHERE id_departamento = ?");

			pst.setInt(1, id_departamento);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Empleado empleado = new Empleado();
				empleado.setId(rs.getInt("id"));
				empleado.setDni(rs.getString("dni"));
				empleado.setNombre(rs.getString("nombre"));
				empleado.setCargo(cargoModelo.selectPorId(rs.getInt("id_cargo")));

				empleados.add(empleado);
			}
			return empleados;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
