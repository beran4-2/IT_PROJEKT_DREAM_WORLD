package Commands;

import Konzole.Konzole;

public class Ukoly implements Command {

    public String vykonat(Konzole konzole, String string) {
        String vypisUkolu;
        vypisUkolu = "Tvoje ukoly: " + konzole.getUkol().vypisMomentalnichUkolu();
        return vypisUkolu;
    }
}
