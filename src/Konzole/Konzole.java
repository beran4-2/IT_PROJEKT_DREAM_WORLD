package Konzole;

import Commands.*;
import HerniNacitani.HerniNacitani;
import Inventar_a_Ukoly.Inventar;
import Inventar_a_Ukoly.Ukol;
import Lokace.Lokace;
import Postavy.HodnaPostava;
import Postavy.ZlaPostava;
import Komunikace.Otazka;


import java.util.HashMap;
import java.util.Scanner;

//TODO DODELAT V CELEM PROJEKTU JAVA DOCS

public class Konzole {
    private boolean konecHry;
    private Scanner scanner = new Scanner(System.in);
    private HashMap<String, Command> mapaPrikazu = new HashMap<>();
    private HerniNacitani data;
    private Lokace aktualniLokace;
    private Ukol ukol;
    private Inventar inventar;
    private HodnaPostava hodnaPostava;
    private ZlaPostava zlaPostava;
    private Otazka otazka;

    public void hra(){
        konecHry = false;
        data = HerniNacitani.nactiDataZeSlozky("/herniSvet.json");
        aktualniLokace = data.getLokace().get(0);
        ukol = new Ukol();
        inventar = new Inventar();
        hodnaPostava = new HodnaPostava();
        zlaPostava = new ZlaPostava();
        otazka = new Otazka();
        inicializace();
        System.out.println("Prave jsi v lokaci " + aktualniLokace);
        data.nacetliSeSouborySpravne();
        inventar.pridatPredmet(this, "prasky na spani");
        inventar.pridatPredmet(this, "maska spanku");
        inventar.pridatPredmet(this, "hudebni krabicka");
        //System.out.println(ukol.vypisMomentalnichUkolu());



        do{
            provedPrikaz();
        }while(!konecHry);


    }



    private void inicializace() {
        mapaPrikazu.put("jdi", new Pohyb());
        mapaPrikazu.put("pomoc", new Pomoc());
        mapaPrikazu.put("ukoly", new Ukoly());
        mapaPrikazu.put("napoveda", new Napoveda());
        mapaPrikazu.put("konec", new Konec());
        mapaPrikazu.put("inventar", new InventarCommand());
        mapaPrikazu.put("mluv", new Komunikace());
        mapaPrikazu.put("prozkoumej", new PohybPoLokaci());
        mapaPrikazu.put("pouzij", new PouzitiPredmetu());
    }

    private void provedPrikaz() {
        System.out.print(">>");
        String prikaz = scanner.nextLine();
        prikaz = prikaz.trim();
        String[] rozdeleni = prikaz.split(" ", 2);
        String prikaz1 = rozdeleni[0].toLowerCase();
        String prikaz2 = "";
        if (rozdeleni.length  == 2) {
            prikaz2 = rozdeleni[1].toLowerCase();
        }
        if (mapaPrikazu.containsKey(prikaz1)) {
            System.out.println(mapaPrikazu.get(prikaz1).vykonat(this,prikaz2));

        } else {
            System.out.println(">> Nedefinovany prikaz");
        }
    }

    public Lokace getAktualniLokace() {
        return aktualniLokace;
    }









    public boolean isKonecHry() {
        return konecHry;
    }

    public void setKonecHry(boolean konecHry) {
        this.konecHry = konecHry;
    }

    public HashMap<String, Command> getMapaPrikazu() {
        return mapaPrikazu;
    }

    public void setMapaPrikazu(HashMap<String, Command> mapaPrikazu) {
        this.mapaPrikazu = mapaPrikazu;
    }

    public HerniNacitani getData() {
        return data;
    }

    public Ukol getUkol() {
        return ukol;
    }

    public Inventar getInventar() {
        return inventar;
    }

    public ZlaPostava getZlaPostava() {
        return zlaPostava;
    }

    public HodnaPostava getHodnaPostava() {
        return hodnaPostava;
    }

    public Otazka getOtazka() {
        return otazka;
    }

    public void setAktualniLokace(Lokace aktualniLokace) {
        this.aktualniLokace = aktualniLokace;
    }
}
