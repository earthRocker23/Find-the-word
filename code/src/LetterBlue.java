
import java.awt.Color;

/**
 *
 *                  @authors 
 *         Anastasios Vanis     321/2012017
 *         Nickolaos Chaikalis  321/2012200
 *             Phase 2 Omadikis Ergasias
 */

/**
 * Se auti tin class diplasiazume to synolo twn pontwn tis leksis
 * an o xristis epileksi auto to xrema (BLUE) i leiturgia to x2 
 * dn ilopoiitai mesa stn LetterBlue afu prwta prepei na exei vrei
 * tin leksi k na iparksei o katallilos elenxos gia na mn ginei to
 * x2 panw apo mia fora.
 */
public class LetterBlue extends Letter{
    private final Color color = Color.CYAN;

    public LetterBlue(char letter, double x, double y) {
        super(letter, x, y);
        super.LetterRank();
    }

    @Override
    public String toString() {
        return super.toString() + "LetterBlue{" + "color=" + color + '}';
    }

    @Override
    public String testColor() {
        return "Blue ";
    }

    @Override
    public Color getColor() {
        return color;
    }
}
