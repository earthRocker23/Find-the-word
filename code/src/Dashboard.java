
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *                  @authors 
 *         Anastasios Vanis     321/2012017
 *         Nickolaos Chaikalis  321/2012200
 *             Phase 2 Omadikis Ergasias
 */
public abstract class Dashboard extends Player implements Serializable{
    private ObjectInputStream ois;
    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<Letter> letterList = new ArrayList<Letter>();
    

    public Dashboard(String nickname, int score, int lives, int tries) {
        super(nickname, score, lives, tries);
    }
    
    /**
     * Methodos pou tin xrisimopoiw gia na arxikopoiisw ena .txt me tis lekseis
     * pou thelw na parw sto dashboard. Auti i method kalleitai otan dn uparxei 
     * to .txt arxeio sto fakelo mas.
     */
    public void WordsToTXT(){
         FileOutputStream fout = null;
        try {
            fout = new FileOutputStream("Words.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            
            //GR: 
            oos.writeObject("ΚΑΦΕΣ");
            oos.writeObject("ΣΑΜΟΣ");
            oos.writeObject("ΜΑΘΗΜΑ");
            oos.writeObject("ΥΓΡΑΣΙΑ");
            oos.writeObject("ΡΟΛΟΙ");
            oos.writeObject("ΤΡΑΠΕΖΙ");
            oos.writeObject("ΒΟΤΚΑ");
            oos.writeObject("ΦΩΣ");
            oos.writeObject("ΧΑΡΤΙ");
            oos.writeObject("ΠΙΝΑΚΑΣ");
            oos.writeObject("ΣΤΥΛΟ");
            oos.writeObject("ΤΑΙΝΙΑ");
            oos.writeObject("ΜΙΚΡΟΦΩΝΟ");
            oos.writeObject("ΑΚΟΥΣΤΙΚΑ");
            oos.writeObject("ΚΟΥΠΑ");
            oos.writeObject("ΤΗΛΕΦΩΝΟ");
            oos.writeObject("ΠΟΝΤΙΚΙ");
            oos.writeObject("ΠΛΗΚΤΡΟΛΟΓΙΟ");
            oos.writeObject("ΤΡΕΝΟ");
            oos.writeObject("ΚΑΡΑΒΙ");
            oos.writeObject("ΑΕΡΟΠΛΆΝΟ");
            oos.writeObject("ΑΥΤΟΚΙΝΗΤΟ");
            oos.writeObject("ΚΑΡΕΚΛΑ");
            
//            EN: 
//            oos.writeObject("MUSIC");
//            oos.writeObject("ISLAND");
//            oos.writeObject("LESSON");
//            oos.writeObject("HUMIDITY");
//            oos.writeObject("CLOCK");
//            oos.writeObject("TABLE");
//            oos.writeObject("VODKA");
//            oos.writeObject("LIGHT");
//            oos.writeObject("PAPER");
//            oos.writeObject("DASHBOARD");
//            oos.writeObject("PEN");
//            oos.writeObject("MOVIE");
//            oos.writeObject("MICROFONE");
//            oos.writeObject("INHERITANCE");
//            oos.writeObject("MOUSE");
//            oos.writeObject("KEYBOARD");
//            oos.writeObject("WATER");
//            oos.writeObject("TRAIN");
//            oos.writeObject("SHIP");
//            oos.writeObject("AIRPLANE");
//            oos.writeObject("CAR");
//            oos.writeObject("CHAIR");
//            oos.writeObject("MONITOR");
            
            oos.close();
//            System.out.println("__WordsToTXT(); Done");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fout.close();
            } catch (IOException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Methodos pou tin xrisimopoiumai gia na arxikopoiisumai tin Domi pou zitaei
     * i ekfwnisi gia na exei mesa tis lekseis pou tha exume sto dashboard.
     */
    public void LoadWords(){
        try {
            FileInputStream istream = new FileInputStream("Words.txt");
            ois = new ObjectInputStream(istream);
            while(istream.available() > 0){
                String tmp = (String) ois.readObject();
                list.add(tmp);
                //System.out.println(tmp);
                
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    

    /**
     * Methodos pou me voithaw na vrw ena String me to megethos pou tha orisw
     * gia 5x5 to 20 gia 8x8 to 60 kai gia 10x10 to 90.
     * @param list
     * @param WordsToUse
     * @param str 
     */
    protected String AllWordsToStringPlusRandomChars(int n, ArrayList<String> list, ArrayList<String> WordsToUse){
        String str = "";
        int totalChars = list.get(0).length();
        WordsToUse.add(list.get(0));
        for(int i=1; i<list.size(); i++){
            int tmp = list.get(i).length() + totalChars;
            if(totalChars<=n && tmp<=n){
                totalChars = tmp;
                WordsToUse.add(list.get(i));
                str += list.get(i);
            }
        }
        System.out.println(str);
        return str;
    }
    //Methodos poy tipwnw to 2d table san xarti.
    protected void DisplayRow(char[] row) {
        for (char i : row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }
    protected void DisplayRow(Letter[] row) {
        for (Letter i : row) {
            System.out.print(i.getLetter() + " " + i.getX() + " " + i.getY() + " " + i.testColor()+ " " + i.getRank());
            System.out.print("\t");
        }
        System.out.println();
    }
    
    /**
     * Methodos pou pairnw to megethos tou Dashboard enan pinaka me ta grammata
     * pou tha exei mesa to dashboard kai enan keno 2d array gia na tn gemisw
     * me ta grammata tou 1d array. O 1d array stelnw ena Reference tou opote
     * den ton kanw return afu gemise me ta idia stoixeia k ekei pou tn kalesa.
     * @param n
     * @param tempArray
     * @param array 
     */
    protected void OneDto2D(int n, char[] tempArray, char[][] array){
        int sum=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                array[i][j] = tempArray[sum];
                sum++;
            }
        }
    }
    protected void OneDto2D(int n, ArrayList<Letter> letterList, Letter[][] letterArray){
        int sum=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                letterArray[i][j] = letterList.get(sum);
                letterArray[i][j].setX(i);
                letterArray[i][j].setY(j);
                sum++;
            }
        }
    }
    
    public ObjectInputStream getOis() {
        return ois;
    }

    public void setOis(ObjectInputStream ois) {
        this.ois = ois;
    }

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    public ArrayList<Letter> getLetterList() {
        return letterList;
    }
    
    
}
