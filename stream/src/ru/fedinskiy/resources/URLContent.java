package ru.fedinskiy.resources;


import ru.fedinskiy.exceptions.IllegalSymbolsException;
import ru.fedinskiy.exceptions.ResourceTooLargeException;
import ru.fedinskiy.exceptions.WrongResourceException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by fedinskiy on 08.02.17.
 */
public class URLContent extends ResourceContent {
	/**
	 *
	 * @param url — УРЛ, по которому расположен ресурс
	 * @throws IOException
	 * @throws IllegalSymbolsException
	 * @throws WrongResourceException
	 */
	public URLContent(URL url) throws IOException, IllegalSymbolsException,
			WrongResourceException {
		super(url.toString());
		try {
			super.prepareStore(url.openConnection().getContentLength());
		} catch (ResourceTooLargeException ex) {
			throw new WrongResourceException("Файл, расположенный по пути"
					+ url.toString()
					+ " слишком велик!", ex);
		}
		try (BufferedReader in = new BufferedReader(
				new InputStreamReader(url.openStream()))) {
			this.read(in);
			in.close();
		}
	}
}
