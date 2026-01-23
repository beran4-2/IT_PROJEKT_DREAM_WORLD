package HerniNacitani;
import Konzole.Konzole;
import Lokace.Lokace;
import Postavy.Postavy;
import Predmety.Predmet;
import com.google.gson.Gson;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class HerniNacitani {
    private ArrayList<Lokace> lokace;
    private ArrayList<Postavy> postavy;
    private ArrayList<Predmet> predmety;



    public static HerniNacitani nactiDataZeSlozky(String cestaSlozky) {
        Gson gson = new Gson();
        try (InputStream is = Konzole.class.getResourceAsStream(cestaSlozky)) {
            if (is == null) {
                throw new IllegalStateException("Nenalezen resource: " + cestaSlozky +
                        " (zkontrolujte, že soubor je v src/main/resources).");
            }
            return gson.fromJson(
                    new InputStreamReader(is, StandardCharsets.UTF_8),
                    HerniNacitani.class
            );
        } catch (Exception e) {
            throw new RuntimeException("Chyba při načítání JSON: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "HerniNacitani{" +
                "lokace=" + lokace +
                ", postavy=" + postavy +
                ", predmety=" + predmety +
                '}';
    }

    public ArrayList<Lokace> getLokace() {
        return lokace;
    }

    public ArrayList<Postavy> getPostavy() {
        return postavy;
    }

    public ArrayList<Predmet> getPredmety() {
        return predmety;
    }
}
