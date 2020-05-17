/**
 *
 *                  @authors 
 *         Anastasios Vanis     321/2012017
 *         Nickolaos Chaikalis  321/2012200
 *             Phase 2 Omadikis Ergasias
 */

/**
 * class pou tin xrisimopoiw gia na kinithun ta grammata opws thelei o xristis
 * Elenxei an oi sintetagmenes tirun ta kritiria (kathe gramma kinite san to vasilai sto skaki)
 * kai an einai orthes tote kanw tin kinisi kai allazei ton array pou pire.
 */
public class Coordinates {
    private Letter[][] array;
    private double currentX, currentY;
    private double willX, willY;

    //Default Constructor
    public Coordinates() {
    }

    //Constructor
    public Coordinates(Letter[][] array, double currentX, double currentY, double willX, double willY) {
        this.array = array;
        this.currentX = currentX;
        this.currentY = currentY;
        this.willX = willX;
        this.willY = willY;
    }
    
     /**
     * Methodos pou elenhw an mporei na kinithei to gramma pou thelei o client.
     * @param x
     * @param y 
     */
    public void ChecknMove(){
//        System.out.println("North: " + CheckNorth(currentX, currentY, willX, willY));
//        System.out.println("South: " + CheckSouth(currentX, currentY, willX, willY));
//        System.out.println("West: " + CheckWest(currentX, currentY, willX, willY));
//        System.out.println("East: " + CheckEast(currentX, currentY, willX, willY));
//        System.out.println("Northwest: " + CheckNorthwest(currentX, currentY, willX, willY));
//        System.out.println("Northeast: " + CheckNortheast(currentX, currentY, willX, willY));
//        System.out.println("Southwest: " + CheckSouthwest(currentX, currentY, willX, willY));
//        System.out.println("Southeast: " + CheckSoutheast(currentX, currentY, willX, willY));
        if(CheckNorth(currentX, currentY, willX, willY)){//mporei na paei voreia
            Swap(currentX, currentY, willX, willY);
        }
        else if(CheckSouth(currentX, currentY, willX, willY)){//paei notia
            Swap(currentX, currentY, willX, willY);
        }
        else if(CheckWest(currentX, currentY, willX, willY)){//paei Dytika
            Swap(currentX, currentY, willX, willY);
        }
        else if(CheckEast(currentX, currentY, willX, willY)){//paei anatolika
            Swap(currentX, currentY, willX, willY);
        } 
        else if(CheckNorthwest(currentX, currentY, willX, willY)){//paei voreioditika
            Swap(currentX, currentY, willX, willY);
        }   
        else if(CheckNortheast(currentX, currentY, willX, willY)){//paei voreioanatolika
            Swap(currentX, currentY, willX, willY);
        }   
        else if(CheckSouthwest(currentX, currentY, willX, willY)){//paei notiodytika
            Swap(currentX, currentY, willX, willY);
        } 
        else if(CheckSoutheast(currentX, currentY, willX, willY)){//paei notioanatolika
            Swap(currentX, currentY, willX, willY);
        }   
    }
    //Checkarw an mporei to gramma na kinithei voreia
    private boolean CheckNorth(double currentX, double currentY, double willX, double willY){
        if(currentX - willX == 1.0 && currentY - willY == 0.0)
            return true;
        return false;
    }
    
    //Checkarw an mporei to gramma na kinithei Notia
    private boolean CheckSouth(double currentX, double currentY, double willX, double willY){
        if(willX - currentX == 1 && currentY - willY == 0)
            return true;
        return false;
    }
    
    //Checkarw an to gramma mporei na kinitehi dytika
    private boolean CheckWest(double currentX, double currentY, double willX, double willY){
        if(currentX - willX == 0 && currentY - willY == 1)
            return true;
        return false;
    }
    
    //Checkarw an to gramma mporei na kinitehi anatolika
    private boolean CheckEast(double currentX, double currentY, double willX, double willY){
        if(willX - currentX == 0 && willY - currentY == 1)
            return true;
        return false;
    }
    
