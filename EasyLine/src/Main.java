public class Main {


    public static void main(String[] args) {
        System.out.println("Hello world!");
        Voyage maroc = new Voyage();

        maroc.setDestination("Maroc");
        maroc.setDuree(7);
        maroc.setPrix(1200.50);

       
        System.out.println("Destination: " + maroc.getDestination());
        System.out.println("Durée: " + maroc.getDuree() + " jour");
        System.out.println("Prix: " + maroc.getPrix() + " euuros");
    }

}