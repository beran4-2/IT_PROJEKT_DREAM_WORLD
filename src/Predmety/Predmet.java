package Predmety;

/**
 * tato trida slouzi jen pro konstrukci predmetu
 */

public class Predmet {
    private String nazev;
    private int zvyseniLucidnihoSneni;
    private int zvyseniDaydreamingu;
    private boolean jePouzivany;
    private String popisPredmetu;
    private String typPredmetu;
    private int aktivniPredmety;

    /**
     * @param nazev
     * @param zvyseniLucidnihoSneni zvysi uroven lucidniho sneni
     * @param zvyseniDaydreamingu zvysi uroven daydreamingu
     * @param jePouzivany znamena jestli je predmetu aktivni jelikoz hrac muze mit z inventare pouze 1 aktivni predmet
     * @param popisPredmetu
     * @param typPredmetu
     */

    public Predmet(String nazev, int zvyseniLucidnihoSneni, int zvyseniDaydreamingu, boolean jePouzivany, String popisPredmetu, String typPredmetu) {
        this.nazev = nazev;
        this.zvyseniLucidnihoSneni = zvyseniLucidnihoSneni;
        this.zvyseniDaydreamingu = zvyseniDaydreamingu;
        this.jePouzivany = jePouzivany;
        this.popisPredmetu = popisPredmetu;
        this.typPredmetu = typPredmetu;
    }

    public Predmet() {
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

    public String getTypPredmetu() {
        return typPredmetu;
    }

    public int getAktivniPredmety() {
        return aktivniPredmety;
    }

    public void setAktivniPredmety(int aktivniPredmety) {
        this.aktivniPredmety = aktivniPredmety;
    }
}
