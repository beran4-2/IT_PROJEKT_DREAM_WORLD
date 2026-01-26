package Postavy;

import java.util.ArrayList;

public class Samir extends Postavy {
    private int urovenDaydreamingu;
    private int urovenLucidnihoSneni;

    public Samir(String jmeno, int zivoty, int fyzickaSila, boolean jeZabitelny, int urovenDaydreamingu, int urovenLucidnihoSneni) {
        super(jmeno, zivoty, fyzickaSila, jeZabitelny);
        this.urovenDaydreamingu = urovenDaydreamingu;
        this.urovenLucidnihoSneni = urovenLucidnihoSneni;
    }


    @Override
    public boolean jeNaZivu() {
        return false;
    }
}
