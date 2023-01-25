package com.android.module2.gradesaverage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        //TODO: solicite ingreso de nombres de varios alumnos
        //TODO: solicite calificación (una prueba) de c/u por teclado. 
        //TODO: programa  terminar cuando se ingrese  “SALIR”.
        //TODO:Luego, desplegar por consola  promedio de curso 
        //TODO:  nombre del alumno con  menor nota 
        //TODO: nombre del alumno con  mayor nota. 
        //TODO:  importante validar que se ingrese siempre más de un alumno.

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> names = new ArrayList<String>();

        names.addAll(getStudentsData(scanner));


        scanner.close();

    }
    
    public static ArrayList<String> getStudentsData(Scanner scanner) {

        boolean process = true;
        ArrayList<String> namesList = new ArrayList<String>();
        ArrayList<Integer> gradesList = new ArrayList<Integer>();
        ArrayList 

        while (process) {
            System.out.print("\r\n\t > Ingresa Nombre del Estudiante: ");
            String studentName = scanner.nextLine();
            namesList.add(studentName);
            gradesList.addAll(getStudentsGrades(scanner, studentName));

            if (studentName.length() > 1 &&  studentName.equals("SALIR")) {
                process = false;
                //print  
            }
            
        }

        return namesList;
    }

    public static ArrayList<Integer> getStudentsGrades(Scanner scanner, String name) {

        ArrayList<Integer> studentsGrades = new ArrayList<Integer> ();
        System.out.print("\r\n\t > Ingresa Nota de " + name  + ": ");
        String input = scanner.nextLine();
        int studentGrade = Integer.valueOf(input);
        studentsGrades.add(studentGrade);

        return studentsGrades;
        
    }








}


