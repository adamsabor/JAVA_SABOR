package fr.esiee;

import fr.esiee.dao.EasyTrainDAO;
import fr.esiee.modele.*;
import java.time.LocalDateTime;
import java.sql.SQLException;

public class TestDAO {
    public static void main(String[] args) {
        EasyTrainDAO dao = new EasyTrainDAO();

        try {
            System.out.println("=== Début des tests ===");

            // Test utilisateur
            System.out.println("\nTest Utilisateur:");
            Utilisateur user = new Utilisateur(0, "test", "test123", "TEST", "User",
                    LocalDateTime.now(), Role.EMPLOYE);
            dao.ajouterUtilisateur(user);

            Utilisateur userLu = dao.getUtilisateurById(1);
            System.out.println("Utilisateur lu: " + userLu);

            // Test arrêt
            System.out.println("\nTest Arrêt:");
            Arret arret = new Arret(0, "Gare du Nord", TypeArret.TERMINUS); // Constructeur modifié avec le type
            dao.ajouterArret(arret);

            Arret arretLu = dao.getArretById(1);
            System.out.println("Arrêt lu: " + arretLu);

            // Test trajet
            System.out.println("\nTest Trajet:");
            Trajet trajet = new Trajet("TR001", LocalDateTime.now(),
                    LocalDateTime.now().plusHours(2), arretLu, arretLu);
            dao.ajouterTrajet(trajet);

            Trajet trajetLu = dao.getTrajetById("TR001");
            System.out.println("Trajet lu: " + trajetLu);

            System.out.println("\n=== Tests terminés avec succès ===");

        } catch (SQLException e) {
            System.err.println("Erreur SQL: " + e.getMessage());
            e.printStackTrace();
        }
    }
}