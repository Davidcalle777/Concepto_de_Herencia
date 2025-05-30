package modelos;

public class Profesor extends Persona {

    public Profesor(String nombre, String apellido, String fechaNacimiento, String genero,
                    double estatura, double peso) {
        super(nombre, apellido, fechaNacimiento, genero, estatura, peso);
    }
    // Método para obtener el nombre completo del profesor
    @Override
    public String toString() {
        return getNombre() + " " + getApellido();
    }
}
