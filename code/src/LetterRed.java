
import java.awt.Color;

/**
 *
 *                  @authors 
 *         Anastasios Vanis     321/2012017
 *         Nickolaos Chaikalis  321/2012200
 *             Phase 2 Omadikis Ergasias
 */

/**
 * Se autin tn class kathe fora pou epilegete ena RED LETTER tote to rank
 * autou tu LETTER diplasiazete.
 */
public class LetterRed extends Letter{
    private final Color color = Color.red;
    
    public LetterRed(char letter, double x, double y) {
        super(letter, x, y);
        super.LetterRank();
        super.rank = super.rank * 2; //diplasiazw to rank tu letter
    }

    @Override
    public String toString() {
        return super.toString() + "LetterRed{" + "color=" + color + '}';
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public String testColor() {
        return "Red  ";
    }
}
