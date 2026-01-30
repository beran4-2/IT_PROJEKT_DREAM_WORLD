package Commands;

import Konzole.Konzole;
import Lokace.Lokace;
import Postavy.HodnaPostava;

import java.util.ArrayList;


public class PohybPoLokaci implements Command {
    public String vykonat(Konzole konzole, String string) {
        String celyPopis = "Jsi v lokaci s nazvem " + konzole.getAktualniLokace().getNazev() + "\n";
        celyPopis = celyPopis + "Popis lokace: " + konzole.getAktualniLokace().getPopis() + "\n";
        celyPopis = celyPopis + postavyVLokaci(konzole) + "";
        if (!konzole.getAktualniLokace().isMistnostProzkoumana()) {
            konzole.getAktualniLokace().setMistnostProzkoumana(true);
        }
        return celyPopis;
    }




    public String postavyVLokaci(Konzole konzole){
        String vypisPostavy = "dostupna hodna postava ke komunikaci: ";
        ArrayList<HodnaPostava> postavy = konzole.getData().getHodnePostavy();
        boolean postavaNalezena = false;
        for (int i = 0; i < postavy.size(); i++) {
            if (postavy.get(i).getKdeSeNachazi().equals(konzole.getAktualniLokace().getNazev())){
                vypisPostavy = vypisPostavy + postavy.get(i).getJmeno();
                postavaNalezena = true;
                break;
            }
        }
        if (!postavaNalezena){
            vypisPostavy = vypisPostavy + "neni";
        }
        return vypisPostavy;
    }


}
