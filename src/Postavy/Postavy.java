package Postavy;

public abstract class Postavy {
    protected String jmeno;
    protected int zivoty;
    protected int fyzickaSila;

    public abstract boolean jeNaZivu();

    public Postavy(String jmeno, int zivoty, int fyzickaSila) {
        this.jmeno = jmeno;
        this.zivoty = zivoty;
        this.fyzickaSila = fyzickaSila;
    }
}
