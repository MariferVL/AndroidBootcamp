package com.android.module2;

public class ValidacionVerdad {
    public static void main(String[] args) {
        // a) V1 = ((‘A’ > ‘B’) O (Largo(‘Hola mundo’) = 10))
        // V1= error
        // < o > no están definidos para argumentos tipo String

        // b) V2 = No((5 + 2) < 7) Y No((7 > 9) O (3 < 5) Y (4 = 3))
        // V2 = true

        // c) V3 = ((2 * 3 + 5 -7) > (2 * (2 + 5)) O ((10 – 5) < 20)
        // V3 = true

        if ("A" > "B" || ("Hola mundo").length() == 10) {
        System.out.println("\r\n V1 es verdadero.");
        } else {
        System.out.println("\r\n V1 es falso.");
        }

        if (!((5 + 2) < 7) && !((7 > 9) || (3 < 5) && (4 == 3))) {
            System.out.println("\r\n   V2 es verdadero.");
        } else {
            System.out.println("\r\n   V2 es falso.");
        }

        if ((2 * 3 + 5 - 7) > (2 * (2 + 5)) || ((10 - 5) < 20)) {
            System.out.println("\r\n   V3 es verdadero.");
        } else {
            System.out.println("\r\n   V3 es falso.");
        }
    }

}
