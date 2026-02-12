package Commands;

import Konzole.Konzole;

/**
 * @author Ondrej Beran
 */
public class Ukoly implements Command {

    /**
     * Command ktery hraci vypise momentalni ukoly pomoci metodu z tridy Ukol
     * @param konzole pro pristup k vsech hernim datum
     */
    public String vykonat(Konzole konzole, String string) {
        String vypisUkolu;
        vypisUkolu = "Tvoje ukoly: " + konzole.getUkol().vypisMomentalnichUkolu();
        return vypisUkolu;
    }
}
