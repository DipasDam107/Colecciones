package dam107t9e2;

import dam107t9e1.*;

public class Coche {
    String matricula;
    String marca;
    String modelo;
    
    Coche(String matricula, String marca, String modelo){
        this.matricula=matricula;
        this.marca=marca;
        this.modelo=modelo;
    }
    
   

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    @Override
    public String toString() {
        return "Coche{" + "matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + '}';
    }
    
    
}
