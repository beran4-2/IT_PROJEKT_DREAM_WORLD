package souboj;

import Konzole.Konzole;
import Postavy.HodnaPostava;
import Postavy.ZlaPostava;

public class Souboj {

    public String trestZaSpatnyCommand(Konzole konzole) {
        if (konzole.getSamir().isJeVBoji()) {
            HodnaPostava hodnaPostava = null;
            ZlaPostava zlaPostava = null;
            int ubraneZivoty = 0;
            String jmenoPostavy = "";
            for (int i = 0; i < konzole.getData().getHodnePostavy().size(); i++) {
                if (konzole.getData().getHodnePostavy().get(i).getKdeSeNachazi().equals(konzole.getAktualniLokace().getNazev())){
                    hodnaPostava = konzole.getData().getHodnePostavy().get(i);
                    jmenoPostavy = hodnaPostava.getJmeno();
                    break;
                }
            }
            for (int i = 0; i < konzole.getData().getZlePostavy().size(); i++) {
                if (konzole.getData().getZlePostavy().get(i).getKdeSeNachazi().equals(konzole.getAktualniLokace().getNazev())){
                    zlaPostava = konzole.getData().getZlePostavy().get(i);
                    jmenoPostavy = zlaPostava.getJmeno();
                    break;
                }
            }
            if (zlaPostava != null) {
                ubraneZivoty = (zlaPostava.getSilaSnu()*3 + zlaPostava.getFyzickaSila()*2);
                konzole.getSamir().setZivoty(hodnaPostava.getZivoty() - ubraneZivoty);
            }
            if (hodnaPostava != null){
                ubraneZivoty = hodnaPostava.getFyzickaSila()*10;
                konzole.getSamir().setZivoty(hodnaPostava.getZivoty() - ubraneZivoty);
            }

        return "\nMomentalne se nachazis v boji s " + jmenoPostavy +" a ty si vyuzil spatny prikaz, bylo ti ubrano " + ubraneZivoty + " zivotu";
        }else return "";
    }

}
