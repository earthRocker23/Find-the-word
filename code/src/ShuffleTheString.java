
import java.util.ArrayList;
import java.util.List;

/**
 *
 *                  @authors 
 *         Anastasios Vanis     321/2012017
 *         Nickolaos Chaikalis  321/2012200
 *             Phase 2 Omadikis Ergasias
 */

/**
 * class pou tin xrisimopoioume gia na shufllarume ena string
 * Pigi: http://stackoverflow.com/questions/3316674/how-to-shuffle-characters-in-a-string/3316696
 * 
 */

public class ShuffleTheString {
    private String forShuffle;

    //Constructor
    public ShuffleTheString(String forShuffle) {
        this.forShuffle = forShuffle;
    }

    //Default Constructor
    public ShuffleTheString() {
    }
    
    //Shufflarume sto string alla dn to kanume return prepei na kalestei i GET gia na to parume.
    public void ShuffleNoReturn(){
        List<Character> characters = new ArrayList<Character>();
        for(char c:forShuffle.toCharArray()){
            characters.add(c);
        }
        StringBuilder output = new StringBuilder(forShuffle.length());
        while(characters.size()!=0){
            int randPicker = (int)(Math.random()*characters.size());
            output.append(characters.remove(randPicker));
        }
        forShuffle = output.toString();
    }
    
    //Shufflarume to string kai to kanume return.
    public String ShuffleReturn(){
        List<Character> characters = new ArrayList<Character>();
        for(char c:forShuffle.toCharArray()){
            characters.add(c);
        }
        StringBuilder output = new StringBuilder(forShuffle.length());
        while(characters.size()!=0){
            int randPicker = (int)(Math.random()*characters.size());
            output.append(characters.remove(randPicker));
        }
        return output.toString();
    }

    //  Getters & Setters:
    
    public String getForShuffle() {
        return forShuffle;
    }

    public void setForShuffle(String forShuffle) {
        this.forShuffle = forShuffle;
    }
    
}
