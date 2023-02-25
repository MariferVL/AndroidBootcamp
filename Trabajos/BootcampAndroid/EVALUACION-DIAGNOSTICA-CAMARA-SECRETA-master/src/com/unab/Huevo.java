package com.unab;

/**
 * @author Luis Zenteno,Barbara Carvajal, María-Fernanda Villalobos
 *
 */
 // Clase “Huevo”: define cada lanzamiento realizado dentro del tablero.
public class Huevo {

    int fila, columna, puntajeLanzamiento;

    public Huevo(int fila, int columna, int puntajeLanzamiento) {
        this.fila = fila;
        this.columna = columna;
        this.puntajeLanzamiento = puntajeLanzamiento;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public int getFila() {
        return fila;
    }

    public int getPuntajeLanzamiento() {
        return puntajeLanzamiento;
    }

    public void setPuntajeLanzamiento(int puntajeLanzamiento) {
        this.puntajeLanzamiento = puntajeLanzamiento;
    }

}


