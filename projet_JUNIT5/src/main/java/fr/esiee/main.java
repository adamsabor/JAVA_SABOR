package fr.esiee;


public class main {
    public static void main(String[] args) {


        //tester les méthodes d'un objet, implique de créer l'objet
        Devise euro=new Devise(100, "euro");
        Devise euro2=new Devise(50, "euro");
        // tester les méthodes = 1) les utiliser
        int qte= euro.getQuantite();
        String monnaie= euro.getMonnaie();
        // 2) vérifier si les valeurs attendues sont bonnes (ici c'est nos yeux qui vérifient)
        System.out.println("Ma devise : qté "+qte+" et monnaie: "+monnaie);
        System.out.println("Ma devise : qté "+euro2.getQuantite()+" et monnaie: "+euro2.getMonnaie());
        //tester la fonction add = utiliser
        Devise somme=euro2.add (euro);
        // 2) vérifier si le résultat de la somme est ok
        System.out.println("Ma somme : qté "+somme.getQuantite()+" et monnaie: "+somme.getMonnaie());










    }
}
