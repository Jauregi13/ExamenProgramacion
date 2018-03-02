package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CargoModelo extends Conector{
	
	/**
	 * Este metodo recoge la informacion que tiene la tabla cargos de la base de datos y lo introduce en el arrayList cargos
	 * @return
	 */
	
	public ArrayList<Cargo> selectAll(){
		
		ArrayList<Cargo> cargos = new ArrayList();
		try {
			Statement st = super.conexion.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM cargos");
			
			while(rs.next()){
				Cargo cargo = new Cargo();
				cargo.setId(rs.getInt("id"));
				cargo.setNombre(rs.getString("nombre"));
				cargo.setSueldo(rs.getDouble("sueldo"));
				
				cargos.add(cargo);
			}
			
			return cargos;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	/**
	 * Este metodo actualiza el sueldo del cargo que se introduce como parametro
	 * @param cargo
	 */
	public void updateCargo(Cargo cargo){
		
		try {
			PreparedStatement pst = super.conexion.prepareStatement("UPDATE cargos SET sueldo = ? WHERE id = ?");
			
			pst.setDouble(1, cargo.getSueldo());
			pst.setInt(2, cargo.getId());
			
			int resultado = pst.executeUpdate();
			
			if(resultado == 1){
				System.out.println("Se ha actualizado correctamente");
			}
			else{
				System.out.println("Ha habido algun error al actualizar");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Este metodo recibe como parametro el id de un cargo y devolvera toda la informacion de ese cargo como objeto Cargo
	 * @param id_cargo
	 * @return
	 */
	public Cargo selectPorId(int id_cargo) {
		
		try {
			PreparedStatement pst = super.conexion.prepareStatement("SELECT * FROM cargos WHERE id = ?");
			
			pst.setInt(1, id_cargo);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				Cargo cargo = new Cargo();
				cargo.setId(rs.getInt("id"));
				cargo.setNombre(rs.getString("nombre"));
				cargo.setSueldo(rs.getDouble("sueldo"));
				
				return cargo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	/**
	 * Este metodo recoge la informacion de la tabla cargos que recoge como parametro un nombre de cargo y devolvera toda la informacion de ese cargo
	 * @param nombre_cargo
	 * @return cargo
	 */
	public Cargo selectPorNombre(String nombre_cargo) {
		
		try {
			PreparedStatement pst = super.conexion.prepareStatement("SELECT * FROM cargos WHERE nombre = ?");
			
			pst.setString(1, nombre_cargo);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				Cargo cargo = new Cargo();
				cargo.setId(rs.getInt("id"));
				cargo.setNombre(rs.getString("nombre"));
				cargo.setSueldo(rs.getDouble("sueldo"));
				
				return cargo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
