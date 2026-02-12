package Commands;

import Konzole.Konzole;

public class Pomoc implements Command {

    /**
     * Command ktery uzivateli vypise vsechnu mozne prikazy
     * @param konzole pro pristup k vsech hernim datum
     * @return
     */
    public String vykonat(Konzole konzole, String string) {
        return "pomoc, napoveda, konec, mluvit, jit dal/zpatky, daydream utok/obrana/ukryt, prozkoumat, ukoly, spat (lucidni sneni), inventar zobrazit, pouzit pridat/odebrat (predmet), vlastnostil";
    }
}
