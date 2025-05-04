package fr.esiee;

import java.util.HashMap;

public class Portefeuille {
    private HashMap<String, Devise> contenu;

    public Portefeuille() {
        contenu = new HashMap<>();
    }

    public HashMap<String, Devise> getContenu() {
        return contenu;
    }

    public void ajouteDevise(Devise d) throws MonnaieDifferenteException {
        String monnaie = d.getMonnaie();
        if (contenu.containsKey(monnaie)) {
            Devise somme = contenu.get(monnaie).add(d);
            contenu.put(monnaie, somme);
        } else {
            contenu.put(monnaie, d);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Portefeuille contenant :\n");
        for (Devise d : contenu.values()) {
            result.append("- ").append(d.toString()).append("\n");
        }
        return result.toString();
    }
}