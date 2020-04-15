/*
    Realizar un programa al que se le introduzca un año y genera un array con las temperaturas
    medias de una ciudad para todos los días de ese año (365 ó 366). La temperatura será un entero
    entre 10 y 30 grados. Almacena en un Mapa y la distribución de temperaturas, es decir, para cada
    temperatura, cuantos días del año la hubo y muestra dicha distribución. 

 */
package dam107t9e8;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    static Scanner teclado;
    static HashMap<Integer, Integer> temperaturas;

    public static void main(String[] args) {
        teclado = new Scanner(System.in);
        temperaturas = new HashMap<>();
        rellenar();
        imprimir();

    }

    public static void rellenar() {
        int anio;
        System.out.println("Dime año: ");
        anio = teclado.nextInt();
        LocalDate fecha = LocalDate.of(anio, 1, 1);
        do {
            int temp = (int) (Math.random() * 21) + 10;
            if (!temperaturas.containsKey(temp)) {
                temperaturas.put(temp, 1);
            } else {
                temperaturas.put(temp, temperaturas.get(temp) + 1);
            }

            fecha = fecha.plusDays(1);
        } while (fecha.getYear() == anio);
    }

    public static void imprimir() {

        Iterator<Integer> temps = temperaturas.keySet().iterator();
        while (temps.hasNext()) {
            int temp = temps.next();
            System.out.println("Temperatura: " + temp + " Repeticiones: " + temperaturas.get(temp));

        }

    }
}
