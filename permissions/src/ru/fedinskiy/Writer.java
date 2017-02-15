package ru.fedinskiy;

import java.io.*;

/**
 * Created by fedinskiy on 15.02.17.
 */
public class Writer {
	public void Write(String filepath, String content) throws IOException {
		File file= new File(filepath);
		FileOutputStream out=new FileOutputStream(file);
		OutputStreamWriter writer =new OutputStreamWriter(out);
		//BufferedWriter briter=new BufferedWriter(writer);
		writer.write(content,0,content.length());
		writer.flush();
	}
}
