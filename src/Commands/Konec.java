package Commands;

import Konzole.Konzole;

/**
 * @author Ondrej Beran
 */
public class Konec implements Command {
    /**
     * Command ktery hraci umozni ukoncit hru
     * @param konzole pro pristup k vsech hernim datum
     */
    public String vykonat(Konzole konzole, String string) {
        konzole.setKonecHry(true);
        return "Hra je ukoncena";
    }
}
