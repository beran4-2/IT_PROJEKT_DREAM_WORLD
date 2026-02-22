/**
 * Tato trida slouzi ke konstrukci hodnych postav
 * @author Ondrej Beran
 */

package Postavy;

public class HodnaPostava extends Postavy {

    public HodnaPostava(String jmeno, int zivoty, int fyzickaSila, boolean jeZabitelny) {
        super(jmeno, zivoty, fyzickaSila, jeZabitelny);
    }

    public HodnaPostava() {
    }

    @Override
    public boolean jeNaZivu() {
        if (this.zivoty > 0){
            return true;
        }else return false;
    }

    @Override
    public String toString() {
        return "HodnaPostava{" +
                " jmeno='" + jmeno + '\'' +
                ", kdeSeNachazi='" + kdeSeNachazi + '\'' +
                ", zivoty=" + zivoty +
                ", fyzickaSila=" + fyzickaSila +
                ", jeZabitelny=" + jeZabitelny +
                '}';
    }
}
