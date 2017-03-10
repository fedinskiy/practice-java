package ru.fedinskiy.chain;

/**
 * Created by fedinskiy on 09.03.17.
 */
public class BabkiRumors extends Rumors {
	@Override
	void writeRumors(String message) {
		System.out.println("Babki said "+message);
	}
}
