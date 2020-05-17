
import java.awt.Color;

/**
 *
 *                  @authors 
 *         Anastasios Vanis     321/2012017
 *         Nickolaos Chaikalis  321/2012200
 *             Phase 2 Omadikis Ergasias
 */
public class LetterWhite extends Letter{
    protected final Color color = Color.white;

    public LetterWhite(char letter, double x, double y) {
        super(letter, x, y);
        super.LetterRank();
    }

    @Override
    public String toString() {
        return super.toString() + "LetterWhite{" + "color=" + color + '}';
    }  

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public String testColor() {
        return "White";
    }
    
    
}
