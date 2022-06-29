package entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread{

	private int socketPort;
	private int contadorClientes;
	
	public Server(int socketPort) {
		super("Hilo Servidor");
		this.socketPort=socketPort;
		this.contadorClientes=0;
	} // constructor
	
	
	public void run() {
		try {
			ServerSocket serverSocket=new ServerSocket(this.socketPort);
			
			do {
				System.out.println("Servidor ejecutando");
				//Socket socket=serverSocket.accept(); // socket creado para el cliente
				ClientServer myCliente=new ClientServer(serverSocket.accept());
				myCliente.start();
				System.out.println("Cliente aceptado: "+this.contadorClientes);
				++this.contadorClientes;
				//serverSocket.close();
				
			}while(true);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // run
	
} // fin clase

