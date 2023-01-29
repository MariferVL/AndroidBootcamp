package com.android.module2.asesoriasprevencion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {

    /* Preambulo:
     * Mejora en gestión, control, seguridad, y disponibilidad de información para
     * empresa y clientes.
     * Permitir planificación de actividades y
     * Permitir control de ejecución de éstas,
     * Permitir gestión de clientes,
     * Permitir coordinación entre empresa, profesionales y clientes ==>respuesta
     * temprana ante incidentes de seguridad.
     * Genere reportes y estadísticas que ayuden a tomar de decisiones y mejorar
     * rendimiento de empresa,
     * Imprescindible mantener comunicación con profesionales en todo momento,
     * inclusive sin conectividad.
     */

    /* Indicaciones
     * (*) son campos obligatorios.
     * almacenados en una matriz de 100 filas y 10 columnas.
     * c/fila corresponde a un USUARIO, y c/columna es uno de los atributos
     * siguiendo orden.
     * Invocar dos funciones creadas antes, mostrando por pantalla sus valores de
     * retorno.
     */

    static List<List<String>> userData = new ArrayList<List<String>>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Welcome to program
        System.out.println("\r\n\t\t |/|  ¡Bienvenido a Regístrate!  |\\|  ");

        /*Saved: Get users number data
         * System.out.print("\r\nIngrese cantidad de usuarios: ");
         * usersNum = Integer.parseInt(scanner.nextLine());
         */

        int menuOption = 0;
        boolean programON = true;
        while (programON) {
            menuOption = displayMainMenu(scanner);
            switch (menuOption) {
                case 1:
                    // Get data from users.
                    userData.add(
                            getUsersData(scanner, "Perfiles", "1- Cliente", "2- Profesional", "3- Administrativo"));
                    break;
                case 2:
                    if (userData.size() > 0) {
                        // Display users data.
                        printUser(userData);
                    } else {
                        System.out.println("\r\n\t\t ¡! Aún no tenemos usuarios registrados. ");
                    }
                    break;
                case 3:
                    if (userData.size() > 0) {
                        // Display number of users per profile.
                        countUsersType();
                    } else {
                        System.out.println("\r\n\t\t ¡! Aún no tenemos usuarios registrados. ");
                    }
                    break;
                case 4:
                    if (userData.size() > 0) {
                        // Update users data.
                        updateData(scanner);
                    } else {
                        System.out.println("\r\n\t\t ¡! Aún no tenemos usuarios registrados. ");
                    }
                    break;
                case 5:
                    if (userData.size() > 0) {
                        // Delete user.
                        deleteUser(scanner);
                    } else {
                        System.out.println("\r\n\t\t ¡! Aún no tenemos usuarios registrados. ");
                    }
                    break;
                case 6:
                    // Exit program.
                    System.out.println("\r\n\t\t **  Gracias por usar Regístrate  **");
                    System.exit(0);
                    break;
            }
        }
        printUser(userData);
        scanner.close();
    }

    /*Indicaciones:
     * Crear una función que permita registrar usuario.
     * Invocar desde el código principal del algoritmo a la función,
     * crear al menos un usuario de cada tipo.
     */
    // Get users data and Create profiles: customer , professional and manager
    public static List<String> getUsersData(Scanner scanner, String label, String option1, String option2,
            String option3) {
        String input = "";
        List<String> userData = new ArrayList<String>();
        boolean process = true;

        while (process) {
            System.out.println("\r\n\t>" + label + ": ");
            System.out.println("\t>> " + option1);
            System.out.println("\t>> " + option2);
            System.out.println("\t>> " + option3);
            // Use print to enable writing after the tag
            System.out.print("\t>> Opción: ");
            // Get user answer
            input = scanner.nextLine();

            // Get common user data
            userData.addAll(getCommonData(scanner));

            // Get user data by specific profile
            if (input.equals("1")) {
                userData.addAll(4, getCustomerData(scanner));
                process = false;
            } else if (input.equals("2")) {
                userData.addAll(4, getProfessionalData(scanner));
                process = false;

            } else if (input.equals("3")) {
                userData.addAll(4, getManagerData(scanner));
                process = false;

            } else {
                // Print error message if neccesary
                System.out.print("\r\n\t>> ¡! La opción " + input + " no es válida.");
            }
            // Add profile option
            userData.add(input);

        }
        System.out.print("\r\n\t\t>> **  Usuario Registrado  **\r\n");

        return userData;
    }

    // c/usuario ==> nombre (*), fecha de nacimiento y RUN (*).
    // Get common user data.
    public static List<String> getCommonData(Scanner scanner) {
        // Todos requieren:
        List<String> userData = new ArrayList<String>();
        // Get name ==> string
        userData.add(validateData(scanner, 1, "Nombre", 1, 22));

        // Get surname ==> string
        userData.add(validateData(scanner, 1, "Apellido", -1, 22));

        // Get FDN ==> string (dd/mm/aaaa) ==> < 11
        userData.add(validateDate(scanner, "Fecha de Nacimiento (dd/mm/aaaa)"));

        // Get RUN ==> string
        userData.add(validateNumber(scanner, 1, "RUN (sin puntos ni digito verificador)", 1111111, 99999999));

        return userData;
    }

    // • Cliente: dirección (*), teléfono (*), cantidad de empleados.
    //Get customer data.
    public static List<String> getCustomerData(Scanner scanner) {
        List<String> customerData = new ArrayList<String>();
        // Save profile name
        customerData.add("Cliente");

        // Get direccion ==> string
        customerData.add(validateData(scanner, 1, "Dirección", 5, 50));

        // Get telefono ==> string
        customerData.add(validateData(scanner, 1, "Teléfono", 8, 16));

        // Get workers quantity
        customerData.add(validateNumber(scanner, 2, "Cantidad de Empleados", -1, 10000000));

        return customerData;
    }

    // • Profesional: años de experiencia, departamento (*)
    // Get professional data:
    public static List<String> getProfessionalData(Scanner scanner) {
        List<String> professionalData = new ArrayList<String>();

        professionalData.add("Profesional");
        // Get years of experience ==> > -1
        // Chose as a requiered element because it's important for the purposes
        // of registering on occupational safety
        professionalData.add(validateNumber(scanner, 2,  "Años de Experiencia", -1, 100));

        // Get company department ==> string < 20
        professionalData.add(validateData(scanner, 1, "Departamento de Compañía", 4, 20));

        return professionalData;
    }

    // Administrativo: función (*), nombre superior
    // Get manager data:
    public static List<String> getManagerData(Scanner scanner) {
        List<String> managerData = new ArrayList<String>();

        managerData.add("Administrativo");

        // Get rol ==> string < 20
        managerData.add(validateData(scanner, 1, "Cargo/Rol", 2, 20));

        // Get supervisor name==>
        managerData.add(validateData(scanner, 2, "Nombre del Supervisor", -1, 20));

        return managerData;
    }

    // Validate char limit on string inputs ==> method
    public static String validateData(Scanner scanner, int required, String label, int min, int limit) {
        String input = "";
        boolean process = true;

        while (process) {
            // Use print to enable writing after the tag
            System.out.print("\r\n\t>" + label + ": ");
            // last one is number
            input = scanner.nextLine();
            if (required == 2 && input.length() == 0) {
                process = false;
            } else if (input.length() < limit && input.length() > min) {
                input = getCapitalizeCase(input);
                process = false;
            } else if (input.length() <= min || input.length() >= limit){
                // Print error message if neccesary
                System.out.println(
                        "\r\n\t>> ¡! Por favor, ingresa\r\n\t los datos necesarios");
            } 
        }
        return input;
    }

    // Validate number max on int inputs
    public static String validateNumber(Scanner scanner, int required, String label, int min, int max) {
        String inputStr = "";
        boolean process = true;

        while (process) {
            System.out.print("\r\n\t>" + label + ": ");
            inputStr = scanner.nextLine();
            if (required == 1 && inputStr.length() > 0) {
                 if (!onlyDigits(inputStr, inputStr.length())) {
                // Print error message if neccesary
                System.out.println("\r\n\t>> ¡! Por favor, ingresa\r\n\t  sólo números.");
                } else {
                    int input = Integer.valueOf(inputStr);

                    if (input < max && input > min) {
                        process = false;
                    } else {
                        // Print error message if neccesary
                        System.out.println(
                                "\r\n\t>> ¡! Por favor, ingresa\r\n\t  la cantidad de dígitos necesaria");
                    }
                }              
            } else if (required == 1 && inputStr.length() < 1){      
                System.out.println(
                                "\r\n\t>> ¡! Por favor, ingresa correctamente\r\n\tel dato solicitado.");       
            } else {
                process = false;
            }
        }
        return inputStr;
    }
 
    // Capitalize case in strings
    public static String getCapitalizeCase(String input) {
        // Create two substrings from word
        // First substring contains first letter of word
        // Second substring contains remaining letters

        String firstLetter = input.substring(0, 1);
        String remainingLetters = input.substring(1, input.length());

        // Change the first letter to uppercase
        firstLetter = firstLetter.toUpperCase();
        // Change the remaining letter to lower case

        remainingLetters = remainingLetters.toLowerCase();

        // Join the two substrings
        input = firstLetter + remainingLetters;

        return input;
    }

    // Detect numbers in string
    public static boolean onlyDigits(String str, int n) {
        // Traverse the string from start to end
        for (int i = 0; i < n; i++) {

            // Check if character is not a digit between 0-9
            // then return false
            if (str.charAt(i) < '0'
                    || str.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    // Validate Date user inputs.
    public static String validateDate(Scanner scanner, String label) {
        String input = "";
        boolean process = true;

        while (process) {
            System.out.print("\r\n\t>" + label + ": ");
            input = scanner.nextLine();
            if (input.length() > 0) {
                if (input.matches("^((0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|2[0-9])[0-9]{2})$")) {
                    process = false;
                } else {
                    System.out.println(
                            "\r\n\t>> ¡! Por favor, ingresa\r\n\t los datos solicitados");
                }
            } else {
                process = false;
            }
        }
        return input;
    }

    /* Indicaciones:
     * Cree la función “mostrarUsuarios”,
     * que despliega el listado completo de usuarios registrado en la matriz.
     * Solo debe mostrar las filas de la tabla que tienen datos ingresados, las
     * filas “vacías”, para estos efectos, no se consideran como válidas.
     */
    // Display all data saved in console
    public static void printUser(List<List<String>> data) {
        int usersNum = data.size();

        // Print all data collected
        System.out.println("\r\n\t\t |/| Datos Registrados  |\\|  ");
        System.out.println("\r\n  > Total Usuarios Registrados: " + usersNum);
        //  FIXME: double checking
        if (usersNum > 0) {
            for (int i = 0; i < usersNum; i++) {
                System.out.println("  > Usuario " + (i + 1) + ": ");

                // Filter profile data
                for (int j = 0; j < data.get(i).size(); j++) {
                    if (userData.get(i).get(j).length() > 0) {
                        switch (j) {
                            case 0:
                                System.out.println("\t>>Nombre: " + data.get(i).get(0));
                                break;
                            case 1:
                                System.out.println("\t>>Apellido: " + data.get(i).get(1));
                                break;
                            case 2:
                                System.out.println("\t>>Fecha de Nacimiento: " + data.get(i).get(2));
                                break;
                            case 3:
                                System.out.println("\t>>RUN: " + data.get(i).get(3));
                                break;
                        }
                        if (userData.get(i).get(4).equals("Cliente")) {
                            switch (j) {
                                case 5:
                                    System.out.println("\t>>Dirección: " + data.get(i).get(5));
                                    break;
                                case 6:
                                    System.out.println("\t>>Telefono: " + data.get(i).get(6));
                                    break;
                                case 7:
                                    System.out.println("\t>>Cantidad de Empleados: " + data.get(i).get(7));
                                    break;
                            }
                        } else if (userData.get(i).get(4).equals("Profesional")) {
                            switch (j) {
                                case 56:
                                    System.out.println("\t>>Años de Experiencia: " + data.get(i).get(5));
                                    break;
                                case 7:
                                    System.out.println("\t>>Departamento de Compañía: " + data.get(i).get(7));
                                    break;
                            }
                        } else if (userData.get(i).get(4).equals("Administrativo")) {
                            switch (j) {
                                case 5:
                                    System.out.println("\t>>Cargo/Rol: " + data.get(i).get(5));
                                    break;
                                case 6:
                                    System.out.println("\t>>Nombre del Supervisor: " + data.get(i).get(6));
                                    break;
                            }
                        }
                    }
                }
            }
            System.out.println("\r\n\t\t **  Fin de despliegue  ** \r\n ");

        } else {
            System.out.println("\r\n\t\t¡! Sin Usuarios Registrados. \r\n");
        }
    }

    /* Indicaciones:
     * Cree función “contarUsuariosPorCategoria”
     * Entregar resumen indicando tipo de usuario y cantidad asociada a c/u.
     */
    // Count users per profile
    public static void countUsersType() {

        int customers = 0;
        int professionals = 0;
        int managers = 0;
        for (int index = 0; index < userData.size(); index++) {
            switch (userData.get(index).get(4)) {
                case "Cliente":
                    customers++;
                    break;
                case "Profesional":
                    professionals++;
                    break;
                case "Administrativo":
                    managers++;
                    break;
            }
        }

        System.out.println("\r\n\t\t |/| Contabilización Usuarios  |\\|  ");
        System.out.println("\r\n\t\t >> Clientes: " + customers);
        System.out.println("\r\n\t\t >> Profesionales: " + professionals);
        System.out.println("\r\n\t\t >> Administrativos: " + managers);
        System.out.println("\r\n\t\t ** Fin de despliegue **  ");
    }

    /*Indicaciones:
     * Cree la función “modificarUsuario” ==> recibir RUT de usuario.
     * Siempre que usuario exista, pedir nuevamente sus datos, y actualizar posición
     * correspondiente en arreglo.
     */
    // Update user info acording to their RUN and Profile
    public static void updateData(Scanner scanner) {
        System.out.println("\r\n\t\t |/| Actualización de Datos  |\\|  ");
        String run = validateNumber(scanner, 1, "RUN (sin puntos ni digito verificador)", 1111111, 99999999);
        String option = "";
        boolean process = true;

        // iterate through arraylist
        for (int i = 0; i < userData.size(); i++) {
            if (userData.get(i).get(3).equals(run)) {
                System.out.println("List of user: " + userData.get(i));
                while (process) {
                    if (userData.get(i).get(4).equals("Cliente")) {
                        option = displayMenu(scanner, 7, "Escoge dato a cambiar.", "\t>> 1-Nombre",
                                "\t>> 2-Apellido", "\t>> 3-Fecha Nacimiento", "\t>> 4-RUN",
                                "\t>> 5-Dirección", "\t>> 6-Teléfono", "\t>> 7-Cantidad de Empleados");
                    } else if (userData.get(i).get(4).equals("Profesional")) {
                        option = displayMenu(scanner, 6, "Escoge dato a cambiar.", "\t>> 1-Nombre",
                                "\t>> 2-Apellido", "\t>> 3-Fecha Nacimiento", "\t>> 4-RUN",
                                "\t>> 5-Años de Experiencia", "\t>> 6-Departamento de Compañía", "");

                    } else if (userData.get(i).get(4).equals("Administrativo")) {
                        option = displayMenu(scanner, 6, "Escoge dato a cambiar.", "\t>> 1-Nombre",
                                "\t>> 2-Apellido", "\t>> 3-Fecha Nacimiento", "\t>> 4-RUN",
                                "\t>> 5-Cargo/Rol", "\t>> 6-Nombre del Supervisor", "");
                    }
                    switch (option) {
                        case "1":
                            userData.get(i).set(0, validateData(scanner, 1,  "Nombre", 1, 22));
                            break;
                        case "2":
                            userData.get(i).set(1, validateData(scanner, 1, "Apellido", -1, 22));
                            break;
                        case "3":
                            userData.get(i).set(2, validateDate(scanner, "Fecha de Nacimiento (dd/mm/aaaa)"));
                            break;
                        case "4":
                            userData.get(i).set(3, validateNumber(scanner, 1,  "RUN (sin puntos ni digito verificador)",
                                    1111111, 99999999));
                            break;
                        // TODO: Add profile option
                        case "7":
                            userData.get(i).set(7, validateNumber(scanner, 2, "Cantidad de Empleados", -1, 10000000));

                    }
                    String userProfile = userData.get(i).get(4);
                    if (userProfile.equals("Cliente") && option.equals("5")) {
                        userData.get(i).set(5, validateData(scanner, 1, "Dirección", 5, 50));
                    } else if (userProfile.equals("Cliente") && option.equals("6")) {
                        userData.get(i).set(6, validateData(scanner, 1, "Teléfono", 9, 16));
                    } else if (userProfile.equals("Profesional") && option.equals("5")) {
                        userData.get(i).set(5, validateNumber(scanner, 2, "Años de Experiencia", -1, 100));
                    } else if (userProfile.equals("Profesional") && option.equals("6")) {
                        userData.get(i).set(6, validateData(scanner, 1, "Departamento de Compañía", -1, 20));
                    } else if (userProfile.equals("Administrativo") && option.equals("5")) {
                        userData.get(i).set(5, validateData(scanner, 1, "Cargo/Rol", 2, 20));
                    } else if (userProfile.equals("Administrativo") && option.equals("6")) {
                        userData.get(i).set(6, validateData(scanner, 2, "Nombre del Supervisor", -1, 20));
                    }

                    System.out.println("\r\n\t\t **   Datos Actualizados  **  ");

                    // Choose next step
                    String next = displayMenu(scanner, 3, "Escoge opción:", "\t>> 1-Actualizar otro dato",
                            "\t>> 2-Regresar a Menú Principal", "\t>> 3-Salir del Programa", "", "", "", "");
                    if (next.equals("2")) {
                        displayMainMenu(scanner);
                        process = false;
                    } else if (next.equals("3")) {
                        System.out.println("\r\n\t\t **   Gracias por usar Regístrate   ** ");
                        System.exit(0);
                    }
                }
            } else {
                System.out.println("\r\n\t\t ¡! No tenemos usuarios \r\nregistrados con ese RUN. ");
            }
        }
    }

    // Display local menu
    public static String displayMenu(Scanner scanner, int options, String label, String option1, String option2,
            String option3, String option4, String option5, String option6, String option7) {
        System.out.println("\r\n\t |/|  Menú  |\\|  ");
        String answer = "";
        boolean process = true;

        while (process) {
            System.out.println("\r\n\t>" + label + ": ");
            System.out.println(option1);
            System.out.println(option2);
            System.out.println(option3);
            System.out.println(option4);
            System.out.println(option5);
            System.out.println(option6);
            System.out.println(option7);

            // Use print to enable writing after the tag
            System.out.print("\t>> Opción: ");
            // Get user answer
            answer = scanner.nextLine();

            // filter errors
            if (onlyDigits(answer, answer.length())) {
                int answertoInt = Integer.parseInt(answer);
                if (answertoInt <= options) {
                    process = false;
                } else {
                    System.out.println(
                            "\r\n\t>> ¡! Por favor, ingresa\r\n\t sólo el número de tu opción.");
                }
            } else {
                System.out.println(
                        "\r\n\t>> ¡! Por favor, ingresa\r\n\t sólo el número de tu opción.");
            }
        }
        return answer;
    }

/*  Indicaciones:
    Cree la función “eliminarUsuario”
    recibir un RUT, y eliminar usuario desde el arreglo. */
    // Delete user acording to their RUN
    public static void deleteUser(Scanner scanner) {
        System.out.println("\r\n\t\t |/|  Eliminación de Usuarios  |\\|  ");
        String run = validateNumber(scanner, 1, "RUN (sin puntos ni digito verificador)", 1111111, 99999999);
        for (int i = 0; i < userData.size(); i++) {
            if (userData.get(i).get(3).equals(run)) {
                String answer = displayMenu(scanner, 2,"¿Deseas eliminar a " + userData.get(i).get(0) + " " + userData.get(i).get(1) + " RUN " +  userData.get(i).get(3) + " ?", "\t>> 1-Si", "\t>> 2-No", "", "", "", "", "");
                if (answer.equals("1")) {
                    System.out.println("\t>> " + userData.get(i).get(1) + " fue eliminado exitósamente.");
                    userData.remove(userData.get(i));         
                }   
            }      
        }
    }

    /*Menú principal con seis opciones:
     * Registrar usuario, Mostrar usuarios, Contar usuarios por categoría, Modificar
     * usuarios, Eliminar usuario, Salir.
     * Mostrar constantemente. y solicitar nuevamente número.
     * opción correcta, se debe llamar a la función correspondiente.
     */
    // Display Main Menu in Console
     public static int displayMainMenu(Scanner scanner) {

        System.out.println("\r\n\t |/|  Menú Principal  |\\|");
        String answer = "";
        boolean process = true;
        int answertoInt = 0;

        while (process) {
            System.out.println("\t>> 1-Registrar usuario ");
            System.out.println("\t>> 2-Mostrar usuarios ");
            System.out.println("\t>> 3-Total Usarios Por Perfil");
            System.out.println("\t>> 4-Actualizar Datos");
            System.out.println("\t>> 5-Eliminar Usuario");
            System.out.println("\t>> 6-Salir");

            // Use print to enable writing after the tag
            System.out.print("\t>> Opción: ");
            // Get user answer
            answer = scanner.nextLine();

            // filter errors
            if (onlyDigits(answer, answer.length())) {
                answertoInt = Integer.parseInt(answer);
                if (answertoInt < 7) {
                    process = false;
                } else {
                    System.out.println(
                            "\r\n\t>> ¡! Por favor, ingresa\r\n\t sólo el número de tu opción.");
                }
            } else {
                System.out.println(
                        "\r\n\t>> ¡! Por favor, ingresa\r\n\t sólo el número de tu opción.");
            }
        }
        return answertoInt;
    }

}
