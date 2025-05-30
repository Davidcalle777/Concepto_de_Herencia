
import java.sql.*;
import java.util.Scanner;
import modelos.Profesor;
import conexion.Conexion;

public class Main {
    // ✅ CONSTANTE
    private static final int MAX_PROFESORES = 50;
    private static final Profesor[] profesores = new Profesor[MAX_PROFESORES];
    // ✅ MÉTODO PRINCIPAL
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int contador = 0;
        // ✅ BUCLE PARA INGRESAR PROFESORES
        while (contador < MAX_PROFESORES) {
            System.out.println("\nProfesor #" + (contador + 1));

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();

            System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
            String fechaNacimiento = scanner.nextLine();

            System.out.print("Género: ");
            String genero = scanner.nextLine();

            System.out.print("Estatura (metros): ");
            double estatura = Double.parseDouble(scanner.nextLine());

            System.out.print("Peso (kg): ");
            double peso = Double.parseDouble(scanner.nextLine());

            Profesor profesor = new Profesor(nombre, apellido, fechaNacimiento, genero, estatura, peso);
            profesores[contador] = profesor;

            insertarProfesorEnBD(profesor);
            contador++;
            // ✅ PREGUNTAR SI DESEA INGRESAR OTRO PROFESOR
            System.out.print("¿Desea ingresar otro profesor? (s/n): ");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("s")) {
                break;
            }
        }

        scanner.close();
    }
    // ✅ MÉTODO PARA INSERTAR PROFESOR EN LA BASE DE DATOS
    public static void insertarProfesorEnBD(Profesor profesor) {
        Connection conn = Conexion.getConexion();

        if (conn == null) {
            System.out.println("No se pudo establecer la conexión con la base de datos.");
            return;
        }
        // ✅ USANDO TRY-CATCH PARA MANEJAR EXCEPCIONES
        try {
            conn.setAutoCommit(false);

            String sqlPersona = "INSERT INTO persona (nombre, apellido, fecha_nacimiento, genero, estatura, peso) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmtPersona = conn.prepareStatement(sqlPersona, Statement.RETURN_GENERATED_KEYS);

            stmtPersona.setString(1, profesor.getNombre());
            stmtPersona.setString(2, profesor.getApellido());
            stmtPersona.setString(3, profesor.getFechaNacimiento());
            stmtPersona.setString(4, profesor.getGenero());
            stmtPersona.setDouble(5, profesor.getEstatura());
            stmtPersona.setDouble(6, profesor.getPeso());
            // ✅ EJECUTANDO LA INSERCIÓN EN PERSONA
            int filasPersona = stmtPersona.executeUpdate();

            if (filasPersona > 0) {
                ResultSet rs = stmtPersona.getGeneratedKeys();
                if (rs.next()) {
                    int idPersona = rs.getInt(1);

                    // ✅ INSERCIÓN EN LA TABLA PROFESOR
                    String sqlProfesor = "INSERT INTO profesor (id) VALUES (?)";
                    PreparedStatement stmtProfesor = conn.prepareStatement(sqlProfesor);
                    stmtProfesor.setInt(1, idPersona);
                    // ✅ EJECUTANDO LA INSERCIÓN EN PROFESOR
                    int filasProfesor = stmtProfesor.executeUpdate();

                    if (filasProfesor > 0) {
                        conn.commit();
                        System.out.println(" Profesor guardado en la base de datos.");
                    } else {
                        conn.rollback();
                        System.out.println(" Error al insertar en profesor.");
                    }

                    stmtProfesor.close();
                }
                rs.close();
            } else {
                conn.rollback();
                System.out.println(" Error al insertar en persona.");
            }

            stmtPersona.close();
            conn.close();
        // ✅ MANEJO DE EXCEPCIONES
        } catch (SQLException e) {
            System.out.println("Error al insertar en la base de datos:");
            e.printStackTrace();
        }
    }
}
