package com.unab;

/**
 * @author Luis Zenteno,Barbara Carvajal, María-Fernanda Villalobos
 *
 */
public class Trupalla extends Carro {

    int nivelArmadura;
    String nombre;

    

    public Trupalla(String fechaIngreso, int cantOcupantes, int fila, int columna, int nivelArmadura, String nombre) {
        super(fechaIngreso, cantOcupantes, fila, columna);
        this.nivelArmadura = nivelArmadura;
        this.nombre = nombre;
    }

    public int getNivelArmadura() {
        return nivelArmadura;
    }

    public void setNivelArmadura(int nivelArmadura) {
        this.nivelArmadura = nivelArmadura;
    }

    

   
}

