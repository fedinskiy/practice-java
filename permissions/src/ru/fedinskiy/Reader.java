package ru.fedinskiy;

import java.io.*;

/**
 * Created by fedinskiy on 15.02.17.
 */
public class Reader {
	public String read(String filepath) throws IOException {
		String retval="";
		File file= new File(filepath);
		BufferedReader reader= new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String line;
		line = reader.readLine();
		while(null!=line){
			retval=retval.concat(line);
			line = reader.readLine();
		}
		return retval;
	}
}
