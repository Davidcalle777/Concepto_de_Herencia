package modelos;

public class Profesor extends Persona {
    private String especialidad;
    private double salario;
    private int aniosExperiencia;
    private String tituloAcademico;

    public Profesor(String nombre, String apellido, String fechaNacimiento, String genero,
                    double estatura, double peso,
                    String especialidad, double salario, int aniosExperiencia, String tituloAcademico) {
        super(nombre, apellido, fechaNacimiento, genero, estatura, peso);
        this.especialidad = especialidad;
        this.salario = salario;
        this.aniosExperiencia = aniosExperiencia;
        this.tituloAcademico = tituloAcademico;
    }

    // Getters
    public String getEspecialidad() {
        return especialidad;
    }

    public double getSalario() {
        return salario;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public String getTituloAcademico() {
        return tituloAcademico;
    }

    @Override
    public String toString() {
        return getNombre() + " " + getApellido();
    }
}
