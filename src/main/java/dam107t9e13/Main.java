/*
    Modifica el programa anterior añadiendo una segunda caja, es decir tener dos colas (el cliente
    se pondrá siempre en la cola que menos gente tenga). Nos interesa mostrar si ya no perdemos
    ningún cliente o al menos es una cifra pequeña. 
 
 */
package dam107t9e13;

import dam107t9e12.*;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner teclado;
    static Random random;
    static final int HORAS = 8;
    static LinkedList<Integer> cola;
    static LinkedList<Integer> cola2;
    static int instanteSiguCliente;
    static int t;

    //la cola contiene los minutos que va a requerir la atención del cajero
    // cuando le toque. Al primero de la cola se le va reduciendo en cada instante.
    public static void main(String[] args) {
        int atendidos = 0, indignados = 0;
        teclado = new Scanner(System.in);
        random = new Random();
        cola = new LinkedList<>();
        cola2 = new LinkedList<>();
        instanteSiguCliente = random.nextInt(5) + 3;

        //un bucle simula los minutos que van pasando
        for (t = 1; t <= HORAS * 60; t++) {
            if (!cola.isEmpty()) {
                //reducir el tiempo de atencion del primero de la lista
                //que es el que está siendo atendido
                cola.set(0, cola.getFirst() - 1);
                //si ese tiempo es cero, acabó de atenderlo. Sale de la cola
                if (cola.getFirst() == 0) {
                    cola.removeFirst();
                    atendidos++;
                }
            }
            
            if (!cola2.isEmpty()) {
                //reducir el tiempo de atencion del primero de la lista
                //que es el que está siendo atendido
                cola2.set(0, cola2.getFirst() - 1);
                //si ese tiempo es cero, acabó de atenderlo. Sale de la cola
                if (cola2.getFirst() == 0) {
                    cola2.removeFirst();
                    atendidos++;
                }
            }
            
            //se añade un nuevo cliente a a la lista (instante aleatorio)
            if (t == instanteSiguCliente) {
                if(cola.size()<5 && cola2.size()<5){
                    if(cola2.size()<cola.size())
                    cola2.addLast(random.nextInt(10) + 3);
                    else if(cola.size()<cola2.size())
                    cola.addLast(random.nextInt(10) + 3);
                    else 
                        cola.addLast(random.nextInt(10) + 3);
                }
                else if(cola.size()<5)
                    cola.addLast(random.nextInt(10) + 3);
                else if(cola2.size()<5)
                    cola2.addLast(random.nextInt(10) + 3);
                else
                    indignados++;
                //se genera el instante de llegada del próximo cliente
                instanteSiguCliente += random.nextInt(5) + 3;
            }
            
        }
        System.out.println("Se han atendido " + atendidos + " clientes");
        System.out.println("Se han ido sin comprar nada " + indignados + " clientes");
    }

    
}
