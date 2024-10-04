package fr.esiee;

import fr.esiee.modele.Utilisateur;
import fr.esiee.modele.Trajet;
import fr.esiee.modele.Arret;
import fr.esiee.modele.Role;

import java.time.LocalDateTime;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Création d'arrêts
        Arret arret1 = new Arret(1, "Gare de Meulan");
        Arret arret2 = new Arret(2, "Cergy prefecture");
        Arret arret3 = new Arret(3, "Gare de Saint Lazare");

        // Création de trajets en reliant des arrêts
        Trajet trajet1 = new Trajet("T123", LocalDateTime.of(2024, 10, 4, 8, 0),
                LocalDateTime.of(2024, 10, 4, 9, 0), arret1, arret2);
        Trajet trajet2 = new Trajet("T124", LocalDateTime.of(2024, 10, 4, 14, 0),
                LocalDateTime.of(2024, 10, 4, 15, 0), arret2, arret3);

        // Création d'utilisateurs avec rôle
        Utilisateur user1 = new Utilisateur(3, "Adam", "mdp123", "Adam", "Sabor", LocalDateTime.of(2023, 5, 10, 9, 0), Role.ADMIN);
        Utilisateur user2 = new Utilisateur(4, "Wissam", "mdp456", "Wissam", "Sabor", LocalDateTime.of(2023, 5, 10, 9, 0), Role.EMPLOYE);

        // Affichage des informations
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(trajet1);
        System.out.println(trajet2);
    }
}
