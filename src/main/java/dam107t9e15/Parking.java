/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam107t9e15;

import dam107t9e1.*;
import java.util.LinkedList;

/**
 *
 * @author User
 */
public class Parking {
    private LinkedList <Coche> parking;
    private static int MAXCOCHES=10;
    
    Parking(){
        parking = new LinkedList<>();
    }
    
    public boolean aparcar(Coche car){
        if(parking.size()<MAXCOCHES){
            parking.addFirst(car);
            return true;
        }
        else return false;
    }
    public Coche desaparcar(){
        if(parking.size()>0){
            Coche car = parking.getFirst();
            parking.removeFirst();
            return car;
        }
        else return null;
    }

    public LinkedList<Coche> getParking() {
        return parking;
    }
    
}
