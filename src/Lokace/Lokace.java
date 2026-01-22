package Lokace;

public class Lokace {
    private String nazev;
    private boolean ukolHotovy;
    private String popis;
    private String naslednik;


    public void dejVMistonosti() {

    }

    public Lokace(String nazev, boolean ukolHotovy, String popis, String naslednik) {
        this.nazev = nazev;
        this.ukolHotovy = ukolHotovy;
        this.popis = popis;
        this.naslednik = naslednik;
    }

    @Override
    public String toString() {
        return "Lokace{" +
                "nazev='" + nazev + '\'' +
                ", ukolHotovy=" + ukolHotovy +
                ", popis='" + popis + '\'' +
                ", naslednik='" + naslednik + '\'' +
                '}';
    }
}
