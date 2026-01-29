package Commands;

import Konzole.Konzole;

public class InventarCommand implements Command {

    @Override
    public String vykonat(Konzole konzole,String string) {
        if (string.equals("zobrazit")) {
            return konzole.getInventar().zobrazitInventar();
        }
        else return "nespravna 2. cast prikazu";
    }


}
