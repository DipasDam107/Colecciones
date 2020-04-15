/*
    Realizar un programa que genera un array con las temperaturas medias de una ciudad para
    todos los días de un año no bisiesto. La temperatura será un entero entre 10 y 30 grados. 
    Ayudándote de un TreeMap, muestra la temperatura mínima y cuantas ocurrencias tuvo y la
    temperatura máxima y cuantas ocurrencias tuvo. 
 */
package dam107t9e9;

import dam107t9e8.*;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    static Scanner teclado;
    static TreeMap<Integer, Integer> temperaturas;

    public static void main(String[] args) {
        teclado = new Scanner(System.in);
        temperaturas = new TreeMap<>();
        rellenar();
        imprimir();
        
        
        System.out.println("----------------------------------------------------------");
        System.out.println("La temperatura minima es " + MinTemp() + " Ocurrencias: " + temperaturas.get(MinTemp()));
        System.out.println("La temperatura maxima es " + MaxTemp() + " Ocurrencias: " + temperaturas.get(MaxTemp()));

    }

    public static void rellenar() {
        int anio;
        LocalDate fecha;
        do{
            System.out.println("Dime año: ");
            anio = teclado.nextInt();
            fecha = LocalDate.of(anio, 1, 1);
            if(fecha.isLeapYear())
                System.out.println("El año no debe ser bisiesto");
        }while(fecha.isLeapYear());
        
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
    public static Integer MaxTemp(){
        return temperaturas.lastKey();
    }
    public static Integer MinTemp(){
        return temperaturas.firstKey();
    }
    
    
    
}
