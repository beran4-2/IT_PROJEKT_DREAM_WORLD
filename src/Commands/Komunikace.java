package Commands;

import Konzole.Konzole;
import Komunikace.Otazka;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Komunikace implements Command {

    //TODO zde bude dodelana herni logika
    public String vykonat(Konzole konzole, String string) {
        if (konzole.getAktualniLokace().isMistnostProzkoumana()) {
           if (konzole.getAktualniLokace().getIdDostupnehoDialogu() > 0) {
               switch (dialogSPostavou(konzole)) {
                   case -101:
                       konzole.getAktualniLokace().setUkolHotovy(true);
                       konzole.getAktualniLokace().setIdDostupnehoDialogu(0);
                       konzole.getInventar().pridatPredmet(konzole, "maska spanku");
                       return "Byla odemcena cesta do dalsi mistnosti";
                   case -102:
                       konzole.getAktualniLokace().setUkolHotovy(true);
                       konzole.getAktualniLokace().setIdDostupnehoDialogu(0);
                       return "byla odemcena cesta do dalsi mistnosti";
                   case -103:
                       return "KONEC3";
                   case -104:
                       return "KONEC4";
                   case -105:
                       return "KONEC";
                   case -106:
                       return "KONEC2";
                   case -107:
                       return "KONEC3";
                   case -108:
                       return "KONEC4";
                   case -110:
                       return "KONEC";
                   case -111:
                       return "KONEC2";
                   case -112:
                       return "KONEC3";
                   case -113:
                       return "KONEC4";
                   case -114:
                       return "KONEC";
                   case -115:
                       return "KONEC2";
                   case -116:
                       return "KONEC3";
                   case -117:
                       return "KONEC4";

               }
               return "KONEC DIALOGU\n";
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
        Scanner scanner = new Scanner(System.in);
        boolean spravnyVstup = false;
        int vyberZOdpvedi = 0;
        do {
                System.out.print(">>");
                try{
                    vyberZOdpvedi = scanner.nextInt();
                    if (vyberZOdpvedi >= 1 && vyberZOdpvedi <= otazka.getOdpovediNaOtazky().size()){
                        spravnyVstup = true;
                    }else {
                        System.out.println("Neplatny vstup, zadej od 1 do " + otazka.getOdpovediNaOtazky().size());
                    }
                }catch (InputMismatchException e){
                    System.out.println("Zadali jste spatny vstup");
                    scanner.nextLine();
                    spravnyVstup = false;
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
