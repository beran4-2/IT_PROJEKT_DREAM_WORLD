package Inventar_a_Ukoly;

import Konzole.Konzole;

import java.util.ArrayList;

public class Ukol {
    private String typUkolu;
    private String nazevUkolu;
    private String popisUkolu;
    private int idUkolu;
    private int idNaslednehoUkolu;
    private boolean otevreDalsiLokaci;
    private boolean ukolSplnen;
    private ArrayList<Ukol> seznamMomentalnichHlavnichUkolu = new ArrayList<>();
    private ArrayList<Ukol> seznamMomentalnichVedljesichUkolu = new ArrayList<>();
    private int idAktualnihoUkolu;



    public Ukol() {
    }

    /**
     * tato metoda hraci pomoci commandu vypise seznam momentalnich ukolu
     */
    public String vypisMomentalnichUkolu(){
        String vypis = "\n";
        if (seznamMomentalnichHlavnichUkolu.size() != 0) {
            vypis = vypis + "HLAVNI UKOLY:\n";
            for (int i = 0; i < seznamMomentalnichHlavnichUkolu.size(); i++) {
                vypis = vypis + "ukol: " + seznamMomentalnichHlavnichUkolu.get(i).nazevUkolu + "\n         popis: " + seznamMomentalnichHlavnichUkolu.get(i).getPopisUkolu() + "\n";
            }
        }else vypis = vypis + "NEMAS HLAVNI UKOLY\n";
        vypis = vypis + "\n";
        if (seznamMomentalnichVedljesichUkolu.size() != 0) {
            vypis = vypis + "VEDLEJSI UKOLY:\n";
            for (int i = 0; i < seznamMomentalnichVedljesichUkolu.size(); i++) {
                vypis = vypis + "Toto jsou tvoje momentalni ukol: " + seznamMomentalnichVedljesichUkolu.get(i).nazevUkolu + ", popis: " + seznamMomentalnichVedljesichUkolu.get(i).getPopisUkolu() + "\n";
            }
        }else vypis = vypis + "NEMAS VEDLEJSI UKOLY";
        return  vypis;
    }



    public String splneniUkolu(Konzole konzole, int idUkolu, String typUkolu){
        splnitUkol(idUkolu, typUkolu);
        String vypis = "";
        Ukol splnenyUkol;
        if (seznamMomentalnichHlavnichUkolu.size()>0) {
            for (int i = 0; i < seznamMomentalnichHlavnichUkolu.size(); i++) {
                if (seznamMomentalnichHlavnichUkolu.get(i).isUkolSplnen()){
                    splnenyUkol = seznamMomentalnichHlavnichUkolu.get(i);
                    vypis = vypis + "Splnil si ukol " + splnenyUkol.getNazevUkolu();
                    konzole.getAktualniLokace().setUkolHotovy(true);
                    vypis = vypis + "\nbyla odemcena dalsi mistnost";
                    vypis =vypis + "\n" + nalezeniDalsihoUkolu(konzole, splnenyUkol.getIdNaslednehoUkolu());
                    seznamMomentalnichHlavnichUkolu.remove(splnenyUkol);
                    setIdAktualnihoUkolu(splnenyUkol.idNaslednehoUkolu);

                }
            }
            return vypis;

        }else return "";
    }
    public void splnitUkol(int idUkolu, String typUkolu){
        if (typUkolu.equals("hlavni")){
            for (int i = 0; i < seznamMomentalnichHlavnichUkolu.size(); i++) {
                if (seznamMomentalnichHlavnichUkolu.get(i).getIdUkolu() == idUkolu){
                    seznamMomentalnichHlavnichUkolu.get(i).setUkolSplnen(true);
                    break;
                }
            }
        }
        if (typUkolu.equals("vedlejsi")){
            for (int i = 0; i < seznamMomentalnichVedljesichUkolu.size(); i++) {
                if (seznamMomentalnichVedljesichUkolu.get(i).getIdUkolu() == idUkolu){
                    seznamMomentalnichVedljesichUkolu.get(i).setUkolSplnen(true);
                    break;
                }
            }
        }
    }

    public Ukol pridaniNovehoUkolu(Konzole konzole, int id) {
        Ukol ukol = null;
        for (int i = 0; i < konzole.getData().getUkoly().size(); i++) {
            if (konzole.getData().getUkoly().get(i).getIdUkolu() == id){
                ukol = konzole.getData().getUkoly().get(i);
            }
        }
        return ukol;
    }

    public String nalezeniDalsihoUkolu(Konzole konzole, int hledaneId){
        for (int i = 0; i < konzole.getData().getUkoly().size(); i++) {
            if (konzole.getData().getUkoly().get(i).getIdUkolu() == hledaneId){
                seznamMomentalnichHlavnichUkolu.add(konzole.getData().getUkoly().get(i));
                return "Mas novy ukol: " + konzole.getData().getUkoly().get(i).getNazevUkolu();
            }if (konzole.getData().getUkoly().get(i).getIdNaslednehoUkolu() < 0){
                konzole.setKonecHry(true);
            }

        }
    return "";
    }
    public String najitNazevAktualniho(){
        if (seznamMomentalnichHlavnichUkolu.size() > 0){
                return seznamMomentalnichHlavnichUkolu.get(0).getNazevUkolu();

        }else return "ukol nemas";
    }


