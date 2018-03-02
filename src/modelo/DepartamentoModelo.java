package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DepartamentoModelo extends Conector {

	/**
	 * Este metodo recoge la informacion de un solo departamento que como
	 * parametro se pasa el id del departamento y se devuelve la informacion de
	 * ese departamento
	 * 
	 * @param id_departamento
	 * @return
	 */

	public Departamento selectPorId(int id_departamento) {

		try {
			PreparedStatement pst = super.conexion.prepareStatement("SELECT * FROM departamentos WHERE id = ?");

			pst.setInt(1, id_departamento);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				Departamento departamento = new Departamento();
				departamento.setId(rs.getInt("id"));
				departamento.setNombre(rs.getString("nombre"));

				return departamento;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Este metodo recoge la informacion de la tabla departamentos que devolvera un arrayList de todos los departamentos incluyendo el arrayList
	 * de empleados
	 * @return
	 */
	public ArrayList<Departamento> selectConGastos() {

		ArrayList<Departamento> departamentos = new ArrayList();
		EmpleadoModelo empleadoModelo = new EmpleadoModelo();
		try {
			Statement st = super.conexion.createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM departamentos");

			while (rs.next()) {
				Departamento departamento = new Departamento();
				departamento.setId(rs.getInt("id"));
				departamento.setNombre(rs.getString("nombre"));
				ArrayList<Empleado> empleados = empleadoModelo.selectPorIdDepartamento(rs.getInt("id"));
				departamento.setEmpleados(empleados);

				departamentos.add(departamento);

			}

			return departamentos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
