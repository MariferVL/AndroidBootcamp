package com.unab;

/**
 * @author Luis Zenteno,Barbara Carvajal, María-Fernanda Villalobos
 *
 */

// Crear Clase “Carro”(parent class)
public class Carro {

    // Crear variables de instancia
    String fechaIngreso;
    int cantOcupantes, fila, columna;

    // Constructor
    // Atributos: cantidad de ocupantes, fecha de ingreso a institución y ubicación
    // (fila, columna)
       public Carro(String fechaIngreso, int cantOcupantes, int fila, int columna) {
        this.fechaIngreso = fechaIngreso;
        this.cantOcupantes = cantOcupantes;
        this.fila = fila;
        this.columna = columna;
    }



    // Crear métodos get
    public int getCantOcupantes() {
        return cantOcupantes;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    // Crear métodos set
    public void setCantOcupantes(int cantOcupantes) {
        this.cantOcupantes = cantOcupantes;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    // Crear método toString 
    @Override
    public String toString() {
        return("Este carro tiene asientos para "+ this.getCantOcupantes()+
			" ocupantes,\n fue ingresado el " + this.getFechaIngreso()+" y está ubicado\n en la fila " +
             this.getFila()+" columna "+ this.getColumna() + ".");
    }

    //Desplegar datos básicos y coordenadas en el tablero.
    public void desplegarDatos() {
        System.out.println(this.toString());
    }
}
