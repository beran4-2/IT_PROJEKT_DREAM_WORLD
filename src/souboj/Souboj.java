/**
 * V teto tride se zpracovava souboj hrace i protivniku
 * @author Ondrej Beran
 */

package souboj;

import Konzole.Konzole;
import Lokace.Lokace;
import Postavy.HodnaPostava;
import Postavy.ZlaPostava;

import java.util.ArrayList;

import java.util.InputMismatchException;

public class Souboj {
    private String typ;
    private String nazevUtoku;
    private String popisUtoku;
    private int potrebnaUroven;
    private int silaUtoku;

    public Souboj(String nazevUtoku, String typ, String popisUtoku, int potrebnaUroven, int silaUtoku) {
        this.nazevUtoku = nazevUtoku;
        this.typ = typ;
        this.popisUtoku = popisUtoku;
        this.potrebnaUroven = potrebnaUroven;
        this.silaUtoku = silaUtoku;
    }

    public Souboj(){


    }


    /**
     * toto je mtoda pro souboj ve snu, hraci vyskoci tabulka s vypasnyma lokacema a vybere si v jake mistnosti chce zautocit, pokuud je v mistnosti posataa ktera nechce bojovat
     * @param konzole pro pristup k vsech hernim datum
     * @return pokud je v mistnosti protivnik tak to vrati kolik mu uzivatel ubral, pokud ne program ho upozorni ze v mistnosti nikdo neni
     */
    public String lucidniSouboj(Konzole konzole){
        for (int i = 0; i < konzole.getData().getLokace().size(); i++) {
            System.out.println((i+1) + ". " + konzole.getData().getLokace().get(i).getNazev());
        }
        System.out.println("Vyber mistnost pro lucidni souboj pomoci cisel");
        Lokace lokaceBoje = konzole.getData().getLokace().get(SoubojZpracovaniOdpovedi(konzole.getData().getLokace().size()));

        HodnaPostava hodnaPostava = hledaniHodnePostavy(konzole, lokaceBoje);
        ZlaPostava zlaPostava = hledaniZlePostavy(konzole, lokaceBoje);
        int silaUtoku;

            System.out.println("Vybral sis " + lokaceBoje.getNazev());
            if (zlaPostava!=null){
                if (zlaPostava.isJeZabitelny()){
                    System.out.println("Bojujes s " + zlaPostava.getJmeno() + ": ");
                    System.out.println("Zivoty protivnika: " + zlaPostava.getZivoty());
                    silaUtoku = lucidniSneniVyberUtoku(konzole, lokaceBoje);
                    System.out.println(zlaPostava.setZivoty(konzole,zlaPostava.getZivoty()-silaUtoku));
                    return "Protivnikovi si ubral " + silaUtoku + " zivotu" ;
                }else return "V mistnosti neni nekdo s kym bys mohl bojovat";

            }else if (hodnaPostava!=null){
                if (hodnaPostava.isJeZabitelny()){
                    System.out.println("Bojujes s " + hodnaPostava.getJmeno() + ":" );
                    System.out.println("Zivoty protivnika: " + hodnaPostava.getZivoty());
                    silaUtoku = lucidniSneniVyberUtoku(konzole, lokaceBoje);
                    System.out.println(hodnaPostava.setZivoty(konzole,hodnaPostava.getZivoty()-silaUtoku));
                    return "Protivnikovi si ubral " + silaUtoku + " zivotu" ;
                }else return "V mistnosti neni nekdo s kym bys mohl bojovat";
            }
            else return "V lokaci neni zdna postava";
    }

    /**
     * Pomocna metoda pro zpracovani uzivatelova vstupu
     * @param maxHodnota maximalni hodnota ktera jde zadat
     * @return cislo ktere uzivatel zadal
     */
    public int SoubojZpracovaniOdpovedi(int maxHodnota){
        boolean spravnyVstup = false;
        int vyberZOdpvedi;
        int index = 0;
        do {
            System.out.print(">>");
            try{
                vyberZOdpvedi =Konzole.scanner.nextInt();
                Konzole.scanner.nextLine();
                if (vyberZOdpvedi >= 1 && vyberZOdpvedi <= maxHodnota){
                    spravnyVstup = true;
                    index = vyberZOdpvedi-1;
                }else {
                    System.out.println("Neplatny vstup, zadej od 1 do " + maxHodnota);
                }
            }catch (InputMismatchException e){
                System.out.println("Zadali jste spatny vstup");
                Konzole.scanner.nextLine();
            }
        }while(!spravnyVstup);
        return index;
    }