    //Checkarw an to gramma mporei na kinitehi Voreiodytika
    private boolean CheckNorthwest(double currentX, double currentY, double willX, double willY){
        if(currentX - willX == 1 && currentY - willY == 1)
            return true;
        return false;
    }
    
    //Checkarw an to gramma mporei na kinitehi Voreioanatolika
    private boolean CheckNortheast(double currentX, double currentY, double willX, double willY){
        if(currentX - willX == 1 && willY - currentY ==1)
            return true;
        return false;
    }
    
    //Checkarw an to gramma mporei na kinitehi Notiodytika
    private boolean CheckSouthwest(double currentX, double currentY, double willX, double willY){
        if(willX - currentX == 1 && currentY - willY == 1)
            return true;
        return false;
    }
    
    //Checkarw an to gramma mporei na kinitehi Notioanatolika
    private boolean CheckSoutheast(double currentX, double currentY, double willX, double willY){
        if(willX - currentX == 1 && willY - currentY == 1)
            return true;
        return false;
    }
    
    public boolean CheckNeighbors(double currentX, double currentY, double willX, double willY){
        if(CheckNorth(currentX, currentY, willX, willY)){//mporei na paei voreia
           return true;
        }
        else if(CheckSouth(currentX, currentY, willX, willY)){//paei notia
            return true;
        }
        else if(CheckWest(currentX, currentY, willX, willY)){//paei Dytika
            return true;
        }
        else if(CheckEast(currentX, currentY, willX, willY)){//paei anatolika
            return true;
        } 
        else if(CheckNorthwest(currentX, currentY, willX, willY)){//paei voreioditika
            return true;
        }   
        else if(CheckNortheast(currentX, currentY, willX, willY)){//paei voreioanatolika
            return true;
        }   
        else if(CheckSouthwest(currentX, currentY, willX, willY)){//paei notiodytika
            return true;
        } 
        else if(CheckSoutheast(currentX, currentY, willX, willY)){//paei notioanatolika
            return true;
        }   
        return false;
    }
        
    
    /**
     * Kanw anazitisi gia ena sigkekrimeno x,y. Gia to x,y pou thelei o client
     * na kinithei. Wste na to vrw k na to epistrepsw an dn yparxei tote null.
     * @param x
     * @param y
     * @return 
     */
    private Letter SearchForALetter(double x, double y){
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array.length; j++){
                if(array[i][j].x == x && array[i][j].y == y)
                    return array[i][j];
            }
        }
        return null;
    }
    
    /**
     * Methodos pou kanw swap 2 gramma :) 
     * @param currentX
     * @param currentY
     * @param willX
     * @param willY 
     */
    private void Swap(double currentX, double currentY, double willX, double willY){
        Letter willLetter = SearchForALetter(willX, willY);
//        System.out.println("Will letter: " + willLetter.toString());
        
        int x1 = (int) currentX;    int x2 = (int) willX;
        int y1 = (int) currentY;    int y2 = (int) willY;

        //swap:
        Letter temp = willLetter;
        array[x2][y2] = array[x1][y1];
        array[x1][y1] = temp;

        //set new coordinates: 
            //X tou neou                        //Y tou neou
        array[x2][y2].setX(willX);          array[x2][y2].setY(willY);
            //X tou paliou                      //Y tou paliou
        array[x1][y1].setX(currentX);       array[x1][y1].setY(currentY);
    }

    public Letter[][] getArray() {
        return array;
    }

    public void setArray(Letter[][] array) {
        this.array = array;
    }

    public double getCurrentX() {
        return currentX;
    }

    public void setCurrentX(double currentX) {
        this.currentX = currentX;
    }

    public double getCurrentY() {
        return currentY;
    }

    public void setCurrentY(double currentY) {
        this.currentY = currentY;
    }

    public double getWillX() {
        return willX;
    }

    public void setWillX(double willX) {
        this.willX = willX;
    }

    public double getWillY() {
        return willY;
    }

    public void setWillY(double willY) {
        this.willY = willY;
    }
}
