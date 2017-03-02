package ru.fedinskiy.spring.implementations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.fedinskiy.spring.interfaces.Downloader;

/**
 * Created by fedinskiy on 01.03.17.
 */
@Component
public class FileDownloader implements Downloader {
	public String download(String path) {
		return "downloaded from file";
	}
}
