package Inventar_a_Ukoly;
import Konzole.Konzole;
import Predmety.Predmet;
import java.util.ArrayList;

public class Inventar {

    ArrayList<Predmet> inventar;


    //TODO dodelat pridani, ODEBRANI ASI NEBUDE POTREBA
    public String pridatPredmet(Konzole konzole, String string) {
        String pridanyPredmet = "";
        for (int i = 0; i < konzole.getData().getPredmety().size(); i++) {
            //if (po casech v komunikaci sem poputuje nazev prdmetu a tady se prida)
                inventar.add(konzole.getData().getPredmety().get(i));
                pridanyPredmet = konzole.getData().getPredmety().get(i).getNazev();
        }
        return pridanyPredmet;
    }

    public String odebratPredmet(Konzole konzole, String string) {
        return "";
    }

    //TODO dodelat zobrazeni inventare aby nepadal kdyz je prazdny
    public String zobrazitInventar() {
        String vypisInventare = "";
        if (!inventar.isEmpty()) {
            for (int i = 0; i <inventar.size(); i++) {
                vypisInventare = vypisInventare + inventar.get(i).getNazev() + ", daydreaming zlepsuje o " + inventar.get(i).getZvyseniDaydreamingu()+" a lucidni sneni zlepsuje o "+ inventar.get(i).getZvyseniLucidnihoSneni() + "\n";
            }
        }else return "Inventar je prazdny";
        return vypisInventare;
    }
}
