package com.android.module2;

import java.util.Scanner;

public class ReglamentoTrabajadores {

    public static void main(String[] args) {
        // Atomizando las frases 
        // asignando valor de verdad;
        
        // Welcome to program
        System.out.println("\r\n\t\t    <Asegurate>");
        System.out.println("\t(+)  Manejo Reglamento Seguridad  (+)  ");

        // Initialize vars
        String workerName = "";
        String regulation1 = " sigue los procedimientos de seguridad";
        String regulation2 = " leyó el manual de seguridad interno";
        String statment = " ha tenido accidentes laborales";


        // Get name from input 
        Scanner scanner = new Scanner(System.in);
        System.out.print("\r\n> Ingrese Nombre de Trabajador: ");
        
        workerName = getCapitalizeCase(scanner.nextLine());
    
        // Get answers about regulations from inputs 
        Boolean regulation1OK = getAnswers(scanner, workerName, regulation1);
        Boolean regulation2OK = getAnswers(scanner, workerName, regulation2);
        Boolean accidents = getAnswers(scanner, workerName, statment);

        //If a worker DOES NOT take care of safety procedures ==> an accident will occur.
        //If a worker DOES NOT read the internal safety manual==> an accident will occur.
        if (!regulation1OK || !regulation2OK ) {
            System.out.println("\r\n\t ¡! Es muy probable que a " + workerName + "\r\n\t    le ocurra un accidente.");
                       
        } else {
            if (accidents) {
                System.out.println("\r\n\t ¡! Es probable que " + workerName + "\r\n\t" + regulation1+ " y\r\n\t"  
                + regulation2 + "\r\n\t pero no los haya seguido en detalle." );   
            } else{
                System.out.println("\r\n\t Las probabilidades de accidentes de " + workerName + 
                "\r\n\tson menores a la mayoría.");
            }
        }


    scanner.close();


    System.out.println("\r\n\tGracias por consultar en Asegurate\r\n");


    }

    // Get answers about company regulations and return a boolean
    public static boolean getAnswers(Scanner scanner, String workerName, String regulation) {
        String input = "";
        boolean process = true;
        boolean answer = true;
        while (process) {
            System.out.print("\r\n>¿" + workerName + regulation +  "?(Si/No): ");
            input = scanner.nextLine();
            input = input.toLowerCase();
            
            if( input.equals("si")){
                process = false;
            } else if (input.equals("no")){
                answer = false;
                process = false;
            } else {
                // Print error message if neccesary
                System.out.print("\r\n\t>> ¡! La opción " + input + " no es válida.");
            }
            
        }
        return answer;
    }
    
    // Capitalize case in strings
    public static String getCapitalizeCase(String input) {
        // Create two substrings from word
        // First substring contains first letter of word
        // Second substring contains remaining letters

        String firstLetter = input.substring(0, 1);
        String remainingLetters = input.substring(1, input.length());

        // Change the first letter to uppercase
        firstLetter = firstLetter.toUpperCase();
        // Change the remaining letter to lower case

        remainingLetters = remainingLetters.toLowerCase();

        // Join the two substrings
        input = firstLetter + remainingLetters;

        return input;
    }
}
