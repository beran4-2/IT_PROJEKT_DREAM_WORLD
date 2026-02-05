package Commands;

import Konzole.Konzole;

import java.util.jar.JarEntry;

public class Spanek implements Command{

    //TODO zde doputuji 2 stringy muze i jen jeden ale ten druhy (lucidne snit) bude slouzit k souboji dostupnych nepratel, po zadani prikazu se hraci ukaze tabulka moznych zabitelnych nepratel a hrac si bude muset vybrat koho chce zabit nebo moznost x ktera vystoupi z listu a hrac neudela nic
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
                        //TODO tady dolnim nejakou tabulku nebo neco kde si hrac vybere koho bude chtit zabit, pokud nebude koho vrati se ze nemuze nikoho zabit
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
