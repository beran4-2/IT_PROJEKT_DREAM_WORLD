package Postavy;
import Inventar_a_Ukoly.Ukol;
import java.util.ArrayList;

public class HodnaPostava extends Postavy {

    public HodnaPostava(String jmeno, int zivoty, int fyzickaSila, boolean jeZabitelny) {
        super(jmeno, zivoty, fyzickaSila, jeZabitelny);
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
                " jmeno='" + jmeno + '\'' +
                ", kdeSeNachazi='" + kdeSeNachazi + '\'' +
                ", zivoty=" + zivoty +
                ", fyzickaSila=" + fyzickaSila +
                ", jeZabitelny=" + jeZabitelny +
                '}';
    }
}
