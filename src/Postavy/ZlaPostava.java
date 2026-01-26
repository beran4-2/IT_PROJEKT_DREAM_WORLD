package Postavy;

import java.util.ArrayList;

public class ZlaPostava extends Postavy {
    public int silaSnu;

    public ZlaPostava(String jmeno, int zivoty, int fyzickaSila, boolean jeZabitelny, ArrayList<String> textPostavy, int silaSnu) {
        super(jmeno, zivoty, fyzickaSila, jeZabitelny, textPostavy);
        this.silaSnu = silaSnu;
    }



    @Override
    public boolean jeNaZivu() {
        return false;
    }
}
