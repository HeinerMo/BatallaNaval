package entity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;



public class ClientServer extends Thread{

	private Socket socket;
	private PrintStream send;
	private BufferedReader receive;
	
	public ClientServer(Socket socket) throws IOException {
		this.socket=socket;
		this.send=new PrintStream(this.socket.getOutputStream());
		this.receive=new BufferedReader(
				new InputStreamReader(this.socket.getInputStream())
		);
	} // constructor	
	
	public void run() {
		do {
			try {
				protocolo(Integer.parseInt(this.receive.readLine()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}while(true);
	}// run
	
	public void protocolo(int accion) throws FileNotFoundException, IOException {
	} // protocolo
	
} // fin clase

