package Konzole;

public class MenuHry {
    public String menuHry(Konzole konzole){
        String vypisMenu = "";
        vypisMenu = "\n--------------------------------\n";
        vypisMenu = vypisMenu + "Momentalni lokace: ";
        if (konzole.getAktualniLokace().isMistnostProzkoumana()){
            vypisMenu = vypisMenu + konzole.getAktualniLokace().getNazev();
        }
        else vypisMenu = vypisMenu + "neznama";
        if (konzole.getSamir().isJeVBoji()){vypisMenu = vypisMenu + "\nmomentalne se nachazis v boji";}
        if (konzole.getPredmet().getAktivniPredmety() == 1){
            String aktivniPredmet;
            for (int i = 0; i < konzole.getData().getPredmety().size(); i++) {
                if (konzole.getData().getPredmety().get(i).isJePouzivany()){
                    aktivniPredmet = konzole.getData().getPredmety().get(i).getNazev();
                    vypisMenu = vypisMenu + "\nMas aktivni predmet: " + aktivniPredmet;
                }
            }
        }
        vypisMenu = vypisMenu + "\nJestli nevis co zadat, pomoc";
        return vypisMenu;
    }
}
