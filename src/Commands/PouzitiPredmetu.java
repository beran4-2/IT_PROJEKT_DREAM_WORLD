package Commands;

import Konzole.Konzole;
import Predmety.Predmet;
import java.util.Arrays;


public class PouzitiPredmetu implements Command {
    public String vykonat(Konzole konzole, String prikaz2) {
        Predmet vyuzivanyPredmet = null;
        String[] rozdeleni = prikaz2.split(" ", 2);
        prikaz2 = rozdeleni[0];

        String predmet = (Arrays.stream(rozdeleni).count() >= 2 ? rozdeleni[1] : "");
        for (int i = 0; i < konzole.getInventar().getInventar().size(); i++) {
            if (konzole.getInventar().getInventar().get(i).isJePouzivany()) {
                vyuzivanyPredmet = konzole.getInventar().getInventar().get(i);
                break;
            }
        }
        if (vyuzivanyPredmet == null){
            if (prikaz2.equals("pridat")) {
                for (int i = 0; i < konzole.getInventar().getInventar().size(); i++) {
                    if (konzole.getInventar().getInventar().get(i).getNazev().equals(predmet)) {
                        vyuzivanyPredmet =  konzole.getInventar().getInventar().get(i);
                        vyuzivanyPredmet.setJePouzivany(true);
                        konzole.getPredmet().setAktivniPredmety(1);
                        konzole.getSamir().aktivaceSchopnosti(konzole, vyuzivanyPredmet);
                        if (vyuzivanyPredmet.getNazev().equals("maska spanku")){konzole.getSamir().setZpusobilyKeSpani(true);}
                        return "\nbyl aktivovan predmet " + vyuzivanyPredmet.getNazev();
                    }
                }
                return "nemas takovy predmet";
            }

        }
        else if (vyuzivanyPredmet != null){
            if (prikaz2.equals("odebrat")) {
                for (int i = 0; i < konzole.getInventar().getInventar().size(); i++) {
                    if (vyuzivanyPredmet.getNazev().equals(predmet)) {
                        vyuzivanyPredmet.setJePouzivany(false);
                        konzole.getPredmet().setAktivniPredmety(0);
                        konzole.getSamir().deaktivaceSchopnosti(konzole.getSamir(), vyuzivanyPredmet);
                        return "odebral si predmet: " + vyuzivanyPredmet.getNazev();
                    }
                }
                return "takovy predmet nebyl nalezen aktivni";
            }
            if (prikaz2.equals("pridat")) {
                return "Uz vyuzivas predmet: " + vyuzivanyPredmet.getNazev();
            }
        }
        return "";

    }

}
