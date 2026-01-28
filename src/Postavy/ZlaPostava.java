package Postavy;

import java.util.ArrayList;

public class ZlaPostava extends Postavy {
    public int silaSnu;

    public ZlaPostava(String jmeno, int zivoty, int fyzickaSila, boolean jeZabitelny, int silaSnu) {
        super(jmeno, zivoty, fyzickaSila, jeZabitelny);
        this.silaSnu = silaSnu;
    }



    @Override
    public boolean jeNaZivu() {
        return false;
    }

    @Override
    public String toString() {
        return "ZlaPostava{" +
                "silaSnu=" + silaSnu +
                ", jmeno='" + jmeno + '\'' +
                ", kdeSeNachazi='" + kdeSeNachazi + '\'' +
                ", zivoty=" + zivoty +
                ", fyzickaSila=" + fyzickaSila +
                ", jeZabitelny=" + jeZabitelny +
                '}';
    }
}
