package Commands;

import Konzole.Konzole;

/**
 * @author Ondrej Beran
 */
public class Spanek implements Command {

    /**
     * Command ktery hrace dostane bud jen do spanku nebo do lucidniho souboje
     *
     * @param konzole pro pristup k vsech hernim datum
     * @param string  vstup podle ktereho se urci jestli hrac jde pouze spat nebo bojovat
     */
    @Override
    public String vykonat(Konzole konzole, String string) {
        if (konzole.getSamir().isZpusobilyKeSpani()) {
        String konecnyVypis = "";
        if (string.equals("")) {

        }
        else if (string.equals("lucidni sneni")) {
            if (konzole.getSamir().getUrovenLucidnihoSneni() > 0) {
                konecnyVypis = konecnyVypis + konzole.getSouboj().lucidniSouboj(konzole);
            } else konecnyVypis = konecnyVypis + "Nemas dostatecnou uroven pro lucidni sneni\n";
        }
        else return "Spatna 2. cast prikazu";

        if (konzole.getAktualniLokace().getNazev().equals("Civitas Domov")) {
            if (konzole.getSamir().getPocetSpankuDoma() == 0){
                System.out.println(konzole.getData().nactiDataZeSouboru("sen"));
                konzole.getSamir().setPocetSpankuDoma(konzole.getSamir().getPocetSpankuDoma() + 1);
                konecnyVypis = konecnyVypis + konzole.getUkol().splneniUkolu(konzole, konzole.getUkol().getIdAktualnihoUkolu(), "hlavni") + "\n";
                konzole.getAktualniLokace().setIdDostupnehoDialogu(201);
            }

        }

        konecnyVypis = konecnyVypis + "\nvyspal ses";
        return konecnyVypis;

        }else return  "Spat nemuzes";
}
}
