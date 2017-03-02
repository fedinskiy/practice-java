package ru.fedinskiy.spring.implementations;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ru.fedinskiy.spring.interfaces.Downloader;

/**
 * Created by fedinskiy on 01.03.17.
 */
@Component("urldown")
//@Primary
public class URLDownloader implements Downloader {
	public String download(String path) {
		return "downloaded from URL";
	}
}
