package fr.esiee.modele;

public class Arret {
    private String nom;
    private String ville;

    // Constructeur par défaut
    public Arret() {
        this.nom = "Inconnu";
        this.ville = "Inconnue";
    }

    // Constructeur avec paramètres
    public Arret(String nom, String ville) {
        this.nom = nom;
        this.ville = ville;
    }

    // Getters et Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Arret [nom=" + nom + ", ville=" + ville + "]";
    }
}
