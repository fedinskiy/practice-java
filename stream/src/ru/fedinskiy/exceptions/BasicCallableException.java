package ru.fedinskiy.exceptions;

import java.util.concurrent.ExecutionException;

/**
 * Created by fedinskiy on 09.02.17.
 */
public abstract class BasicCallableException extends ExecutionException {
	/**
	 *
	 * @param cause — описание исключения
	 */
	public BasicCallableException(String cause) {
		super(cause);
	}
	
	/**
	 *
	 * @param cause — описание исключения
	 * @param ex — исключение, ставшее причиной данного
	 */
	public BasicCallableException(String cause, ResourceTooLargeException ex) {
		super(cause, ex);
	}
	
	/**
	 *
	 * @return — текст сообщения
	 * @implSpec — нужна для правильного отображения текста исключений,
	 * выброшенных из наследников Callable
	 */
	@Override
	public String toString() {
		return super.getMessage();
	}
}