    public String herniUkolMost(Konzole konzole) {
        boolean ukolSplnen = false;
        do {
            System.out.println("Plnis ukol:");
            String sablona = "|- - -- ---  --|";
            System.out.println("Dopln chybjejici pomlcky tak, aby vznikla souvisla rada(most):");
            System.out.println(sablona);
            System.out.print("Tvuj pokus: ");

            String vstup = Konzole.scanner.nextLine();

            if (vstup.equals("--------------")) {
                System.out.println("Spravne\n");
                ukolSplnen = true;
            } else {
                System.out.println("Spatne. Zkus to znovu\n");
            }
        }while (!ukolSplnen);

        return splneniUkolu(konzole, idAktualnihoUkolu, "hlavni");
    }
    public String herniUkolOblastXStiny(Konzole konzole) {
        boolean ukolSplnen = false;

        do {
            System.out.println("Plnis ukol v Oblasti X:");
            System.out.println("Stiny snu se pohybuji stejnym smerem.");

            System.out.println("Levo → Dole → Levo → Dole → ?");
            System.out.print("Zadej dalsi smer (levo/pravo/nahoru/dole): ");

            String vstup = Konzole.scanner.nextLine().toLowerCase();

            if (vstup.equals("levo")) {
                System.out.println("Stiny te vedou spravne. Cesta se otevira.\n");
                ukolSplnen = true;
            } else {
                System.out.println("Stiny se rozplynuly. Zkus sledovat vzor znovu.\n");
            }

        } while (!ukolSplnen);

        return splneniUkolu(konzole, idAktualnihoUkolu, "hlavni");
    }
    public String herniUkolSopka(Konzole konzole) {
        boolean ukolSplnen = false;

        do {
            System.out.println("Plnis ukol: Vyhasnuti sopky snu");
            System.out.println("Mas tri prameny chladu:");
            System.out.println("1 = severni led");
            System.out.println("2 = hluboka voda");
            System.out.println("3 = mlha snu");

            System.out.println("Musis je pouzit ve spravnem poradi aby se jadro uklidnilo");
            System.out.print("Zadej poradi jako tri cisla bez mezer (napr. 213): ");

            String vstup = Konzole.scanner.nextLine();

            if (vstup.equals("321")) {
                System.out.println("Jadro sopky se ochladilo Plameny mizi Sopka vyhasla\n");
                ukolSplnen = true;
            } else {
                System.out.println("Teplo zesililo Sopka se znovu rozohnila Zkus to znovu\n");
            }

        } while (!ukolSplnen);

        return splneniUkolu(konzole, idAktualnihoUkolu, "hlavni");
    }

    public String herniUkolHory(Konzole konzole) {
        boolean ukolSplnen = false;

        do {
            System.out.println("Ve spravnem poradi napis napis udalosti");
            System.out.println("1 zavrit oci");
            System.out.println("2 spojit kameny");
            System.out.println("3 hora hotova");

            System.out.println("Musis je pouzit ve spravnem poradi aby se jadro uklidnilo");
            System.out.print("Zadej poradi jako tri cisla bez mezer (napr. 151): ");

            String vstup = Konzole.scanner.nextLine();

            if (vstup.equals("123")) {
                System.out.println("Jadro sopky se ochladilo Plameny mizi Sopka vyhasla\n");
                ukolSplnen = true;
            } else {
                System.out.println("Teplo zesililo Sopka se znovu rozohnila Zkus to znovu\n");
            }

        } while (!ukolSplnen);

        return splneniUkolu(konzole, idAktualnihoUkolu, "hlavni");
    }




    public String getNazevUkolu() {
        return nazevUkolu;
    }

    public String getPopisUkolu() {
        return popisUkolu;
    }

    public boolean isOtevreDalsiLokaci() {
        return otevreDalsiLokaci;
    }

    public ArrayList<Ukol> getSeznamMomentalnichHlavnichUkolu() {
        return seznamMomentalnichHlavnichUkolu;
    }

    public ArrayList<Ukol> getSeznamMomentalnichVedljesichUkolu() {
        return seznamMomentalnichVedljesichUkolu;
    }

    public boolean isUkolSplnen() {
        return ukolSplnen;
    }

    public void setUkolSplnen(boolean ukolSplnen) {
        this.ukolSplnen = ukolSplnen;
    }

    public int getIdUkolu() {
        return idUkolu;
    }

    public int getIdNaslednehoUkolu() {
        return idNaslednehoUkolu;
    }

    public int getIdAktualnihoUkolu() {
        return idAktualnihoUkolu;
    }

    public void setIdAktualnihoUkolu(int idAktualnihoUkolu) {
        this.idAktualnihoUkolu = idAktualnihoUkolu;
    }
}
