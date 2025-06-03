
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// Importa las clases necesarias para manejar la conexión a la base de datos
public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/concepto_de_herencia";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConexio() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.out.println("❌ Error de conexión: " + e.getMessage());
        }
        return conn;
    }
}
