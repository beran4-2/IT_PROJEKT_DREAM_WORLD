package Konzole;

import Commands.Command;
import Commands.Pomoc;
import HerniNacitani.HerniNacitani;
import Commands.Pohyb;
import Lokace.Lokace;

import java.util.HashMap;
import java.util.Scanner;


public class Konzole {
    private boolean konecHry;
    private Scanner scanner = new Scanner(System.in);
    private HashMap<String, Command> mapaPrikazu = new HashMap<>();
    private HerniNacitani data;
    private Lokace aktualniLokace;

    public void hra(){
        konecHry = false;
        data = HerniNacitani.nactiDataZeSlozky("/herniSvet.json");
        aktualniLokace = data.getLokace().get(0);
        inicializace();
        System.out.println("Prave jsi v lokaci " + aktualniLokace);
        //data.vypisLokaci();

        do{
            provedPrikaz();
        }while(!konecHry);


    }



    private void inicializace() {
        mapaPrikazu.put("jdi", new Pohyb());
        mapaPrikazu.put("pomoc", new Pomoc());
    }

    private void provedPrikaz() {
        System.out.print(">>");
        String prikaz = scanner.nextLine();
        prikaz = prikaz.trim();
        String[] rozdeleni = prikaz.split(" ");
        String prikaz1 = rozdeleni[0].toLowerCase();
        String prikaz2 = "";
        if (rozdeleni.length  == 2) {
            prikaz2 = rozdeleni[1].toLowerCase();
        }
        if (mapaPrikazu.containsKey(prikaz1)) {
            mapaPrikazu.get(prikaz1).vykonat(this,prikaz2);
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

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
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

    public void setData(HerniNacitani data) {
        this.data = data;
    }

    public void setAktualniLokace(Lokace aktualniLokace) {
        this.aktualniLokace = aktualniLokace;
    }
}
