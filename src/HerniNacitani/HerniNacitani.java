package HerniNacitani;
import Inventar_a_Ukoly.Ukoly;
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
    private ArrayList<Postavy> HodnePostavy;
    private ArrayList<Postavy> ZlePostavy;
    private ArrayList<Predmet> predmety;
    private ArrayList<Ukoly> ukoly;



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
                ", HodnePostavy=" + HodnePostavy +
                ", ZlePostavy=" + ZlePostavy +
                ", predmety=" + predmety +
                ", ukoly=" + ukoly +
                '}';
    }

    public ArrayList<Lokace> getLokace() {
        return lokace;
    }

    public ArrayList<Postavy> getHodnePostavy() {
        return HodnePostavy;
    }

    public ArrayList<Postavy> getZlePostavy() {
        return ZlePostavy;
    }

    public ArrayList<Predmet> getPredmety() {
        return predmety;
    }

    public ArrayList<Ukoly> getUkoly() {
        return ukoly;
    }

    public void vypisLokaci(){
        for (int i = 0; i < lokace.size(); i++) {
            System.out.println(lokace.get(i));
        }
    }
}
