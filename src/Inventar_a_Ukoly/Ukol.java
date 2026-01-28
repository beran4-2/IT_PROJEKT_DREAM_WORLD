package Inventar_a_Ukoly;

import Konzole.Konzole;

import java.util.ArrayList;

public class Ukol {
    private String typUkolu;
    private String nazevUkolu;
    private String popisUkolu;
    private String vJakeLokaciJe;
    private String kdoZadava;
    private ArrayList<Ukol> seznamMomentalnichHlavnichUkolu = new ArrayList<>();
    private ArrayList<Ukol> seznamMomentalnichVedljesichUkolu = new ArrayList<>();


    public Ukol(String typUkolu, String nazevUkolu, String popisUkolu, String kdoZadava, String vJakeLokaciJe) {
        this.typUkolu = typUkolu;
        this.nazevUkolu = nazevUkolu;
        this.popisUkolu = popisUkolu;
        this.kdoZadava = kdoZadava;
        this.vJakeLokaciJe = vJakeLokaciJe;
    }

    public Ukol() {
    }

    /**
     * tato metoda hraci pomoci commandu vypise seznam momentalnich ukolu
     */
    public String vypisMomentalnichUkolu(){
        String vypis = "\n";
        if (seznamMomentalnichHlavnichUkolu.size() != 0) {
            vypis = vypis + "HLAVNI UKOLY:\n" + "////////////\n";
            for (int i = 0; i < seznamMomentalnichHlavnichUkolu.size(); i++) {
                vypis = vypis + "ukol: " + seznamMomentalnichHlavnichUkolu.get(i).nazevUkolu + ", popis: " + seznamMomentalnichHlavnichUkolu.get(i).getPopisUkolu() + "\n";
            }
        }else vypis = vypis + "NEMAS HLAVNI UKOLY\n" + "XXXXXXXXXXXXXXXXXX\n";
        vypis = vypis + "\n";
        if (seznamMomentalnichVedljesichUkolu.size() != 0) {
            vypis = vypis + "VEDLEJSI UKOLY:\n" + "///////////////\n";
            for (int i = 0; i < seznamMomentalnichVedljesichUkolu.size(); i++) {
                vypis = vypis + "Toto jsou tvoje momentalni ukol: " + seznamMomentalnichVedljesichUkolu.get(i).nazevUkolu + ", popis: " + seznamMomentalnichVedljesichUkolu.get(i).getPopisUkolu() + "\n";
            }
        }else vypis = vypis + "NEMAS VEDLEJSI UKOLY\n" + "XXXXXXXXXXXXXXXXXXXX\n";
        return  vypis;
    }


    public void sypacDoMomentalichHlavnichUkolu(){

    }
    public void sypacDoMomentalichVedlejsichUkolu(){

    }

    public String getNazevUkolu() {
        return nazevUkolu;
    }

    public String getPopisUkolu() {
        return popisUkolu;
    }
}
