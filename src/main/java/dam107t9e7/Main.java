/*
        Realizar un programa que tenga un HashMap que almacene una plantilla de jugadores de un
        equipo (Nombre, salario). La plantilla tiene un máximo de 25 jugadores. El programa dispondrá de
        menú que permita: añadir jugador, eliminar jugador, lista jugadores con su salario y que tenga
        también opción que permita introducir un salario y muestre los jugadores que tiene un salario
        parecido al introducido (por “parecido” entendemos que el salario del jugador esté en un rango de
        6000 euros arriba o abajo respecto al introducido). 
        ado.
 */
package dam107t9e7;

import dam107t9e6.*;
import java.util.HashMap;
import java.util.Iterator;
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
            if(opcion==5)mostrarJugadores();
            if(opcion==6)mostrarSalariosParecidos();
        }while(opcion!=0 || (opcion<0 || opcion>6));
    }
    
    public static void menu(){
        System.out.println("---------------------------");
        System.out.println("MENU");
        System.out.println("---------------------------");
        System.out.println("1 - Añadir jugador");
        System.out.println("2 - Eliminar Jugador");
        System.out.println("3 - Consultar Informacion");
        System.out.println("4 - Incrementar Salario");
        System.out.println("5 - Listar Plantilla");
        System.out.println("6 - Listar Salarios similares");
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
    
    public static void mostrarSalariosParecidos(){
        
        System.out.println("Dime Salario:");
        float salario = teclado.nextFloat();
        teclado.nextLine();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        HashMap<String, Jugador> plantilla = plantel.getPlantilla();
        Iterator<String> nombres = plantilla.keySet().iterator();
        System.out.println("---------------------------");
        System.out.println("Salarios Similares");
        System.out.println("---------------------------");
        while(nombres.hasNext()){
            String nombre = nombres.next();
            if( Math.abs(plantilla.get(nombre).salario - salario) < 2000)
                System.out.println("Nombre: " + nombre + " Salario: " + plantilla.get(nombre).salario);
        }
        System.out.println("---------------------------");
    }
    public static void mostrarJugadores(){
        HashMap<String, Jugador> plantilla = plantel.getPlantilla();
        Iterator<String> nombres = plantilla.keySet().iterator();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("---------------------------");
        System.out.println("PLANTILLA");
        System.out.println("---------------------------");
        while(nombres.hasNext()){
            String nombre = nombres.next();
            System.out.println("Nombre: " + nombre + " Salario: " + plantilla.get(nombre).salario);
        }
        System.out.println("---------------------------");
    }
    
}
