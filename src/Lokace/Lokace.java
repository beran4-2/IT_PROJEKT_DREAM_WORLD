package Lokace;

public abstract class Lokace {
    protected String nazev;
    protected boolean ukolHotovy;
    protected String popis;

    public abstract void dejVMistonosti();

    public Lokace(String nazev, boolean ukolHotovy, String popis) {
        this.nazev = nazev;
        this.ukolHotovy = ukolHotovy;
        this.popis = popis;
    }
}
