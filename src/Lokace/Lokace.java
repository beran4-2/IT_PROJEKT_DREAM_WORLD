/**
 * Tato trida slouzi ke konstrukci lokaci a je zde zpracovavana logika idDialogu
 */

package Lokace;

import Konzole.Konzole;

public class Lokace {
    private String nazev;
    private boolean ukolHotovy;
    private String popis;
    private String naslednik;
    private String napovedaKMistnosti;
    private int idDostupnehoDialogu;
    private boolean mistnostProzkoumana;
    private boolean jeVMistnostiSouboj;

    public Lokace(String nazev, boolean ukolHotovy, String popis, String naslednik, String napovedaKMistnosti, int idDostupnehoDialogu, boolean jeVMistnostiSouboj) {
        this.nazev = nazev;
        this.ukolHotovy = ukolHotovy;
        this.popis = popis;
        this.naslednik = naslednik;
        this.napovedaKMistnosti = napovedaKMistnosti;
        this.idDostupnehoDialogu = idDostupnehoDialogu;
        this.jeVMistnostiSouboj = jeVMistnostiSouboj;
    }

    public Lokace(){

    }

    /**
     * Metoda ktera podle atributu idDialogu hleda nove odemcene dialogy
     * @param konzole pro pristup k vsech hernim datum
     * @param idDialogu vstup ktery zadavam podle potreby
     * @param kde vstup ktery urci kam se ma idDialogu priradit
     * @return
     */
    public String novyDostupnyDialog(Konzole konzole, int idDialogu, String kde){
        for (int i = 0; i < konzole.getData().getLokace().size(); i++) {
            if (konzole.getData().getLokace().get(i).getNazev().equals(kde)){
                konzole.getData().getLokace().get(i).setIdDostupnehoDialogu(idDialogu);
                break;

            }
        }
        return "Mas novy dostupny dialog s Magou";
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

    public String getNazev() {
        return nazev;
    }

    public boolean isUkolHotovy() {
        return ukolHotovy;
    }

    public String getPopis() {
        return popis;
    }

    public String getNaslednik() {
        return naslednik;
    }

    public int getIdDostupnehoDialogu() {
        return idDostupnehoDialogu;
    }

    public String getNapovedaKMistnosti() {
        return napovedaKMistnosti;
    }

    public boolean isMistnostProzkoumana() {
        return mistnostProzkoumana;
    }

    public void setMistnostProzkoumana(boolean mistnostProzkoumana) {
        this.mistnostProzkoumana = mistnostProzkoumana;
    }

    public void setUkolHotovy(boolean ukolHotovy) {
        this.ukolHotovy = ukolHotovy;
    }

    public void setIdDostupnehoDialogu(int idDostupnehoDialogu) {
        this.idDostupnehoDialogu = idDostupnehoDialogu;
    }

    public boolean isJeVMistnostiSouboj() {
        return jeVMistnostiSouboj;
    }

    public void setJeVMistnostiSouboj(boolean jeVMistnostiSouboj) {
        this.jeVMistnostiSouboj = jeVMistnostiSouboj;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public void setNaslednik(String naslednik) {
        this.naslednik = naslednik;
    }

    public void setNapovedaKMistnosti(String napovedaKMistnosti) {
        this.napovedaKMistnosti = napovedaKMistnosti;
    }
}
