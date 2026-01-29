package Postavy;

import java.util.ArrayList;

public class Samir extends Postavy {
    private int urovenDaydreamingu;
    private int urovenLucidnihoSneni;
    private boolean jeUkryty;
    private boolean spi;
    private boolean jeVBoji;

    public Samir(String jmeno, int zivoty, int fyzickaSila, boolean jeZabitelny, int urovenDaydreamingu, int urovenLucidnihoSneni) {
        super(jmeno, zivoty, fyzickaSila, jeZabitelny);
        this.urovenDaydreamingu = urovenDaydreamingu;
        this.urovenLucidnihoSneni = urovenLucidnihoSneni;
    }

    public Samir() {
    }

    @Override
    public boolean jeNaZivu() {
        return false;
    }

    public int getUrovenDaydreamingu() {
        return urovenDaydreamingu;
    }

    public int getUrovenLucidnihoSneni() {
        return urovenLucidnihoSneni;
    }

    public boolean isSpi() {
        return spi;
    }

    public void setSpi(boolean spi) {
        this.spi = spi;
    }

    public boolean isJeVBoji() {
        return jeVBoji;
    }

    public void setJeVBoji(boolean jeVBoji) {
        this.jeVBoji = jeVBoji;
    }

    public boolean isJeUkryty() {
        return jeUkryty;
    }

    public void setJeUkryty(boolean jeUkryty) {
        this.jeUkryty = jeUkryty;
    }
}
