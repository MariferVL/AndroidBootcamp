package com.android.module2.clasePOO;

import java.lang.reflect.Constructor;

public class Calculadora {

    /* Atributos */
    private int numero1;
    private int numero2;
/* 
    public Calculadora(){

    } */

    public Calculadora( int numero1, int numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;

}



    public static void main(String[] args) {
        Calculadora calc = new Calculadora(2,3);
        
        
    }
    
}
