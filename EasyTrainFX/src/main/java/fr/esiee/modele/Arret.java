package fr.esiee.modele;

public class Arret {
    private int id;        // Clé primaire
    private String nom;     // Nom de l'arrêt

    // Constructeur par défaut
    public Arret() {
        this.id = 0;
        this.nom = "Inconnu";
    }

    // Constructeur avec arguments
    public Arret(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Arret [id=" + id + ", nom=" + nom + "]";
    }
}
