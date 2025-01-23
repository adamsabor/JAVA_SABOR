package fr.esiee;

import java.sql.*;

public class TestJDBC {
    private static final String URL_DISTANT = "jdbc:mysql://adamdev.alwaysdata.net:3306/adamdev_database";
    private static final String USER_DISTANT = "AdamDev";
    private static final String PWD_DISTANT = "root";

    private static final String URL_LOCAL = "jdbc:mariadb://localhost:8889/EasyTrain";
    private static final String USER_LOCAL = "root";
    private static final String PWD_LOCAL = "root";

    public static void main(String[] args) {
        System.out.println("=== Test des connexions ===");

        // Test connexion distante
        try {
            Connection connDistant = DriverManager.getConnection(URL_DISTANT, USER_DISTANT, PWD_DISTANT);
            System.out.println("Connexion distante réussie!");
            connDistant.close();
            System.out.println("Connexion distante fermée");
        } catch (SQLException e) {
            System.out.println("Échec connexion distante: " + e.getMessage());
        }

        // Test connexion locale
        try {
            Connection connLocal = DriverManager.getConnection(URL_LOCAL, USER_LOCAL, PWD_LOCAL);
            System.out.println("Connexion locale réussie!");

            System.out.println("\n=== Test requête INSERT ===");
            Statement stmt = connLocal.createStatement();
            String insertQuery = "INSERT INTO Utilisateur (login, mdp, nom, prenom, dateEmbauche, role) " +
                    "VALUES ('test', 'test123', 'Test', 'User', NOW(), 'EMPLOYE')";
            int nbLignes = stmt.executeUpdate(insertQuery);
            System.out.println(nbLignes + " ligne(s) insérée(s)");

            System.out.println("\n=== Test requête SELECT by ID ===");
            ResultSet rs = stmt.executeQuery("SELECT * FROM Utilisateur WHERE id = 1");
            if(rs.next()) {
                System.out.println("Utilisateur trouvé:");
                System.out.println("Login: " + rs.getString("login"));
                System.out.println("Nom: " + rs.getString("nom"));
                System.out.println("Prénom: " + rs.getString("prenom"));
            } else {
                System.out.println("Aucun utilisateur avec id=1");
            }

            System.out.println("\n=== Test requête SELECT multiple ===");
            ResultSet rsAll = stmt.executeQuery("SELECT * FROM Utilisateur");
            while(rsAll.next()) {
                System.out.println("ID: " + rsAll.getInt("id") +
                        " | Login: " + rsAll.getString("login") +
                        " | Nom: " + rsAll.getString("nom") +
                        " | Prénom: " + rsAll.getString("prenom"));
            }

            System.out.println("\n=== Test requête UPDATE ===");
            String updateQuery = "UPDATE Utilisateur SET nom = 'UPDATED' WHERE login = 'test'";
            nbLignes = stmt.executeUpdate(updateQuery);
            System.out.println(nbLignes + " ligne(s) mise(s) à jour");

            System.out.println("\n=== Test requête DELETE ===");
            String deleteQuery = "DELETE FROM Utilisateur WHERE login = 'test'";
            nbLignes = stmt.executeUpdate(deleteQuery);
            System.out.println(nbLignes + " ligne(s) supprimée(s)");

            connLocal.close();
            System.out.println("\nConnexion locale fermée");

        } catch (SQLException e) {
            System.out.println("Erreur: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("\nTests terminés!");
    }
}