/*
 Realizar un programa que contenga una LinkedList para almacenar las matrículas de los
coches aparcados en un parking. El parking es un poco raro, mide solo 3 metros de ancho y caben
10 coches, pero uno detrás de otro por lo que el último en entrar debe ser el primero en salir (esta
estructura se llama pila LIFO – Last Input, First Output). El programa tendrá un menú para:
    a. Aparcar: se le pasará el número de matrícula y lo almacenará a no ser que esté lleno.
    b. Desaparcar: Muestra la matrícula del coche a desaparcar o bien un mensaje informando
    cadena vacía si el parking está vacío.
    c. Mostrar la lista de las matrículas de los coches que hay en el parking, por orden inverso al
    de llegada, es decir primero el último en llegar
    Nota: Usa los métodos que meten y sacan por el principio de la lista: addFirst, removeFirst
 */
package dam107t9e1;

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
        LinkedList <Coche> parking = park.getParking();
        for(Coche x : parking){
            System.out.println(x);
        }
        
    }
}
