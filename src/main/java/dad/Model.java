package dad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Model extends Thread{
	ServerSocket sk;
	Socket socket;
	BufferedReader bReader;
	BufferedWriter bWriter;
	
	public void abrirPuerto() {
		try {
			sk = new ServerSocket(40080);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void esperarAlCliente() {
		try {
			socket = sk.accept();			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void crearFlujos() {
		try {
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			bReader = new BufferedReader(isr);
			
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osr = new OutputStreamWriter(os);
			bWriter = new BufferedWriter(osr);
		} catch (IOException e) {
			e.printStackTrace();
		}				
	}
	
	public void enviarMensaje(String mensaje) {
		try {
			bWriter.write(mensaje);
			bWriter.newLine();
			bWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String recibirMensaje() {
		try {
			String mensaje = bReader.readLine();
			return mensaje;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public void run() {
		while (true) {
			String mensaje = recibirMensaje();			
			System.out.println(mensaje);					
		}
	}
}
