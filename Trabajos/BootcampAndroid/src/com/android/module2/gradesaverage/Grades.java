package com.android.module2.gradesaverage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Grades {
    public static void main(String[] args) {
        //solicite ingreso de nombres de varios alumnos
        // solicite calificación (una prueba) de c/u por teclado. 
        // programa  terminar cuando se ingrese  “SALIR”.

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> data = new ArrayList<String>();

        data.addAll(getStudentsData(scanner));
        System.out.println(data);

        printData(data); 

        scanner.close();

    }
    
    public static ArrayList<String> getStudentsData(Scanner scanner) {

        boolean process = true;
        ArrayList<String> namesList = new ArrayList<String>();
        ArrayList<String> data = new ArrayList<String>();

        while (process) {
            System.out.print("\r\n\t > Ingresa Nombre del Estudiante: ");
            String studentName = scanner.nextLine();


            if (namesList.size() > 2 &&  studentName.equals("SALIR")) {
                process = false;
                //print  
            } else if (studentName.equals("SALIR")){
                System.out.print("\r\n\t\t > ¡!  Debe ingresar al menos 2 estudiantes\r\n\t\t  para terminar programa");

            } else {
                namesList.add(studentName);
                data.addAll(1, getStudentsGrades(scanner, studentName));
            }
            
        }
        data.addAll(namesList);

        return data;
    }

    public static ArrayList<String> getStudentsGrades(Scanner scanner, String name) {

        ArrayList<String> studentsGrades = new ArrayList<String> ();
        System.out.print("\r\n\t > Ingresa Nota de " + name  + ": ");
        String studentGrade = scanner.nextLine();
        studentsGrades.add(studentGrade);

        return studentsGrades;
        
    }

    //Print students data in console
    public static void printData(ArrayList<String> data) {
        ArrayList<String> names = new ArrayList<String>(Arrays.asList(data.get(0)));    
        ArrayList<String> grades = new ArrayList<String>(Arrays.asList(data.get(1)));     
 
        System.out.println("\r\n\t>Notas Estudiantes : ");

        for (int i = 0; i < names.size(); i++){
            System.out.println("\t>>" + (i+1) + names.get(i) + grades.get(i));
        }
        

        //Luego, desplegar por consola  promedio de curso 
        //TODO:  nombre del alumno con  menor nota 
        //TODO: nombre del alumno con  mayor nota. 
        //TODO:  importante validar que se ingrese siempre más de un alumno.

        System.out.println("\r\n\t>Promedio del Grupo: " + getGradesAverage(grades));

    }

    public static Float getGradesAverage(ArrayList<String> grades) { 
        
        Float sum;
        Float gradesAverage;
        if (!grades.isEmpty()) {
        for ( parseFloat(number)  : grades) {
        sum += number;
        }
        gradesAverage = sum.FloatValue() / grades.size();
        }
        return gradesAverage;
        
    }





}


