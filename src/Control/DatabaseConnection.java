package Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {
	
	private static final String URL = "jdbc:mysql://localhost:3306/bdbibliotheque";
    private static final String USER = "root"; // Remplacez par votre nom d'utilisateur MySQL
    private static final String PASSWORD = ""; // Remplacez par votre mot de passe MySQL

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
