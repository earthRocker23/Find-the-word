import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 *                  @authors 
 *         Anastasios Vanis     321/2012017
 *         Nickolaos Chaikalis  321/2012200
 *             Phase 2 Omadikis Ergasias
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String choice;
        System.out.println("An thelete na paiksete me grafika patiste 1, alliws patiste otidipote.");
        Scanner sc = new Scanner(System.in);
        choice = sc.nextLine();
        if(!choice.equals("1"))//Xwris gui
            NewGameNoGui();
        else
            NewGameWithGui();
    }
    public static void NewGameWithGui(){
        gui g = new gui();
    }
    public static void NewGameNoGui(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Dwste to nickname sas: ");
        String nickname = sc.nextLine();
        int choice; //gia tin switc sto Menu
        int inGame; //gia tin switch sto Ipomenu
        do{
            System.out.println("Dwste to eidos tou paixnidou pou thelete na paiksete 1->5x5, 2->8x8, 3->10x10");
            choice = sc.nextInt();
        }while(choice <= 0 || choice > 3);
        switch(choice){
            case 0:
                System.exit(0);
                break;
            case 1:
                Dashboard5x5 ff = new Dashboard5x5(nickname, 0, 3, 0);
                ff.ShuffleTheWords();
//                System.out.println(ff.getWordsToUse());
                ff.FindLetter();
                Arena ar5 = new Arena(ff.GetArray(), ff);
                ar5.DisplayArray();
                while(true){
                    inGame = InGameMenu();
                    if(inGame == 0) break;
                    switch(inGame){
                        case 1:
                            newSwap(ar5);
                            break;
                        case 2:
                            DeleteRow(ar5, 5);
                            ar5.getDashboard().setTries(ar5.getDashboard().getTries()+1);
                            GameOver(ar5);
                            ar5.DisplayArray();
                            break;
                        case 3:
                            ar5.AnadiataksiGrammatwn(5);
                            ar5.getDashboard().setTries(ar5.getDashboard().getTries()+1);
                            GameOver(ar5);
                            ar5.DisplayArray();
                            break;
                        case 4:
                            DeleteColumn(ar5, 5);
                            ar5.getDashboard().setTries(ar5.getDashboard().getTries()+1);
                            GameOver(ar5);
                            ar5.DisplayArray();
                            break;
                        case 5:
                            ShuffleRow(ar5, 5);
                            ar5.getDashboard().setTries(ar5.getDashboard().getTries()+1);
                            GameOver(ar5);
                            ar5.DisplayArray();
                            break;
                        case 6:
                            ShuffleColumn(ar5, 5);
                            ar5.getDashboard().setTries(ar5.getDashboard().getTries()+1);
                            GameOver(ar5);
                            ar5.DisplayArray();
                            break;
                        case 7:
                            ArrayList<CheckWord> checkWordList = new ArrayList<CheckWord>();
                            CheckWord(ar5, 5, checkWordList, ff);
                            ar5.DisplayArray();
                            GameOver(ar5);
                            break;
                        case 8:
                            SetJoker(ar5);
                            ar5.DisplayArray();
                            break;
                    }
                }
                break;
            case 2:
                Dashboard8x8 ee = new Dashboard8x8(nickname, 0, 3, 0);
                ee.ShuffleTheWords();
        //        System.out.println(ee.getWordsToUSe());
                ee.FindLetter();
                Arena ar8 = new Arena(ee.GetArray(), ee);
                ar8.DisplayArray();
//                ar8.Move(2, 3, 1, 3);//North
                while(true){
                    inGame = InGameMenu();
                    if(inGame == 0) break;
                    switch(inGame){
                        case 1:
                            newSwap(ar8);
                            break;
                        case 2:
                            DeleteRow(ar8, 8);
                            ar8.getDashboard().setTries(ar8.getDashboard().getTries()+1);
                            GameOver(ar8);
                            ar8.DisplayArray();
                            break;
                        case 3:
                            ar8.AnadiataksiGrammatwn(8);
                            ar8.getDashboard().setTries(ar8.getDashboard().getTries()+1);
                            GameOver(ar8);
                            ar8.DisplayArray();
                            break;
                        case 4:
                            DeleteColumn(ar8, 8);
                            ar8.getDashboard().setTries(ar8.getDashboard().getTries()+1);
                            GameOver(ar8);
                            ar8.DisplayArray();
                            break;
                        case 5:
                            ShuffleRow(ar8, 8);
                            ar8.getDashboard().setTries(ar8.getDashboard().getTries()+1);
                            GameOver(ar8);
                            ar8.DisplayArray();
                            break;
                        case 6:
                            ShuffleColumn(ar8, 8);
                            ar8.getDashboard().setTries(ar8.getDashboard().getTries()+1);
                            GameOver(ar8);
                            ar8.DisplayArray();
                            break;
                        case 7:
                            ArrayList<CheckWord> checkWordList = new ArrayList<CheckWord>();
                            CheckWord(ar8, 8, checkWordList, ee);
                            ar8.DisplayArray();
                            GameOver(ar8);
                            break;
                        case 8:
                            SetJoker(ar8);
                            ar8.DisplayArray();
                            break;
                    }
                }
                break;
            case 3:
                Dashboard10x10 tt = new Dashboard10x10(nickname, 0, 3, 0);
                tt.ShuffleTheWords();
        //        System.out.println(tt.getWordsToUse());
                tt.FindLetter();
                Arena ar10 = new Arena(tt.GetArray(), tt);
                ar10.DisplayArray();
//                ar10.Move(2, 3, 1, 3);//North
                while(true){
                    inGame = InGameMenu();
                    if(inGame == 0) break;
                    switch(inGame){
                        case 1:
                            newSwap(ar10);
                            break;
                        case 2:
                            DeleteRow(ar10, 10);
                            ar10.getDashboard().setTries(ar10.getDashboard().getTries()+1);
                            GameOver(ar10);
                            ar10.DisplayArray();
                            break;
                        case 3:
                            ar10.AnadiataksiGrammatwn(10);
                            ar10.getDashboard().setTries(ar10.getDashboard().getTries()+1);
                            GameOver(ar10);
                            ar10.DisplayArray();
                            break;
                        case 4:
                            DeleteColumn(ar10, 10);
                            ar10.getDashboard().setTries(ar10.getDashboard().getTries()+1);
                            GameOver(ar10);
                            ar10.DisplayArray();
                            break;
                        case 5:
                            ShuffleRow(ar10, 10);
                            ar10.getDashboard().setTries(ar10.getDashboard().getTries()+1);
                            GameOver(ar10);
                            ar10.DisplayArray();
                            break;
                        case 6:
                            ShuffleColumn(ar10, 10);
                            ar10.getDashboard().setTries(ar10.getDashboard().getTries()+1);
                            GameOver(ar10);
                            ar10.DisplayArray();
                            break;
                        case 7:
                            ArrayList<CheckWord> checkWordList = new ArrayList<CheckWord>();
                            CheckWord(ar10, 10, checkWordList, tt);
                            ar10.DisplayArray();
                            GameOver(ar10);
                            break;
                        case 8:
                            SetJoker(ar10);
                            ar10.DisplayArray();
                            break;
                    }
                }
                break;
        }//telos switch(choice)
    }
    
    /**
     * Menu afu exei ksekinisei to game:
     * @return 
     */
    public static int InGameMenu(){
        int choice;
        do{
            Scanner sc = new Scanner(System.in);
            System.out.println("Dwste: ");
            System.out.println("\t0 gia eksodo.");
            System.out.println("\t1 gia swap grammatwn.");
            System.out.println("\t2 gia diagrafi grammis.");
            System.out.println("\t3 gia anadiataksi grammatwn.");
            System.out.println("\t4 gia diagrafi stilis.");
            System.out.println("\t5 gia anadiataksi grammis.");
            System.out.println("\t6 gia anadiataksi stilis.");
            System.out.println("\t7 gia elenxo leksis.");
            System.out.println("\t8 gia na dwsete timi ston Joker.");
            choice = sc.nextInt(); 
        }while(choice < 0 || choice > 8);
        return choice;
    }
    
    /**
     * Dinw timi ston joker
     * @param ar 
     */
    public static void SetJoker(Arena ar){
        Scanner sc = new Scanner(System.in);
        System.out.println("Dwste tis sintetagmenes tou Joker: ");
        System.out.print("X: ");
        double x = sc.nextDouble();
        System.out.print("Y: ");
        double y = sc.nextDouble();
        System.out.println("Dwste ena char");
        char tmp = sc.next().charAt(0);
        ar.SetValueOnJoker(x, y, tmp);
    }
    /**
     * Methodos pou o client dinei ta grammata pou thelei na ginun swap
     * @param ar 
     */
    public static void newSwap(Arena ar){
        Scanner sc = new Scanner(System.in);
        System.out.println("Dwste tis sintetagmenes tou grammatos pou thelete na allaksete: ");
        System.out.print("X1: ");
        double x = sc.nextDouble();
        System.out.print("Y1: ");
        double y = sc.nextDouble();
        System.out.println("Dwste tis sintetagmenes tou grammatos me to opoio thelete na ginei i allagi: ");
        System.out.print("X2: ");
        double x1 = sc.nextDouble();
        System.out.print("Y2: ");
        double y1 = sc.nextDouble();
        ar.Move(x, y, x1, y1);
    }
    
    /**
     * Methodos gia tin diagrafi grammis kai eisagwgi newn grammatwn.
     * @param ar 
     */
    public static void DeleteRow(Arena ar, int n){
        int row;
        do{
            Scanner sc = new Scanner(System.in);
            System.out.println("Dwste tis sintetagmenes tis grammis pou thelete na diagrapsete: ");
            System.out.print("Row: ");
            row = sc.nextInt();
        }while(row < 0 || row > n);
        ar.DeleteRow(n, row);
    }
    
    /**
     * Methodos gia tin diagrafi stilis kai eisagwgi newn grammatwn.
     * @param ar
     * @param n 
     */
    public static void DeleteColumn(Arena ar, int n){
        int col;
        do{
            Scanner sc = new Scanner(System.in);
            System.out.println("Dwste tis sintetagmenes tis stilis pou thelete na allaksete: ");
            System.out.print("Column: ");
            col = sc.nextInt();
        }while(col < 0 || col > n);
        ar.DeleteColumn(n, col);
    }
    
    /**
     * Methodos gia to shuffling mias grammis.
     * @param ar
     * @param n 
     */
    public static void ShuffleRow(Arena ar, int n){
        int row;
        do{
            Scanner sc = new Scanner(System.in);
            System.out.println("Dwste tis sintetagmenes tis grammis pou thelete na anadiataksete: ");
            System.out.print("Row: ");
            row = sc.nextInt();
        }while(row < 0 || row > n);
        ar.ShuffleRow(n, row);
    }
    
    /**
     * Methodos gia to shuffling mias stilis.
     * @param ar
     * @param n 
     */
    public static void ShuffleColumn(Arena ar, int n){
        int col;
        do{
            Scanner sc = new Scanner(System.in);
            System.out.println("Dwste tis sintetagmenes tis stlis pou thelete na anadiataksete: ");
            System.out.print("Column: ");
            col = sc.nextInt();
        }while(col < 0 || col > n);
        ar.ShuffleColumn(n, col);
    }
    
    /**
     * Methodos pou checkarw an i leksi pou sximatise o client einai swsti.
     * @param ar
     * @param n 
     */
    public static void CheckWord(Arena ar, int n, ArrayList<CheckWord> list, Dashboard dashboard){ 
        System.out.println("Dwste tis sintetagmenes tis leksis me ti seira twn grammatwn px FWS oxi SWF etc.\n");
        int check = 1;
        do{
            Scanner sc = new Scanner(System.in);
            System.out.print("X: ");
            double x = sc.nextDouble();
            System.out.print("Y: ");
            double y = sc.nextDouble();
            CheckWord cw = new CheckWord(x, y, dashboard);
            for(int i=0; i<list.size(); i++){
                if(cw.hashCode() == list.get(i).hashCode()){
                    CheckWord(ar, n, list, dashboard);
                    return;//spaw tin methodo gia otan girisei i anadromi.
                }
            }
            list.add(cw);
            if(list.size()>2){
                System.out.println("An dn thelete na eisagete alles syntetagmenes patiste 0 alliws patiste oti kumpi thelete.");
                check = sc.nextInt();
            }
            System.out.println("list: " + list.size());
        }while(list.size()<2 || check!=0);
        ar.FindTheWord(list);
    }
    
    /**
     * Elenxw an o client exei xasei. An exei xasei tote game over :( 
     * @param ar 
     */
    public static void GameOver(Arena ar){
        if(ar.getDashboard().getLives() <= 0 || ar.getDashboard().getTries() >= 7){
            System.out.println("Game over");
            System.exit(0);
        }
        else if(ar.getDashboard().getScore()>=30){
            System.out.println("We have a WINNER !!! Congratulations " + ar.getDashboard().getNickname());
            System.exit(0);
        }
    }
}
