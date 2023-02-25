package com.unab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Luis Zenteno,Barbara Carvajal, María-Fernanda Villalobos
 *
 */

// Clase “Tablero”: representa terreno en que se ubica cada carro y proyectiles.
public class Tablero {

    // Crear 2 atributos: un arreglo de instancias de “Carro”(<19 elementos) y un
    // arreglo de instancias de “Huevo”(ilimitado)
    Carro[] matrizCarro = new Carro[18];
    ArrayList<Huevo> listaHuevo = new ArrayList<Huevo>();
    int conteoHuevos = 0;
    // tablero
    String[][] matrizTablero = new String[16][16];
    String[][] matrizControl = new String[16][16];
    // Crear instancia de clase “Huevo”,
   

    // Calcular coordenadas del carro de forma aleatoria sin traslaparse entre si.
    // fila y columna aleatorio
    Random numRandom = new Random();

    String[] columnas = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o" };

    // Puntajes Lanzamientos
    final int kromi = 3;
    final int caguano = 2;
    final int trupalla = 1;

    // Puntajes Adicionales por destrucción total
    final int kromiFatality = 10;
    final int caguanoFatality = 7;

    // Puntaje Total
    int puntajeTotal = 0;
    int filaSH, colSH;
    private int puntajeInstancia;

    // Crear una subclase de clase Carro y asignar a lista respectiva.
    public void crearCarro() {

        // TODO: Validar choque de carros
        matrizCarro[0] = new Kromi("12-02-2000", 2, numRandom.nextInt(12) + 1, numRandom.nextInt(14) + 1, "1998",
                "Mercedes");
        matrizCarro[1] = new Kromi("13-08-1993", 2, numRandom.nextInt(12) + 1, numRandom.nextInt(14) + 1, "1993",
                "Toyota");
        matrizCarro[2] = new Kromi("12-09-2020", 1, numRandom.nextInt(12) + 1, numRandom.nextInt(14) + 1, "2000",
                "BMW");

        matrizCarro[3] = new Caguano("12-04-2000", 3, numRandom.nextInt(14) + 1, numRandom.nextInt(13) + 1, "200",
                "naranja");
        matrizCarro[4] = new Caguano("15-09-2010", 3, numRandom.nextInt(14) + 1, numRandom.nextInt(13) + 1, "100",
                "rojo");
        matrizCarro[5] = new Caguano("15-05-2002", 2, numRandom.nextInt(14) + 1, numRandom.nextInt(13) + 1, "300",
                "rosa");
        matrizCarro[6] = new Caguano("17-03-2005", 5, numRandom.nextInt(14) + 1, numRandom.nextInt(13) + 1, "150",
                "celeste");
        matrizCarro[7] = new Caguano("03-05-2005", 6, numRandom.nextInt(14) + 1, numRandom.nextInt(14) + 1, "230",
                "negro");

        matrizCarro[8] = new Trupalla("03-05-2005", 3, numRandom.nextInt(14) + 1, numRandom.nextInt(14) + 1, 0,
                "trupalla1");
        matrizCarro[9] = new Trupalla("03-05-2005", 4, numRandom.nextInt(14) + 1, numRandom.nextInt(14) + 1, 0,
                "trupalla2");
        matrizCarro[10] = new Trupalla("03-05-2005", 5, numRandom.nextInt(14) + 1, numRandom.nextInt(14) + 1, 0,
                "trupalla3");
        matrizCarro[11] = new Trupalla("03-05-2005", 2, numRandom.nextInt(14) + 1, numRandom.nextInt(14) + 1, 0,
                "trupalla4");
        matrizCarro[12] = new Trupalla("03-05-2005", 3, numRandom.nextInt(14) + 1, numRandom.nextInt(14) + 1, 0,
                "trupalla5");
        matrizCarro[13] = new Trupalla("03-05-2005", 1, numRandom.nextInt(14) + 1, numRandom.nextInt(14) + 1, 0,
                "trupalla6");
        matrizCarro[14] = new Trupalla("03-05-2005", 2, numRandom.nextInt(14) + 1, numRandom.nextInt(14) + 1, 0,
                "trupalla7");
        matrizCarro[15] = new Trupalla("03-05-2005", 3, numRandom.nextInt(14) + 1, numRandom.nextInt(14) + 1, 0,
                "trupalla8");
        matrizCarro[16] = new Trupalla("03-05-2005", 4, numRandom.nextInt(14) + 1, numRandom.nextInt(14) + 1, 0,
                "trupalla9");
        matrizCarro[17] = new Trupalla("03-05-2005", 2, numRandom.nextInt(14) + 1, numRandom.nextInt(14) + 1, 0,
                "trupalla10");

    }

