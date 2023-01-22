package com.android.module2.password;
import java.util.Scanner;
public class Password {
    public static void main(String[] args) {
       // una cadena de texto (String) contiene una contraseña cualquiera.
       // pedir a usuario que introduzca la contraseña
       // no más de 3 intentos.
       // Cuando el usuario acierte ya no pedirá más la contraseña y 
       //mostrará un mensaje diciendo “La clave ingresada es correcta”. 
       //considerar correctamente condición de salida
       // 3 intentos, si acierta se termina programa, aunque queden intentos.

       Scanner scanner = new Scanner(System.in);
       
       String password = "moon";

       System.out.println("\r\n\t\t ***  Bienvenido a Password  ***  ");

       System.out.print("\r\n> Tienes solo 3 oportunidades para adivinar. ");

       System.out.print("\r\n   ¡Comencémos! ");

      
        String answer = "";
        for(int i = 0; i < 3; i++){
            System.out.print("\r\n\t>" + (i+1) + "° Intento: ");
            answer = scanner.nextLine();
            if(password.equals(answer)){
                System.out.println("\r\n\t ***  ¡Acertaste!  ***  \r\n");
                System.exit(0);
            } else {
                System.out.println("\r\n\t ¡!  Intenta Nuevamente   ");
            }
        }
        System.out.println("\r\n\t ¡!  Se acabaron tus 3 intentos  :´(  \r\n");

       scanner.close();
    }
    
}
