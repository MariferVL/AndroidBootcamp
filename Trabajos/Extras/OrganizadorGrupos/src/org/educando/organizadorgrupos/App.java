package org.educando.organizadorgrupos;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.LinkedList;


/**
 * @author mfvl1
 *
Test Data: pedro, laura, javi, paula, camila, luis, leo ,rosa, mf, cala, carla, susy, carlos, sergio, fabi, bea, barb, jose, javier, seba, fabian, laura, paloma, consuelo, jacinta, cami, pablo, jano, joao, valeria, valeska, cecilia, tamy,sofy
 */
public class App {

	/**
	 * @param args
	 */
    
    // Drive Function
	public static void main(String[] args) {

        //Welcome to program
        System.out.println("\r\n\t\t<^> ¡Bienvenido a Agrupate! <^>  ");
        System.out.println("\r\n\t\t<Programa diseñado para crear esquema \r\n\t\t\tde estudios para grupos>  ");

        // Get user's name
        System.out.println("\r\nPor favor, dinos tu nombre: ");
        String userName = System.console().readLine();

        // Explain program to the user
        System.out.println("\r\n" + userName + ", te cuento que este programa te entregará: " );
        System.out.println("\t>> Grupos de 2 a 5 personas dependiendo \r\n\t   de la cantidad de nombres que ingreses.");
        System.out.println("\t>> Tiempos de concentración inspirados en Técnica Pomodoro.");
        System.out.println("\t>> Tiempos de descanso o recambio de grupos.");
        System.out.println("\r\n" + userName + ", para comenzar: " );

        // Create input with students names 
		System.out.println("\r\nIngresa nombres de estudiantes separado por coma: ");
		String students = System.console().readLine();

        AbstractList<String> studentsList = new LinkedList<>();
        // Split string from comma
        studentsList.addAll(Arrays.asList(students.split("\\s*,\\s*")));

        // Get list length 
        int totalStudents = studentsList.size();

        // Rule out program misunderstandings
        if(totalStudents < 3){
            System.out.println("\r\n" + userName + ", " + totalStudents + " no son suficientes para crear 2 grupos" );
            System.out.println("\r\n * Pista: Según la RAE un grupo es una \r\n\t'Pluralidad de seres o cosas que forman un conjunto, \r\n\t  material o mentalmente considerado.'\r\n" );
            System.exit(0);
        }
        
        // Create input with total working time
        System.out.println("\r\nIngresa total de minutos de sesión : ");
		int workTime = Integer.parseInt(System.console().readLine());
    




        // Confirm students list and total number.
        System.out.println("\r\nPor favor, confirma la información ingresada: \r\n");
        
        System.out.println("> Lista de estudiantes = " + (Arrays.toString(studentsList.toArray())));
        

        // Print list length
        System.out.println("\r\n> Número total de estudiantes = " + totalStudents);

        System.out.println("\r\nLa info ingresada es correcta? (Si/No): ");
		String respuesta = System.console().readLine().toUpperCase();

        // group characteristic vars 
        int membersPerGroup = 0;
        int groupsNumber = 0;
        int extraGroup = 0;        
        
        if(respuesta.equals("SI") || respuesta.equals("SÍ")){
            
            System.out.println("\r\nPrograma de trabajo: \r\n");
            System.out.println("> Organización de Grupos: "); 
            List<Integer> differentGroup = new ArrayList<>();
            differentGroup.addAll(getGroupsNumber(totalStudents));

            membersPerGroup = differentGroup.get(0);
            groupsNumber = differentGroup.get(1);
            extraGroup = differentGroup.get(2);


        } else {
             System.out.println("Reinicia el Programa");
        }

        float sessions = setPeriods(workTime);
        System.out.println("\r\nSesiones: " + sessions);
        for (int i = 0; i < sessions; i++) {
            System.out.println("\r\n   >Grupos Sesión " + (i+1) + ":\r\n");

            // Clone Students list to control random fn.
            List <String> studentsNames = new ArrayList<>(cloneDataList(studentsList));

            for (int j = 0; j < groupsNumber; j++) {
                // Take a random element from list and print them
                List<Integer> params = new ArrayList<>();
                params.add(membersPerGroup);
                params.add(extraGroup);    
        		System.out.println("      Grupo" + (j+1) + ": " + setGroupsRandomly(studentsNames, params));
            }
        }
        System.out.println("\r\n    Éxito y disfruta tu actividad. \r\n" );

	}
    // Function Create groups randomly
	public static List<String>setGroupsRandomly(List<String> list, List<Integer> parameters){
        Random randomNumber = new Random();
        int totalItems = parameters.get(0);
        int extraGroup = parameters.get(1);

        // Create a temporary list for storing selected element
		List<String> eachGroup = new ArrayList<>();
        
        if(extraGroup == 0){
            for (int i = 0; i < totalItems; i++) {

            // take a random index between 0 to size of given List
            int randomIndex = randomNumber.nextInt(list.size());

            // add element in temporary list
            eachGroup.add(list.get(randomIndex));

            // Remove selected element from original list
            list.remove(randomIndex);
            }   
        } else if(extraGroup == 1){
            
            if(list.size() == (totalItems + 1)){

                eachGroup.addAll(list);
                list.clear();
                
            } else {
                for (int i = 0; i < totalItems; i++) {

                    // take a random index between 0 to size of given List
                    int randomIndex = randomNumber.nextInt(list.size());
        
                    // add element in temporary list
                    eachGroup.add(list.get(randomIndex));
        
                    // Remove selected element from original list
                    list.remove(randomIndex);

                }
            }          
        } else {
            if(list.size() == 2){
                eachGroup.addAll(list);
                list.clear();
                
            } else {
                for (int i = 0; i < totalItems; i++) {

                    // take a random index between 0 to size of given List
                    int randomIndex = randomNumber.nextInt(list.size());
        
                    // add element in temporary list
                    eachGroup.add(list.get(randomIndex));
        
                    // Remove selected element from original list
                    list.remove(randomIndex);
                }           
            }         
        }    
        return eachGroup;
	}

