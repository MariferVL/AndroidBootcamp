/**
 * 
 */
package com.android.groupsorganaizer;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.LinkedList;



/**
* @author mfvl1
*
*/
public class Main {

	/**
	 * @param args
	 */
 // Function get groups organzation base on index and return a list of data
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
     
     } else {
          membersPerGroup = 3;
          groupsNumber = Math.round(totalStudents / 3);
          lastGroup = totalStudents % 3; 
         if (lastGroup == 1){
             lastGroup = 4;
             groups = (groupsNumber-1) + " grupos de " + membersPerGroup + " personas y 1 grupo de 4 personas.";
             

         } else if (lastGroup == 2) {
              groups = groupsNumber + " grupos de " + membersPerGroup + " personas y 1 grupo de 2 personas.";
             groupsNumber += 1;
 
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
     System.out.println(groups);
         
     return groupsData;
 }

 
 // Drive Function
	public static void main(String[] args) {
		//  Create Vars: concentration time min, max, and group swapping.
     final int longFocusTime = 26;
     final int restChange = 5;
     final int shortFocusTime = 10;
     final int groupChangeTime = 2;

     String groups;
     
     //  Create input with students names 
		System.out.println("Ingresa nombres de estudiantes separado por coma: ");
		String students = System.console().readLine();
     //System.out.print("Los estudiantes ingresados: " + students);
     
     //  Create input with total working time
     System.out.println("Ingresa total de minutos de sesión : ");
		int workTime = Integer.parseInt(System.console().readLine());
		//System.out.println("Minutos totales a trabajar: " + workTime);

     //  Confirm students list and total number.
     System.out.println("\r\nPor favor, confirma la información ingresada: \r\n");
     AbstractList<String> studentsList = new LinkedList<String>();
     // Split string from comma
     studentsList.addAll(Arrays.asList(students.split("\\s*,\\s*")));
     
     System.out.println("> Lista de estudiantes = " + (Arrays.toString(studentsList.toArray())));
     
     // Get list length 
     int totalStudents = studentsList.size();
     // Print list length
     System.out.println("> Número total de estudiantes = " + totalStudents);

     System.out.println("La info ingresada es correcta? (Si/No): ");
		String respuesta = System.console().readLine().toUpperCase();

//pedro, laura, javi, paula, camila, luis, leo ,rosa, mf, cala, carla, susy, carlos, sergio, fabi, bea, barb, jose, javier, seba, fabian, laura, paloma, consuelo, jacinta, cami, pablo, jano, joao, valeria, valeska, cecilia, tamy,sofy

     
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
         extraGroup = differentGroup.get(1);


     } else {
          System.out.println("Reinicia el Programa");
     }

     Main obj = new Main();

     System.out.println("\r\n> Integrantes por grupo: ");

     for (int i = 0; i < groupsNumber; i++) {
         // Take a random element from list and print them
         List<Integer> params = new ArrayList<>();
         params.add(membersPerGroup);
         params.add(extraGroup);

 		System.out.println("Grupo" + (i+1) + ": " + obj.setGroupsRandomly(studentsList, params));
     }
     //System.out.println("lista restante: " + studentsList);

	}

	
 
	public List<String>setGroupsRandomly(List<String> list, List<Integer> parameters){
     Random randomNumber = new Random();
     int totalItems = parameters.get(0);
     int extraGroup = parameters.get(1);

     // Create a temporary list for storing selected element
		List<String> eachGroup = new ArrayList<String>();
     
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
         if(list.size() == 4){
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
     

    //fin Fn 
	}


	//  chequear valores línea 57 y 104 
	//Condición más de 30 min--> Pomodoro
	//< 30 min --> 10 min + 2 













 
}

