package Komunikace;

import Postavy.Postavy;

import java.util.ArrayList;

public class Otazka {
    private String kdoMluvi;
    private int id;
    private String replika;
    private ArrayList<Odpoved> odpovediNaOtazky;

    public Otazka(int id, String replika, ArrayList<Odpoved> odpovediNaOtazky) {
        this.id = id;
        this.replika = replika;
        this.odpovediNaOtazky = odpovediNaOtazky;
    }


    public int getId() {
        return id;
    }

    public String getReplika() {
        return replika;
    }

    public ArrayList<Odpoved> getOdpovediNaOtazky() {
        return odpovediNaOtazky;
    }
}
