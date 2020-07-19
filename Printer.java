import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Printer {
    // create a new writer
    static PrintStream stream = new PrintStream(new FileOutputStream(FileDescriptor.out));

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void Green(String s) {
        stream.print(ANSI_GREEN + s + ANSI_RESET + "\n");
    }

    public static void Yellow(String s) {
        stream.print(ANSI_YELLOW + s + ANSI_RESET + "\n");
    }

    public static void Blue(String s) {
        stream.print(ANSI_BLUE + s + ANSI_RESET + "\n");
    }

}