package Commands;

import Konzole.Konzole;

public class Daydream implements Command {

//TODO Tento command bude dodelan az bude dodelan v ramci dalsiho cviceni #5 Logika Hry protoze je s nim propojeny

    @Override
    public String vykonat(Konzole konzole, String string) {
        if(string.equals("souboj")){
            konzole.getSamir().setJeVBoji(true);
            return "Samir bojuje";


        }

        if (string.equals("ukryt")){
            konzole.getSamir().setJeUkryty(true);
            return "Samir se ukryl";


        }else return "spatna 2. cast vstupu";
    }


}
