
package dam107t9e6;
public class Jugador {
    int numero;
    String posicion;
    float altura;
    String pie;
    float salario;
    static float INCREMENTO= 0.1f;
    
    public Jugador(int numero, String posicion, float altura, String pie, float salario) {
        this.numero = numero;
        this.posicion = posicion;
        this.altura = altura;
        this.pie = pie;
        this.salario = salario;
    }

    public double incrementarSalario(){
        this.salario=this.salario + (this.salario * INCREMENTO);
        return this.salario;
    }
    
    @Override
    public String toString() {
        return "numero=" + numero + ", posicion=" + posicion + ", altura=" + altura + ", pie=" + pie + ", salario=" + salario;
    }
    
    

    
    
}
