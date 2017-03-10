package ru.fedinskiy.chain;

/**
 * Created by fedinskiy on 09.03.17.
 */
public class TeshaRumors extends Rumors {
	@Override
	void writeRumors(String message) {
		System.out.println("Beast said "+message);
	}
}
