package Postavy;
import Inventar_a_Ukoly.Ukoly;
import java.util.ArrayList;

public class HodnaPostava extends Postavy {
    private ArrayList<Ukoly> zadavatelneUkoly;

    public HodnaPostava(String jmeno, int zivoty, int fyzickaSila, boolean jeZabitelny, ArrayList<Ukoly> zadavatelneUkoly) {
        super(jmeno, zivoty, fyzickaSila, jeZabitelny);
        this.zadavatelneUkoly = zadavatelneUkoly;
    }


    @Override
    public boolean jeNaZivu() {
        return false;
    }
}
