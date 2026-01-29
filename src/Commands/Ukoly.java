package Commands;

import Konzole.Konzole;

public class Ukoly implements Command {

    public String vykonat(Konzole konzole, String string) {
        return "Tvoje ukoly: " + konzole.getUkol().vypisMomentalnichUkolu();
    }
}