    // Function get groups organzation based on index and return a list of data
    public static List<Integer>  getGroupsNumber(int totalStudents){
        // Create condition to get  in work teams
        int lastGroup = 0;
        int membersPerGroup;
        int groupsNumber;
        String groups;
    
        if (totalStudents % 4 == 0) {
            membersPerGroup = 4;
            groupsNumber = totalStudents / 4;
            groups = groupsNumber +  " grupos de " + membersPerGroup +  " personas";

        } else if (totalStudents % 5 == 0){
             membersPerGroup = 5;
             groupsNumber = totalStudents / 5;
             groups = groupsNumber + " grupos de " + membersPerGroup +  " personas";
        
        } else if (totalStudents % 3 == 0){
            membersPerGroup = 3;
            groupsNumber = totalStudents / 3;
            groups = groupsNumber + " grupos de " + membersPerGroup +  " personas";
        } else {
             membersPerGroup = 2;
             groupsNumber = Math.round(totalStudents / 2);
             lastGroup = totalStudents % 2; 
            if (lastGroup == 1){
                groups = (groupsNumber-1) + " grupos de " + membersPerGroup + " personas y 1 grupo de 3 personas.";
                
            // } else if (lastGroup == 2) {
            //      groups = groupsNumber + " grupos de " + membersPerGroup + " personas y 1 grupo de 2 personas.";
            //     groupsNumber += 1;
    
            } else {
                groups = groupsNumber + " grupos de " + membersPerGroup + " personas.";
            }

        }  
        
         // Compact data to return it   
         List<Integer> groupsData = new ArrayList<>();
                groupsData.add(membersPerGroup);
                groupsData.add(groupsNumber);
                groupsData.add(lastGroup);
                
        // Print groups organization
        System.out.println("  >>" + groups);
            
        return groupsData;
    }

    // Function Set concentration periods based on work minutes entered
    public static float setPeriods (int period){
        
        // Create Vars: concentration time min, max, and group swapping.
        final int shortFocusTime = 10;
        final int groupChangeTime = 2;
        int restChange = 5;
        float sessionTime;
        float sessions = 0;

        
        System.out.println("\r\nEsquema de equipos: \r\n");
        
        //  Apply Pomodoro Technique for work periods equal to or greater than 30 min.
        if(period >= 22 && period < 75){
            // 1 concentration session and no rests.
            sessions = Math.round(period/shortFocusTime);   
            sessionTime = Math.round((period-(groupChangeTime * (sessions - 1))) / sessions);
            restChange = groupChangeTime;

        } else if (period >= 75 && period <= 90){
            // 3 concentration session and 2 rest.
            sessionTime = Math.round((period - (restChange * 2)) / 2);
            sessions = 3;
        } else if (period > 90){
            // 4 concentration session, 3 short rests and 1 long rest.

            if (period >= 115){
                sessions = Math.round(period / 30);   
                sessionTime = 25;
            } else {
                sessionTime = Math.round((period - (restChange * 3)) / 4);
                sessions = 4;
            }
            
        } else {
            sessions = 1;   
            sessionTime = period;
            
        }

        System.out.println("> Sesiones de concentración: " + sessions + "\r\n  >> Duración: " + sessionTime + " minutos.");          
        System.out.println("\r\n> Cambios de grupos: " + restChange + " minutos.");

        System.out.println("\r\n> Descanso de 20 minutos al finalizar las 4 sesiones.");
                   
    return sessions;    
    }


    public static List<String>  cloneDataList(List <String>  studentsNames){

        return new ArrayList<>(studentsNames);

    }

    
}
