package ma.hafsaemsi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestOracleConnection {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:orcle"; // Format : jdbc:oracle:thin:@<host>:<port>:<SID>
        String user = "sys as sysdba"; // Utilisateur, notez que sys peut nécessiter 'as sysdba'
        String password = "System123"; // Mot de passe

        Connection connection = null;

        try {
            // Chargement du driver JDBC
            Class.forName("oracle.jdbc.OracleDriver");

            // Établir la connexion
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion réussie!");

        } catch (SQLException e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC non trouvé : " + e.getMessage());
        } finally {
            // Fermer la connexion si elle a été établie
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
            }
        }
    }
}
