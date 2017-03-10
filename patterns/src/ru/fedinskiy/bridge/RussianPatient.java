package ru.fedinskiy.bridge;

/**
 * Created by fedinskiy on 08.03.17.
 */
public class RussianPatient extends Patient {
	
	public RussianPatient(Hospital hospital) {
		super(hospital);
	}
	
	@Override
	public void heal() {
		hospital.heal();
	}
}
