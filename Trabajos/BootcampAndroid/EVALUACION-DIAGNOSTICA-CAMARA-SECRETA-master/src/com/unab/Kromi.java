package com.unab;
import java.util.Scanner;
/**
 * @author Luis Zenteno,Barbara Carvajal, María-Fernanda Villalobos
 *
 */
public class Kromi extends Carro {

    String anioFabricacion, marca;

    

    public Kromi(String fechaIngreso, int cantOcupantes, int fila, int columna, String anioFabricacion, String marca) {
        super(fechaIngreso, cantOcupantes, fila, columna);
        this.anioFabricacion = anioFabricacion;
        this.marca = marca;
    }

    public String validarMarca(String mensaje, Scanner sc){

        boolean cond = true;
        String input = "";

        while(cond){

            System.out.println(mensaje);
            input = sc.nextLine();

            if (input.matches("[a-zA-Z]{1,}")){

                

                cond = false;
            }
        }
        return input;

        }

    public String validarAnioFabricacion(String mensaje, Scanner sc){

        String input = "";

        return input;
    }
    }


