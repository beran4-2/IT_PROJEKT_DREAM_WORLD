package Commands;

import Konzole.Konzole;

public class Konec implements Command {
    public String vykonat(Konzole konzole, String string) {
        konzole.setKonecHry(true);
        return "Hra je ukoncena";
    }
}