    /**
     * Metoda pro smaotny utok, kde se hraci ukazi 3 moznosti utoku, jsou nahodne vybrane z nacteneho arraylistu v hernim nacitani, ale 1 utok bude urcite dostupny
     * @param konzole pro pristup k vsech hernim datum
     * @param lokaceBoje
     * @return int silu utoku a to znamena kolik souperi ubere
     */
    public int lucidniSneniVyberUtoku(Konzole konzole, Lokace lokaceBoje){
        ArrayList<Souboj> triUtoky = new ArrayList<>(3);
        ArrayList<Souboj> nahodneDostupneUtoky = new ArrayList<>(konzole.getData().getTypyUtokuLucidni().size());

        for (int i = 0; i < konzole.getData().getTypyUtokuLucidni().size(); i++) {
            if (konzole.getData().getTypyUtokuLucidni().get(i).getPotrebnaUroven() <= konzole.getSamir().getUrovenLucidnihoSneni()){
                nahodneDostupneUtoky.add(konzole.getData().getTypyUtokuLucidni().get(i));
            }
        }
        triUtoky.add(nahodneDostupneUtoky.get(konzole.random.nextInt(0,nahodneDostupneUtoky.size())));

        for (int i = 0; i < 2 ; i++) {
            int rozhodovac = Konzole.random.nextInt(konzole.getData().getTypyUtokuLucidni().size());
            triUtoky.add(konzole.getData().getTypyUtokuLucidni().get(rozhodovac));
        }
        for (int i = 0; i < triUtoky.size(); i++) {
            System.out.print((1+i) + ". " + triUtoky.get(i).getNazevUtoku() + ":    Sila utoku: " + triUtoky.get(i).getSilaUtoku()  + "     Potrebna uroven: " + triUtoky.get(i).getPotrebnaUroven());
            if (konzole.getSamir().getUrovenLucidnihoSneni()<triUtoky.get(i).getPotrebnaUroven()){
                System.out.println("    NEDOSTUPNY UTOK");
            } else System.out.println(" ");
        }
        System.out.println("Jaky typ utoku si vyberes?");
        int silaUtoku;
        boolean spravnyVstup = false;
        do{
            Souboj vybranyUtok = triUtoky.get(SoubojZpracovaniOdpovedi(triUtoky.size()));
            int ulozenaUroven =  vybranyUtok.getPotrebnaUroven();
            silaUtoku = vybranyUtok.getSilaUtoku();
            if (konzole.getSamir().getUrovenLucidnihoSneni() >= ulozenaUroven){
                spravnyVstup = true;
            }else System.out.println("Nemas dostatecnu uroven");
        }while (!spravnyVstup);
        return  silaUtoku;
    }


