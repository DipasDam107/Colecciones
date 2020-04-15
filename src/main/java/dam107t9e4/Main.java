/*
    Repite el ejercicio anterior con un LinkedHashSet ¿Qué ha cambiado? 
    
    El array esta ordenado segun el orden de inserción

 */
package dam107t9e4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashSet;

public class Main {
    static LinkedHashSet <Persona> listaPersonas;
    public static void main(String [] args){
        listaPersonas = new LinkedHashSet<>();
        listaPersonas.add(new Persona("Pepe", "981622222", "pepe@pepe", LocalDate.parse("1990-01-01")));
        listaPersonas.add(new Persona("Jose", "981622224", "Jose@Jose", LocalDate.parse("1991-01-01")));
        listaPersonas.add(new Persona("Fran", "981622221", "Fran@Fran", LocalDate.parse("1992-01-01")));
        listaPersonas.add(new Persona("Maria", "981622220", "Maria@Maria", LocalDate.parse("1993-01-01")));
        listaPersonas.add(new Persona("Maria", "981622227", "Maria2@Maria2", LocalDate.parse("1997-01-01")));
        listaPersonas.add(new Persona("PEPE", "981622227", "pep@pep", LocalDate.parse("1997-01-01")));
        
        for(Persona x : listaPersonas){
            System.out.println(x);
        }
        
        System.out.println(mayor());
        System.out.println("La edad media es : " + media());
    }
    
    public static String mayor(){
        String nombre = null;
        int edadMayor=0;
        for(Persona x : listaPersonas){
            int edad = (int) ChronoUnit.YEARS.between(x.fecNac, LocalDate.now());
            if(nombre==null || edad > edadMayor){
                nombre=x.nombre;
                edadMayor=edad;
            }
        }
        
        return "El mayor es " + nombre + ". Edad: " + edadMayor;
    }
    public static double media(){
        int total=0;
        for(Persona x : listaPersonas){
            total+=(int) ChronoUnit.YEARS.between(x.fecNac, LocalDate.now());
        }
        return (double)total/(double)listaPersonas.size();
    }   
}
