package Commands;

import Konzole.Konzole;
import Postavy.Samir;

/**
 * Command ktery vypise hracovy vlastnosti
 */
public class Vlastnosti implements Command{
    @Override
    public String vykonat(Konzole konzole, String string) {
        return "Zivoty: " + konzole.getSamir().getZivoty() + "\nTvuj level daydreamingu: " + konzole.getSamir().getUrovenDaydreamingu() +
                "\nTvuj level lucidniho sneni: " + konzole.getSamir().getUrovenLucidnihoSneni() + "\nTvoje uroven fyzicke sily: " + konzole.getSamir().getFyzickaSila();

    }
}
