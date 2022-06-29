package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;


public class Client extends Thread{

	private int socketPort;
	private InetAddress address;
	private Socket socket;
	private PrintStream send;
	private BufferedReader receive;
	
	public Client(int socketPort) throws IOException {
		this.socketPort=socketPort;
		this.address=InetAddress.getLocalHost();
		this.socket=new Socket(this.address, this.socketPort);
		this.send=new PrintStream(this.socket.getOutputStream());
		this.receive=new BufferedReader(
				new InputStreamReader(this.socket.getInputStream())
		);
	} // constructor
	
	public void run() {
		do {
		}while(true);
	} // run
	
	
} // fin clase


