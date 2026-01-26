package Inventar_a_Ukoly;

import Konzole.Konzole;
import java.util.ArrayList;

public class Ukoly {
    private String nazevUkolu;
    private String popisUkolu;
    private String vJakeLokaciJe;
    private String kdoZadava;
    private ArrayList<Ukoly> seznamMomentalnichUkolu = new ArrayList<>();


    public Ukoly(String nazevUkolu, String popisUkolu, String vJakeLokaciJe) {
        this.nazevUkolu = nazevUkolu;
        this.popisUkolu = popisUkolu;
        this.vJakeLokaciJe = vJakeLokaciJe;
    }

    public void vypisMomentalnichUkolu(){
        for (int i = 0; i < seznamMomentalnichUkolu.size(); i++) {
            System.out.println("Toto je tvuj momentalni ukol: " + seznamMomentalnichUkolu.get(i).nazevUkolu);
            System.out.println(seznamMomentalnichUkolu.get(i).getPopisUkolu());
        }
    }

    //TODO dodelat metodu pomoci konzole.getData.getUkoly
    /*public void sypacDoMomentalichUkolu(){
        for (int i = 0; i < ; i++) {

        }
    }*/

    public String getNazevUkolu() {
        return nazevUkolu;
    }

    public String getPopisUkolu() {
        return popisUkolu;
    }
}
