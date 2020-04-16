/*Realiza un programa que defina un Arraylist de Persona_v3. Añade 5 personas al mismo, pero
una de ellas que esté repetida. Utilizando conversiones entre colecciones (sin iterar sobre el
ArrayList) elimina los repetidos, preservando el orden de los elementos del ArrayList.*/
package dam107t9e18;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static ArrayList<Persona> listaPersonas;

    public static void main(String[] args) {
        listaPersonas = new ArrayList<>();

        listaPersonas.add(new Persona("Pepe", "981622222", "pepe@pepe", LocalDate.parse("1991-01-01")));
        listaPersonas.add(new Persona("Zacarias", "981622227", "Maria2@Maria2", LocalDate.parse("1997-01-01")));
        listaPersonas.add(new Persona("Jose", "981622224", "Jose@Jose", LocalDate.parse("1991-01-01")));
        listaPersonas.add(new Persona("Fran", "981622221", "Fran@Fran", LocalDate.parse("1992-01-01")));
        listaPersonas.add(new Persona("Maria", "981622220", "Maria@Maria", LocalDate.parse("1993-01-01")));
        listaPersonas.add(new Persona("Antonio", "981622227", "ANTONIO@ant", LocalDate.parse("1998-01-01")));
        listaPersonas.add(new Persona("ANTONIO", "981622222", "ANTONIO@ANTONIO", LocalDate.parse("1998-01-01")));
        Collections.sort(listaPersonas);
        imprimir();

        Set<Persona> set = new HashSet<>(listaPersonas);
        if (set.size() == listaPersonas.size()) {
            System.out.println("No hay Duplicados");
        } else {
            System.out.println("Hay Duplicados");
            System.out.println("------------------");
            System.out.println("Lista sin Duplicados");
            System.out.println("------------------");
            listaPersonas = new ArrayList<>(set);
            Collections.sort(listaPersonas);
            imprimir();
        }
    }

    public static void imprimir() {
        for (Persona x : listaPersonas) {
            System.out.println(x);
        }
    }

}
