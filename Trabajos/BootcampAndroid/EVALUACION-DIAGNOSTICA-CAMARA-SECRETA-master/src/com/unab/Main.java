package com.unab;
import java.util.Scanner;

/**
 * @author Luis Zenteno,Barbara Carvajal, María-Fernanda Villalobos
 *
 */
public class Main {

	/**
	 * @param args
	 */
	static Scanner scanner = new Scanner(System.in);

	static public void menu(){
		// creamos un objeto tipo graficas
		Graficas grafica = new Graficas();
		grafica.titulo();
		System.out.println("\r\n\t\t¡Hola! ¿Cómo te llamas?");
		String nombreJugador = scanner.nextLine();
		System.out.println("\r\n\t\tBienvenid@ "+nombreJugador);
		Tablero tablero = new Tablero();
		
		tablero.crearTablero();
		tablero.crearCarro();
		tablero.tableroFalso();
		boolean condMenu = true;
		while (condMenu){
			System.out.println("\r\n" + nombreJugador+", ingresa tu opción:");
			System.out.println("\tOpcion 1) Iniciar Juego\r\n\tOpcion 2) Lanzar Huevo\r\n\tOpcion 3) Salir ");
			System.out.print("Opcion:  ");

			String opcion = scanner.nextLine();
			if (opcion.equals("1")){
				System.out.println("\r\n\t\t   ¡A Jugar!");  
				System.out.println("\r\n\t\tPuntaje Inicial: 0");  
				condMenu = tablero.mostrarMatriz();
				tablero.lanzarHuevo(scanner);

			}else if (opcion.equals("2")){
				condMenu = tablero.mostrarMatriz();
				tablero.lanzarHuevo(scanner);
				
			}else if (opcion.equals("3")){
				grafica.gameOver();
				System.out.println("Puntaje total: "+tablero.puntajeTotal);
				condMenu = false;
			} else {
				System.out.println("Opción inválida");
			}
		}
	}
	public static void main(String[] args) {
		
		menu();

	}
}
