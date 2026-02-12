package Commands;

import Konzole.Konzole;

public class InventarCommand implements Command {

    /**
     * Command ktery skrz metodu z tridy Inventar vypise
     * @param konzole pro pristup k vsech hernim datum
     * @author Ondrej Beran
     */
    @Override
    public String vykonat(Konzole konzole,String string) {
        if (string.equals("zobrazit")) {
            return konzole.getInventar().zobrazitInventar();
        }
        else return "nespravna 2. cast prikazu";
    }


}
