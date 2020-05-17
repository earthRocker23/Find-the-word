/**
 *
 *                  @authors 
 *         Anastasios Vanis     321/2012017
 *         Nickolaos Chaikalis  321/2012200
 *             Phase 2 Omadikis Ergasias
 */
public interface DashboardsInterface {
    public void ShuffleTheWords();
    public void FindLetter();
    public void InsertWhiteLetter(char[][] array, int i, int j);
    public void InsertRedLetter(char[][] array, int i, int j);
    public void InsertBlueLetter(char[][] array, int i, int j);
    public void InsertJokerLetter(char[][] array, int i, int j);
    public int RandomNumber(int n);
    public Letter[][] GetArray();
    public void PrintArray();
}
