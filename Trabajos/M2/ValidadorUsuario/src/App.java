import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        List <String> userData = new ArrayList<String>();

        // Docs Scanner https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html
        Scanner scanner = new Scanner(System.in);
        
        //Welcome to program
        System.out.println("\r\n\t\t)*(  Registro de Usuarios  )*(  ");
        // System.out.println("\r\n\t\t<_____ \r\n\t\t\t___>  ");
        
        // TODO:  Get data from input and  Create variables

        System.out.println("\r\nDatos a Ingresar: ");



        // TODO:  Get Nombres==>  requiered, String
        userData.add(0, "funcion");

        // TODO:  Get Apellidos==> requiered, String
        System.out.println("\r\n\t>Apellidos: ");
        String lastName = scanner.nextLine();


        // TODO:  Get  Edad: <120 años
        System.out.println("\r\n\t>Edad: ");
        int age = scanner.nextInt(0);

        // TODO:  Get RUT ==> Number < 99.999.999, Int
        System.out.println("\r\n\t>RUN: ");
        int run = scanner.nextInt(0);

        // TODO:  Get Teléfono: <= 15 char, String
        System.out.println("\r\n\t>Teléfono: ");
        String phone = scanner.next();

        // TODO:  Get  Dirección: <=50 char, String
        System.out.println("\r\n\t>Dirección: ");
        String address = scanner.nextLine();


        // TODO:  Get  Comuna: requiered, String
        System.out.println("\r\n\t>Comuna: ");
        String city = scanner.nextLine();

        // TODO:  Get AFP ==> requiered, String
        System.out.println("\r\n\t>AFP: ");
        String afp = scanner.nextLine();


        // TODO:  Get Sistema de salud ==>  1 (Fonasa) o 2 (Isapre), Menu with int
        System.out.println("\r\n\t>Sistema de Salud: ");
        System.out.println("\r\n\t>> 1-FONASA ");
        System.out.println("\r\n\t>> 2-ISAPRE ");
        String healthInsurance = scanner.nextLine();


        // TODO: Validate data ==> method
        // TODO: Print error message if neccesary
        // TODO: Print all data in console. 
        scanner.close();
    }

    
    public static String validateName(Scanner scanner) {
        boolean procces = true; 
        String name = "";
        while(procces){
            System.out.println("\r\n\t>Nombres: ");
            name = scanner.nextLine();
            System.out.println("Name length: " + name.length());
            if(name.length() > 1){
                procces = false;
            } 
            System.out.println("\r\n\t>> Por favor, escribe tu nombre ");
        }
        return name;
        }
}
