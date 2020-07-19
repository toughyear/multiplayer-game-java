import java.util.Arrays;

public class Moderator implements Runnable {
    private GameData game; // shared data

    Moderator(GameData game) {
        this.game = game;
    }

    public void run() {

        int counter = 0;

        synchronized (game.lock) {

            // enter only if all are checked
            while (game.areAllTrue(game.checkedList)) {
                // check if someone won
                if (game.gameCompleted) {
                    Printer.Green("Player " + game.winnerID + " has won the game !");
                    break;
                }
                // else continue

                // check if counter has crossed 10
                if (counter >= 10) {
                    Printer.Blue("10 draws complete, No winner! Try again!");
                    break;
                }
                // generate a random number and add to the list
                System.out.println("Waiting for Moderator");
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                game.generateRandom();
                // increase the counter
                counter++;
                // set the checked array to false for everyone
                Arrays.fill(game.checkedList, false);
                // notify all that a new number generated, try if they can proceed now
                game.lock.notifyAll();

                // wait until all player threads have checked the latest number
                // next while loop ends when all have checked and the outer while loop continues
                while (!game.areAllTrue(game.checkedList)) {
                    try {
                        game.lock.wait();
                    } catch (InterruptedException e) {

                        System.err.println("error: mod can't wait for all the threads to check");
                    }
                }

            }

        }

    }
}