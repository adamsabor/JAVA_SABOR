package fr.esiee;  // Indique le package (comme un dossier) où se trouve la classe

/**
 * La classe Devise représente une somme d'argent avec une certaine monnaie.
 * Exemple : 10 EUR, 5 USD, etc.
 */
public class Devise {

    // 🔒 Attributs privés : ils ne sont accessibles qu'à l'intérieur de cette classe
    private int quantite;     // Représente la quantité d'argent (ex : 100)
    private String monnaie;   // Représente la monnaie (ex : "EUR", "USD")

    /**
     * 🛠️ Constructeur de la classe Devise
     * Permet de créer un objet Devise avec une somme et une monnaie.
     *
     * @param somme   La quantité d'argent
     * @param monnaie La monnaie de la devise
     */
    public Devise(int somme, String monnaie) {
        this.quantite = somme;     // Initialise l'attribut quantite avec la valeur donnée
        this.monnaie = monnaie;    // Initialise l'attribut monnaie avec la valeur donnée
    }

    /**
     * 📥 Getter pour obtenir la quantité d'argent.
     *
     * @return la quantité d'argent
     */
    public int getQuantite() {
        return quantite;  // Retourne la valeur de quantite
    }

    /**
     * 📥 Getter pour obtenir la monnaie.
     *
     * @return la monnaie de la devise
     */
    public String getMonnaie() {
        return monnaie;   // Retourne la valeur de monnaie
    }

    /**
     * ➕ Méthode pour additionner deux devises.
     *
     * @param m La devise à ajouter à celle-ci
     * @return Une nouvelle Devise représentant la somme des deux devises
     * @throws MonnaieDifferenteException si les monnaies sont différentes
     */
    public Devise add(Devise m) throws MonnaieDifferenteException {
        // 🔎 Vérifie si les monnaies sont différentes
        if (!this.monnaie.equals(m.monnaie)) {
            // 🚫 Si les monnaies sont différentes, on lève une exception
            throw new MonnaieDifferenteException(this, m);
        }

        // ✅ Si les monnaies sont identiques, on additionne les quantités
        return new Devise(getQuantite() + m.getQuantite(), getMonnaie());
    }

    /**
     * 🔄 Redéfinit la méthode equals() pour comparer deux objets Devise.
     *
     * @param obj L'objet à comparer avec cette Devise
     * @return true si les deux devises ont la même monnaie et la même quantité, sinon false
     */
    @Override  // @Override signifie qu'on réécrit une méthode existante de la classe Object
    public boolean equals(Object obj) {
        if (obj instanceof Devise) {  // Vérifie si l'objet est bien une Devise
            Devise autreDevise = (Devise) obj;  // Convertit l'objet en Devise

            // 🧐 Comparaison des monnaies
            boolean memeMonnaie = this.monnaie.equals(autreDevise.monnaie);

            // 🧐 Comparaison des quantités
            boolean memeQuantite = this.quantite == autreDevise.quantite;

            // ✅ Retourne vrai si les monnaies ET les quantités sont identiques
            return memeMonnaie && memeQuantite;
        }

        // 🚫 Si l'objet n'est pas une Devise, retourne false
        return false;
    }

    /**
     * 📝 Redéfinit la méthode toString() pour afficher joliment la Devise.
     *
     * @return Une chaîne de caractères représentant la devise (ex : "10 EUR")
     */
    @Override
    public String toString() {
        return quantite + " " + monnaie;  // Exemple : "10 EUR"
    }
}
