import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Create a list to save all user data
        List<String> userData = new ArrayList<String>();

        // Docs Scanner https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html
        Scanner scanner = new Scanner(System.in);

        // Welcome to program
        System.out.println("\r\n\t\t)*(  Registro de Usuarios  )*(  ");
        // System.out.println("\r\n\t\t<_____ \r\n\t\t\t___> ");

        // Get data from inputs and Create variables
        System.out.println("\r\nDatos a Ingresar: ");

        // Get Nombres==> requiered, String
        // Add data to userData List
        userData.add(validateData(scanner, "Nombre"));

        // Get Apellidos==> requiered, String
        userData.add(validateData(scanner, "Apellidos"));

        // Get Edad ==> int <120 años
        userData.add(validateMaxNumber(scanner, "Edad", 120));

        // Get RUT ==> int < 99.999.999
        userData.add(validateMaxNumber(scanner, "RUN" , 99999999));

        //  Get Teléfono: <= 15 char, String
        // System.out.print("\r\n\t>Teléfono: ");
        userData.add(validateStrLength(scanner, "Teléfono",16));

        //  Get Dirección: <=50 char, String
        userData.add(validateStrLength(scanner, "Dirección", 51));

        // Get Comuna: requiered, String
        userData.add(validateData(scanner, "Comuna"));

        // Get AFP ==> requiered, String
        userData.add(validateData(scanner, "AFP"));

        // Get Sistema de salud ==> 1 (Fonasa) o 2 (Isapre), Menu with int
        userData.add(validateMenu(scanner, "Sistema de Salud", "1-FONASA" , "2-ISAPRE " ));

        // TODO: Print all data in console.
        scanner.close();

        // Print data
        System.out.println("\r\nDatos Registados: ");
        System.out.print("\r\n\t>Nombre: " + userData.get(0));
        System.out.print("\r\n\t>Apellidos: " + userData.get(1));
        System.out.print("\r\n\t>Edad: " + userData.get(2));
        System.out.print("\r\n\t>RUN: " + userData.get(3));
        System.out.print("\r\n\t>Telefono: " + userData.get(4));
        System.out.print("\r\n\t>Dirección: " + userData.get(5));
        System.out.print("\r\n\t>Comuna: " + userData.get(6));
        System.out.print("\r\n\t>AFP: " + userData.get(7));
        System.out.print("\r\n\t>Sistema de Salud: " + userData.get(8));

        System.out.println("\r\n¡Gracias por Registrarte! ");




    }

    // Validate data entry ==> method
    public static String validateData(Scanner scanner, String label) {
        boolean procces = true; 
        String input = "";
        while(procces){
            System.out.print("\r\n\t>"+ label+ ": ");
            input = scanner.nextLine();
            if(input.length() > 1){
                // create two substrings from name
                // first substring contains first letter of name
                // second substring contains remaining letters
                String firstLetter = input.substring(0, 1);
                String remainingLetters = input.substring(1, input.length());

                // change the first letter to uppercase
                firstLetter = firstLetter.toUpperCase();

                // join the two substrings
                input = firstLetter + remainingLetters;
                procces = false;
            } else {
                // Print error message if neccesary
                System.out.println("\r\n\t>> Por favor, escribe tu " + label);
            }
        }
        return input;
        }

    // Validate data entry by Menu options ==> method
    public static String validateMenu(Scanner scanner, String label, String option1, String option2) {
        boolean procces = true; 
        String input = "";
        while(procces){
            System.out.print("\r\n\t>"+ label+ ": ");
            System.out.println("\r\n\t>> " + option1);
            System.out.print("\r\n\t>> " + option2);

            input = scanner.nextLine();
            System.out.println("Input : " + input);
            if(input.equals("1")){
                procces = false;
            } else if (input.equals("2")) {
                procces = false;
            } else {
                 // Print error message if neccesary
                System.out.print("\r\n\t\t> ¡! La opción " +  input + " no es válida.");
            }
        }
        return input;
    }

    // Validate char limit on string inputs ==> method
    public static String validateStrLength(Scanner scanner, String label, int limit) {
        boolean procces = true; 
        String input = "";
        while(procces){
            System.out.print("\r\n\t>"+ label+ ": ");
            input = scanner.nextLine();
            System.out.println("Input : " + input);
            if(input.length() < limit ){
                procces = false;
            } else {
                // Print error message if neccesary
                System.out.print("\r\n\t\t>¡! Dato extenso: Por favor, ingresa sólo la info necesaria");
            }
        }
        return input;
    }

    // Validate number max on int inputs ==> method
    public static String validateMaxNumber(Scanner scanner, String label, int max) {
        boolean procces = true; 
        int input = 0;
        while(procces){
            System.out.print("\r\n\t>"+ label+ ": ");
            input = scanner.nextInt();
            System.out.println("Input : " + input);
            if(input < max ){
                procces = false;
            } else {
                // Print error message if neccesary
                System.out.print("\r\n\t\t>¡! Dato extenso: Por favor, ingresa sólo la cantidad de dígitos necesaria");
            }
        }
        String inputStr = Integer.toString(input);
        return inputStr;        
    }




}

