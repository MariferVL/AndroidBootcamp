package com.android.module2.evaluaciondiagnostica_poo;

public class main {
    
}
// TODO: sistema de votación para sus leyes
//  FirstLine , superheroes
// PKS, grupo que contempla Kromis, caguanos, trupallas
// TODO: Kromis: largo de tres metros cada una,utilizadas para transportar efectivos de PKS.
// TODO:Caguanos:c/u mide dos metros de largo, lanzar confetis y dulces aquienes protestan.
// TODO:Trupallas: efectivos cibernéticos con tecnología de punta, c/u ocupa metro cuadrado de espacio, opresores de manifestantes 
// TODO: Programa que simule posiciones de efectivos alrededor de Cámara Secreta, y  coordinar acciones previas a invasión.
// TODO: Simular matriz compuesta de caracteres con 15 filas y 15 columnas
// TODO: Dispuestos de forma aleatoria:
//TODO: 3 Kromis, c/u utiliza 3 celdas de matriz y siempre de forma vertical. 
//TODO: 1 vehículo por c/celda  => letra “K”.
//TODO: Caguanos, siempre horizontalmente==>letra“C” y usa 2 espacios.
//TODO:10 Trupallas 1 celda ==> letra “T”.
//TODO: situar de forma aleatoria la cantidad de vehículos antes indicados. 
//TODO: Se recomienda hacerlo en el orden antes mencionado, pero no es obligación. 
//TODO: No pueden existir vehículos encima de otros.
//TODO: Calcular una fila y columna de forma aleatoria (N° en rango definido).
//TODO: Validar que celda esté vacía antes de agregar.
// TODO: Obtener otro par de coordenadas de forma aleatoria si está ocupada
//TODO:Agregar Kromi, escribiendo 3 celdas hacia abajo contando desde la celda obtenida, 
//TODO:Agregar Caguano escribiendo 2 celdas hacia el lado (de izquierda a derecha), 
//TODO: Agregar Trupalla con coordenada obtenida,solo usa una celda.
//TODO: Validar que se agregue dentro de matriz
// TODO: Solicitar otra fila y columna si quedase fuera de rango
// TODO: Manifestantes==> Arsenal Ilimitado de huevos: método de defensa frente a PKS. 
// TODO: Metodo: lanzar libremente dentro del espacio considerado. 
        // TODO: Solicitar a usuario que ingrese un N° de fila y N° de columna,
        // TODO:Valudar ambos números
// TODO: Verificar si en la matriz está ubicado un vehículo o no:
// TODO: Dar puntaje: proyectil da sobre una Kromi = 3 puntos, sobre Caguano= 2puntos, sobre Trupalla = 1 punto.
// TODO: Puntajes :Kromi con 3 celdas atacadas (inutilizada) =  10 puntos adicionales. 
// TODO:Puntajes: utilizar Caguano = 7 puntos adicionales.
// TODO:Puntajes:Trupalla queda inutilizado con 1 huevo ==> sin puntaje adicional
// TODO: Atributo: cantidad ilimitada de huevos a lanzar, huevo puede caer más de una vez sobre misma posición.
// TODO: Puntajes :celda atacada  == “H” en matriz. 
// TODO: Puntajes:  Celda atacada previamente NO da puntaje.
// TODO: Indicar el puntaje total obtenido por el usuario al finalizar programa.
// TODO: Crear Clase “Carro”(parent class)
// TODO: Atributos:  cantidad de ocupantes,  fecha de ingreso a  institución y su ubicación (fila, columna) en tablero virtual de 15x15 
// TODO:(se recomienda registrar la fila y columna en atributos independientes).
// TODO:Métodos: desplegar datos básicos y coordenadas en el tablero.
// TODO: Crear Clase “Kromi” (child class) 
// TODO: Atributo: año de fabricación y su marca.
// TODO:Crear Clase “Caguano” (child class) 
// TODO: Atributo: alcance de tiro, y color de confeti que arroja.
// TODO: Crear Clase “Trupalla” (child class) 
// TODO: Atributos: nivel de armadura (entero entre 1 a 5) y nombre de persona que manipula.
// TODO: Crear Clase “Huevo”:define cada lanzamiento realizado dentro del tablero.
// TODO: Atributos:  fila donde cayó el proyectil,  columna y  puntaje obtenido en lanzamiento.
// TODO: Crear Clase “Tablero”: representa terreno donde se ubica cada carro y ubicación de proyectiles. 
// TODO: 2 Atributos: 1 lista de instancias de clase “Carro” y 1 lista de instancias de clase “Huevo”; 
// TODO:Lista 1 ==> más de 18 elementos, 2nda lista sin límites de instancias a crear.
// TODO: Métodos:  Crear Carro: crea una subclase de clase Carro 
// TODO: Métodos: Asignar a lista respectiva. 
// TODO: Métodos: Lanzar Huevo: crea una instancia de la clase “Huevo”, solicita la coordenada de
//lanzamiento, asigna el puntaje al movimiento y almacena en listado correspondiente.
// TODO: Métodos: Mostrar Matriz: mostrar en forma de matriz c/u de los carros existentes y lanzamientos 
//registrados. 
// TODO: Métodos: Calcular puntaje obtenido hasta el momento. Suma puntajes asignados a c/lanzamiento y entrega como
// resultado. Método sólo de la clase
// TODO:  Crear métodos set, get y toString en todas las clases
// TODO: Crear constructor apropiado en todas las clases.
// TODO: Crear otras clases si es necesario
// TODO: Crear menú que despliegue acciones que contempla programa, y mostrar hasta que usuario salga del programa.
// TODO: Considerar POO: Estructura de clases y superclases, conceptos de herencia y polimorfismos.
// TODO: Implementar la mayor cantidad de conceptos vistos en cada una de las clases
// TODO: Evitar la copia de código directo, tanto de Internet como de pares.
// TODO: Se valorará la participación y el trabajo colaborativo.
// TODO: Revisión se realizará durante clases.
// TODO: Duración máxima de 3 clases. 
// TODO: Se revisará en uno de los equipos de los participantes