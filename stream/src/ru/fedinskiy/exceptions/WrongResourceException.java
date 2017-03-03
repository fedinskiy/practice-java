package ru.fedinskiy.exceptions;

/**
 * Created by fedinskiy on 07.02.17.
 */
public class WrongResourceException extends BasicCallableException {
	/**
	 * @param cause — сообщение об ошибке
	 */
	public WrongResourceException(String cause) {
		this(cause, null);
	}
	
	/**
	 * @param cause — сообщение об ошибке
	 * @param ex    — причина ошибки
	 */
	public WrongResourceException(String cause, ResourceTooLargeException ex) {
		super(cause, ex);
	}
}
