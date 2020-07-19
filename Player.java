import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Player implements Runnable {

    // id of each player
    private int id;
    // for common gamedata reference
    private GameData game;
    // counter for number of matches
    private int counter = 0;
    // array for randomly generated numbers for the current player
    public ArrayList<Integer> card = new ArrayList<Integer>();
    // list of repeated numbers
    public ArrayList<Integer> RepeatList = new ArrayList<Integer>();

    Player(GameData game, int id) {
        // declare the id of player
        this.id = id;
        // set game data
        this.game = game;
        // fill the card of player with random number
        Random rand = new Random();
        // Generate random integers in range 0 to 50

        for (int i = 0; i < 10; i++) {
            card.add(rand.nextInt(50));
        }

        System.out.println("player " + id + " got this: " + card);

    }

    public void run() {
        outerloop: synchronized (game.lock) {
            // don't enter the main loop first time until new value has been added
            while (game.checkedList[id - 1]) {

                try {
                    game.lock.wait();
                } catch (InterruptedException e) {
                    System.err.println("error: thread can't wait for first time");
                }
            }

            // continue while the player hasn't checked the latest number
            while (!game.checkedList[id - 1]) {
                // check if already declared
                if (game.gameCompleted) {
                    break outerloop;
                }
                // check the latest number is a repeat
                if (RepeatList.contains(game.ModList.get(game.ModList.size() - 1))) {
                    Printer.Yellow("The latest number is a repeat for player " + id);

                }
                // else check if matches
                else if (card.contains(game.ModList.get(game.ModList.size() - 1))) {
                    System.out.println("Match found for player " + id);
                    // counter add
                    counter++;
                    this.RepeatList.add(game.ModList.get(game.ModList.size() - 1));
                    if (counter >= 3) {
                        // set winner
                        // System.out.println("we have a winner" + id);
                        // set: all of the players have checked the last value to true
                        Arrays.fill(game.checkedList, true);
                        game.checkedList[id - 1] = true;
                        game.gameCompleted = true;
                        game.winnerID = id;
                        game.lock.notifyAll();
                        break outerloop;
                    }
                }
                // set itself as checked
                game.checkedList[id - 1] = true;

                // notify all other threads and mod that it has completed checking
                game.lock.notifyAll();
                // wait until new number arrives and the latest number has been checked
                while (game.checkedList[id - 1]) {
                    try {
                        game.lock.wait();
                    } catch (InterruptedException e) {
                        System.err.println("error: thread can't wait for next time");
                    }
                }

            }

        }

        return;
    }

}