    public void crearTablero() {
        for (int i = 1; i < matrizTablero.length; i++) {
            matrizTablero[0][0] = "   ";
            matrizTablero[0][i] = columnas[i - 1] + " ";

            for (int celdas = 1; celdas < matrizTablero[i].length; celdas++) {
                if (celdas > 9) {
                    matrizTablero[celdas][0] = Integer.toString(celdas);
                } else {
                    matrizTablero[celdas][0] = " " + Integer.toString(celdas);
                }
                matrizTablero[i][celdas] = "  ";
            }
        }
    }

    public void tableroFalso() {

        for (int i = 1; i < matrizControl.length; i++) {
            matrizControl[0][0] = "   ";
            matrizControl[0][i] = columnas[i - 1] + " ";

            for (int celdas = 1; celdas < matrizControl[i].length; celdas++) {
                if (celdas > 9) {
                    matrizControl[celdas][0] = Integer.toString(celdas);
                } else {
                    matrizControl[celdas][0] = " " + Integer.toString(celdas);
                }
                matrizControl[i][celdas] = "  ";
            }

            matrizControl[matrizCarro[0].fila][matrizCarro[0].columna] = " K";
            matrizControl[matrizCarro[0].fila + 1][matrizCarro[0].columna] = " K";
            matrizControl[matrizCarro[0].fila + 2][matrizCarro[0].columna] = " K";

            matrizControl[matrizCarro[1].fila][matrizCarro[1].columna] = " K";
            matrizControl[matrizCarro[1].fila + 1][matrizCarro[1].columna] = " K";
            matrizControl[matrizCarro[1].fila + 2][matrizCarro[1].columna] = " K";

            matrizControl[matrizCarro[2].fila][matrizCarro[2].columna] = " K";
            matrizControl[matrizCarro[2].fila + 1][matrizCarro[2].columna] = " K";
            matrizControl[matrizCarro[2].fila + 2][matrizCarro[2].columna] = " K";

            matrizControl[matrizCarro[3].fila][matrizCarro[3].columna] = " C";
            matrizControl[matrizCarro[3].fila][matrizCarro[3].columna + 1] = " C";
            matrizControl[matrizCarro[4].fila][matrizCarro[4].columna] = " C";
            matrizControl[matrizCarro[4].fila][matrizCarro[4].columna + 1] = " C";
            matrizControl[matrizCarro[5].fila][matrizCarro[5].columna] = " C";
            matrizControl[matrizCarro[5].fila][matrizCarro[5].columna + 1] = " C";
            matrizControl[matrizCarro[6].fila][matrizCarro[6].columna] = " C";
            matrizControl[matrizCarro[6].fila][matrizCarro[6].columna + 1] = " C";
            matrizControl[matrizCarro[7].fila][matrizCarro[7].columna] = " C";
            matrizControl[matrizCarro[7].fila][matrizCarro[7].columna + 1] = " C";

            matrizControl[matrizCarro[8].fila][matrizCarro[8].columna] = " T";
            matrizControl[matrizCarro[9].fila][matrizCarro[9].columna] = " T";
            matrizControl[matrizCarro[10].fila][matrizCarro[10].columna] = " T";
            matrizControl[matrizCarro[11].fila][matrizCarro[11].columna] = " T";
            matrizControl[matrizCarro[12].fila][matrizCarro[12].columna] = " T";
            matrizControl[matrizCarro[13].fila][matrizCarro[13].columna] = " T";
            matrizControl[matrizCarro[14].fila][matrizCarro[14].columna] = " T";
            matrizControl[matrizCarro[15].fila][matrizCarro[15].columna] = " T";
            matrizControl[matrizCarro[16].fila][matrizCarro[16].columna] = " T";
            matrizControl[matrizCarro[17].fila][matrizCarro[17].columna] = " T";
        }
    }

