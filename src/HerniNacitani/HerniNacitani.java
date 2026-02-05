package HerniNacitani;
import Inventar_a_Ukoly.Ukol;
import Komunikace.Odpoved;
import Komunikace.Otazka;
import Konzole.Konzole;
import Lokace.Lokace;
import Postavy.HodnaPostava;
import Postavy.ZlaPostava;
import Predmety.Predmet;
import com.google.gson.Gson;
import souboj.Souboj;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class HerniNacitani {
    private ArrayList<Lokace> lokace;
    private ArrayList<HodnaPostava> HodnePostavy;
    private ArrayList<ZlaPostava> ZlePostavy;
    private ArrayList<Predmet> predmety;
    private ArrayList<Ukol> ukoly;
    private ArrayList<Otazka> otazky;
    private ArrayList<Souboj> typyUtokuDayDream;
    private ArrayList<Souboj>typyUtokuLucidni;




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

    public String nactiDataZeSouboru(String cestaKSouboru){
        String vypis = "";
        try {
            BufferedReader br = new BufferedReader((new FileReader("rescources/" + cestaKSouboru+ ".txt")));
            String line = "";
            while ((line = br.readLine()) != null) {
                String radek = line.trim();
                vypis = vypis + radek + "\n";
            }
            br.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return vypis;
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

    public ArrayList<HodnaPostava> getHodnePostavy() {
        return HodnePostavy;
    }

    public ArrayList<ZlaPostava> getZlePostavy() {
        return ZlePostavy;
    }

    public ArrayList<Predmet> getPredmety() {
        return predmety;
    }

    public ArrayList<Ukol> getUkoly() {
        return ukoly;
    }

    public ArrayList<Otazka> getOtazky() {
        return otazky;
    }

    public ArrayList<Souboj> getTypyUtokuDaydreaming() {
        return typyUtokuDayDream;
    }

    public ArrayList<Souboj> getTypyUtokuLucidni() {
        return typyUtokuLucidni;
    }

    public void vypisLokaci(){
        for (int i = 0; i < lokace.size(); i++) {
            System.out.println(lokace.get(i));
        }
    }
    public void nacetliSeSouborySpravne(){
        System.out.println("Pocet lokaci je: " + lokace.size());
        System.out.println("Pocet hodnych postav je: " + HodnePostavy.size());
        System.out.println("Pocet zlych postav je: " + ZlePostavy.size());
        System.out.println("Pocet predmetu je: " + predmety.size());
        System.out.println("Pocet ukolu je: " + ukoly.size());
        System.out.print("Pocet otazek je: " + otazky.size());
    }
}
