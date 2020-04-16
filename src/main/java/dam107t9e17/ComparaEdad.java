/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam107t9e17;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;

/**
 *
 * @author User
 */
public class ComparaEdad implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
       Persona p1 = (Persona) o1; 
       Persona p2 = (Persona) o2;
       int edad1 = (int)ChronoUnit.YEARS.between(p1.fecNac, LocalDate.now());
       int edad2 = (int)ChronoUnit.YEARS.between(p2.fecNac, LocalDate.now());
        return edad1 - edad2; 
    }
    
}
