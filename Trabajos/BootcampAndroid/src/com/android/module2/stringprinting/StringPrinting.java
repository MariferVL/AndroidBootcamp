package com.android.module2.stringprinting;

import java.util.Scanner;
import java.io.*;


public class StringPrinting {
    public static void main(String[] args) {
        // ingresar String por teclado,
        // lea carácter por carácter, y
        // los despliegue por consola.
        // indicar la cantidad de vocales y la cantidad de consonantes.
        // Campo requerido.
        // CharAt.

        Scanner scanner = new Scanner(System.in);
        // Welcome to program
        System.out.println("\r\n\t\t |/|  Detector de Letras  |\\|  ");

        // Get user data ==> String
        System.out.print("\r\nIngresa una palabra o frase: ");
        String input = validateData(scanner, "Ingresa una palabra o frase");;
        countVowel(input);

        scanner.close();

    }

    public static String validateData(Scanner scanner, String label) {
        boolean procces = true;
        String input = "";
        while (procces) {
            System.out.print("\r\n\t>" + label + ": ");
            input = scanner.nextLine();
            if (input.length() > 1) {
                procces = isAlphabet(input);
            } else {
                // Print error message if neccesary
                System.out.println("\r\n\t>> ¡! Por favor, escribe tu " + label);
            }
        }
        return input;
    }

    // Check each char in string
    public static boolean isAlphabet(String input) {
        boolean is_alphabet = false;
        int countAlphabet= 0;
        for (int i = 0; i < input.length(); i++) {
            // Check Alphabet using isAlphabetic() Method
            if(Character.isAlphabetic(input.charAt(i))){
                countAlphabet++;
                if(countAlphabet == input.length()){
                }
            } else {
                System.out.println("Por favor, ingrese sólo letras.");
                is_alphabet = true;

            }
        }
        
        return is_alphabet;
    }

    // Method to Count Number of Vowels in a String in a iterative way
    public static void countVowel(String input) {
		input = input.toLowerCase();
		int countVowel = 0;

        System.out.print("\r\n\t Desgloce de '" + input +"': "); 

        // Count and print each vowel char
		for (int i = 0; i < input.length(); i++) {
			// check if char[i] is vowel
            System.out.print("\r\n\t>" + (i+1) +"° Carácter: " + input.charAt(i)); 
			if (input.charAt(i) == 'a' || input.charAt(i) == 'e'
				|| input.charAt(i) == 'i'
				|| input.charAt(i) == 'o'
				|| input.charAt(i) == 'u') {
				// Count increments if there is vowel in char[i]
				countVowel++;
			}
		}

		// Display total count of vowels in string
		System.out.println(
			"\r\n\t>Total de Vocales: " + countVowel);
        System.out.println(
            "\t>Total de Consonantes: " + (input.length() - countVowel) + "\r\n");
        
	}
}

