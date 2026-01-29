package Commands;

import Konzole.Konzole;
import Lokace.Lokace;

public class Pohyb implements Command {
    private Lokace lokace;


    public String vykonat(Konzole konzole, String prikaz2) {
    if (prikaz2.equals("dal")) {
       if (konzole.getAktualniLokace().isUkolHotovy() == true) {
        if (konzole.getAktualniLokace().getNaslednik() != null) {
            lokace = hledacDalsiLokace(konzole.getAktualniLokace(), konzole);
            konzole.setAktualniLokace(lokace);
            return "Nachazis se v lokaci " + konzole.getAktualniLokace().getNazev();

        }else return "Dalsi mistnost neni, dale jit nemuzes";
       }else return  "Nesplnil si hlavni ukol";

    }
    else if (prikaz2.equals("zpatky")) {
        lokace = hledacPredchoziLokace(konzole.getAktualniLokace(), konzole);
        konzole.setAktualniLokace(lokace);
        return "Sel jsi zpet, momentalne se nachazis v lokaci " + konzole.getAktualniLokace().getNazev();


    }else {return "takovy prikaz neni";}

    }


    /**
     * Tato metoda hleda predchozi lokaci, tim ze projde ArrayList lokaci, jestli se nazev aktualni lokace shoduje s naslednikem u jine lokace, pokud ano tak tato metoda vrati lokaci
     * @param aktualniLokace
     * @param konzole
     * @return
     */
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


    /**
     * Tato metoda hleda dalsi lokaci, tim ze projde ArrayList lokaci, jestli se naslednik aktualni lokace shoduje s nazvem jine lokace, pokud ano tak tato metoda vrati lokaci
     * @param aktualniLokace
     * @param konzole
     * @return
     */
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
