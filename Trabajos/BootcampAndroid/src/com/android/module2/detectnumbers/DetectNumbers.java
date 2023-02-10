package com.android.module2.detectnumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DetectNumbers {
 
        public static void main(String[] args) {
    
            Scanner scanner = new Scanner(System.in);

            ArrayList<Integer> numbers = new ArrayList<Integer>(getNumbers(scanner));
            
            
            printData(numbers, "Ingresados");

            printData(filterEvenNum(scanner,numbers), "con Pares Filtrados");

            scanner.close();
    
        }
    
        /* 
        Almacene una cantidad indeterminada de números enteros en un ArrayList.
        Solicitar números hasta que se ingrese el valor 0 ==> */
        public static ArrayList<Integer> getNumbers(Scanner scanner) {
    
            boolean process = true;
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            while (process) {
                System.out.print("\r\n\t > Ingresa un número: ");
                String input = scanner.nextLine();
                int number = Integer.parseInt(input);

                // validar que hayan al menos tres valores ingresados.
                if (numbers.size() >= 3 && number == 0) {
                //  Considere que valor 0 final no debe ser tomado en cuenta en ArrayList.
                    process = false;

                } else if (number == 0) {
                    System.out.print("\r\n\t\t > ¡!  Debe ingresar al menos 3 números\r\n\t\t  para terminar el programa");

                } else {
                    numbers.add(number);
                }
            }
            return numbers;
        }
    
        /* desplegar el promedio simple de los números,
        desplegar el menor valor y
        desplegar el mayor de ellos. */
        public static void printData(ArrayList<Integer> data, String condition) {
           
            // Desplegar por consola promedio de curso
            System.out.println("\r\n\t>Números "  + condition +": " + data.toString());
            System.out.print("\r\n\t>>Promedio: ");
            System.out.printf("%.1f", getNumbersAverage(data));
            float min = Collections.min(data);
            float max = Collections.max(data);
    
            System.out.println("\r\n\t>>Número Menor: ");
            for (int index = 0; index < data.size(); index++) {
                if (data.get(index) == min) {
                    System.out.println("\t>>" + data.get(index));
                }
            }
    
            System.out.println("\r\n\t>>Número Mayor: ");
            for (int index = 0; index < data.size(); index++) {            
                if (data.get(index) == max) {
        
                    System.out.println("\t>>" + data.get(index));
                }   
            }
        }
    
        public static float getNumbersAverage(ArrayList<Integer> numbers) {
    
            float sum = 0, listAvg;
            int totalNumbers = numbers.size();
            int i;
            
            for (i = 0; i < totalNumbers; i++)
                sum = sum + numbers.get(i);
                listAvg = sum / totalNumbers;
    
            return listAvg;
    
        }

        /* Eliminar de colección aquellos números que sean PARES, y
        calcular y desplegar nuevamente el promedio, menor y mayor de valores restantes. */
        public static ArrayList<Integer> filterEvenNum(Scanner scanner, ArrayList<Integer> numbers ) {
            
            ArrayList<Integer> oddNumbers = new ArrayList<Integer>();
            
            for (int index = 0; index < numbers.size(); index++) {
                if (numbers.get(index) % 2 != 0) {
                    oddNumbers.add(numbers.get(index));
                } 
            }
            return oddNumbers;
        }
    
    }
    
