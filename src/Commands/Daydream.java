package Commands;

import Konzole.Konzole;

public class Daydream implements Command {


    @Override
    public String vykonat(Konzole konzole, String string) {
        if (konzole.getSamir().getUrovenDaydreamingu() > 0) {
            if (string.equals("utok")) {
                konzole.getSamir().setJeVBoji(true);
                konzole.getSouboj().daydreamUtok(konzole, konzole.getAktualniLokace());
            } else if (string.equals("ukryt")) {
                konzole.getSamir().setJeUkryty(true);
                return "Samir se ukryl";
            } else if (string.equals("obrana")) {
                return "Samir se brani";
            } else return "spatna 2. cast vstupu";
            return "";
        }else return "Nemas dostatecnou uroven na daydreaming";
    }


}
