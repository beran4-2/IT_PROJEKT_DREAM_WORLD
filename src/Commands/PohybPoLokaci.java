package Commands;

import Konzole.Konzole;
import Lokace.Lokace;
import Postavy.HodnaPostava;

import java.util.ArrayList;


/**
 * @author Ondrej Beran
 */
public class PohybPoLokaci implements Command {
    /**
     * Tento command umzni hraci prozkoumat mistnost, ale pokud ma v mistnosti ukol tak se mu spusti
     * @param konzole pro pristup k vsech hernim datum
     * @return
     */
    public String vykonat(Konzole konzole, String string) {
        String celyPopis = "";
        if (konzole.getUkol().najitNazevAktualniho().equals("Zformovani mostu") && konzole.getAktualniLokace().getNazev().equals("Jezero")){
            celyPopis = celyPopis + konzole.getUkol().herniUkolMost(konzole);
            konzole.getLokace().novyDostupnyDialog(konzole,340, "Jezero");
        }
        if (konzole.getUkol().najitNazevAktualniho().equals("Vyres hadanku v Oblasti X") && konzole.getAktualniLokace().getNazev().equals("Oblast X")){
            celyPopis = celyPopis + konzole.getUkol().herniUkolOblastXStiny(konzole);
            konzole.getLokace().novyDostupnyDialog(konzole, 401, "Jezero");
        }
        if (konzole.getUkol().najitNazevAktualniho().equals("Zformovat horu") && konzole.getAktualniLokace().getNazev().equals("Hory")){
            celyPopis = celyPopis + konzole.getUkol().herniUkolHory(konzole);
            konzole.getLokace().novyDostupnyDialog(konzole, 501, "Jezero");
        }
        if (konzole.getUkol().najitNazevAktualniho().equals("Vyhasnout sopku") && konzole.getAktualniLokace().getNazev().equals("Sopka")){
            celyPopis = celyPopis + konzole.getUkol().herniUkolSopka(konzole);
            konzole.getLokace().novyDostupnyDialog(konzole, 601,"Jezero");
        }
        if (konzole.getUkol().najitNazevAktualniho().equals("Prozkoumej pekelne mesto") && konzole.getAktualniLokace().getNazev().equals("Pekelne Mesto")){
            celyPopis = celyPopis + "V teto lokaci jsou negani, ktere musis zabit";

        }
        celyPopis = celyPopis + "Jsi v lokaci s nazvem " + konzole.getAktualniLokace().getNazev() + "\n";
        celyPopis = celyPopis + "Popis lokace: " + konzole.getAktualniLokace().getPopis() + "\n";
        celyPopis = celyPopis + postavyVLokaci(konzole) + "";
        if (!konzole.getAktualniLokace().isMistnostProzkoumana()) {
            konzole.getAktualniLokace().setMistnostProzkoumana(true);
        }
        return celyPopis;
    }


    /**
     * Vypise hraci dostupnou postavu pro komunikaci
     * @param konzole pro pristup k vsech hernim datum
     * @return dostupnou postavu
     */
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
