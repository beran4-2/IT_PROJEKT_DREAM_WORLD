package Inventar_a_Ukoly;
import Konzole.Konzole;
import Predmety.Predmet;
import java.util.ArrayList;

public class Inventar {

    ArrayList<Predmet> inventar = new ArrayList<>();

    //TODO tato metoda bude vyuzita v command komunikace po dodelani herni logiky
    public String pridatPredmet(Konzole konzole, String string) {
        String pridanyPredmet = "";
        for (int i = 0; i < konzole.getData().getPredmety().size(); i++) {
            if (konzole.getData().getPredmety().get(i).getNazev().equals(string))
                inventar.add(konzole.getData().getPredmety().get(i));
                pridanyPredmet = konzole.getData().getPredmety().get(i).getNazev();
        }
        return "byl pridany predmet "+pridanyPredmet;
    }

    public String aktivniPredmet(){
        for (int i = 0; i < inventar.size(); i++) {
            if (inventar.get(i).isJePouzivany()){
                return inventar.get(i).getNazev();
            }
        }
        return "nic neni aktivovano";
    }

    public String odebratPredmet(Konzole konzole, String string) {
        return "";
    }

    public String zobrazitInventar() {
        String vypisInventare = "";
        if (!inventar.isEmpty()) {
            vypisInventare = vypisInventare + "V INVENTARI MAS:\n";
            for (int i = 0; i <inventar.size(); i++) {
                vypisInventare = vypisInventare + (i+1) + ". " + inventar.get(i).getNazev() + ", popis: daydreaming zlepsuje o " + inventar.get(i).getZvyseniDaydreamingu()+" a lucidni sneni zlepsuje o "+ inventar.get(i).getZvyseniLucidnihoSneni() + "\n";
                vypisInventare = vypisInventare + "     co dela: " + inventar.get(i).getPopisPredmetu() + "\n";
            }
        }else vypisInventare = "Inventar je prazdny\n";
        return vypisInventare;
    }

    public ArrayList<Predmet> getInventar() {
        return inventar;
    }
}
