
import java.util.Objects;

/**
 *
 *                  @authors 
 *         Anastasios Vanis     321/2012017
 *         Nickolaos Chaikalis  321/2012200
 *             Phase 2 Omadikis Ergasias
 */
public abstract class Player {
    protected String nickname;
    protected int score;
    protected int lives;
    protected int tries;//poses fores tha xrisimopoiisei diagrafes anadiatakseis MAX = 7;

    public Player(String nickname, int score, int lives, int tries) {
        this.nickname = nickname;
        this.score = score;
        this.lives = lives;
        this.tries = tries;
    }

    @Override
    public String toString() {
        return "Player{" + "nickname=" + nickname + ", score=" + score + ", lives=" + lives + ", tries=" + tries + '}';
    }

    

    public int getTries() {
        return tries;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }
    
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    } 
}
