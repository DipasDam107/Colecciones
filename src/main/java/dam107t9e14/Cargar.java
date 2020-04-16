package dam107t9e14;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Cargar {

    public static TreeMap <String, Pais> Cargar(){
        TreeMap <String, Pais> lista = new TreeMap<>();
        String linea = "";
        try (FileReader fr = new FileReader("./src/main/java/Archivos/paises2019.csv");
                Scanner sc = new Scanner(fr)) {

            while (sc.hasNextLine()) {
                linea = sc.nextLine();
                Scanner scLinea = new Scanner(linea);
                //Indicamos cual es el caracter utilizado para saparar los campos
                scLinea.useDelimiter(";");
                //Preguntamos por si no viene bien formado o sin datos
                if (scLinea.hasNext()) {
                    String Pais = scLinea.next();
                    String Ciudad = scLinea.next();
                    int habitantes = scLinea.nextInt();
                    
                    lista.put(Pais, new Pais(Ciudad, habitantes));
                    
                }
            }
            
        } catch (Exception ex) {
            System.err.printf("%nError:%s", ex.getMessage());
            return null;
        }
        return lista;
    }
}
