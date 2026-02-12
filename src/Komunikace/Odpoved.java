package Komunikace;

/**
 * Tato trida slouzi ke konstrukci odpovedi na otazky
 * @author Ondrej Beran
 */
public class Odpoved {

    /**
     * promena text je text ktery se vypise jako odpoved
     * promena IdNasledneOtazky je kam bude dialog smerovat dal
     */
    private String text;
    private int IdNasledneOtazky;

    public Odpoved(String replika, int IdNasledneOtazky) {
        this.text = replika;
        this.IdNasledneOtazky = IdNasledneOtazky;
    }

    public String getText() {
        return text;
    }

    public int getIdNasledneOtazky() {
        return IdNasledneOtazky;
    }

    @Override
    public String toString() {
        return "Odpoved{" +
                "text='" + text + '\'' +
                ", IdNasledneOtazky=" + IdNasledneOtazky +
                '}';
    }
}
