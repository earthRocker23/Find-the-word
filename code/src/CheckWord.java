/**
 *
 *                  @authors 
 *         Anastasios Vanis     321/2012017
 *         Nickolaos Chaikalis  321/2012200
 *             Phase 2 Omadikis Ergasias
 */

public class CheckWord {
    private double x, y;
    private Dashboard dashboard;

    //Default Constructor
    public CheckWord() {
    }
    
    //Constructor
    public CheckWord(double x, double y, Dashboard dashboard) {
        this.x = x;
        this.y = y;
        this.dashboard = dashboard;
    }
    
    // Hashcode, Equals, Getters & Setters:
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CheckWord other = (CheckWord) obj;
        return true;
    }

    @Override
    public String toString() {
        return "CheckWord{" + "x=" + x + ", y=" + y + '}';
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

    public Dashboard getDashboard() {
        return dashboard;
    }

    public void setDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
    } 
}
