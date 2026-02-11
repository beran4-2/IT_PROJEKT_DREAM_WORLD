package Commands;

import Konzole.Konzole;
import Inventar_a_Ukoly.Inventar;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class InventarCommandTest {

    InventarCommand inventarCommand;
    Konzole konzole;
    Inventar inventar;

    @BeforeEach
    void setUp() {
        inventar = new Inventar();
        konzole = new Konzole();
        konzole.setInventar(inventar);
        inventarCommand = new InventarCommand();
    }

    @Test
    void vykonatZobrazit() {
        String vysledek = inventarCommand.vykonat(konzole, "zobrazit");
        String ocekavanyVystup = inventar.zobrazitInventar();
        assertEquals(ocekavanyVystup, vysledek);
    }

    @Test
    void vykonatChybnyPrikaz() {
        String vysledek = inventarCommand.vykonat(konzole, "zahodit");
        assertEquals("nespravna 2. cast prikazu", vysledek);
    }

    @Test
    void vykonatPrazdnyPrikaz() {
        String vysledek = inventarCommand.vykonat(konzole, "");
        assertEquals("nespravna 2. cast prikazu", vysledek);
    }
}