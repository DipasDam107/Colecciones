/*
Realizar un programa que tenga un HashMap que almacene una plantilla de jugadores de un
equipo (Nombre, salario). El programa dispondrá de un menú que permita: añadir jugador, eliminar
jugador, consultar el salario de un jugador e incrementar el salario un 10% a un empleado.
 */
package dam107t9e6;

import java.util.Scanner;

public class Main {
    static Scanner teclado;
    static Plantilla plantel;
    
    public static void main(String [] args){
        teclado=new Scanner(System.in);
        plantel = new Plantilla();
        int opcion;
        do{
            menu();
            opcion=teclado.nextInt();
            teclado.nextLine();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            if(opcion==1)aniadirJugador();
            if(opcion==2)eliminarJugador();
            if(opcion==3)ConsultarJugador();
            if(opcion==4)incrementoSalario();
        }while(opcion!=0 || (opcion<0 || opcion>4));
    }
    
    public static void menu(){
        System.out.println("1 - Añadir jugador");
        System.out.println("2 - Eliminar Jugador");
        System.out.println("3 - Consultar Informacion");
        System.out.println("4 - Incrementar Salario");
        System.out.println("0 - Salir");
        System.out.println("---------------------------");
        System.out.println("Dime opcion: ");
    }
    
    public static void aniadirJugador(){
        System.out.println("Dime nombre: ");
        String nombre = teclado.nextLine();
        System.out.println("Dime numero: ");
        int numero = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Dime posicion: ");
        String posicion = teclado.nextLine();
        System.out.println("Dime altura: ");
        float altura = teclado.nextFloat();
        System.out.println("Dime pie: ");
        String pie = teclado.nextLine();
        System.out.println("Dime salario: ");
        float salario = teclado.nextFloat();
        teclado.nextLine();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        
       if(plantel.aniadirJugador(nombre, new Jugador(numero, posicion, altura, pie, salario)))
            System.out.println("Jugador " + nombre + " añadido con exito");
       else System.out.println("El jugador ya existe");
        
    }
    public static void eliminarJugador(){
        System.out.println("Dime nombre: ");
        String nombre = teclado.nextLine();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        if(plantel.borrarJugador(nombre))
            System.out.println("El jugador " + nombre +  " borrado");
        else
            System.out.println("El jugador " + nombre +  " no existe");
        
    }
    public static void ConsultarJugador(){
        System.out.println("Dime nombre: ");
        String nombre = teclado.nextLine();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        Jugador jugador = plantel.getJugador(nombre);
        if(jugador!=null){
            System.out.println("-------------------");
            System.out.println("Nombre: " + nombre);
            System.out.println("-------------------");
            System.out.println(jugador);
        }
        else
            System.out.println("El jugador " + nombre + " no existe");
    }
    public static void incrementoSalario(){
        System.out.println("Dime nombre: ");
        String nombre = teclado.nextLine();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        double salario=plantel.incrementarSalario(nombre);
        if(salario!=-1)
            System.out.println("Salario del jugador " + nombre + " incrementado. Nuevo Salario: " + salario);
        else
            System.out.println("El jugador " + nombre + " no existe");
    }
    
}
