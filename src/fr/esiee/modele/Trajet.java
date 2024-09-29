package fr.esiee.modele;

import java.util.List;

public class Trajet {
    private int id;
    private String heureDepart;
    private List<Arret> arrets;

    // Constructeur avec paramètres
    public Trajet(int id, String heureDepart, List<Arret> arrets) {
        this.id = id;
        this.heureDepart = heureDepart;
        this.arrets = arrets;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(String heureDepart) {
        this.heureDepart = heureDepart;
    }

    public List<Arret> getArrets() {
        return arrets;
    }

    public void setArrets(List<Arret> arrets) {
        this.arrets = arrets;
    }

    @Override
    public String toString() {
        return "Trajet [id=" + id + ", heureDepart=" + heureDepart + ", arrets=" + arrets + "]";
    }
}
