package dad;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Model model = new Model();
		System.out.println("abriendo puerto");
		model.abrirPuerto();
		System.out.println("esperando al cliente");
		model.esperarAlCliente();
		model.crearFlujos();
		System.out.println("flujos creados");
		model.start();
		
		Scanner rdScanner = new Scanner(System.in);
		
		model.enviarMensaje(rdScanner.next());
		System.out.println("mensaje enviado");
		
		model.enviarMensaje(rdScanner.next());
		System.out.println("mensaje enviado");
	}

}
