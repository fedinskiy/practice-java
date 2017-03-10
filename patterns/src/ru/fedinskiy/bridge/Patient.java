package ru.fedinskiy.bridge;

/**
 * Created by fedinskiy on 08.03.17.
 */
public abstract class Patient {
	protected Hospital hospital;
	
	protected Patient(Hospital hospital) {
		this.hospital = hospital;
	}
	
	public abstract void heal();
}
