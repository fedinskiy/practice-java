package ru.fedinskiy.exceptions;

/**
 * Created by fedinskiy on 08.02.17.
 */
public class ResourceTooLargeException extends WrongResourceException {
	
	/**
	 * @param cause
	 */
	public ResourceTooLargeException(String cause) {
		super(cause);
	}
}
