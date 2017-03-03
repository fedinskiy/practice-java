package ru.fedinskiy.resources;

import ru.fedinskiy.exceptions.IllegalSymbolsException;
import ru.fedinskiy.exceptions.WrongResourceException;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by fedinskiy on 09.02.17.
 */
public class ResourceContentFactory {
	/**
	 * @param sourcePath путь к ресурсу, который надо прочесть
	 * @return ResourceContent объект класса, хранящий себя слова из данного
	 * ресурса
	 * @throws WrongResourceException
	 * @throws IOException
	 * @throws IllegalSymbolsException
	 * @implSpec создает нужного наследника класса ResourceContent
	 */
	public static ResourceContent createChecker(String sourcePath)
			throws WrongResourceException, IOException, IllegalSymbolsException {
		ResourceType sourceType;
		
		if (null == sourcePath) {
			throw new WrongResourceException("Не передан путь!");
		}
		sourceType = getSourceType(sourcePath);
		switch (sourceType) {
			case FILE:
				return new FileContent(new File(sourcePath));
			case URL:
				return new URLContent(new URL(sourcePath));
			default:
				return null;
		}
	}
	
	private static ResourceType getSourceType(String sourcePath) {
		final String URL_FLAG = "http";
		
		return (sourcePath.startsWith(URL_FLAG))
				? ResourceType.URL
				: ResourceType.FILE;
	}
	
	private enum ResourceType {
		URL, FILE
	}
}
