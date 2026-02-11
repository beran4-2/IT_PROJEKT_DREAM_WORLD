

package Commands;

import HerniNacitani.HerniNacitani;
import Komunikace.Otazka;
import Komunikace.Odpoved;
import Konzole.Konzole;
import Lokace.Lokace;
import Postavy.Samir;
import Inventar_a_Ukoly.Inventar;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class KomunikaceTest {

    Komunikace komunikace;
    Konzole konzole;
    HerniNacitani data;
    Samir samir;
    Inventar inventar;
    Lokace lokace;
    Otazka otazka1;
    Otazka otazka2;
    Odpoved odpoved1;
    Odpoved odpoved2;

    @BeforeEach
    void setUp() {
        samir = new Samir();
        inventar = new Inventar();
        data = new HerniNacitani();
        komunikace = new Komunikace();
        lokace = new Lokace("TestLokace", true, "popis", "Sever", "Jih", 0, false);

        odpoved1 = new Odpoved("Ano", 2);
        odpoved2 = new Odpoved("Ne", 3);
        ArrayList<Odpoved> odpovedi = new ArrayList<>();
        odpovedi.add(odpoved1);
        odpovedi.add(odpoved2);

        otazka1 = new Otazka(1, "Otazka 1", odpovedi);
        otazka2 = new Otazka(2, "Otazka 2", new ArrayList<>());

        ArrayList<Otazka> seznamOtazek = new ArrayList<>();
        seznamOtazek.add(otazka1);
        seznamOtazek.add(otazka2);
        data.setOtazky(seznamOtazek);

        konzole = new Konzole();
        konzole.setSamir(samir);
        konzole.setInventar(inventar);
        konzole.setData(data);
        konzole.setAktualniLokace(lokace);
    }

    @Test
    void vypisOdpovedi() {
        String vysledek = komunikace.vypisOdpovedi(otazka1);
        String ocekavano = "1. Ano\n2. Ne\n";
        assertEquals(ocekavano, vysledek);
    }

    @Test
    void vypisOdpovediPrazdne() {
        String vysledek = komunikace.vypisOdpovedi(otazka2);
        assertEquals("", vysledek);
    }

    @Test
    void nalezeniDalsiOtazky() {
        Otazka nalezena = komunikace.nalezeniDalsiOtazky(konzole, otazka1, 2);
        assertEquals(otazka2, nalezena);
        assertEquals(2, nalezena.getId());
    }

    @Test
    void nalezeniDalsiOtazkyNenalezeno() {
        Otazka nalezena = komunikace.nalezeniDalsiOtazky(konzole, otazka1, 99);
        assertEquals(otazka1, nalezena);
    }

    @Test
    void vykonatMistnostNeprozkoumana() {
        lokace.setMistnostProzkoumana(false);
        String vysledek = komunikace.vykonat(konzole, "mluvit");
        assertEquals("Mistnost neni prozkoumana", vysledek);
    }

    @Test
    void vykonatZadnyDostupnyDialog() {
        lokace.setMistnostProzkoumana(true);
        lokace.setIdDostupnehoDialogu(0);
        String vysledek = komunikace.vykonat(konzole, "mluvit");
        assertEquals("Nemas dostupny dialog s postavou", vysledek);
    }
}