    // Solicitar coordenada de lanzamiento,asigna el puntaje al movimiento y la
    // almacena en el listado correspondiente.
    public void lanzarHuevo(Scanner scanner) {

        Huevo superHuevo = new Huevo(0, 0, 0);
        listaHuevo.add(superHuevo);
        puntajeInstancia = 0;
        boolean condCoordenada = true;
        String input = "";
        while (condCoordenada) {
            System.out.print("> Ingresa Fila y columna que deseas atacar (Ej: a1): ");
            input = scanner.nextLine();
            // validacion
            if (input.matches("^[a-no-o&&[^ñÑ]](1[0-5]|[1-9])$")) {
                condCoordenada = false;
            } else {
                System.out.println("Coordenadas invalidas... ¡intenta otra vez!");
            }

        }
        String colAtaque = input.substring(0, 1);
        int filaAtaque = Integer.parseInt(input.substring(1));
        superHuevo.setFila(filaAtaque);
        filaSH = superHuevo.getFila();

        for (String letra : columnas) {
            if (colAtaque.equals(letra)) {
                superHuevo.setColumna(findIndex(columnas, colAtaque) + 1);
                colSH = superHuevo.getColumna();
            }
        }

        String celdaAtacar = matrizControl[filaSH][colSH];
        if (celdaAtacar.equals(" H")) {
            System.out.println(" La ubicación '" + input + "' ya había sido masacrada con el SuperHuevo");
            System.out.println(" ¡Intenta nuevamente!");
        } else if (celdaAtacar.equals(" T") || celdaAtacar.equals(" K") || celdaAtacar.equals(" C")) {
            calcularPuntaje(superHuevo);
            matrizTablero[filaSH][colSH] = " H";
            matrizControl[filaSH][colSH] = " H";
        } else {
            matrizTablero[filaSH][colSH] = " H";
            matrizControl[filaSH][colSH] = " H";
            System.out.println(" No le achuntaste :´( ");
            System.out.println(" Enfoca el ojo y DALE!");

        }
        mostrarMatriz();


    }

    // Obtener indice de arreglo.
    public int findIndex(String arr[], String t) {
        int index = Arrays.binarySearch(arr, t);
        return (index < 0) ? -1 : index;
    }

    // Mostrar carros existentes y lanzamientos registrados(“H”).
    public boolean mostrarMatriz() {

        System.out.println("\r\n\t\tPuntaje Total: " + puntajeTotal);
        boolean game_on = true;
        if (puntajeTotal == 122 ) {
            System.out.println("\r\n\t\t¡ARRASASTE!");
            System.out.println("\tLograste destruir todos los PKS.");     
            System.out.println("\r\n\t\tPuntaje Final: " + puntajeTotal);
            System.out.println("\t\tJuego Terminado.");
            game_on = false;
        } else {
            for (String[] fila : matrizTablero) {
                String filaStr = String.join(" ", fila);
                System.out.println(filaStr);
            }
            System.out.println("\r\n\t\tPuntaje Total: " + puntajeTotal);
           
        }
        return game_on;



    }

    // Controlar jugadas entre lanzamientos y carros
    public void mostrarMatrizControl() {
        for (String[] fila : matrizControl) {
            String filaStr = String.join(" ", fila);
            System.out.println(filaStr);
        }

    }

