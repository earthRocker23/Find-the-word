import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 *                  @authors 
 *         Anastasios Vanis     321/2012017
 *         Nickolaos Chaikalis  321/2012200
 *             Phase 2 Omadikis Ergasias
 */
public class Dashboard8x8 extends Dashboard implements DashboardsInterface, Serializable{
    private ArrayList<String> list = new ArrayList<String>();//list me oles tis lekseis pou exume kanei save sto .txt
    private ArrayList<String> WordsToUse = new ArrayList<String>();//list me oles tis lekseis pou MPORUME na xrisimopoiisume sto 8x8 (max 60 grammata)
    private ArrayList<Letter> letterList = new ArrayList<Letter>();
    private char[][] array = new char[8][8];
    private char[] tempArray = new char[64];
    private Letter[][] letterArray = new Letter[8][8];
    
    public Dashboard8x8(String nickname, int score, int lives, int tries) {
        super(nickname, score, lives, tries);
        super.WordsToTXT();
        super.LoadWords();
        list = super.getList();  
        Collections.shuffle(list);
    }


    @Override
    public void ShuffleTheWords() {
        
        /**
         * Arxika vriskw tis lekseis me MAX 60 letters kai tis kanw add
         * se mia arraylist
         */
        Collections.shuffle(list);//shufflarw ti lista me tis lekseis wste na exw kathe fora diaforetikes alliws tha epairnw tis idies me ta prwta 60 chars.
        String str = AllWordsToStringPlusRandomChars(60, list, WordsToUse);        
        /**
         * Kanw add random GR Letters sto String mexri na ginei to lenght tu 64.
         */
        Random r = new Random();
        while(str.length()!=64){
            char c = (char)(r.nextInt(24) + 'Α');
            str += c;
        }
        
        /**
         * Pleon eimai sto simeio pou se ena String ehw oles tis lekseis pou
         * mporw na xrisimopoiisw sto sigkekrimeno dashboard + ta random grammata
         * gia na ftasw to CAP tou dashboard.
         */
        ShuffleTheString sas = new ShuffleTheString(str);
        
//        tempArray = str.toCharArray();
        tempArray = sas.ShuffleReturn().toCharArray();

        super.OneDto2D(8, tempArray, array);
//        PrintArray();
        
    }
    
    @Override
    public void FindLetter() {
        int red = RandomNumber(4);
        int redSum = 0;
        int blue = RandomNumber(3);
        int blueSum = 0;
        int joker = RandomNumber(2);
        int jokerSum = 0;
        
        System.out.println("red" + red +" blue" + blue +" joker" + joker);
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(redSum < red && blueSum == 0 && jokerSum == 0){
                    InsertRedLetter(array, i, j);
                    redSum++;
                }
                else if(redSum == red && blueSum < blue && jokerSum == 0){
                    InsertBlueLetter(array, i, j);
                    blueSum++;
                }
                else if(redSum == red && blueSum == blue && jokerSum < joker){
                    InsertJokerLetter(array, i, j);
                    jokerSum++;
                }
                else{
                    InsertWhiteLetter(array, i, j);
                }
            }
        }
        Collections.shuffle(letterList);   
        super.OneDto2D(8, letterList, letterArray);
//        PrintArray();

    }
    
    @Override
    public void PrintArray() {
        for(Letter[] row : letterArray)
            super.DisplayRow(row);
    }
    
    @Override
    public Letter[][] GetArray() {
        return letterArray;
    }
    
    @Override
    public void InsertWhiteLetter(char[][] array, int i, int j) {
        LetterWhite lw = new LetterWhite(array[i][j], i,j);
        letterList.add(lw);
    }

    @Override
    public void InsertRedLetter(char[][] array, int i, int j) {
        LetterRed lr = new LetterRed(array[i][j], i,j);
        letterList.add(lr);
    }

    @Override
    public void InsertBlueLetter(char[][] array, int i, int j) {
        LetterBlue lb = new LetterBlue(array[i][j], i,j);
        letterList.add(lb);
    }

    @Override
    public void InsertJokerLetter(char[][] array, int i, int j) {
        LetterJoker jl = new LetterJoker(array[i][j], i,j);
        letterList.add(jl);
    }
    
    @Override
    public int RandomNumber(int n) {
        Random rn = new Random();
        int magicNumber = rn.nextInt(n+1) + 0;
        return magicNumber;
    }

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    public ArrayList<String> getWordsToUSe() {
        return WordsToUse;
    }

    public void setWordsToUSe(ArrayList<String> WordsToUSe) {
        this.WordsToUse = WordsToUSe;
    } 

    public ArrayList<String> getWordsToUse() {
        return WordsToUse;
    }

    public void setWordsToUse(ArrayList<String> WordsToUse) {
        this.WordsToUse = WordsToUse;
    }

    public ArrayList<Letter> getLetterList() {
        return letterList;
    }

    public void setLetterList(ArrayList<Letter> letterList) {
        this.letterList = letterList;
    }

    public char[][] getArray() {
        return array;
    }

    public void setArray(char[][] array) {
        this.array = array;
    }

    public char[] getTempArray() {
        return tempArray;
    }

    public void setTempArray(char[] tempArray) {
        this.tempArray = tempArray;
    }

    public Letter[][] getLetterArray() {
        return letterArray;
    }

    public void setLetterArray(Letter[][] letterArray) {
        this.letterArray = letterArray;
    }
    
}