    /**
     * Tato metoda zpracovava uzivateluv boj nablizko tzv daydream utok
     * @param konzole pro pristup k vsech hernim datum
     * @param lokaceBoje
     * @return
     */
    public String daydreamUtok(Konzole konzole, Lokace lokaceBoje){
        ZlaPostava zlaPostava = hledaniZlePostavy(konzole,lokaceBoje);
        HodnaPostava hodnaPostava = hledaniHodnePostavy(konzole, lokaceBoje);

        if (zlaPostava!=null){
            if (zlaPostava.jeNaZivu()) {
                if (zlaPostava.isJeZabitelny()) {
                    System.out.println("Bojujes s " + zlaPostava.getJmeno() + ": ");
                    System.out.println("Zivoty protivnika: " + zlaPostava.getZivoty());
                    silaUtoku = daydreamingVyberUtoku(konzole, lokaceBoje);
                    System.out.println(zlaPostava.setZivoty(konzole, zlaPostava.getZivoty() - silaUtoku));

                } else return "V mistnosti neni nekdo s kym bys mohl bojovat";
            }else return zlaPostava.getJmeno() + " je uz mrtva";

        }else if (hodnaPostava!=null){
            if (hodnaPostava.jeNaZivu()) {
                if (hodnaPostava.isJeZabitelny()) {
                    System.out.println("Bojujes s " + hodnaPostava.getJmeno() + ":");
                    System.out.println("Zivoty protivnika: " + hodnaPostava.getZivoty());
                    silaUtoku = daydreamingVyberUtoku(konzole, lokaceBoje);
                    System.out.println(hodnaPostava.setZivoty(konzole, hodnaPostava.getZivoty() - silaUtoku));

                } else return "V mistnosti neni nekdo s kym bys mohl bojovat";
            }else return hodnaPostava.getJmeno() + " je uz mrtva";
        } else return "V lokaci neni zdna postava";

        return "Protivnikovi si ubral " + silaUtoku + " zivotu" ;


        /*
        if (hodnaPostava.isJeZabitelny() || zlaPostava.isJeZabitelny()){
            System.out.println("Vybral sis " + lokaceBoje.getNazev());
            if (zlaPostava!=null){
                System.out.println("Bojujes s " + zlaPostava.getJmeno() + ": ");
                System.out.println("Zivoty protivnika: " + zlaPostava.getZivoty());
                silaUtoku = daydreamingVyberUtoku(konzole, lokaceBoje);
                zlaPostava.setZivoty(konzole, zlaPostava.getZivoty()-silaUtoku);
                return "Protivnikovi si ubral " + silaUtoku + " zivotu" ;

            }else if (hodnaPostava!=null){
                System.out.println("Bojujes s " + hodnaPostava.getJmeno() + ":" );
                System.out.println("Zivoty protivnika: " + hodnaPostava.getZivoty());
                silaUtoku = daydreamingVyberUtoku(konzole, lokaceBoje);
                hodnaPostava.setZivoty(konzole,hodnaPostava.getZivoty()-silaUtoku);
                return "Protivnikovi si ubral " + silaUtoku + " zivotu" ;
            }

        }else return "V mistnosti neni souboj nemas s kym bojovat";
        return "";*/
    }


    /**
     * pomocna metoda ktera najde nahodne 3 daydream utoky a vypise je
     * @param konzole pro pristup k vsech hernim datum
     * @param lokaceBoje
     * @return vraci silu utoku  = kolik zivotu uzivatel ubere protivnikovi
     */
    public int daydreamingVyberUtoku(Konzole konzole, Lokace lokaceBoje) {
        ArrayList<Souboj> triUtoky = new ArrayList<>(3);
        ArrayList<Souboj> nahodneDostupneUtoky = new ArrayList<>(konzole.getData().getTypyUtokuDayDream().size());
        for (int i = 0; i < konzole.getData().getTypyUtokuDaydreaming().size(); i++) {
            if (konzole.getData().getTypyUtokuDaydreaming().get(i).getPotrebnaUroven() <= konzole.getSamir().getUrovenDaydreamingu()){
            nahodneDostupneUtoky.add(konzole.getData().getTypyUtokuDaydreaming().get(i));
            }
        }
        triUtoky.add(nahodneDostupneUtoky.get(Konzole.random.nextInt(0, konzole.getData().getTypyUtokuDaydreaming().size())));
        for (int i = 0; i < 2; i++) {
            int rozhodovac = konzole.random.nextInt(konzole.getData().getTypyUtokuDaydreaming().size());
                triUtoky.add(konzole.getData().getTypyUtokuDaydreaming().get(rozhodovac));
        }
        String nazePredchoziho = "Predchozi";
        for (int i = 0; i < triUtoky.size(); i++) {
            if (nazePredchoziho.equals(triUtoky.get(i).getNazevUtoku())){
                triUtoky.remove(i);
                triUtoky.add(konzole.getData().getTypyUtokuDaydreaming().get(Konzole.random.nextInt(konzole.getData().getTypyUtokuDaydreaming().size())));
            }else {nazePredchoziho = triUtoky.get(i).getNazevUtoku();}
        }
        int i;
        for (i = 0; i < triUtoky.size(); i++) {
            System.out.print((1 + i) + ". " + triUtoky.get(i).getNazevUtoku() + ":    Sila utoku: " + triUtoky.get(i).getSilaUtoku() + "     Potrebna uroven: " + triUtoky.get(i).getPotrebnaUroven());
            if (konzole.getSamir().getUrovenDaydreamingu() < triUtoky.get(i).getPotrebnaUroven()) {
                System.out.println("    NEDOSTUPNY UTOK");
            } else System.out.println(" ");
        }
        System.out.println("Jaky typ utoku si vyberes?");
        return triUtoky.get(SoubojZpracovaniOdpovedi(triUtoky.size())).getSilaUtoku();
    }


