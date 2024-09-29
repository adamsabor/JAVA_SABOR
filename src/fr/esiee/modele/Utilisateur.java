package fr.esiee.modele;

public class Utilisateur {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private String dateDeNaissance;
    private Role role;

    // Constructeur par défaut
    public Utilisateur() {
        this.id = 0;
        this.nom = "Inconnu";
        this.prenom = "Inconnu";
        this.email = "inconnu@example.com";
        this.motDePasse = "password";
        this.dateDeNaissance = "01/01/2000";
        this.role = Role.PASSAGER;
    }

    // Constructeur avec 7 arguments
    public Utilisateur(int id, String nom, String prenom, String email, String motDePasse, String dateDeNaissance, Role role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.dateDeNaissance = dateDeNaissance;
        this.role = role;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(String dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", role=" + role + "]";
    }
}
