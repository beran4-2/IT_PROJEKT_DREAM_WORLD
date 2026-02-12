package Commands;


import Konzole.Konzole;

/**
 * Command ktery hraci vypise napovedu pro mistnost
 */
public class Napoveda implements Command {
    public String vykonat(Konzole konzole, String string) {
        if (konzole.getAktualniLokace().isMistnostProzkoumana()) {
            return "Napoveda k teto mistnosti zni: " + konzole.getAktualniLokace().getNapovedaKMistnosti();
        }else return "Mistnost neni prozkoumana";
    }
}
