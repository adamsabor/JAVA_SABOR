package fr.esiee;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeviseTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void getQuantite() {
    }

    @Test
    void getMonnaie() {
    }

    @Test
    void add() {
    }

    @Test
    void testEqual() {
    }

    @Test
    void testAddSimple() {

        Devise euro = new Devise(100, "euro");
        Devise euro2 = new Devise(50, "euro");
        Devise resultatAttendu = new Devise(150, "euro");

        assertEquals(resultatAttendu, euro.add(euro2));
    }
}
