package Inventar_a_Ukoly;

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
    public void vypisMomentalnichUkolu(){
        System.out.println("HLAVNI UKOLY:");
        if (seznamMomentalnichHlavnichUkolu.size() != 0) {
            for (int i = 0; i < seznamMomentalnichHlavnichUkolu.size(); i++) {

                System.out.println("Toto je tvuj momentalni ukol: " + seznamMomentalnichHlavnichUkolu.get(i).nazevUkolu);
                System.out.println(seznamMomentalnichHlavnichUkolu.get(i).getPopisUkolu());
            }
        }else System.out.println("nemas hlavni ukoly");
        if (seznamMomentalnichVedljesichUkolu.size() != 0) {
            System.out.println("VEDLEJSI UKOLY:");
            for (int i = 0; i < seznamMomentalnichVedljesichUkolu.size(); i++) {
                System.out.println("Toto je tvuj momentalni ukol: " + seznamMomentalnichVedljesichUkolu.get(i).nazevUkolu);
                System.out.println(seznamMomentalnichVedljesichUkolu.get(i).getPopisUkolu());
            }
        }else System.out.println("nemas vedlejsi ukoly");
    }

    //TODO dodelat metodu pomoci konzole.getData.getUkoly
    public void sypacDoMomentalichHlavnichUkolu(Ukol ukol){
        seznamMomentalnichHlavnichUkolu.add(ukol);
    }
    public void sypacDoMomentalichVedlejsichUkolu(Ukol ukol){
        seznamMomentalnichVedljesichUkolu.add(ukol);
    }

    public String getNazevUkolu() {
        return nazevUkolu;
    }

    public String getPopisUkolu() {
        return popisUkolu;
    }
}
