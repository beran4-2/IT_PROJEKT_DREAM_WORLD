package Commands;

import Konzole.Konzole;

public class Pomoc implements Command {
    public String vykonat(Konzole konzole, String string) {
        return "pomoc, napoveda, konec, mluvit, jit dal/zpatky, daydream souboj/ukryt, prozkoumat, ukoly, inventar zobrazit, pouzit pridat/odebrat (predmet)";
    }
}
