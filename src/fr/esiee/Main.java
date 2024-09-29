package fr.esiee;

import fr.esiee.modele.Arret;
import fr.esiee.modele.Trajet;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Création de deux objets Arret
        Arret arret1 = new Arret("Gare de Meulan", "Meulan");
        Arret arret2 = new Arret("Cergy prefecture", "Cergy");

        // Création d'un trajet avec deux arrêts
        Trajet trajet1 = new Trajet(1, "08:00", Arrays.asList(arret1, arret2));
        System.out.println("Trajet 1 : " + trajet1);

        // Création d'un autre trajet
        Arret arret3 = new Arret("Gare d'Arcueil", "Arcueil");
        Trajet trajet2 = new Trajet(2, "14:00", Arrays.asList(arret2, arret3));
        System.out.println("Trajet 2 : " + trajet2);
    }
}
