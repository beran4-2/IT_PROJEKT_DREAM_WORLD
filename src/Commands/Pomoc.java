package Commands;

import Konzole.Konzole;

public class Pomoc implements Command {
    public String vykonat(Konzole konzole, String string) {
        return "pomoc, konec, mluvit, jdi dal/zpatky, daydream souboj/ukryt, průzkum, úkoly";
    }
    public boolean odejit() {
        return false;
    }
}
