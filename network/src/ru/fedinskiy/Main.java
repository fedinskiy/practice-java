package ru.fedinskiy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
	
	public static void main(String[] args) {
		Thread serverThread=new Thread(new Runnable() {
			@Override
			public void run() {
				Server server=new Server();
				try {
					server.start();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		Thread clentThread=new Thread(new Runnable() {
			@Override
			public void run() {
				Client client=new Client();
				try {
					client.start();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		serverThread.start();
		clentThread.start();
	}
}
