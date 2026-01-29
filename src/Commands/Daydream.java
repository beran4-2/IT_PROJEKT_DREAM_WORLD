package Commands;

import Konzole.Konzole;

public class Daydream implements Command {

//TODO Tento command bude dodelan az bude hotove dalsi cviceni #5 Logika Hry

    @Override
    public String vykonat(Konzole konzole, String string) {
        if(string.equals("souboj")){
            return "";


        }

        if (string.equals("ukryt")){
            return "";



        }else return "spatna 2. cast vstupu";
    }

    @Override
    public boolean odejit() {
        return false;
    }


}
