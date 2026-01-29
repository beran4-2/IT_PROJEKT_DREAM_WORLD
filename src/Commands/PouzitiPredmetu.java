package Commands;

import Konzole.Konzole;
import Predmety.Predmet;

//TODO Tento command bude lepe fungovat az bude hotove dalsi cviceni #5 Logika Hry

public class PouzitiPredmetu implements Command {
    public String vykonat(Konzole konzole, String prikaz2) {
        Predmet vyuzivanyPredmet = null;
        String[] rozdeleni = prikaz2.split(" ", 2);
        prikaz2 = rozdeleni[0];
        String predmet = rozdeleni[1];
        for (int i = 0; i < konzole.getInventar().getInventar().size(); i++) {
            if (konzole.getInventar().getInventar().get(i).isJePouzivany()) {
                vyuzivanyPredmet = konzole.getInventar().getInventar().get(i);
                break;
            }else vyuzivanyPredmet = null;
        }
        if (vyuzivanyPredmet == null){
            if (prikaz2.equals("pridat")) {
                for (int i = 0; i < konzole.getInventar().getInventar().size(); i++) {
                    if (konzole.getInventar().getInventar().get(i).getNazev().equals(predmet)) {
                        vyuzivanyPredmet =  konzole.getInventar().getInventar().get(i);
                        vyuzivanyPredmet.setJePouzivany(true);
                        return "byl aktivovan predmet " + vyuzivanyPredmet.getNazev();
                    } else vyuzivanyPredmet = null;
                }
            }



        }else if (vyuzivanyPredmet == null){
            return "nemas takovy predmet";



        }else if (vyuzivanyPredmet != null){
            if (prikaz2.equals("odebrat")) {
                for (int i = 0; i < konzole.getInventar().getInventar().size(); i++) {
                    String nazevOdebraneho = vyuzivanyPredmet.getNazev();
                    vyuzivanyPredmet.setJePouzivany(false);
                    return "odebral si predmet: " + nazevOdebraneho;

                }
            }


        }else {
            return "Uz vyuzivas predmet: " + vyuzivanyPredmet.getNazev();
        }
        return "";

    }
    public boolean odejit() {
        return false;
    }
}
