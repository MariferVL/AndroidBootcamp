package com.android.module2.gradesaverage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

/*      Indicaciones:
        Solicite ingreso de nombres de varios alumnos
        solicite calificación (una prueba) de c/u por teclado. 
        programa  terminar cuando se ingrese  “SALIR”. */
public class Grades {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>(getStudentsData(scanner));

        System.out.println(data);

        printData(data);

        scanner.close();

    }

    public static ArrayList<ArrayList<String>> getStudentsData(Scanner scanner) {

        boolean process = true;
        ArrayList<String> namesList = new ArrayList<String>();
        ArrayList<String> gradesList = new ArrayList<String>();
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        while (process) {
            System.out.print("\r\n\t > Ingresa Nombre del Estudiante: ");
            String studentName = scanner.nextLine();

            if (namesList.size() >= 2 && studentName.equals("SALIR")) {
                process = false;
                // print
            } else if (studentName.equals("SALIR")) {
                System.out.print("\r\n\t\t > ¡!  Debe ingresar al menos 2 estudiantes\r\n\t\t  para terminar programa");

            } else {
                namesList.add(studentName);
                gradesList.add(getStudentsGrades(scanner, studentName));
            }
        }
        data.add(namesList);
        data.add(gradesList);


        return data;
    }

    public static String getStudentsGrades(Scanner scanner, String name) {

        System.out.print("\r\n\t > Ingresa Nota de " + name + ": ");
        String studentGrade = scanner.nextLine();
        return studentGrade;

    }

    // Print students data in console
    public static void printData(ArrayList <ArrayList<String>> data) {
        ArrayList<String> names = new ArrayList<String>(data.get(0));
        ArrayList<Float> grades = new ArrayList<Float>(data.get(1).stream().map(Float::valueOf).collect(Collectors.toList()));

        // Desplegar por consola promedio de curso
        System.out.println("\r\n\t>Notas Estudiantes : ");

        for (int i = 0; i < names.size(); i++) {
            System.out.println("\t>>" + (i + 1) + ") " + names.get(i) + ": " + grades.get(i));
        }

        for (int index = 0; index < data.get(1).size(); index++) {

            
        }
        System.out.print("\r\n\t>>Promedio del Grupo: ");
        System.out.printf("%.1f", getGradesAverage(grades));
        float min = Collections.min(grades);
        float max = Collections.max(grades);

        System.out.println("\r\n\t>>Nota Mínima: ");
        for (int index = 0; index < grades.size(); index++) {
            if (grades.get(index) == min) {
                // nombre del alumno con menor nota
                System.out.println("\t>>" + names.get(index) + ": " + grades.get(index));
            }
        }

        System.out.println("\r\n\t>>Nota Máxima: ");
        for (int index = 0; index < grades.size(); index++) {            
            if (grades.get(index) == max) {
                 // nombre del alumno con mayor nota.
                System.out.println("\t>>" + names.get(index) + ": " + grades.get(index));
            }   
        }
    }

    public static float getGradesAverage(ArrayList<Float> grades) {

        float sum = 0, gradesAvg;
        int totalStudents = grades.size();
        // float[] marks = new float[totalStudents];
        int i;
        
        for (i = 0; i < totalStudents; i++)
            sum = sum + grades.get(i);
        gradesAvg = sum / totalStudents;

        return gradesAvg;

    }

}
