package ru.fedinskiy.spring.interfaces;

/**
 * Created by fedinskiy on 01.03.17.
 */
public interface Downloader {
	/**
	 *
	 * @param path
	 * @return
	 */
	public String download(String path);
}
