package ru.fedinskiy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by fedinskiy on 03.03.17.
 */
public class Server {
	private ServerSocket server;
	private Socket socket;
	private final int port = 61123;
	
	public void start() throws IOException {
		server = new ServerSocket(port);
		socket = server.accept();
		BufferedReader breader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String message = null;
		while ((message = breader.readLine()) != null){
			System.out.println(message);
		}
	}
}
