package com.android.gato;


import java.util.Scanner;

public class App {
	public static Scanner entrada = new Scanner(System.in);
	public static String a1= " ";
	public static String a2= " ";
	public static String a3= " ";
	public static String b1= " ";
	public static String b2= " ";
	public static String b3= " ";
	public static String c1= " ";
	public static String c2= " ";
	public static String c3= " ";
	
	public static void  tablero() {
		
		System.out.println("  1 2 3");
		System.out.println(" ");		
		System.out.println("a "+ a1 + "|" + a2 + "|" + a3);
		System.out.println("  _|_|_");
		System.out.println("b "+ b1 + "|" + b2 + "|" + b3);
		System.out.println("  _|_|_");		
		System.out.println("c "+ c1 + "|" + c2 + "|" + c3);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String respuesta;
		String jugador ="O";
		tablero();
		
		for(int i=1; i <=9; i++) {
			if(jugador=="O") {
				jugador = "X";
			}else {
				jugador = "O";
			}
				
			System.out.println(" ");
			System.out.println("Jugador "+jugador+", ingrese casilla (fila columnas) Ej a1:");
		
			respuesta = entrada.nextLine();
			
			switch (respuesta) {
				case "a1":
					a1 = jugador;
					break;
				case "a2":
					a2 = jugador;
					break;			
				case "a3":
					a3 = jugador;
					break;	
				case "b1":
					b1 = jugador;
					break;			
				case "b2":
					b2 = jugador;
					break;		
				case "b3":
					b3 = jugador;
					break;		
				case "c1":
					c1 = jugador;
					break;			
				case "c2":
					c2 = jugador;
					break;		
				case "c3":
					c3 = jugador;
					break;									
			
			}
			
			tablero();
			
			
		}
	}

}
