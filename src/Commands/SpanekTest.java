package Commands;

import HerniNacitani.HerniNacitani;
import Konzole.Konzole;
import Lokace.Lokace;
import Postavy.Samir;
import Inventar_a_Ukoly.Ukol;
import souboj.Souboj;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class SpanekTest {

    Spanek spanek;
    Konzole konzole;
    HerniNacitani data;
    Samir samir;
    Lokace domov;
    Lokace venku;
    Ukol manazerUkolu;
    Ukol konkretniUkol;
    Souboj souboj;

    @BeforeEach
    void setUp() {
        samir = new Samir();
        data = new HerniNacitani();
        spanek = new Spanek();
        souboj = new Souboj();

        domov = new Lokace("Civitas Domov", true, "domov", "NENI", "NENI", 0, false);
        venku = new Lokace("Les", true, "les", "NENI", "NENI", 0, false);

        ArrayList<Lokace> seznamLokaci = new ArrayList<>();
        seznamLokaci.add(domov);
        seznamLokaci.add(venku);
        data.setLokace(seznamLokaci);

        ArrayList<Ukol> hlavni = new ArrayList<>();
        ArrayList<Ukol> vedlejsi = new ArrayList<>();

        konkretniUkol = new Ukol("hlavni", "Test Ukol", "Popis", 0, 1, false, false, null, null);
        hlavni.add(konkretniUkol);

        manazerUkolu = new Ukol("Manazer", "System", "Popis", 0, 0, false, false, hlavni, vedlejsi);

        konzole = new Konzole();
        konzole.setSamir(samir);
        konzole.setData(data);
        konzole.setUkol(manazerUkolu);
        konzole.setSouboj(souboj);
        konzole.setAktualniLokace(venku);
    }

    @Test
    void vykonatNezpusobily() {
        samir.setZpusobilyKeSpani(false);
        String vysledek = spanek.vykonat(konzole, "Vyspal ses");
        assertEquals("Spat nemuzes", vysledek);
    }

    @Test
    void vykonatVyspalSes() {
        samir.setZpusobilyKeSpani(true);
        String vysledek = spanek.vykonat(konzole, "Vyspal ses");
        assertEquals("", vysledek);
    }

    @Test
    void vykonatLucidniSneniNedostatekUrovne() {
        samir.setZpusobilyKeSpani(true);
        samir.setUrovenLucidnihoSneni(0);

        String vysledek = spanek.vykonat(konzole, "lucidni sneni");

        assertTrue(vysledek.contains("Nemas dostatecnou uroven pro lucidni sneni"));
        assertTrue(vysledek.contains("vyspal ses"));
    }

    @Test
    void vykonatNeplatnyPrikaz() {
        samir.setZpusobilyKeSpani(true);

        String vysledek = spanek.vykonat(konzole, "skakat");

        assertEquals("neplatna 2. cast prikazu", vysledek);
    }
}