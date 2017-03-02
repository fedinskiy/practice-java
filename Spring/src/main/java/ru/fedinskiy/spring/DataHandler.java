package ru.fedinskiy.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.fedinskiy.spring.implementations.DBUploader;
import ru.fedinskiy.spring.implementations.FileDownloader;
import ru.fedinskiy.spring.interfaces.Downloader;
import ru.fedinskiy.spring.interfaces.Uploader;

/**
 * Created by fedinskiy on 01.03.17.
 */
@Component
public class DataHandler {
	@Qualifier("urldown")
	@Autowired
	private Downloader downloader;
	@Autowired
	private Uploader uploader;
	
	public DataHandler(){
//		downloader=new FileDownloader();
//		uploader=new DBUploader();
 /*Жесткое создание полей*/
	}
	
	public DataHandler(Downloader downloader, Uploader uploader) {
		this.downloader = downloader;
		this.uploader = uploader;
	}
	
	public void handleData(String srcPath, String destPath){
		String content = this.downloader.download(srcPath);
		String handledContent = handle(content);
		this.uploader.upload(destPath, handledContent);
	}
	
	private String handle(String content) {
		return content;
	}
		
	public void setUploader(Uploader uploader) {
		this.uploader = uploader;
	}
	public void setDownloader(Downloader downloader) {
		this.downloader = downloader;
	}
}
