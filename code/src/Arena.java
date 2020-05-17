import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
/**
 *
 *                  @authors 
 *         Anastasios Vanis     321/2012017
 *         Nickolaos Chaikalis  321/2012200
 *             Phase 2 Omadikis Ergasias
 */

public class Arena{
    private Letter[][] array; //array me ola ta Letter Objects
    private Dashboard dashboard; //to dashboard pou exei epileksei to user eite 5x5 8x8 10x1x0

    //Default Constructor
    public Arena() {
    }

    //Constructor
    public Arena(Letter[][] array, Dashboard dashboard) {
        this.array = array;
        this.dashboard = dashboard;
    }
    
    /**
     * Methodos pou tipwnei ton 2d array me ola ta objects Letter.
     */
    public void DisplayArray(){
        System.out.println(dashboard.toString());
        for(Letter[] row : array){
            for (Letter i : row) {
                System.out.print(i.getLetter() + " " + i.getX() + " " + i.getY() + " " + i.testColor()+ " " + i.getRank());
                System.out.print("\t");
            }
            System.out.println();
        }
    }
    
    /**
     * Setarw neo joker.
     * @param x
     * @param y
     * @param newChar 
     */
    public void SetValueOnJoker(double x, double y, char newChar){
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array.length; j++){
                if(array[i][j].getLetter() == '?' && array[i][j].getX() == x && array[i][j].getY() == y){
                    array[i][j].setLetter(newChar); 
//                    System.out.println("new joker: " + array[i][j]);
                    return;
                }
            }
        }
    }
    
    /**
     * Methodos pou elenhw an mporei na kinithei to gramma pou thelei o client.
     * @param x
     * @param y 
     */
    public void Move(double currentX, double currentY, double willX, double willY){
      Coordinates coor = new Coordinates(array, currentX, currentY, willX, willY);
      coor.ChecknMove();
      array = coor.getArray();
      DisplayArray();
    }
    
    /**
     * Methodos gia tin diagrafi/anadiataksi mias sigkekrimenis grammis.
     */
    public void DeleteRow(int n, int row){
        Random r = new Random();
        for(int j=0; j<n; j++){
            char c = (char)(r.nextInt(24) + 'Α');
            array[row][j].setLetter(c);
            array[row][j].LetterRank();
        }
    }
    /**
     * Methodos gia tin diagrafi/anadiataksi mias sigkekrimenis stilis.
     * @param n
     * @param column 
     */
    public void DeleteColumn(int n, int column){
        Random r = new Random();
        for(int i=0; i<n; i++){
            char c = (char)(r.nextInt(24) + 'Α');
            array[i][column].setLetter(c);
            array[i][column].LetterRank();
        }
    }
    
    /**
     * Anadiataksi olou tou pinaka.Ousiastika shufflarume ton idi iparxon array.
     */
    public void AnadiataksiGrammatwn(int n){
        ArrayList<Letter> letterList = dashboard.getLetterList();
        Collections.shuffle(letterList);   
        System.out.println("Letter size: " + letterList.size());
        dashboard.OneDto2D(n, letterList, array);
    }
    
    /**
     * Methodos gia to shuffling mias grammis.
     * @param ar
     * @param n 
     */
    public void ShuffleRow(int n, int row){
        ArrayList<Letter> list = new ArrayList<Letter>();
        for(int j=0; j<n; j++){
            list.add(array[row][j]);
        }
        Collections.shuffle(list);
        for(int j=0; j<n; j++){
            array[row][j] = list.get(j);
            System.out.println(array[row][j]);
        }

        FixCoor();
    }
    
    /**
     * Methodos gia to shuffling mias stilis.
     * @param ar
     * @param n 
     */
    public void ShuffleColumn(int n, int column){
        ArrayList<Letter> list = new ArrayList<Letter>();
        for(int i=0; i<n; i++){
            list.add(array[i][column]);
        }
        Collections.shuffle(list);
        for(int i=0; i<n; i++){
            array[i][column] = list.get(i);
        }

        FixCoor();
    }
    
    private void FixCoor(){
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array.length; j++){
                array[i][j].setX(i);
                array[i][j].setY(j);
            }
        }
    }
    
    
    /**
     * Methodos pou vriskw checkarw oi sintetagmenes pou edwse o xristis 
     * einai geitonikes. Stin synexeia vriskw ti leksi k checkarw an iparxei
     * stin lista me tis lekseis.
     * @param list 
     */
    public String FindTheWord(ArrayList<CheckWord> list){
        Coordinates coor = new Coordinates();
        for(int i=1; i<list.size(); i++){
            if(coor.CheckNeighbors(list.get(i).getX(), list.get(i).getY(), list.get(i-1).getX(), list.get(i-1).getY()) == false){
                System.out.println("lathos syntetagmenes.");
                dashboard.setLives(dashboard.getLives()-1);
                return "Wrong Coordinates";
            }
        }
        String word = "";
        ArrayList<Letter> LetterList = new ArrayList<Letter>();
        for(int i=0; i<list.size(); i++){
            for(int j=0; j<array.length; j++){
                for(int k=0; k<array.length; k++){
                    if(array[j][k].getX() == list.get(i).getX() && array[j][k].getY() == list.get(i).getY()){
                        word += String.valueOf(array[j][k].getLetter());
                        LetterList.add(array[j][k]);
                    }
                }
            }
        }
       
        ArrayList<String> wordList = dashboard.getList();
        for(int i=0; i<wordList.size(); i++){
            if(wordList.get(i).equals(word)){
                System.out.println("You found the word: " + word);
                dashboard.setScore(CalculateScore(LetterList));
                System.out.println("Score: " + dashboard.getScore());
                AddNewLetters(list);
                return "You found the word: " + word;
            }
        }
        //Den exei vrei ti swsti leksi
        System.out.println("The word : " + word + " isn't right");
        dashboard.setLives(dashboard.getLives()-1);
        return "The word isn't right";
    }
    
    //Add nea grammaya panw sta palia:
    public void AddNewLetters(ArrayList<CheckWord> list){
        for(int i=0; i<list.size(); i++){
            for(int j=0; j<array.length; j++){
                for(int k=0; k<array.length; k++){
                    if(array[j][k].getX() == list.get(i).getX() && array[j][k].getY() == list.get(i).getY()){
                        //Add neo gramma panw sto palio:
                        Random r = new Random();
                        char c = (char)(r.nextInt(24) + 'Α');
                        array[j][k].setLetter(c);
                        array[j][k].LetterRank();
                    }
                }
            }
        }
    }
    
    /**
     * Methodos pou ipologizw to score tou xristi.
     * @param list
     * @return 
     */
    private int CalculateScore(ArrayList<Letter> list){
        int score = 0;
        boolean IhaveBlue = false;
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getColor() == Color.blue && IhaveBlue == false){
                IhaveBlue = true;
            }
            score += list.get(i).getRank();
        }
        if(IhaveBlue)
            score = score * 2;
        return score;
    }
    
    //Getters & Setters

    public Letter[][] getArray() {
        return array;
    }

    public void setArray(Letter[][] array) {
        this.array = array;
    }

    public Dashboard getDashboard() {
        return dashboard;
    }

    public void setDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
    }
}