    /**
     * tato metoda s spousti vzdy po 1 cyklu hry, je spustena pozue kdyz je Samir v souboji, a pokud se v nem vyskytuje tak mu ubere zivoty pokud se nebude branit
     * @param konzole pro pristup k vsech hernim datum
     * @return text a kolik bylo hlavni postave ubrano zivotu
     */
    public String protihracuvTah(Konzole konzole) {
        if (konzole.getSamir().isJeVBoji()) {
            ZlaPostava zlaPostava = hledaniZlePostavy(konzole,konzole.getAktualniLokace());
            HodnaPostava hodnaPostava = hledaniHodnePostavy(konzole,konzole.getAktualniLokace());
            int ubraneZivoty = 0;
            String jmenoPostavy = "";

            if (zlaPostava != null) {
                ubraneZivoty = (zlaPostava.getSilaSnu()*3 + zlaPostava.getFyzickaSila()*2);
                konzole.getSamir().setZivoty(konzole,hodnaPostava.getZivoty() - ubraneZivoty);
                jmenoPostavy = zlaPostava.getJmeno();
            }
            if (hodnaPostava != null){
                ubraneZivoty = hodnaPostava.getFyzickaSila()*10;
                konzole.getSamir().setZivoty(konzole,konzole.getSamir().getZivoty() - ubraneZivoty);
                jmenoPostavy = hodnaPostava.getJmeno();
            }

        return "\nMomentalne se nachazis v boji s " + jmenoPostavy +" a ty si vyuzil spatny prikaz, bylo ti ubrano " + ubraneZivoty + " zivotu";
        }else return "";
    }


    /**
     * pomocna metoda ktera hleda zlou postavu v lokaci
     * @param konzole pro pristup k vsech hernim datum
     * @param lokaceSeSoubojem
     * @return zlou postavu
     */
    public ZlaPostava hledaniZlePostavy(Konzole konzole, Lokace lokaceSeSoubojem){
        ZlaPostava zlaPostava = null;
        for (int i = 0; i < konzole.getData().getZlePostavy().size(); i++) {
            if (lokaceSeSoubojem.getNazev().equals(konzole.getData().getZlePostavy().get(i).getKdeSeNachazi())){
            zlaPostava = konzole.getData().getZlePostavy().get(i);
            }
        }
        return zlaPostava;
    }

    /**
     *pomocna metoda ktera hleda hodnou postavu v lokaci
     * @param konzole pro pristup k vsech hernim datum
     * @param lokaceSeSoubojem
     * @return vraci hodnou postavu
     */
    public HodnaPostava hledaniHodnePostavy(Konzole konzole, Lokace lokaceSeSoubojem){
        HodnaPostava hodnaPostava = null;
        for (int i = 0; i < konzole.getData().getHodnePostavy().size(); i++) {
            if (lokaceSeSoubojem.getNazev().equals(konzole.getData().getHodnePostavy().get(i).getKdeSeNachazi())){
            hodnaPostava = konzole.getData().getHodnePostavy().get(i);
            break;
            }
        }
        return hodnaPostava;
    }

    /**
     * Metoda vyuzita v commandu Pohyb, delat to ze kdyz random cislo bude mensi nez 5 tak hrac nepriteli neutece, pokud padne 5 a vice tak se mu to podari
     * @return true hrac neutece, false hrac utece
     */
    public boolean bojovaNahoda(){
        int bojovaNahoda = Konzole.random.nextInt(1,11);
        if (bojovaNahoda <5){
            return true;
        }else return false;
    }

    public String getTyp() {
        return typ;
    }

    public String getNazevUtoku() {
        return nazevUtoku;
    }

    public String getPopisUtoku() {
        return popisUtoku;
    }

    public int getPotrebnaUroven() {
        return potrebnaUroven;
    }

    public int getSilaUtoku() {
        return silaUtoku;
    }
}