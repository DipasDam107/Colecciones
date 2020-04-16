/*
 Haz una versión del ejercicio 1.1. pero muestre los coches por orden de llegada. Recordemos
que en ese ejercicio se añadían los elementos en la lista por el principio, en la primera posición. Por
lo tanto, al mostrar el ArrayList con un for…each los mostraba por el orden inverso al de llegada.
Ahora queremos lo contrario, que muestre la lista de final a principio. Pista: iterador descendente.

 */
package dam107t9e15;

import dam107t9e1.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
   
    static Scanner teclado;
    static Parking park;
    public static void main(String [] args){
        int opcion;
        teclado=new Scanner(System.in);
        park = new Parking();
        do{
            menu();
            opcion=teclado.nextInt();
            teclado.nextLine();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            if(opcion==1)mostrar();
            if(opcion==2)aparcar();
            if(opcion==3)desaparcar();
        }while(opcion!=0 || (opcion<0 || opcion>3));
        
    }
    
    public static void menu(){
        System.out.println("1 - Mostrar Lista");
        System.out.println("2 - Aparcar coche");
        System.out.println("3 - Desaparcar coche");
        System.out.println("0 - Salir");
        System.out.println("---------------------------");
        System.out.println("Dime opcion: ");
    }
    public static void aparcar(){
        System.out.println("Dime matricula: ");
        String mat=teclado.nextLine();
        System.out.println("Dime marca: ");
        String marca=teclado.nextLine();
        System.out.println("Dime modelo: ");
        String modelo=teclado.nextLine();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        if(park.aparcar(new Coche(mat,marca,modelo)))
            System.out.println("Coche de matricula " + mat + " aparcado");
        else System.out.println("El parking esta lleno");
            
    }
    public static void desaparcar(){
        Coche car =park.desaparcar();
        if(car!=null)
            System.out.println("Se ha quitado el ultimo vehiculo en entrar. Datos: " + car);
        else
            System.out.println("No hay vehiculos aparcados para quitar");
        
    }
    public static void mostrar(){
        Iterator <Coche> it = park.getParking().descendingIterator();
        System.out.println("---------------------------");
        System.out.println("Lista Coches");
        System.out.println("---------------------------");
        while(it.hasNext()){
            System.out.println(it.next());
        }
        
    }
}
