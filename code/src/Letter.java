
import java.awt.Color;

/**
 *
 *                  @authors 
 *         Anastasios Vanis     321/2012017
 *         Nickolaos Chaikalis  321/2012200
 *             Phase 2 Omadikis Ergasias
 */
public abstract class Letter{
    protected char letter; //gramma PX A,B,C.
    protected int rank; //vathmologia tou grammatos px 10.
    protected double x, y; //Coordinations of a letter.

    public Letter(char letter, double x, double y) {
        this.letter = letter;
        this.x = x;
        this.y = y;
    }
    
    protected void LetterRank(){
            if(letter == 'Α')
                rank = 1;
            else if(letter == 'Β')
                rank = 8;
            else if(letter == 'Γ')
                rank = 4;
            else if(letter == 'Δ')
                rank = 4;
            else if(letter == 'Ε')
                rank = 1;
            else if(letter == 'Ζ')
                rank = 8;
            else if(letter == 'Η')
                rank = 1;
            else if(letter == 'Θ')
                rank = 8;
            else if(letter == 'Ι')
                rank = 1;
            else if(letter == 'Κ')
                rank = 2;
            else if(letter == 'Λ')
                rank = 3;
            else if(letter == 'Μ')
                rank = 3;
            else if(letter == 'Ν')
                rank = 1;
            else if(letter == 'Ξ')
                rank = 10;
            else if(letter == 'Ο')
                rank = 1;
            else if(letter == 'Π')
                rank = 2;
            else if(letter == 'Ρ')
                rank = 2;
            else if(letter == 'Σ')
                rank = 1;
            else if(letter == 'Τ')
                rank = 1;
            else if(letter == 'Υ')
                rank = 2;
            else if(letter == 'Φ')
                rank = 8;
            else if(letter == 'Χ')
                rank = 10;
            else if(letter == 'Ψ')
                rank = 10;
            else if(letter == 'Ω')
                rank = 3;       
    }

    @Override
    public String toString() {
        return "Letter{" + "letter=" + letter + ", rank=" + rank + ", x=" + x + ", y=" + y + '}';
    }
    

    public String testColor() {
        return "letterColor";
    }
    

    public Color getColor() {
        return null;
    }

    // Getters & Setters:

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    } 
}
