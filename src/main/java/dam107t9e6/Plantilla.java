
package dam107t9e6;

import java.util.HashMap;


public class Plantilla {
    HashMap<String, Jugador> plantilla;
    
    Plantilla(){
        plantilla = new HashMap<>();
    }
    
    public boolean aniadirJugador(String nombre, Jugador player){
        if(plantilla.containsKey(nombre))
            return false;
        else{
            plantilla.put(nombre, player);
            return true;
        }
    }
    
    public boolean borrarJugador(String nombre){
        if(plantilla.containsKey(nombre)){
            plantilla.remove(nombre);
            return true;
        }
        else
            return false;
            
    }
    
    public Jugador getJugador(String nombre){
        return plantilla.get(nombre);
    }
    
    public double incrementarSalario(String nombre){
        if(plantilla.containsKey(nombre)){
           return plantilla.get(nombre).incrementarSalario();
        }
        else return -1d;
    }
}
