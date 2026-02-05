package Konzole;

import Commands.*;
import HerniNacitani.HerniNacitani;
import Inventar_a_Ukoly.Inventar;
import Inventar_a_Ukoly.Ukol;
import Lokace.Lokace;
import Postavy.HodnaPostava;
import Postavy.Samir;
import Postavy.ZlaPostava;
import Komunikace.Otazka;
import Predmety.Predmet;
import souboj.Souboj;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Konzole {
    private HashMap<String, Command> mapaPrikazu = new HashMap<>();
    private boolean konecHry;
    private HerniNacitani data;
    private Samir samir;
    private Lokace aktualniLokace;
    private Ukol ukol;
    private Inventar inventar;
    private HodnaPostava hodnaPostava;
    private ZlaPostava zlaPostava;
    private Otazka otazka;
    private Predmet predmet;
    private MenuHry menu;
    private Souboj souboj;
    private Lokace lokace;

    /*public static int zpracovaniOdpovedi(Otazka otazka){
        boolean spravnyVstup = false;
        int vyberZOdpvedi = 0;
        do {
            System.out.print(">>");
            try{
                vyberZOdpvedi =Konzole.scanner.nextInt();
                Konzole.scanner.nextLine();
                if (vyberZOdpvedi >= 1 && vyberZOdpvedi <= otazka.getOdpovediNaOtazky().size()){
                    spravnyVstup = true;
                }else {
                    System.out.println("Neplatny vstup, zadej od 1 do " + otazka.getOdpovediNaOtazky().size());
                }
            }catch (InputMismatchException e){
                System.out.println("Zadali jste spatny vstup");
                Konzole.scanner.nextLine();
            }
        }while(!spravnyVstup);
        System.out.println("\nOdpovedel si: " + otazka.getOdpovediNaOtazky().get(vyberZOdpvedi-1).getText() + "\n" );

        return otazka.getOdpovediNaOtazky().get(vyberZOdpvedi-1).getIdNasledneOtazky();
    }*/

    public static Scanner scanner = new Scanner(System.in);


    public void hra(){
        data = HerniNacitani.nactiDataZeSlozky("/herniSvet.json");
        inicializace();
        ukol = new Ukol();
        inventar = new Inventar();
        hodnaPostava = new HodnaPostava();
        zlaPostava = new ZlaPostava();
        otazka = new Otazka();
        predmet = new Predmet();
        menu = new MenuHry();
        souboj = new Souboj();
        lokace = new Lokace();
        konecHry = false;
        aktualniLokace = data.getLokace().get(0);
        ukol.setIdAktualnihoUkolu(1);
        samir = new Samir("Samir",100,1,true,0,1,0,false,false,false,false);
        ukol.getSeznamMomentalnichHlavnichUkolu().add(ukol.pridaniNovehoUkolu(this, ukol.getIdAktualnihoUkolu()));
       // data.nacetliSeSouborySpravne();



        do{
            provedPrikaz();
        }while(!konecHry);


    }



    private void inicializace() {
        mapaPrikazu.put("jit", new Pohyb());
        mapaPrikazu.put("pomoc", new Pomoc());
        mapaPrikazu.put("ukoly", new Ukoly());
        mapaPrikazu.put("napoveda", new Napoveda());
        mapaPrikazu.put("konec", new Konec());
        mapaPrikazu.put("inventar", new InventarCommand());
        mapaPrikazu.put("mluvit", new Komunikace());
        mapaPrikazu.put("prozkoumat", new PohybPoLokaci());
        mapaPrikazu.put("pouzit", new PouzitiPredmetu());
        mapaPrikazu.put("spat", new Spanek());
        mapaPrikazu.put("daydream", new Daydream());
        mapaPrikazu.put("vlastnosti", new Vlastnosti());
    }

    private void provedPrikaz() {
        String prikaz;
        System.out.println(menu.menuHry(this));
        System.out.print(">>");
        prikaz = scanner.nextLine();
        System.out.print("\n");
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
        if (samir.isJeVBoji()){
            if (prikaz2.equals("obrana")) {
            }else System.out.println( souboj.protihracuvTah(this));
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

    public Samir getSamir() {
        return samir;
    }

    public void setAktualniLokace(Lokace aktualniLokace) {
        this.aktualniLokace = aktualniLokace;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public Souboj getSouboj() {
        return souboj;
    }

    public Lokace getLokace(){
        return lokace;
    }

}
