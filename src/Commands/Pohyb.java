package Commands;

import HerniNacitani.HerniNacitani;
import Konzole.Konzole;
import Lokace.Lokace;

public class Pohyb implements Command {
    private HerniNacitani data;
    private Lokace lokace;

    public String vykonat(Konzole konzole, String prikaz2) {

    if (prikaz2.equals("dal")) {
       if (konzole.getAktualniLokace().isUkolHotovy() == true) {
        if (konzole.getAktualniLokace().getNaslednik() != null) {
            lokace = hledacDalsiLokace(konzole.getAktualniLokace(), konzole);
            konzole.setAktualniLokace(lokace);
            System.out.println("Nachazis se v lokaci " + konzole.getAktualniLokace().getNazev());

        }else {System.out.println("Dalsi mistnost neni, dale jit nemuzes");}
       }else {System.out.println("Nesplnil si hlavni ukol");}

    }
    else if (prikaz2.equals("zpatky")) {
        lokace = hledacPredchoziLokace(konzole.getAktualniLokace(), konzole);
        konzole.setAktualniLokace(lokace);
        System.out.println("Sel jsi zpet, momentalne se nachazis v lokaci " + konzole.getAktualniLokace().getNazev());

    }else {
        System.out.println("takovy prikaz neni");
    }
        return  "";
    }


    public boolean odejit   () {
        return false;
    }



    public Lokace hledacPredchoziLokace(Lokace aktualniLokace, Konzole konzole) {
        String nazevAktualniLokace = aktualniLokace.getNazev();
        for (int i = 0; i < konzole.getData().getLokace().size(); i++) {
            if (konzole.getData().getLokace().get(i).getNaslednik() != null) {
                if (konzole.getData().getLokace().get(i).getNaslednik().equals(nazevAktualniLokace)) {
                    lokace = konzole.getData().getLokace().get(i);
                    return lokace;
                }
            }

        }
        return aktualniLokace;
    }

    public Lokace hledacDalsiLokace(Lokace aktualniLokace, Konzole konzole){
        String nazevNasledujiciLokace = aktualniLokace.getNaslednik();
        for (int i = 0; i < konzole.getData().getLokace().size(); i++) {
            if (konzole.getData().getLokace().get(i).getNazev().equals(nazevNasledujiciLokace)) {
                lokace = konzole.getData().getLokace().get(i);
            }
        }
        return lokace;
    }
}
