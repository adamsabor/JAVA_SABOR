package fr.esiee;

import fr.esiee.dao.UtilisateurDAO;
import fr.esiee.modele.Role;
import fr.esiee.modele.Utilisateur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // Connexion à la base de données
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:8889/EasyTrain", "root", "root");

            // Instanciation du DAO
            UtilisateurDAO utilisateurDAO = new UtilisateurDAO(connection);

            // Menu pour tester les fonctionnalités du DAO
            Scanner scanner = new Scanner(System.in);
            System.out.println("=== Menu Utilisateur ===");
            System.out.println("1. Ajouter un utilisateur");
            System.out.println("2. Lire un utilisateur par ID");
            System.out.println("3. Mettre à jour un utilisateur");
            System.out.println("4. Supprimer un utilisateur");
            System.out.println("5. Quitter");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    Utilisateur utilisateur = new Utilisateur(0, "login", "mdp", "Nom", "Prenom", LocalDateTime.now(), Role.EMPLOYE);
                    utilisateurDAO.ajouterUtilisateur(utilisateur);
                    break;
                case 2:
                    System.out.print("ID de l'utilisateur : ");
                    int id = scanner.nextInt();
                    Utilisateur user = utilisateurDAO.lireUtilisateur(id);
                    System.out.println(user != null ? user : "Utilisateur non trouvé");
                    break;
                case 3:
                    // Logique de mise à jour
                    break;
                case 4:
                    System.out.print("ID de l'utilisateur à supprimer : ");
                    int idSup = scanner.nextInt();
                    utilisateurDAO.supprimerUtilisateur(idSup);
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Option invalide");
            }

            // Fermeture de la connexion
            connection.close();

        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
        }
    }
}
