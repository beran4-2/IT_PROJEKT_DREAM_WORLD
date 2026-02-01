package Commands;


import Konzole.Konzole;

public class Napoveda implements Command {
    public String vykonat(Konzole konzole, String string) {
        if (konzole.getAktualniLokace().isMistnostProzkoumana()) {
            return "Napoveda k teto mistnosti zni: " + konzole.getAktualniLokace().getNapovedaKMistnosti() + konzole.getSouboj().trestZaSpatnyCommand(konzole);
        }else return "Mistnost neni prozkoumana";
    }
}
