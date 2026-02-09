
package Commands;

import HerniNacitani.HerniNacitani;
import Konzole.Konzole;
import Lokace.Lokace;
import Postavy.Samir;
import Inventar_a_Ukoly.Inventar;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class PohybTest {

    Pohyb pohyb;
    Konzole konzole;
    Lokace lokace1;
    Lokace lokace2;
    HerniNacitani data;
    Samir samir;
    Inventar inventar;

    @BeforeEach
    void setUp() {
        samir = new Samir();
        inventar = new Inventar();
        data = new HerniNacitani();

        lokace1 = new Lokace("Praha", true, "popis", "Brno", "NENI", 0, false);
        lokace2 = new Lokace("Brno", false, "popis", null, "NENI", 0, false);

        ArrayList<Lokace> seznamLokaci = new ArrayList<>();
        seznamLokaci.add(lokace1);
        seznamLokaci.add(lokace2);
        data.setLokace(seznamLokaci);

        konzole = new Konzole();
        konzole.setSamir(samir);
        konzole.setInventar(inventar);
        konzole.setData(data);
        konzole.setAktualniLokace(lokace1);

        pohyb = new Pohyb();
    }

    @Test
    void vykonatDal() {
        String vysledek = pohyb.vykonat(konzole, "dal");
        assertEquals("Brno", konzole.getAktualniLokace().getNazev());
        assertTrue(vysledek.contains("Sel jsi dal"));
    }

    @Test
    void vykonatDalNesplnenyUkol() {
        lokace1.setUkolHotovy(false);
        String vysledek = pohyb.vykonat(konzole, "dal");
        assertEquals("Praha", konzole.getAktualniLokace().getNazev());
        assertEquals("Nesplnil si hlavni ukol", vysledek);
    }

    @Test
    void vykonatDalKonec() {
        konzole.setAktualniLokace(lokace2);
        lokace2.setUkolHotovy(true);
        String vysledek = pohyb.vykonat(konzole, "dal");
        assertEquals("Brno", konzole.getAktualniLokace().getNazev());
        assertEquals("Dalsi mistnost neni, dale jit nemuzes", vysledek);
    }


    @Test
    void vykonatZpatky() {
        konzole.setAktualniLokace(lokace2);
        String vysledek = pohyb.vykonat(konzole, "zpatky");
        assertEquals("Praha", konzole.getAktualniLokace().getNazev());
        assertTrue(vysledek.contains("Sel jsi zpet"));
    }

    @Test
    void vykonatNeplatnyPrikaz() {
        String vysledek = pohyb.vykonat(konzole, "skoc");
        assertEquals("takovy prikaz neni", vysledek);
    }
}