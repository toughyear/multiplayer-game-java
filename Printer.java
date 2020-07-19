public class Printer {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void Green(String s) {
        System.out.println(ANSI_GREEN + s + ANSI_RESET);
    }

    public static void Yellow(String s) {
        System.out.println(ANSI_YELLOW + s + ANSI_RESET);
    }

    public static void Blue(String s) {
        System.out.println(ANSI_BLUE + s + ANSI_RESET);
    }
}