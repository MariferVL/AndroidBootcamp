import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        List<String> userData = new ArrayList<String>();

        // Docs Scanner https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html
        Scanner scanner = new Scanner(System.in);

        // Welcome to program
        System.out.println("\r\n\t\t)*(  Registro de Usuarios  )*(  ");
        // System.out.println("\r\n\t\t<_____ \r\n\t\t\t___> ");

        // Get data from input and Create variables
        System.out.println("\r\nDatos a Ingresar: ");

        // Get Nombres==> requiered, String
        userData.add(0, validateData(scanner, "Nombre"));

        // Get Apellidos==> requiered, String
        userData.add(0, validateData(scanner, "Apellidos"));

        // TODO: Get Edad: <120 años
        System.out.print("\r\n\t>Edad: ");


        // TODO: Get RUT ==> Number < 99.999.999, Int
        System.out.print("\r\n\t>RUN: ");


        // TODO: Get Teléfono: <= 15 char, String
        System.out.print("\r\n\t>Teléfono: ");
        userData.add(validateStrLength(scanner, "Teléfono", "16"));


        // TODO: Get Dirección: <=50 char, String
        System.out.print("\r\n\t>Dirección: ");
        userData.add(validateStrLength(scanner, "Dirección", "51"));


        // Get Comuna: requiered, String
        System.out.print("\r\n\t>Comuna: ");
        userData.add(0, validateData(scanner, "Comuna"));

        // Get AFP ==> requiered, String
        System.out.print("\r\n\t>AFP: ");
        userData.add(0, validateData(scanner, "AFP"));

        // Get Sistema de salud ==> 1 (Fonasa) o 2 (Isapre), Menu with int
        System.out.println("\r\n\t>Sistema de Salud: ");
        System.out.println("\r\n\t>> 1-FONASA ");
        System.out.print("\r\n\t>> 2-ISAPRE ");
        userData.add(validateMenu(scanner, "Sistema de Salud"));

        // TODO: Print all data in console.
        scanner.close();
    }

    // TODO: Validate data entry ==> method
    public static String validateData(Scanner scanner, String label) {
        boolean procces = true; 
        String input = "";
        while(procces){
            System.out.print("\r\n\t>"+ label+ ": ");
            input = scanner.nextLine();
            System.out.println("Input length: " + input.length());
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
            System.out.println("Input: " + input);
                procces = false;
            } else {
                // Print error message if neccesary
                System.out.println("\r\n\t>> Por favor, escribe tu " + label);
            }
        }
        return input;
        }

    public static String validateMenu(Scanner scanner, String label) {
        boolean procces = true; 
        String input = "";
        while(procces){
            System.out.print("\r\n\t>"+ label+ ": ");
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

    public static String validateStrLength(Scanner scanner, String label, String number) {
        boolean procces = true; 
        String input = "";
        while(procces){
            //FIXME:  
            System.out.print("\r\n\t>"+ label+ ": ");
            input = scanner.nextLine();
            System.out.println("Input : " + input);
            int limite = Integer.parseInt(number);
            if(input.length() < limite ){
                procces = false;
            } else {
                // Print error message if neccesary
                System.out.print("\r\n\t\t>¡! Dato extenso: Por favor, ingresa sólo la info necesaria");
            }
        }
        return input;
    }





}

