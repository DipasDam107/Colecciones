
package dam107t9e4;

import java.time.LocalDate;
import java.util.Objects;

public class Persona {
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
        hash = 43 * hash + Objects.hashCode(this.nombre);
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
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", telefono=" + telefono + ", email=" + email + ", fecNac=" + fecNac + '}';
    }
    
    
    
}
