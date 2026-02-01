package Postavy;

import java.util.ArrayList;

public abstract class Postavy {
    protected String jmeno;
    protected String kdeSeNachazi;
    protected int zivoty;
    protected int fyzickaSila;
    protected boolean jeZabitelny;

    public abstract boolean jeNaZivu();

    public Postavy() {
    }

    public Postavy(String jmeno, int zivoty, int fyzickaSila, boolean jeZabitelny) {
        this.jmeno = jmeno;
        this.zivoty = zivoty;
        this.fyzickaSila = fyzickaSila;
        this.jeZabitelny = jeZabitelny;

    }

    public String getKdeSeNachazi() {
        return kdeSeNachazi;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setZivoty(int zivoty) {
        this.zivoty = zivoty;
    }

    public boolean isJeZabitelny() {
        return jeZabitelny;
    }

    public void setJeZabitelny(boolean jeZabitelny) {
        this.jeZabitelny = jeZabitelny;
    }

    public int getZivoty() {
        return zivoty;
    }

    public int getFyzickaSila() {
        return fyzickaSila;
    }

    public void setFyzickaSila(int fyzickaSila) {
        this.fyzickaSila = fyzickaSila;
    }
}
