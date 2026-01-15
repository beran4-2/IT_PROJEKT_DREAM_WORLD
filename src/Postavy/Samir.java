package Postavy;

public class Samir extends Postavy {
    private int urovenDaydreamingu;
    private int urovenLucidnihoSneni;

    public Samir(String jmeno, int zivoty, int fyzickaSila) {
        super(jmeno, zivoty, fyzickaSila);
    }

    @Override
    public boolean jeNaZivu() {
        return false;
    }
}
