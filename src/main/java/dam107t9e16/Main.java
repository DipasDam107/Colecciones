/*Modifica la clase Persona_v2 (llámale Persona_v3) para que cualquier colección, por defecto,
ordene las personas por su DNI. Crea un programa que cree TreeSet (es un conjunto ordenado) en
el que se introduzcan “a mano” unas cuantas personas y a continuación las muestre con un for…each.
Comprueba en qué orden muestra las personas. Pista: LocalDate tiene un método compareTo()*/
package dam107t9e16;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class Main {
    static TreeSet <Persona> listaPersonas;
    public static void main(String [] args){
        listaPersonas = new TreeSet<>();
        
        listaPersonas.add(new Persona("Pepe", "981622222", "pepe@pepe", LocalDate.parse("1990-01-01")));
        listaPersonas.add(new Persona("Zacarias", "981622227", "Maria2@Maria2", LocalDate.parse("1997-01-01")));
        listaPersonas.add(new Persona("Jose", "981622224", "Jose@Jose", LocalDate.parse("1991-01-01")));
        listaPersonas.add(new Persona("Fran", "981622221", "Fran@Fran", LocalDate.parse("1992-01-01")));
        listaPersonas.add(new Persona("Maria", "981622220", "Maria@Maria", LocalDate.parse("1993-01-01")));
        listaPersonas.add(new Persona("Antonio", "981622227", "Maria2@Maria2", LocalDate.parse("1998-01-01")));

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
