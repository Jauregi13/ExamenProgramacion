package utils;

import java.util.Comparator;

import modelo.Cargo;

public class CargoComparator implements Comparator<Cargo>{

	public int compare(Cargo cargo1, Cargo cargo2) {
		
		return cargo1.getNombre().compareTo(cargo2.getNombre());
	}

}
