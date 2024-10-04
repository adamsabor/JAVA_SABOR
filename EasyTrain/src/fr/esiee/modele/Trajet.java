package fr.esiee.modele;

import java.time.LocalDateTime;

public class Trajet {
    private String code;             // Clé primaire
    private LocalDateTime tempsDepart;
    private LocalDateTime tempsArrivee;
    private Arret arretDepart;       // Clé étrangère vers Arret
    private Arret arretArrivee;      // Clé étrangère vers Arret

    // Constructeur par défaut
    public Trajet() {
        this.code = "Inconnu";
        this.tempsDepart = LocalDateTime.now();
        this.tempsArrivee = LocalDateTime.now();
        this.arretDepart = new Arret();
        this.arretArrivee = new Arret();
    }

    // Constructeur avec arguments
    public Trajet(String code, LocalDateTime tempsDepart, LocalDateTime tempsArrivee, Arret arretDepart, Arret arretArrivee) {
        this.code = code;
        this.tempsDepart = tempsDepart;
        this.tempsArrivee = tempsArrivee;
        this.arretDepart = arretDepart;
        this.arretArrivee = arretArrivee;
    }

    // Getters et Setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getTempsDepart() {
        return tempsDepart;
    }

    public void setTempsDepart(LocalDateTime tempsDepart) {
        this.tempsDepart = tempsDepart;
    }

    public LocalDateTime getTempsArrivee() {
        return tempsArrivee;
    }

    public void setTempsArrivee(LocalDateTime tempsArrivee) {
        this.tempsArrivee = tempsArrivee;
    }

    public Arret getArretDepart() {
        return arretDepart;
    }

    public void setArretDepart(Arret arretDepart) {
        this.arretDepart = arretDepart;
    }

    public Arret getArretArrivee() {
        return arretArrivee;
    }

    public void setArretArrivee(Arret arretArrivee) {
        this.arretArrivee = arretArrivee;
    }

    @Override
    public String toString() {
        return "Trajet [code=" + code + ", tempsDepart=" + tempsDepart + ", tempsArrivee=" + tempsArrivee +
                ", arretDepart=" + arretDepart + ", arretArrivee=" + arretArrivee + "]";
    }
}
