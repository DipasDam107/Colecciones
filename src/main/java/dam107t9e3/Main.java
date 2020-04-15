/*
 Haz un programa que cree un conjunto HashSet que almacene la lista de personas que van a
una fiesta (de una persona sabemos su nombre, teléfono, email y fecha de nacimiento). Crea en un
archivo aparte la clase Persona con los atributos y métodos que necesites. En el programa introduce
“a mano” unas cuantas personas, y luego muestre la edad media y el nombre del mayor.
    • Intenta hacer una inserción de una persona repetida ¿Qué ocurre? (Dos personas son
    iguales si tienen exactamente el mismo nombre.

    Se produce una colisión y los conjuntos no admiten duplicados.

    • Muestra todos los valores almacenados en el HashSet ¿Tienen algún orden? 

    No hay ordenación. 
 */
package dam107t9e3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;

public class Main {
    static HashSet <Persona> listaPersonas;
    public static void main(String [] args){
        listaPersonas = new HashSet<>();
        listaPersonas.add(new Persona("Pepe", "981622222", "pepe@pepe", LocalDate.parse("1990-01-01")));
        listaPersonas.add(new Persona("Jose", "981622224", "Jose@Jose", LocalDate.parse("1991-01-01")));
        listaPersonas.add(new Persona("Fran", "981622221", "Fran@Fran", LocalDate.parse("1992-01-01")));
        listaPersonas.add(new Persona("Maria", "981622220", "Maria@Maria", LocalDate.parse("1993-01-01")));
        listaPersonas.add(new Persona("Maria", "981622227", "Maria2@Maria2", LocalDate.parse("1997-01-01")));
        
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
