package Postavy;

public class ZlaPostava extends Postavy {
    public int silaSnu;

    public ZlaPostava(String jmeno, int zivoty, int fyzickaSila) {
        super(jmeno, zivoty, fyzickaSila);
    }

    @Override
    public boolean jeNaZivu() {
        return false;
    }
}
