package Commands;

import HerniNacitani.HerniNacitani;
import Konzole.Konzole;
import Lokace.Lokace;

public class Pohyb implements Command {
    private HerniNacitani herniNacitani;
    private Konzole konzole;
    private Lokace lokace;

    public String vykonat(String prikaz2) {
    if (prikaz2.equals("dal")) {
        if (konzole.getAktualniLokace().getNaslednik() != null) {
            lokace = hledacDalsiLokace(konzole.getAktualniLokace());
        }
        if (konzole.getAktualniLokace().getNaslednik() == null) {
            System.out.println("Dalsi mistnost neni, dale jit nemuzes");
        }
    }
    else if (prikaz2.equals("zpatky")) {



    }else {
        System.out.println("takovy prikaz neni");
    }
        return  "";
    }


    public boolean odejit   () {
        return false;
    }



    public Lokace hledacPredchoziLokace(String nazevHlednaneho){
        for (int i = 0; i < herniNacitani.getLokace().size(); i++) {
            if (nazevHlednaneho.equals(herniNacitani.getLokace().get(i).getNazev())) {
                nazevHlednaneho = herniNacitani.getLokace().get(i).getNazev();
                lokace = herniNacitani.getLokace().get(i);
                return lokace;
            }
        }
        return null;
    }

    public Lokace hledacDalsiLokace(Lokace aktualniLokace){
        //String nazevAktualniLokace = aktualniLokace.getNazev();
        String nazevNasledujiciLokace = aktualniLokace.getNaslednik();
        for (int i = 0; i < herniNacitani.getLokace().size(); i++) {
            if (herniNacitani.getLokace().get(i).getNazev().equals(nazevNasledujiciLokace)) {
                aktualniLokace = herniNacitani.getLokace().get(i);
            }
        }
        return aktualniLokace;
    }
}
