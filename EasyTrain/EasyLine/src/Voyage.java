public class Voyage {
    private String destination;
    private int duree;
    private double prix;

    public Voyage() {}

    public Voyage(String destination, int duree, double prix) {
        this.destination = destination;
        this.duree = duree;
        this.prix = prix;
    }

      public String getDestination(String destination) {
        return destination;
    }

      public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDuree(int duree) {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

      public double getPrix(double prix) {
        return prix;
    }

     public void setPrix(double prix) {
        this.prix = prix;
    }
}
