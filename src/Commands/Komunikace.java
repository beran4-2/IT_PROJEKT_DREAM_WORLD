package Commands;

import Konzole.Konzole;
import Komunikace.Otazka;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Komunikace implements Command {


    public String vykonat(Konzole konzole, String string) {
        String vypis = "";
        if (konzole.getAktualniLokace().isMistnostProzkoumana()) {
           if (konzole.getAktualniLokace().getIdDostupnehoDialogu() > 0) {
               switch (dialogSPostavou(konzole)) {
                   case -101:
                       konzole.getAktualniLokace().setIdDostupnehoDialogu(110);
                       vypis = vypis + konzole.getInventar().pridatPredmet(konzole, "maska spanku") + "\n";
                       vypis = vypis + konzole.getUkol().splneniUkolu(konzole,konzole.getUkol().getIdAktualnihoUkolu(), "hlavni");
                       break;
                   case -102:
                       vypis = vypis + konzole.getUkol().splneniUkolu(konzole,konzole.getUkol().getIdAktualnihoUkolu(), "hlavni");
                       konzole.getAktualniLokace().setIdDostupnehoDialogu(110);
                       break;
                   case -103:
                       konzole.getSamir().setZivoty(konzole,100);
                       vypis = vypis + "KONEC";
                       break;
                   case -201:
                       vypis = vypis + konzole.getSamir().setUrovenLucidnihoSneni(konzole.getSamir().getUrovenLucidnihoSneni() + 1);
                       vypis = "\n" + vypis + konzole.getUkol().splneniUkolu(konzole,konzole.getUkol().getIdAktualnihoUkolu(), "hlavni");
                       konzole.getAktualniLokace().setIdDostupnehoDialogu(0);
                       break;
                   case -202:
                       vypis = vypis + konzole.getSamir().setUrovenDaydreamingu(konzole.getSamir().getUrovenDaydreamingu() + 1);
                       vypis = "\n" + vypis + konzole.getUkol().splneniUkolu(konzole,konzole.getUkol().getIdAktualnihoUkolu(), "hlavni");
                       konzole.getAktualniLokace().setIdDostupnehoDialogu(0);
                       break;
                   case -203:
                       konzole.getUkol().splneniUkolu(konzole, 4, "hlavni");
                       vypis = vypis + "KONEC";
                       break;
                   case -204:
                       return "Byl si vylecen";
                   case -205:
                       vypis = vypis + "KONEC";
                       break;
                   case -206:
                       vypis = vypis + "KONEC";
                       break;
                   case -301:
                       vypis = vypis + konzole.getSamir().setUrovenDaydreamingu(konzole.getSamir().getUrovenDaydreamingu() + 1);
                       vypis = vypis + "\n" + konzole.getUkol().splneniUkolu(konzole, konzole.getUkol().getIdAktualnihoUkolu(), "hlavni");
                       konzole.getAktualniLokace().setIdDostupnehoDialogu(0);
                       break;
                   case -302:
                       vypis = vypis + konzole.getSamir().setUrovenLucidnihoSneni(konzole.getSamir().getUrovenLucidnihoSneni() + 1);
                       vypis = vypis +"\n"+ konzole.getUkol().splneniUkolu(konzole, konzole.getUkol().getIdAktualnihoUkolu(), "hlavni");
                       konzole.getAktualniLokace().setIdDostupnehoDialogu(0);
                       break;
                   case -303:
                       konzole.getAktualniLokace().setIdDostupnehoDialogu(0);
                       vypis = vypis +"\n"+ konzole.getUkol().splneniUkolu(konzole, konzole.getUkol().getIdAktualnihoUkolu(), "hlavni");

                       break;
                   case -401:
                       konzole.getAktualniLokace().setIdDostupnehoDialogu(0);
                       vypis = vypis +"\n"+ konzole.getUkol().splneniUkolu(konzole, konzole.getUkol().getIdAktualnihoUkolu(), "hlavni");
                       break;
                   case -601:
                       vypis = vypis + konzole.getSamir().setUrovenLucidnihoSneni(konzole.getSamir().getUrovenLucidnihoSneni() + 2);
                       vypis = vypis +"\n"+ konzole.getUkol().splneniUkolu(konzole, konzole.getUkol().getIdAktualnihoUkolu(), "hlavni");
                       break;
                   case -602:
                       vypis = vypis + konzole.getSamir().setUrovenLucidnihoSneni(konzole.getSamir().getUrovenLucidnihoSneni() + 2);
                       vypis = vypis + konzole.getSamir().setUrovenDaydreamingu(konzole.getSamir().getUrovenLucidnihoSneni() + 2);
                       vypis = vypis +"\n"+ konzole.getUkol().splneniUkolu(konzole, konzole.getUkol().getIdAktualnihoUkolu(), "hlavni");
                       break;
               }
               return vypis + "\nKONEC DIALOGU";
           }else return "Nemas dostupny dialog s postavou";
        }else return "Mistnost neni prozkoumana";
    }


    /**
     * metoda kde se vyuzivaji vsechny vytvorene metody
     * @param konzole
     * @return
     */
    public int dialogSPostavou(Konzole konzole){
        String kdoMluvi = "";
        Otazka otazka = null;
        boolean otazkaInicializovana = false;
        for (int i = 0; i < konzole.getData().getOtazky().size(); i++) {
            if (konzole.getData().getOtazky().get(i).getId() == konzole.getAktualniLokace().getIdDostupnehoDialogu()){
                kdoMluvi = konzole.getData().getOtazky().get(i).getKdoMluvi();
                otazka = konzole.getData().getOtazky().get(i);
                otazkaInicializovana = true;
                break;
            }
        }
        System.out.println("Mluvis s " + kdoMluvi + "\n");
        int idDalsiOtazky;
        if (otazkaInicializovana){
            do {
                System.out.println(kdoMluvi + " odpoved:");
                System.out.println(otazka.getReplika() + "\n");
                System.out.println("Samir:");
                System.out.println("Odpovedi: stiskni 1-" + otazka.getOdpovediNaOtazky().size() + ".");
                System.out.print(vypisOdpovedi(otazka));
                idDalsiOtazky = zpracovaniOdpovedi(otazka);
                otazka = nalezeniDalsiOtazky(konzole, otazka, idDalsiOtazky);
            }while (idDalsiOtazky>0);
            return idDalsiOtazky;
        }else return 0;
    }

    /**
     * Tato metoda si vezme vstup a podle neho najde list moznych odpovedi urcite otazky
     * @param otazka
     * @return
     */
    public String vypisOdpovedi(Otazka otazka){
        String vypis = "";
        for (int i = 0; i < otazka.getOdpovediNaOtazky().size(); i++) {
            vypis = vypis + (i+1) + ". " + otazka.getOdpovediNaOtazky().get(i).getText()+"\n";
        }
        return vypis;
    }

    /**
     * V teto metode se zpracuje uzivateluv vstup a kam jeho dialog povede
     * @param otazka
     * @return
     */


    public int zpracovaniOdpovedi(Otazka otazka){
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
    }

    /**
     * Tato metoda hleda v listu otazku ktere se id shoduje s idDalsiOtazky u odpovedi
     * @param konzole
     * @param otazka
     * @param idDalsiOtazka
     * @return
     */
    public Otazka nalezeniDalsiOtazky(Konzole konzole, Otazka otazka, int idDalsiOtazka){
        for (int i = 0; i < konzole.getData().getOtazky().size(); i++) {
            if (konzole.getData().getOtazky().get(i).getId() == idDalsiOtazka){
                otazka = konzole.getData().getOtazky().get(i);
            }
        }
        return otazka;
    }

}
