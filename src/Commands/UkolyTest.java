package Commands;

import Konzole.Konzole;
import Inventar_a_Ukoly.Ukol;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class UkolyTest {

    Ukoly ukolyPrikaz;
    Konzole konzole;
    Ukol manazerUkolu;
    ArrayList<Ukol> hlavniUkoly;
    ArrayList<Ukol> vedlejsiUkoly;

    @BeforeEach
    void setUp() {
        hlavniUkoly = new ArrayList<>();
        vedlejsiUkoly = new ArrayList<>();

        manazerUkolu = new Ukol("System", "Manazer", "Spravuje ukoly", 0, 0, false, false, hlavniUkoly, vedlejsiUkoly);

        konzole = new Konzole();
        konzole.setUkol(manazerUkolu);

        ukolyPrikaz = new Ukoly();
    }

    @Test
    void vykonat() {
        String vysledek = ukolyPrikaz.vykonat(konzole, "");
        assertTrue(vysledek.startsWith("Tvoje ukoly: "));
    }
}