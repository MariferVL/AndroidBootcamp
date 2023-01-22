package com.android.module2.calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        //un signo aritmético a modo de texto (Sting)
        //mostrará por consola el resultado.

        Scanner scanner = new Scanner(System.in);
        
        // Welcome to program
        System.out.println("\r\n\t\t(X)  Calcúlalo  (X)  ");

        // Get data from inputs and Create variables
        System.out.println("\r\n> Operación a realizar: ");

        // Print results in console.
        System.out.println("\r\n Cálculo: ");

        double total = calculate(scanner, "Operación a realizar", "1- Suma (+)", 
        "2- Resta (-)", "3- Multiplicación (x)", "4- División (:)", "5- Resíduo/Módulo (/)");

        System.out.println("\t>Total: " + total + "\r\n");

        scanner.close();


    }

    // Validate data entry by Menu options
    public static double calculate(Scanner scanner, String label, String option1,String option2, String option3, String option4, String option5) {

        boolean procces = true;
        String input = "";
        String mathOperator = "";
        int number1 = 0;
        int number2 = 0;
        double total = 0;

        while (procces) {
            System.out.println("\r\n\t>" + label + ": ");
            System.out.println("\t>> " + option1);
            System.out.println("\t>> " + option2);
            System.out.println("\t>> " + option3);
            System.out.println("\t>> " + option4);
            System.out.println("\t>> " + option5);
            System.out.print("\t>> Opción: ");
            input = scanner.nextLine();

            number1 = getNumber(scanner, "Primer Número");
            number2 = getNumber(scanner, "Segundo Número");

            switch (input) {
                case "1":
                    total = number1 + number2;
                    mathOperator =" + ";
                    procces = false;
                    break;
                case "2":
                    total = number1 - number2;
                    mathOperator =" - ";
                    procces = false;
                    break;
                case "3":
                    total = number1 * number2;
                    mathOperator =" x ";
                    procces = false;
                    break;
                case "4":
                    total = number1 / number2;
                    mathOperator =" : ";
                    procces = false;
                    break;
                case "5":
                    total = number1 % number2;
                    mathOperator =" / ";
                    procces = false;
                    break;
                default:
                    // Print error message if neccesary
                    System.out.print("\r\n\t>> ¡! La opción " + input + " no es válida.");
                    break;
                }
            }        
            System.out.println("\t> " + number1+ mathOperator + number2 );
            return total;
            
        }

    // Pedir 2 operandos tipo int
    public static int getNumber(Scanner scanner, String num) {
        int number = 0;
        // boolean procces = true;
        // while (procces) {
        System.out.println("\r\n\t>Ingresa Número Entero (no decimales): ");
        System.out.print("\t>> " + num + ": ");
        number = scanner.nextInt();

        // if(number != 0){

        //     // } else {
        //     //     // Print error message if neccesary
        //     //     System.out.print("\r\n\t>> ¡! Por favor " + input + " no es válida.");
        //     // }
        // }
           
        return number;
    }


    // public static boolean onlyDigits(String str, int n) {
    //     // Traverse the string from start to end
    //     for (int i = 0; i < n; i++) {

    //         // Check if character is not a digit between 0-9
    //         // then return false
    //         if (str.charAt(i) < '0'
    //                 || str.charAt(i) > '9') {
    //             return false;
    //         }
    //     }
    //     return true;
    }

