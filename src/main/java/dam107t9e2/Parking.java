
package dam107t9e2;

import dam107t9e1.*;
import java.util.LinkedList;


public class Parking {
    private LinkedList <Coche> parking;
    private static int MAXCOCHES=10;
    
    Parking(){
        parking = new LinkedList<>();
    }
    
    public boolean aparcar(Coche car){
        if(parking.size()<MAXCOCHES){
            parking.push(car);
            return true;
        }
        else return false;
    }
    public Coche desaparcar(){
        if(parking.size()>0){
            return parking.poll();
        }
        else return null;
    }
    
    public Coche proximo(){
        return parking.peek();
    }
    

    public LinkedList<Coche> getParking() {
        return parking;
    }
    
}