    // Calcular puntaje por cada lanzamiento y mostrar resultado.
    public void calcularPuntaje(Huevo superHuevo) {

        String celdaAtacar = matrizControl[filaSH][colSH];

        String carro = "";
        if (celdaAtacar.equals(" T")) {
            superHuevo.setPuntajeLanzamiento(trupalla);
            System.out.println("Puntaje T : " + superHuevo.getPuntajeLanzamiento());
            System.out.println("¡Genial! Le diste a un Trupalla con tu SuperHuevo");

        } else if (celdaAtacar.equals(" K")) {
            carro = "Kromi";
            superHuevo.setPuntajeLanzamiento(kromi);
            System.out.println("Puntaje K : " + superHuevo.getPuntajeLanzamiento());

            if (filaSH == 15) {
                // Celdas verticales
                String kromiArriba1 = matrizControl[filaSH - 2][colSH];
                String kromiArriba2 = matrizControl[filaSH - 1][colSH];

                if ((kromiArriba1.equals(" H") && kromiArriba2.equals(" H"))) {
                    puntajeInstancia = superHuevo.getPuntajeLanzamiento() + kromiFatality;
                    superHuevo.setPuntajeLanzamiento(puntajeInstancia);
                    System.out.println("\r\nFatality!");
                    System.out.println("¡Felicitaciones! Terminaste de destruir un " + carro + ".\r\n");

                } else {
                    System.out.println("¡Genial! Le diste a un " + carro + " con tu SuperHuevo");
                }

            } else if (filaSH == 1) {
                String kromiAbajo1 = matrizControl[filaSH + 1][colSH];
                String kromiAbajo2 = matrizControl[filaSH + 2][colSH];
                if (kromiAbajo1.equals(" H") && kromiAbajo2.equals(" H")) {
                    puntajeInstancia = superHuevo.getPuntajeLanzamiento() + kromiFatality;
                    superHuevo.setPuntajeLanzamiento(puntajeInstancia);
                    System.out.println("\r\nFatality!");
                    System.out.println("¡Felicitaciones! Terminaste de destruir un " + carro + ".\r\n");

                } else {
                    System.out.println("¡Genial! Le diste a un " + carro + " con tu SuperHuevo");
                }
            } else if (filaSH == 2 || filaSH == 14) {
                String kromiAbajo1 = matrizControl[filaSH + 1][colSH];
                String kromiArriba2 = matrizControl[filaSH - 1][colSH];
                if ((kromiAbajo1.equals(" H") && kromiArriba2.equals(" H"))) {
                    puntajeInstancia = superHuevo.getPuntajeLanzamiento() + kromiFatality;
                    superHuevo.setPuntajeLanzamiento(puntajeInstancia);
                    System.out.println("\r\nFatality!");
                    System.out.println("¡Felicitaciones! Terminaste de destruir un " + carro + ".\r\n");

                } else {
                    System.out.println("¡Genial! Le diste a un " + carro + " con tu SuperHuevo");
                }

            } else {
                String kromiArriba1 = matrizControl[filaSH - 2][colSH];
                String kromiArriba2 = matrizControl[filaSH - 1][colSH];
                String kromiAbajo1 = matrizControl[filaSH + 1][colSH];
                String kromiAbajo2 = matrizControl[filaSH + 2][colSH];
                if ((kromiAbajo1.equals(" H") && kromiArriba2.equals(" H"))
                        || (kromiArriba1.equals(" H") && kromiArriba2.equals(" H"))
                        || (kromiAbajo1.equals(" H") && kromiAbajo2.equals(" H"))) {
                    puntajeInstancia = superHuevo.getPuntajeLanzamiento() + kromiFatality;
                    superHuevo.setPuntajeLanzamiento(puntajeInstancia);
                    System.out.println("\r\nFatality!");
                    System.out.println("¡Felicitaciones! Terminaste de destruir un " + carro + ".\r\n");

                } else {
                    System.out.println("¡Genial! Le diste a un " + carro + " con tu SuperHuevo");
                }
            }

        } else {
            carro = "Caguano";
            superHuevo.setPuntajeLanzamiento(caguano);
            System.out.println("Puntaje C : " + superHuevo.getPuntajeLanzamiento());

            if (colSH == 15) {
                // Celdas horizontales
                String caguanoIzq = matrizControl[filaSH][colSH - 1];
                if (caguanoIzq.equals(" H")) {
                    puntajeInstancia = superHuevo.getPuntajeLanzamiento() + caguanoFatality;
                    superHuevo.setPuntajeLanzamiento(puntajeInstancia);
                    System.out.println("\r\nFatality!");
                    System.out.println("¡Felicitaciones! Terminaste de destruir un " + carro + ".\r\n");
                } else {
                    System.out.println("¡Genial! Le diste a un " + carro + " con tu SuperHuevo");
                }
            } else if (colSH == 1) {
                String caguanoDer = matrizControl[filaSH][colSH + 1];
                if (caguanoDer.equals(" H")) {
                    puntajeInstancia = superHuevo.getPuntajeLanzamiento() + caguanoFatality;
                    superHuevo.setPuntajeLanzamiento(puntajeInstancia);
                    System.out.println("\r\nFatality!");
                    System.out.println("¡Felicitaciones! Terminaste de destruir un " + carro + ".\r\n");
                } else {
                    System.out.println("¡Genial! Le diste a un " + carro + " con tu SuperHuevo");
                }
            } else {
                String caguanoDer = matrizControl[filaSH][colSH + 1];
                String caguanoIzq = matrizControl[filaSH][colSH - 1];
                if (caguanoIzq.equals(" H") || caguanoDer.equals(" H")) {
                    puntajeInstancia = superHuevo.getPuntajeLanzamiento() + caguanoFatality;
                    superHuevo.setPuntajeLanzamiento(puntajeInstancia);
                    System.out.println("\r\nFatality!");
                    System.out.println("¡Felicitaciones! Terminaste de destruir un " + carro + ".\r\n");
                } else {
                    System.out.println("¡Genial! Le diste a un " + carro + " con tu SuperHuevo");
                }
            }
        }
        for (Huevo huevo1 : listaHuevo) {
            puntajeTotal +=huevo1.getPuntajeLanzamiento();  
        }
    }

