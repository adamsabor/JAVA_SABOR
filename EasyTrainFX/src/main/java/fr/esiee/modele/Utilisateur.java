package fr.esiee.modele;

import java.time.LocalDateTime;

public class Utilisateur {
    private int id;           // Clé primaire
    private String login;      // Unique
    private String mdp;        // Mot de passe (256 caractères max)
    private String nom;
    private String prenom;
    private LocalDateTime dateEmbauche;
    private Role role;         // Enum (ADMIN, EMPLOYE)

    // Constructeur par défaut
    public Utilisateur() {
        this.id = 0;
        this.login = "inconnu";
        this.mdp = "inconnu";
        this.nom = "inconnu";
        this.prenom = "inconnu";
        this.dateEmbauche = LocalDateTime.now();
        this.role = Role.EMPLOYE;
    }

    // Constructeur avec arguments
    public Utilisateur(int id, String login, String mdp, String nom, String prenom, LocalDateTime dateEmbauche, Role role) {
        this.id = id;
        this.login = login;
        this.mdp = mdp;
        this.nom = nom;
        this.prenom = prenom;
        this.dateEmbauche = dateEmbauche;
        this.role = role;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDateTime getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(LocalDateTime dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Utilisateur [id=" + id + ", login=" + login + ", mdp=" + mdp + ", nom=" + nom +
                ", prenom=" + prenom + ", dateEmbauche=" + dateEmbauche + ", role=" + role + "]";
    }
}
