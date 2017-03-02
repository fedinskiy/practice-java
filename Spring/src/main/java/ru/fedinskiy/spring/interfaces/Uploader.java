package ru.fedinskiy.spring.interfaces;

/**
 * Created by fedinskiy on 01.03.17.
 */
public interface Uploader {
	
	/**
	 *
	 * @param path
	 * @param content
	 * @return
	 */
	public boolean upload(String path, Object content);
}