    // Crear getter y setter por cada clase
    public Carro[] getMatrizCarro() {
        return matrizCarro;
    }

    public void setMatrizCarro(Carro[] matrizCarro) {
        this.matrizCarro = matrizCarro;
    }

    public ArrayList<Huevo> getListaHuevo() {
        return listaHuevo;
    }

    public void setListaHuevo(ArrayList<Huevo> listaHuevo) {
        this.listaHuevo = listaHuevo;
    }

    public String[][] getMatrizTablero() {
        return matrizTablero;
    }

    public void setMatrizTablero(String[][] matrizTablero) {
        this.matrizTablero = matrizTablero;
    }

    public String[][] getMatrizControl() {
        return matrizControl;
    }

    public void setMatrizControl(String[][] matrizControl) {
        this.matrizControl = matrizControl;
    }

    public Random getNumRandom() {
        return numRandom;
    }

    public void setNumRandom(Random numRandom) {
        this.numRandom = numRandom;
    }

    public String[] getColumnas() {
        return columnas;
    }

    public void setColumnas(String[] columnas) {
        this.columnas = columnas;
    }

    public int getKromi() {
        return kromi;
    }

    public int getCaguano() {
        return caguano;
    }

    public int getTrupalla() {
        return trupalla;
    }

    public int getKromiFatality() {
        return kromiFatality;
    }

    /**
     * @return
     */
    public int getCaguanoFatality() {
        return caguanoFatality;
    }
}