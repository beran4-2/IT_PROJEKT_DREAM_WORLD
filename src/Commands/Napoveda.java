package Commands;


import Konzole.Konzole;

public class Napoveda implements Command {
    public String vykonat(Konzole konzole, String string) {
        return "Napoveda k teto mistnosti zni: " + konzole.getAktualniLokace().getNapovedaKMistnosti();
    }
}
