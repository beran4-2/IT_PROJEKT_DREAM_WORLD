package Postavy;

import Konzole.Konzole;

/**
 * Materska trida postav
 * @author Ondrej Beran
 */
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

    public String setZivoty(Konzole konzole, int zivoty) {
        this.zivoty = zivoty;
        if (this.zivoty <= 0){
            if (this.jmeno.equals("Jester")){
                return konzole.getData().nactiDataZeSouboru("JesterSouboj") + "\n";
            }
            if (this.jmeno.equals("Negani")){
                konzole.getUkol().splneniUkolu(konzole, konzole.getUkol().getIdAktualnihoUkolu(), "hlavni");
                konzole.getLokace().novyDostupnyDialog(konzole, 702, "Jezero");
                return konzole.getData().nactiDataZeSouboru("Negani");
            }
            if (this.jmeno.equals("Noiceur")){
                konzole.getUkol().splneniUkolu(konzole,konzole.getUkol().getIdAktualnihoUkolu(),"hlavni");
                return konzole.getData().nactiDataZeSouboru("konec");
            }
            return "Zabil si " + this.jmeno;
        }
        return "";
    }

    public boolean isJeZabitelny() {
        return jeZabitelny;
    }

    public void setJeZabitelnyZlaPostava(Konzole konzole, String kde) {
        for (int i = 0; i < konzole.getData().getZlePostavy().size(); i++) {
            if (konzole.getData().getZlePostavy().get(i).getKdeSeNachazi().equals(kde)) {
                konzole.getData().getZlePostavy().get(i).setJeZabitelny(true);
            }
        }
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
