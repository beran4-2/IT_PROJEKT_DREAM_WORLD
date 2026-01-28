package Commands;

import Konzole.Konzole;

public class Pomoc implements Command {
    public String vykonat(Konzole konzole, String string) {
        return "pomoc, napoveda, konec, mluvit, jdi dal/zpatky, daydream souboj/ukryt, pruzkum, ukoly, inventar zobrazit";
    }
    public boolean odejit() {
        return false;
    }
}
