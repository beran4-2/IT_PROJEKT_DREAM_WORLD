package Commands;

import Konzole.Konzole;

public class InventarCommand implements Command {
    //TODO kdyz to opravim ve tride Inventar tak to bude fungovat

    @Override
    public String vykonat(Konzole konzole,String string) {
        if (string.equals("zobrazit")) {
            return konzole.getInventar().zobrazitInventar();
        }
        else return "nespravna 2. cast prikazu";
    }

    public boolean odejit() {
        return false;
    }
}
