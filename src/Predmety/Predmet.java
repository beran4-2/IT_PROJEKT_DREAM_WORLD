package Predmety;

public class Predmet {
    private String nazev;
    private int zvyseniLucidnihoSneni;
    private int zvyseniDaydreamingu;
    private boolean jePouzivany;

    public String getNazev() {
        return nazev;
    }

    public int getZvyseniLucidnihoSneni() {
        return zvyseniLucidnihoSneni;
    }

    public int getZvyseniDaydreamingu() {
        return zvyseniDaydreamingu;
    }

    public boolean isJePouzivany() {
        return jePouzivany;
    }

    public void setJePouzivany(boolean jePouzivany) {
        this.jePouzivany = jePouzivany;
    }
}
