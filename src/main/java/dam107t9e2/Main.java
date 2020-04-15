/*
    Haz una versión del ejercicio anterior, pero con los métodos que tiene LinkedList referidos
    específicamente a pilas ( peek, poll/pop, push, etc) 
 */
package dam107t9e2;

import dam107t9e1.*;
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
            if(opcion==4)proximo();
        }while(opcion!=0 || (opcion<0 || opcion>4));
        
    }
    
    public static void menu(){
        System.out.println("1 - Mostrar Lista");
        System.out.println("2 - Aparcar coche");
        System.out.println("3 - Desaparcar coche");
        System.out.println("4 - Proximo en salir");
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
    
    public static void proximo(){
        Coche car = park.proximo();
        if(car==null)
            System.out.println("No hay ningun coche esperando a salir");
        else
            System.out.println("El coche esperando a salir es: " + car);
    }
}
