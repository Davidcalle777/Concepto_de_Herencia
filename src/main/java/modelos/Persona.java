
package modelos;
// Importa las clases necesarias para manejar la herencia y atributos de Persona
public class Persona {
    protected String nombre;
    protected String apellido;
    protected String fechaNacimiento;
    protected String genero;
    protected double estatura;
    protected double peso;
    // Constructor de la clase Persona
    public Persona(String nombre, String apellido, String fechaNacimiento, String genero,
                   double estatura, double peso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.estatura = estatura;
        this.peso = peso;
    }
    // Métodos getters para acceder a los atributos de la clase Persona
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public double getEstatura() {
        return estatura;
    }

    public double getPeso() {
        return peso;
    }
}
