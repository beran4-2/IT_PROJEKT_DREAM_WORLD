package Predmety;

public class Predmet {
    private String nazev;
    private int zvyseniLucidnihoSneni;
    private int zvyseniDaydreamingu;
    private boolean jePouzivany;
    private String popisPredmetu;

    public Predmet(String nazev, int zvyseniLucidnihoSneni, int zvyseniDaydreamingu, boolean jePouzivany, String popisPredmetu) {
        this.nazev = nazev;
        this.zvyseniLucidnihoSneni = zvyseniLucidnihoSneni;
        this.zvyseniDaydreamingu = zvyseniDaydreamingu;
        this.jePouzivany = jePouzivany;
        this.popisPredmetu = popisPredmetu;
    }

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

    public String getPopisPredmetu() {
        return popisPredmetu;
    }
}
