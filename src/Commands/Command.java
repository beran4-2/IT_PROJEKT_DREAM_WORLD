package Commands;

import Konzole.Konzole;

public interface Command {
    public abstract String vykonat(Konzole konzole, String string);

}
