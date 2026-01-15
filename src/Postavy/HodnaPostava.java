package Postavy;

public class HodnaPostava extends Postavy {
    public HodnaPostava(String jmeno, int zivoty, int fyzickaSila) {
        super(jmeno, zivoty, fyzickaSila);
    }

    @Override
    public boolean jeNaZivu() {
        return false;
    }
}
