package Postavy;
import Inventar_a_Ukoly.Ukol;
import java.util.ArrayList;

public class HodnaPostava extends Postavy {
    private ArrayList<Ukol> zadavatelneUkol;

    public HodnaPostava(String jmeno, int zivoty, int fyzickaSila, boolean jeZabitelny, ArrayList<Ukol> zadavatelneUkol) {
        super(jmeno, zivoty, fyzickaSila, jeZabitelny);
        this.zadavatelneUkol = zadavatelneUkol;
    }


    @Override
    public boolean jeNaZivu() {
        return false;
    }
}
