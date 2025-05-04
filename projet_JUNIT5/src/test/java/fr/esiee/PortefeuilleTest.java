package fr.esiee;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PortefeuilleTest {

    @Test
    void testAjouteDevise() throws MonnaieDifferenteException {
        Portefeuille p1 = new Portefeuille();
        p1.ajouteDevise(new Devise(5, "EUR"));
        p1.ajouteDevise(new Devise(5, "EUR"));

        Portefeuille p2 = new Portefeuille();
        p2.ajouteDevise(new Devise(10, "EUR"));

        assertIterableEquals(p1.getContenu().values(), p2.getContenu().values());

        p1.ajouteDevise(new Devise(7, "USD"));
        assertEquals(2, p1.getContenu().size());
    }
}