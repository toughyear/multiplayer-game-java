import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GameData {
    // number of players
    int NOP;
    // boolean to check if game finished
    public boolean gameCompleted = false;
    public int winnerID = 0;
    // lock object declaration
    public Object lock = new Object();
    // boolean array for players to check whether they have compared the latest
    boolean[] checkedList;
    // arraylist for generated number
    public ArrayList<Integer> ModList = new ArrayList<Integer>();

    // function to generate a random number
    public void generateRandom() {
        // create instance of Random class
        Random rand = new Random();

        // Generate random integers in range 0 to 999
        int rand_int = rand.nextInt(50);

        ModList.add(rand_int);
        Printer.Yellow("Moderator generated a new number:" + rand_int);

    }

    // function to check all true in a boolean array
    public boolean areAllTrue(boolean[] array) {
        for (boolean b : array)
            if (!b)
                return false;
        return true;
    }

    // constructor
    GameData(final int n) {
        // set the NOP to number of players
        this.NOP = n;
        // set checkedlist with memory
        checkedList = new boolean[NOP];
        // set: all of the players have checked the last value to true
        Arrays.fill(checkedList, true);

    }

}