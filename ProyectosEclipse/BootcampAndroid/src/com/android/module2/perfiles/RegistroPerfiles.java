package com.android.module2.perfiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class RegistroPerfiles {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int usersNum = 0;

        // Welcome to program
        System.out.println("\r\n\t\t |/|  Registro de Usuarios  |\\|  ");

        // Get users number data
        System.out.print("\r\nIngrese cantidad de usuarios: ");
        usersNum = Integer.parseInt(scanner.nextLine());

        // Get data from total (usersNum) users
        List<List<String>> userData = new ArrayList<List<String>>();
        for (int i = 0; i < usersNum; i++) {
            userData.add(validateMenu(scanner, "Perfiles", "1- Cliente", "2- Profesional", "3- Administrativo"));
        }

        scanner.close();

        // Print all data collected
        System.out.println("\r\n  Datos Registrados: ");
        System.out.println("\r\n  >Total Usuarios Registrados: "+ userData.size());

        for (int i = 0; i < usersNum; i++) {
            // Main list: [[Sdfgn, 234yu, 234567, sdfgh, 2345678, 23], [Dfgh, wert, 123456,
            // werfghj, 23456, 2345]]
            System.out.println("\r\n  >Usuario " + (i+1) + ": ");
            System.out.println("\t>>Nombre: " + userData.get(i).get(0));
            System.out.println("\t>>Apellido: " + userData.get(i).get(1));
            System.out.println("\t>>Fecha de Nacimiento: " + userData.get(i).get(2));
            System.out.println("\t>>RUN: " + userData.get(i).get(3));

            // Filter profile data
            if (userData.get(i).get(userData.get(i).size() - 1).equals("1")) {
                
                System.out.println("\t>>Dirección: " +  userData.get(i).get(4));
                System.out.println("\t>>Telefono: " +  userData.get(i).get(5));
                System.out.println("\t>>Cantidad de Trabajadores: " +  userData.get(i).get(6));

            } else if (userData.get(i).get(userData.get(i).size() - 1).equals("2")) {

                System.out.println("\t>>Años de Experiencia: " +  userData.get(i).get(4));
                System.out.println("\t>>Departamento de Compañía: " +  userData.get(i).get(5));

            } else if (userData.get(i).get(userData.get(i).size() - 1).equals("3")) {

                System.out.println("\t>>Cargo/Rol: " +  userData.get(i).get(4));
                System.out.println("\t>>Nombre del Supervisor: " +  userData.get(i).get(5));

            } 

        }

        System.out.println("\r\n\t\t¡Gracias por Registrar! \r\n");

    }

    // Create profiles: customer , professional and manager
    public static List<String> validateMenu(Scanner scanner, String label, String option1, String option2,
            String option3) {
        boolean procces = true;
        String input = "";
        List<String> userData = new ArrayList<String>();

        while (procces) {
            System.out.println("\r\n\t>" + label + ": ");
            System.out.println("\t>> " + option1);
            System.out.println("\t>> " + option2);
            System.out.println("\t>> " + option3);
            // Use print to enable writing after the tag
            System.out.print("\t>> Opción: ");
            // Get user answer
            input = scanner.nextLine();
            // Get common user data
            userData.addAll(getCommonData(scanner));

            // Get user data by specific profile
            if (input.equals("1")) {
                userData.addAll(4, getCustomerData(scanner));
                procces = false;
            } else if (input.equals("2")) {
                userData.addAll(4, getProfessionalData(scanner));
                procces = false;

            } else if (input.equals("3")) {
                userData.addAll(4, getManagerData(scanner));
                procces = false;

            } else {
                // Print error message if neccesary
                System.out.print("\r\n\t>> ¡! La opción " + input + " no es válida.");
            }
            // Add profile option
            userData.add(input);

        }

        return userData;
    }

    // Validate required input
    public static String validateData(Scanner scanner, String label) {
        boolean procces = true;
        String input = "";
        while (procces) {
            System.out.print("\r\n\t>" + label + ": ");
            input = scanner.nextLine();
            if (input.length() > 1) {
                input = getCapitalizeCase(input);
                procces = false;
            } else {
                // Print error message if neccesary
                System.out.println("\r\n\t>> ¡! Por favor, escribe tu " + label);
            }
        }
        return input;
    }

    // Validate char limit on string inputs ==> method
    public static String validateStrLength(Scanner scanner, String label, int limit) {
        boolean procces = true;
        String input = "";
        while (procces) {
            // Use print to enable writing after the tag
            System.out.print("\r\n\t>" + label + ": ");
            // last one is number
            input = scanner.nextLine();
            if (input.length() < limit && input.length() > 2 ) {
                input = getCapitalizeCase(input);
                procces = false;
            } else if (input.length() < limit) {
                procces = false;
            } else {
                // Print error message if neccesary
                System.out.println(
                        "\r\n\t>> ¡! Dato extenso: Por favor, ingresa\r\n\t  sólo la cantidad de dígitos necesaria");
            }
        }

        return input;
    }

    // Validate number max on int inputs
    public static String validateMaxNumber(Scanner scanner, String label, int max) {
        boolean procces = true;
        String inputStr = "";
        while (procces) {
            System.out.print("\r\n\t>" + label + ": ");
            inputStr = scanner.nextLine();
            while (!onlyDigits(inputStr, inputStr.length())) {
                // Print error message if neccesary
                System.out.println("\r\n\t>> ¡! Dato Inválido: Por favor, ingresa\r\n\t  sólo lo solicitado.");
                System.out.print("\r\n\t>" + label + ": ");
                inputStr = scanner.nextLine();
            }
            int input = Integer.valueOf(inputStr);

            if (input < max) {
                procces = false;
            } else {
                // Print error message if neccesary
                System.out.println(
                        "\r\n\t>> ¡! Dato extenso: Por favor, ingresa\r\n\t  sólo la cantidad de dígitos necesaria");
            }
        }
        return inputStr;
    }

    // Validate number min on int inputs
    public static String validateMinNumber(Scanner scanner, String label, int min) {
        boolean procces = true;
        String inputStr = "";
        while (procces) {
            System.out.print("\r\n\t>" + label + ": ");
            inputStr = scanner.nextLine();
            int input = Integer.valueOf(inputStr);

            if (input > min) {
                procces = false;
            } else {
                // Print error message if neccesary
                System.out.println(
                        "\r\n\t>> ¡! Dato inválido: Por favor, ingresa\r\n\t sólo info solicitada.");
            }
        }

        return inputStr;

    }

    public static List<String> getCommonData(Scanner scanner) {
        // Todos requieren:
        List<String> userData = new ArrayList<String>();
        // Get name ==> string
        userData.add(validateData(scanner, "Nombre"));

        // Get surname ==> string
        userData.add(validateData(scanner, "Apellido"));

        // Get FDN ==> string (dd/mm/aaaa) ==> < 11
        userData.add(validateStrLength(scanner, "Fecha de Nacimiento (dd/mm/aaaa)", 11));

        // Get RUN ==> string
        userData.add(validateMaxNumber(scanner, "RUN (sin puntos ni digito verificador)", 99999999));

        return userData;
    }

    public static List<String> getCustomerData(Scanner scanner) {
        List<String> customerData = new ArrayList<String>();
        // Get direccion ==> string
        customerData.add(validateStrLength(scanner, "Dirección", 50));

        // Get telefono ==> string
        customerData.add(validateStrLength(scanner, "Teléfono", 16));

        // Get workers quantity
        customerData.add(validateMinNumber(scanner, "Cantidad de Trabajadores", -1));

        return customerData;
    }

    public static List<String> getProfessionalData(Scanner scanner) {
        List<String> professionalData = new ArrayList<String>();
        // Get años experiencia ==> > -1
        professionalData.add(validateMinNumber(scanner, "Años de Experiencia", -1));

        // Get company department ==> string < 20
        professionalData.add(validateStrLength(scanner, "Departamento de Compañía", 20));

        return professionalData;
    }

    // Get manager data:
    public static List<String> getManagerData(Scanner scanner) {
        List<String> managerData = new ArrayList<String>();
        // Get rol ==> string < 20
        managerData.add(validateStrLength(scanner, "Cargo/Rol", 20));

        // Get supervisor name==>
        managerData.add(validateStrLength(scanner, "Nombre del Supervisor", 20));

        return managerData;
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

    public static boolean onlyDigits(String str, int n) {
        // Traverse the string from start to end
        for (int i = 0; i < n; i++) {

            // Check if character is not a digit between 0-9
            // then return false
            if (str.charAt(i) < '0'
                    || str.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
}