package Postavy;
import Inventar_a_Ukoly.Ukol;
import java.util.ArrayList;

public class HodnaPostava extends Postavy {
    private ArrayList<Ukol> zadavatelneUkol;

    public HodnaPostava(String jmeno, int zivoty, int fyzickaSila, boolean jeZabitelny, ArrayList<Ukol> zadavatelneUkol) {
        super(jmeno, zivoty, fyzickaSila, jeZabitelny);
        this.zadavatelneUkol = zadavatelneUkol;
    }

    public HodnaPostava() {
    }

    @Override
    public boolean jeNaZivu() {
        return false;
    }

    @Override
    public String toString() {
        return "HodnaPostava{" +
                "zadavatelneUkol=" + zadavatelneUkol +
                ", jmeno='" + jmeno + '\'' +
                ", kdeSeNachazi='" + kdeSeNachazi + '\'' +
                ", zivoty=" + zivoty +
                ", fyzickaSila=" + fyzickaSila +
                ", jeZabitelny=" + jeZabitelny +
                '}';
    }
}
