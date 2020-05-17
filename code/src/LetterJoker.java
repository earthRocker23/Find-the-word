
import java.awt.Color;

/**
 *
 *                  @authors 
 *         Anastasios Vanis     321/2012017
 *         Nickolaos Chaikalis  321/2012200
 *             Phase 2 Omadikis Ergasias
 */

/**
 * Se auti tn class dinume ti dynatotia ston xristi gia tin epilogi tou Balader 
 * O client exei tin dynatotia na wrisei autos opoio gramma epithimei wste na 
 * klipsei to sigkekrimeno keno ston "xarti". Logo tou oti einai ligo cheat na 
 * epilegei o client to gramma k na pairnei tus antistoixous pontus pou exume orisei
 * orizume ena sigkekrimeno rank gia kathe Balader Episis tou orizw ws xrwma to pink.
 */
public class LetterJoker extends Letter{
    private final Color color = Color.pink;

    public LetterJoker(char letter, double x, double y) {
        super(letter, x, y);
        super.setRank(2);
        super.setLetter('?');
    }

    @Override
    public String toString() {
        return super.toString() + "LetterJoker{" + "color=" + color + '}';
    }
    
    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public String testColor() {
        return "Joker";
    }

}
