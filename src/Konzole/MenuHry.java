package Konzole;

/**
 * Tato trida obsahuje pouze metodu menuHry
 */

public class MenuHry {

    /**
     * Tato metoda po kazdem cyklu vypise hlavni menu hry
     * @param konzole pro pristup k vsech hernim datum
     * @return vypis celeho menu
     */
    public String menuHry(Konzole konzole){
        String vypisMenu = "";
        vypisMenu = "\n--------------------------------\n";
        if (konzole.getSamir().isJeVBoji()){
            vypisMenu = vypisMenu + "\nSamirovy zivoty: " + konzole.getSamir().getZivoty();
            vypisMenu = vypisMenu + "\nmomentalne se nachazis v boji s ";
            if (konzole.getSouboj().hledaniHodnePostavy(konzole, konzole.getAktualniLokace()) != null) {
                vypisMenu = vypisMenu +   konzole.getSouboj().hledaniHodnePostavy(konzole, konzole.getAktualniLokace()).getJmeno();
            } else vypisMenu = vypisMenu + konzole.getSouboj().hledaniZlePostavy(konzole, konzole.getAktualniLokace()).getJmeno();

        }
        vypisMenu = vypisMenu + "\nMomentalni lokace: ";
        if (konzole.getAktualniLokace().isMistnostProzkoumana()){
            vypisMenu = vypisMenu + konzole.getAktualniLokace().getNazev();
        }
        else vypisMenu = vypisMenu + "neznama";
        if (konzole.getPredmet().getAktivniPredmety() == 1){
            vypisMenu = vypisMenu + "\nMas aktivni predmet: " + konzole.getInventar().aktivniPredmet();;
        }
        vypisMenu = vypisMenu + "\nMomentalni hlavni ukol: " + konzole.getUkol().najitNazevAktualniho();
        vypisMenu = vypisMenu + "\nJestli nevis co zadat, pomoc";
        return vypisMenu;
    }
}
