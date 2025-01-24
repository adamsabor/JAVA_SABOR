package fr.esiee.modele;

public class Arret {
    private int id;
    private String nom;
    private TypeArret typeArret;  // Utilisation de l'enum

    // Constructeur par défaut
    public Arret() {
        this.id = 0;
        this.nom = "";
        this.typeArret = TypeArret.INTERMEDIAIRE;
    }

    // Constructeur avec paramètres
    public Arret(int id, String nom, TypeArret typeArret) {
        this.id = id;
        this.nom = nom;
        this.typeArret = typeArret;
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public TypeArret getTypeArret() { return typeArret; }
    public void setTypeArret(TypeArret typeArret) { this.typeArret = typeArret; }

    @Override
    public String toString() {
        return "Arret [id=" + id + ", nom=" + nom + ", typeArret=" + typeArret + "]";
    }
}