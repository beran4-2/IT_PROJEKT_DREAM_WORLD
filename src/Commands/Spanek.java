package Commands;

import Konzole.Konzole;

import java.util.jar.JarEntry;

public class Spanek implements Command{

    @Override
    public String vykonat(Konzole konzole, String string) {
        String konecnyVypis = "";
            if (konzole.getSamir().isZpusobilyKeSpani()) {
                konzole.getSamir().setSpi(true);
                if (konzole.getSamir().getPocetSpankuDoma() == 0 && konzole.getAktualniLokace().getNazev().equals("Civitas Domov")) {
                    System.out.println(konzole.getData().nactiDataZeSouboru("sen"));
                    konzole.getSamir().setPocetSpankuDoma(konzole.getSamir().getPocetSpankuDoma() + 1);
                    konecnyVypis = konecnyVypis + konzole.getUkol().splneniUkolu(konzole, konzole.getUkol().getIdAktualnihoUkolu(), "hlavni") + "\n";
                    konzole.getAktualniLokace().setIdDostupnehoDialogu(201);
                }
                if (konzole.getAktualniLokace().getNazev().equals("Civitas Domov")){

                }
                if (string.equals("lucidni sneni")){
                    if (konzole.getSamir().getUrovenLucidnihoSneni() > 0) {
                        konecnyVypis = konecnyVypis + konzole.getSouboj().lucidniSouboj(konzole);



                    }else konecnyVypis = konecnyVypis + "Nemas dostatecnou uroven pro lucidni sneni\n";

                }else if (string.equals("")){

                }else konecnyVypis = "neplatna 2. cast prikazu";

                konzole.getSamir().setSpi(false);
                konecnyVypis = konecnyVypis + "vyspal ses";
            }
            else konecnyVypis = "Spat nemuzes";
        return konecnyVypis;
    }
}
