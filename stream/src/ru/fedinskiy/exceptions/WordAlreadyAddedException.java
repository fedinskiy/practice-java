package ru.fedinskiy.exceptions;


/**
 * Created by fedinskiy on 07.02.17.
 */
public class WordAlreadyAddedException extends BasicCallableException {
	
	/**
	 * @param word — слово, которое уже было добавлено
	 */
	public WordAlreadyAddedException(String word) {
		super("Слово '" + word + "' уже было добавлено");
	}
}
