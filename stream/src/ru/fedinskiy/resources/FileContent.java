package ru.fedinskiy.resources;


import ru.fedinskiy.exceptions.IllegalSymbolsException;
import ru.fedinskiy.exceptions.ResourceTooLargeException;
import ru.fedinskiy.exceptions.WrongResourceException;

import java.io.*;

/**
 * Created by fedinskiy on 08.02.17.
 */
public class FileContent extends ResourceContent {
	/**
	 * @param resource — файл, содержимое которого будет прочитано
	 * @throws WrongResourceException
	 * @throws IOException
	 * @throws IllegalSymbolsException
	 */
	public FileContent(File resource)
			throws WrongResourceException,
			IOException, IllegalSymbolsException {
		super(resource.getAbsolutePath());
		final String DEFAULT_ENCODING = "UTF-8";
		
		String filePath = resource.getAbsolutePath();
		
		if (!resource.exists()) {
			throw new WrongResourceException("Файл " + filePath
					+ " не существует");
		}
		
		if (!resource.isFile()) {
			throw new WrongResourceException("По пути " + filePath
					+ " расположена папка!");
		}
		
		if (!resource.canRead()) {
			throw new WrongResourceException("Невозможно прочесть файл "
					+ filePath + " !");
		}
		
		try {
			super.prepareStore(resource.length());
		} catch (ResourceTooLargeException ex) {
			throw new WrongResourceException("Файл " + filePath
					+ " слишком велик!", ex);
		}
		
		try (BufferedReader in = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(resource), DEFAULT_ENCODING))) {
			this.read(in);
			in.close();
		}
	}
}
