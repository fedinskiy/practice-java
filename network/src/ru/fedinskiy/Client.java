package ru.fedinskiy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.function.IntToDoubleFunction;

/**
 * Created by fedinskiy on 03.03.17.
 */
public class Client {
	private Socket socket;
	private final int port = 61123;
	public void start() throws IOException {
		socket=new Socket("localhost", port);
//		BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(socket.getInputStream()));
		int a=0;
		final IntToDoubleFunction intToDoubleFunction = (int b) -> {
			final int i = (a + b);
			return i;
		};
		a++;
		PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
		Scanner scanner= new Scanner(System.in);
		String message=null;
		while ((message=scanner.nextLine())!=null){
			printWriter.println(message);
			printWriter.flush();
		}
	}
}
