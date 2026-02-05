package Postavy;

import Konzole.Konzole;
import Predmety.Predmet;

import java.util.ArrayList;

public class Samir extends Postavy {
    private int urovenDaydreamingu;
    private int urovenLucidnihoSneni;
    private int pocetSpankuDoma = 0;
    private boolean jeUkryty;

    //TODO popremyslet o tom jestli je vubec potreba mit atribut spi
    private boolean spi;
    private boolean jeVBoji;
    private boolean zpusobilyKeSpani;

    public Samir(String jmeno, int zivoty, int fyzickaSila, boolean jeZabitelny, int urovenDaydreamingu, int urovenLucidnihoSneni, int pocetSpankuDoma, boolean jeUkryty, boolean spi, boolean jeVBoji, boolean zpusobilyKeSpani) {
        super(jmeno, zivoty, fyzickaSila, jeZabitelny);
        this.urovenDaydreamingu = urovenDaydreamingu;
        this.urovenLucidnihoSneni = urovenLucidnihoSneni;
        this.pocetSpankuDoma = pocetSpankuDoma;
        this.jeUkryty = jeUkryty;
        this.spi = spi;
        this.jeVBoji = jeVBoji;
        this.zpusobilyKeSpani = zpusobilyKeSpani;
    }



    public Samir() {
    }

    public void aktivaceSchopnosti(Konzole konzole, Predmet predmet) {
      konzole.getSamir().setUrovenDaydreamingu(konzole.getSamir().getUrovenDaydreamingu() + predmet.getZvyseniDaydreamingu());
      konzole.getSamir().setUrovenLucidnihoSneni(konzole.getSamir().getUrovenLucidnihoSneni() + predmet.getZvyseniLucidnihoSneni());
    }
    public void deaktivaceSchopnosti(Samir samir, Predmet predmet){
        samir.setUrovenDaydreamingu(samir.getUrovenDaydreamingu() - predmet.getZvyseniDaydreamingu());
        samir.setUrovenLucidnihoSneni(samir.getUrovenLucidnihoSneni() - predmet.getZvyseniLucidnihoSneni());
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

    public boolean isZpusobilyKeSpani() {
        return zpusobilyKeSpani;
    }

    public void setZpusobilyKeSpani(boolean zpusobilyKeSpani) {
        this.zpusobilyKeSpani = zpusobilyKeSpani;
    }

    public int getPocetSpankuDoma() {
        return pocetSpankuDoma;
    }

    public void setPocetSpankuDoma(int pocetSpankuDoma) {
        this.pocetSpankuDoma = pocetSpankuDoma;
    }

    public String setUrovenDaydreamingu(int urovenDaydreamingu) {
        int staraUroven = this.urovenDaydreamingu;
        this.urovenDaydreamingu = urovenDaydreamingu;
        return "Tvoje uroven daydreamingu byla zvysena o " + (this.urovenDaydreamingu - staraUroven)+"\n";
    }

    public String setUrovenLucidnihoSneni(int urovenLucidnihoSneni) {
        int staraUroven = this.urovenLucidnihoSneni;
        this.urovenLucidnihoSneni = urovenLucidnihoSneni;
        return "Tvoje uroven lucidniho sneni se zvysila o " + (this.urovenLucidnihoSneni-staraUroven) + "\n";
    }

    @Override
    public String toString() {
        return "Samir{" +
                "urovenDaydreamingu=" + urovenDaydreamingu +
                ", urovenLucidnihoSneni=" + urovenLucidnihoSneni +
                ", pocetSpankuDoma=" + pocetSpankuDoma +
                ", jeUkryty=" + jeUkryty +
                ", spi=" + spi +
                ", jeVBoji=" + jeVBoji +
                ", zpusobilyKeSpani=" + zpusobilyKeSpani +
                ", jmeno='" + jmeno + '\'' +
                ", kdeSeNachazi='" + kdeSeNachazi + '\'' +
                ", zivoty=" + zivoty +
                ", fyzickaSila=" + fyzickaSila +
                ", jeZabitelny=" + jeZabitelny +
                '}';
    }
}
