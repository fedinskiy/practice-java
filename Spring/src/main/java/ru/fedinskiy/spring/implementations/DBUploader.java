package ru.fedinskiy.spring.implementations;

import org.springframework.stereotype.Component;
import ru.fedinskiy.spring.interfaces.Downloader;
import ru.fedinskiy.spring.interfaces.Uploader;

/**
 * Created by fedinskiy on 01.03.17.
 */
@Component
public class DBUploader implements Uploader {
	public boolean upload(String path, Object content) {
		System.out.println("Uploading "+content.toString() +" to db "+path );
		return true;
	}
}
