package Commands;

import HerniNacitani.HerniNacitani;
import Konzole.Konzole;
import Postavy.Samir;
import Inventar_a_Ukoly.Inventar;
import Predmety.Predmet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class PouzitiPredmetuTest {


    PouzitiPredmetu pouzitiPredmetu;
    Konzole konzole;
    HerniNacitani data;
    Samir samir;
    Inventar inventar;
    Predmet mec;
    Predmet stit;
    Predmet maska;
    Predmet systemovyPredmet;

    @BeforeEach
    void setUp() {
        samir = new Samir();
        inventar = new Inventar();
        data = new HerniNacitani();

        mec = new Predmet("mec", 10, 5, false, "ostry mec", "zbran");
        stit = new Predmet("stit", 5, 10, false, "kovovy stit", "obrana");
        maska = new Predmet("maska spanku", 0, 0, false, "maska pro spanek", "specialni");
        systemovyPredmet = new Predmet("system", 0, 0, false, "systémový předmět", "system");

        inventar.getInventar().add(mec);
        inventar.getInventar().add(stit);
        inventar.getInventar().add(maska);

        konzole = new Konzole();
        konzole.setSamir(samir);
        konzole.setInventar(inventar);
        konzole.setData(data);
        konzole.setPredmet(systemovyPredmet);

        pouzitiPredmetu = new PouzitiPredmetu();
    }

    @Test
    void vykonatPridat() {
        String vysledek = pouzitiPredmetu.vykonat(konzole, "pridat mec");
        assertTrue(vysledek.contains("byl aktivovan predmet mec"));
        assertTrue(mec.isJePouzivany());
        assertEquals(1, konzole.getPredmet().getAktivniPredmety());
    }

    @Test
    void vykonatPridatNenalezen() {
        String vysledek = pouzitiPredmetu.vykonat(konzole, "pridat lektvar");
        assertEquals("nemas takovy predmet", vysledek);
        assertFalse(mec.isJePouzivany());
    }

    @Test
    void vykonatPridatKdyzUzJePouzivanJiny() {
        mec.setJePouzivany(true);
        String vysledek = pouzitiPredmetu.vykonat(konzole, "pridat stit");
        assertEquals("Uz vyuzivas predmet: mec", vysledek);
        assertFalse(stit.isJePouzivany());
    }

    @Test
    void vykonatOdebrat() {
        mec.setJePouzivany(true);
        konzole.getPredmet().setAktivniPredmety(1);
        String vysledek = pouzitiPredmetu.vykonat(konzole, "odebrat mec");
        assertEquals("odebral si predmet: mec", vysledek);
        assertFalse(mec.isJePouzivany());
        assertEquals(0, konzole.getPredmet().getAktivniPredmety());
    }

    @Test
    void vykonatOdebratNeaktivni() {
        mec.setJePouzivany(true);
        String vysledek = pouzitiPredmetu.vykonat(konzole, "odebrat stit");
        assertEquals("takovy predmet nebyl nalezen aktivni", vysledek);
        assertTrue(mec.isJePouzivany());
    }

    @Test
    void vykonatMaskaSpanku() {
        String vysledek = pouzitiPredmetu.vykonat(konzole, "pridat maska spanku");
        assertTrue(vysledek.contains("byl aktivovan predmet maska spanku"));
        assertTrue(maska.isJePouzivany());
        assertTrue(konzole.getSamir().isZpusobilyKeSpani());
    }

    @Test
    void vykonatNeplatnyPrikaz() {
        String vysledek = pouzitiPredmetu.vykonat(konzole, "neco");
        assertEquals("", vysledek);
    }
}