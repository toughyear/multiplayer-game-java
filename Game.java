import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Printer.Blue("Let's start the game");
        System.out.println("How many players will be playing?");

        // get number of players as input from the user
        Scanner sc = new Scanner(System.in);
        int numberOfPlayers = sc.nextInt();
        // instantiate gamedata
        final GameData game = new GameData(numberOfPlayers);
        sc.close();

        // create a single Moderator
        final Moderator moderator = new Moderator(game);

        // create an array n of players
        final Player[] players = new Player[numberOfPlayers];

        // fill the array with instantiated players
        for (int i = 0; i < numberOfPlayers; i++) {
            players[i] = new Player(game, i + 1);
        }

        // create and run the mod thread
        Thread modThread = new Thread(moderator);
        modThread.start();

        // run the player threads
        for (Player player : players) {
            new Thread(player).start();
        }

        // let the moderator declare the winner
        try {
            modThread.join();
        } catch (InterruptedException e) {

            System.err.println("mod thread joining error");
        }

        Printer.Blue("Game has ended. Thanks for playing");

        return;

    }

}