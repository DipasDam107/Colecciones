
package dam107t9e16;

import java.time.LocalDate;
import java.util.Objects;

public class Persona implements Comparable{
    String nombre;
    String telefono;
    String email;
    LocalDate fecNac;

    public Persona(String nombre, String telefono, String email, LocalDate fecNac) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.fecNac = fecNac;
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.nombre.toUpperCase());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.nombre.toUpperCase(), other.nombre.toUpperCase())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", telefono=" + telefono + ", email=" + email + ", fecNac=" + fecNac + '}';
    }

    @Override
    public int compareTo(Object o) {
        Persona p1 = (Persona) o; 
        return this.fecNac.compareTo(p1.fecNac);
    }
    
    
    
}
