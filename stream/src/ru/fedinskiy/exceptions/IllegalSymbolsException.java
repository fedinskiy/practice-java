package ru.fedinskiy.exceptions;


/**
 * Created by fedinskiy on 07.02.17.
 */
public class IllegalSymbolsException extends BasicCallableException {
	
	/**
	 * @param line         — строка, содержащая неподдерживаемые символы
	 * @param resourceName — ресурс, содержащий неподдерживаемые символы
	 */
	public IllegalSymbolsException( String line,
	                               String resourceName) {
		super("Строка '" + line + "' в файле " + resourceName
				+ " содержит запрещенные символы!");
	}
}
