package souboj;

import Konzole.Konzole;
import Lokace.Lokace;
import Postavy.HodnaPostava;
import Postavy.Postavy;
import Postavy.ZlaPostava;

import java.util.ArrayList;
import java.util.Random;

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

    public String lucidniSouboj(Konzole konzole){
        Souboj utok;
        String celkovyVypis = "";
        for (int i = 0; i < konzole.getData().getLokace().size(); i++) {
            System.out.println((i+1) + ". " + konzole.getData().getLokace().get(i).getNazev());
        }
        System.out.println("Vyber mistnost pro lucidni souboj pomoci cisel");
        Lokace lokaceBoje = konzole.getData().getLokace().get(SoubojZpracovaniOdpovedi(konzole.getData().getLokace().size()));

        HodnaPostava hodnaPostava = hledaniHodnePostavy(konzole, lokaceBoje);
        ZlaPostava zlaPostava = hledaniZlePostavy(konzole, lokaceBoje);
        int silaUtoku;
        if (hodnaPostava.isJeZabitelny() || zlaPostava.isJeZabitelny()){
            System.out.println("Vybral sis " + lokaceBoje.getNazev());
            if (zlaPostava!=null){
                System.out.println("Bojujes s " + zlaPostava.getJmeno() + ": ");
                System.out.println("Zivoty protivnika: " + zlaPostava.getZivoty());
                silaUtoku = lucidniSneniVyberUtoku(konzole, lokaceBoje);
                zlaPostava.setZivoty(konzole,zlaPostava.getZivoty()-silaUtoku);
                return "Protivnikovi si ubral " + silaUtoku + " zivotu" ;

            }else if (hodnaPostava!=null){
                System.out.println("Bojujes s " + hodnaPostava.getJmeno() + ":" );
                System.out.println("Zivoty protivnika: " + hodnaPostava.getZivoty());
                silaUtoku = lucidniSneniVyberUtoku(konzole, lokaceBoje);
                hodnaPostava.setZivoty(konzole,hodnaPostava.getZivoty()-silaUtoku);
                return "Protivnikovi si ubral " + silaUtoku + " zivotu" ;
            }

        }else return "V mistnosti neni souboj nemas s kym bojovat";
        return "";
    }

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

    public int lucidniSneniVyberUtoku(Konzole konzole, Lokace lokaceBoje){
        ArrayList<Souboj> triUtoky = new ArrayList<>(3);
        Souboj nejsilnejsiDostupnyUtok =  new Souboj("","lucidni","c",0,0);
        for (int i = 0; i < konzole.getData().getTypyUtokuLucidni().size(); i++) {
            if (konzole.getData().getTypyUtokuLucidni().get(i).getPotrebnaUroven() <= konzole.getSamir().getUrovenLucidnihoSneni() && konzole.getData().getTypyUtokuLucidni().get(i).getPotrebnaUroven() > nejsilnejsiDostupnyUtok.getPotrebnaUroven()){
            nejsilnejsiDostupnyUtok = konzole.getData().getTypyUtokuLucidni().get(i);
            }
        }
        triUtoky.add(nejsilnejsiDostupnyUtok);
        Random rd = new Random();
        for (int i = 0; i < 2 ; i++) {
            int rozhodovac = rd.nextInt(konzole.getData().getTypyUtokuLucidni().size());
            triUtoky.add(konzole.getData().getTypyUtokuLucidni().get(rozhodovac));
        }
        for (int i = 0; i < triUtoky.size(); i++) {
            System.out.print((1+i) + ". " + triUtoky.get(i).getNazevUtoku() + ":    Sila utoku: " + triUtoky.get(i).getSilaUtoku()  + "     Potrebna uroven: " + triUtoky.get(i).getPotrebnaUroven());
            if (konzole.getSamir().getUrovenLucidnihoSneni()<triUtoky.get(i).getPotrebnaUroven()){
                System.out.println("    NEDOSTUPNY UTOK");
            } else System.out.println(" ");
        }
        System.out.println("Jaky typ utoku si vyberes?");
        return  triUtoky.get(SoubojZpracovaniOdpovedi(triUtoky.size())).getSilaUtoku();
    }



    public String daydreamUtok(Konzole konzole, Lokace lokaceBoje){
        ZlaPostava zlaPostava = hledaniZlePostavy(konzole,lokaceBoje);
        HodnaPostava hodnaPostava = hledaniHodnePostavy(konzole, lokaceBoje);
        int SilaUtoku;

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
        return "";
    }


    public int daydreamingVyberUtoku(Konzole konzole, Lokace lokaceBoje){
        ArrayList<Souboj> triUtoky = new ArrayList<>(3);
        Souboj nejsilnejsiDostupnyUtok =  new Souboj("","daydreaming","c",0,0);
        for (int i = 0; i < konzole.getData().getTypyUtokuDaydreaming().size(); i++) {
            if (konzole.getData().getTypyUtokuDaydreaming().get(i).getPotrebnaUroven() <= konzole.getSamir().getUrovenDaydreamingu() && konzole.getData().getTypyUtokuDaydreaming().get(i).getPotrebnaUroven() > nejsilnejsiDostupnyUtok.getPotrebnaUroven()){
                nejsilnejsiDostupnyUtok = konzole.getData().getTypyUtokuDaydreaming().get(i);
            }
        }
        triUtoky.add(nejsilnejsiDostupnyUtok);
        Random rd = new Random();
        for (int i = 0; i < 2 ; i++) {
            int rozhodovac = rd.nextInt(konzole.getData().getTypyUtokuDaydreaming().size());
            triUtoky.add(konzole.getData().getTypyUtokuDaydreaming().get(rozhodovac));
        }
        for (int i = 0; i < triUtoky.size(); i++) {
            System.out.print((1+i) + ". " + triUtoky.get(i).getNazevUtoku() + ":    Sila utoku: " + triUtoky.get(i).getSilaUtoku()  + "     Potrebna uroven: " + triUtoky.get(i).getPotrebnaUroven());
            if (konzole.getSamir().getUrovenLucidnihoSneni()<triUtoky.get(i).getPotrebnaUroven()){
                System.out.println("    NEDOSTUPNY UTOK");
            } else System.out.println(" ");
        }
        System.out.println("Jaky typ utoku si vyberes?");
        return  triUtoky.get(SoubojZpracovaniOdpovedi(triUtoky.size())).getSilaUtoku();
    }














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

















    public ZlaPostava hledaniZlePostavy(Konzole konzole, Lokace lokaceSeSoubojem){
        ZlaPostava zlaPostava = null;
        for (int i = 0; i < konzole.getData().getZlePostavy().size(); i++) {
            if (lokaceSeSoubojem.getNazev().equals(konzole.getData().getZlePostavy().get(i).getKdeSeNachazi())){
            zlaPostava = konzole.getData().getZlePostavy().get(i);
            }
        }
        return zlaPostava;
    }
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