package ru.fedinskiy.bridge;

/**
 * Created by fedinskiy on 08.03.17.
 */
public class Surgery implements Hospital{
	@Override
	public void heal() {
		System.out.println("Cut something");
	}
}
