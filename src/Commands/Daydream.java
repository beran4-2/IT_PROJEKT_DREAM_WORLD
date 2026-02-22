package Commands;

import Konzole.Konzole;

public class Daydream implements Command {
    /**
     * Command ktery hracovi umozni pomoci prikauzu se schovat, ukryt a nebo bojovat
     * @param konzole pro pristup k vsech hernim datum
     * @author Ondrej Beran
     * @return
     */
    @Override
    public String vykonat(Konzole konzole, String string) {
        if (konzole.getSamir().getUrovenDaydreamingu() > 0) {
            if (string.equals("utok")) {
                return konzole.getSouboj().daydreamUtok(konzole, konzole.getAktualniLokace());
            } else if (string.equals("ukryt")) {
                konzole.getSamir().setJeUkryty(true);
                return "Samir se ukryl";
            } else if (string.equals("obrana")) {
                return "Samir se brani";
            } else return "spatna 2. cast vstupu";
        }else return "Nemas dostatecnou uroven na daydreaming";
    }


}
