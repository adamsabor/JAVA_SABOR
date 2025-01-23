package fr.esiee;



public class Devise {
    private int quantite;
    private String monnaie;

    public Devise(int somme, String monnaie) {
        this.quantite = somme;
        this.monnaie = monnaie;
    }
    public int getQuantite() {
        return quantite;
    }
    public String getMonnaie() {
        return monnaie;
    }
    public Devise add(Devise m) {
        return new Devise(getQuantite()+m.getQuantite(), getMonnaie());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Devise) {
            Devise valeur = (Devise) obj;

            boolean test1 = this.monnaie.equals(valeur.monnaie);
            boolean test2 = this.quantite == valeur.quantite;

            return test1 && test2;
        }
        return false;
    }
}