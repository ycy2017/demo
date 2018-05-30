package com.example.demo.socket;

import java.io.IOException;
import java.net.ServerSocket;

public class SocketDemo {

	public static void main(String[] args) {
		
		try {
			ServerSocket ss = new ServerSocket(8081);
			ss.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
