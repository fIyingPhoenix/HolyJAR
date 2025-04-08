package HolyJAR;


import java.util.Scanner;

/**
 * A static utility class for console input and output operations.
 * Provides methods for reading various data types from the console and writing to it.
 */
public class Console {
    // Static Scanner instance for all input operations
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private Console() {
        // This constructor is intentionally empty to prevent instantiation
    }

    /**
     * Closes the scanner when it's no longer needed.
     * This method should only be called when completely finished with all console input operations
     * as it will release the Scanner resource.
     */
    public static void closeScanner() {
        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
    }

    // Write methods (for displaying output)

    /**
     * Prints a string value to the console followed by a newline.
     * 
     * @param value The string value to be printed.
     */
    public static void WriteLine(String value) {
        System.out.println(value);
    }

    /**
     * Prints a blank line to the console.
     */
    public static void WriteLine() {
        System.out.println();
    }

    /**
     * Prints a string value to the console without adding a newline.
     * 
     * @param value The string value to be printed.
     */
    public static void Write(String value) {
        System.out.print(value);
    }

    /**
     * Prints an integer value to the console followed by a newline.
     * 
     * @param value The integer value to be printed.
     */
    public static void WriteLine(int value) {
        System.out.println(value);
    }

    /**
     * Prints an integer value to the console without adding a newline.
     * 
     * @param value The integer value to be printed.
     */
    public static void Write(int value) {
        System.out.print(value);
    }

    /**
     * Prints a double value to the console without adding a newline.
     * 
     * @param value The double value to be printed.
     */
    public static void Write(double value) {
        System.out.print(value);
    }

    /**
     * Prints a double value to the console followed by a newline.
     * 
     * @param value The double value to be printed.
     */
    public static void WriteLine(double value) {
        System.out.println(value);
    }

    /**
     * Prints a long value to the console without adding a newline.
     * 
     * @param value The long value to be printed.
     */
    public static void Write(long value) {
        System.out.print(value);
    }

    /**
     * Prints a long value to the console followed by a newline.
     * 
     * @param value The long value to be printed.
     */
    public static void WriteLine(long value) {
        System.out.println(value);
    }

    /**
     * Prints a char value to the console without adding a newline.
     * 
     * @param value The char value to be printed.
     */
    public static void Write(char value) {
        System.out.print(value);
    }

    /**
     * Prints a char value to the console followed by a newline.
     * 
     * @param value The char value to be printed.
     */
    public static void WriteLine(char value) {
        System.out.println(value);
    }

    /**
     * Prints a boolean value to the console without adding a newline.
     * 
     * @param value The boolean value to be printed.
     */
    public static void Write(boolean value) {
        System.out.print(value);
    }

    /**
     * Prints a boolean value to the console followed by a newline.
     * 
     * @param value The boolean value to be printed.
     */
    public static void WriteLine(boolean value) {
        System.out.println(value);
    }

    /**
     * Prints an object to the console followed by a newline.
     * The object's `toString()` method will be called to represent it as a string.
     * 
     * @param value The object to be printed.
     */
    public static void WriteLine(Object value) {
        System.out.println(value);
    }

    /**
     * Prints an object to the console without adding a newline.
     * The object's `toString()` method will be called to represent it as a string.
     * 
     * @param value The object to be printed.
     */
    public static void Write(Object value) {
        System.out.print(value);
    }

    // Read methods (for user input)

    /**
     * Reads a full line of input from the user with a prompt message.
     * 
     * @param prompt The message to prompt the user.
     * @return The input string entered by the user.
     */
    public static String ReadLine(String prompt) {
        Write(prompt);
        return scanner.nextLine();
    }

    /**
     * Reads a full line of input from the user without a prompt message.
     * 
     * @return The input string entered by the user.
     */
    public static String ReadLine() {
        return scanner.nextLine();
    }

    /**
     * Reads an integer value from the user with error handling and a prompt message.
     * If the input is not a valid integer, the user is prompted again.
     * 
     * @param prompt The message to prompt the user.
     * @return The integer value entered by the user.
     */
    public static int ReadInt(String prompt) {
        Write(prompt);
        while (!scanner.hasNextInt()) {
            WriteLine("Ungültige Eingabe! Bitte geben Sie eine gültige ganze Zahl ein.");
            scanner.next(); // consume the invalid input
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // consume the line feed
        return value;
    }

    /**
     * Reads an integer value from the user without a prompt message.
     * If the input is not a valid integer, the user is prompted again.
     * 
     * @return The integer value entered by the user.
     */
    public static int ReadInt() {
        while (!scanner.hasNextInt()) {
            WriteLine("Ungültige Eingabe! Bitte geben Sie eine gültige ganze Zahl ein.");
            scanner.next(); // consume the invalid input
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // consume the line feed
        return value;
    }

    /**
     * Reads a double value from the user with error handling and a prompt message.
     * If the input is not a valid double, the user is prompted again.
     * 
     * @param prompt The message to prompt the user.
     * @return The double value entered by the user.
     */
    public static double ReadDouble(String prompt) {
        Write(prompt);
        while (!scanner.hasNextDouble()) {
            WriteLine("Ungültige Eingabe! Bitte geben Sie eine gültige Zahl ein.");
            scanner.next(); // consume the invalid input
        }
        double value = scanner.nextDouble();
        scanner.nextLine(); // consume the line feed
        return value;
    }

    /**
     * Reads a double value from the user without a prompt message.
     * If the input is not a valid double, the user is prompted again.
     * 
     * @return The double value entered by the user.
     */
    public static double ReadDouble() {
        while (!scanner.hasNextDouble()) {
            WriteLine("Ungültige Eingabe! Bitte geben Sie eine gültige Zahl ein.");
            scanner.next(); // consume the invalid input
        }
        double value = scanner.nextDouble();
        scanner.nextLine(); // consume the line feed
        return value;
    }

    /**
     * Reads a float value from the user with error handling and a prompt message.
     * If the input is not a valid float, the user is prompted again.
     * 
     * @param prompt The message to prompt the user.
     * @return The float value entered by the user.
     */
    public static float ReadFloat(String prompt) {
        Write(prompt);
        while (!scanner.hasNextFloat()) {
            WriteLine("Ungültige Eingabe! Bitte geben Sie eine gültige Dezimalzahl ein.");
            scanner.next(); // consume the invalid input
        }
        float value = scanner.nextFloat();
        scanner.nextLine(); // consume the line feed
        return value;
    }

    /**
     * Reads a float value from the user without a prompt message.
     * If the input is not a valid float, the user is prompted again.
     * 
     * @return The float value entered by the user.
     */
    public static float ReadFloat() {
        while (!scanner.hasNextFloat()) {
            WriteLine("Ungültige Eingabe! Bitte geben Sie eine gültige Dezimalzahl ein.");
            scanner.next(); // consume the invalid input
        }
        float value = scanner.nextFloat();
        scanner.nextLine(); // consume the line feed
        return value;
    }

    /**
     * Reads a boolean value from the user with error handling and a prompt message.
     * If the input is not a valid boolean, the user is prompted again.
     * 
     * @param prompt The message to prompt the user.
     * @return The boolean value entered by the user.
     */
    public static boolean ReadBoolean(String prompt) {
        Write(prompt);
        while (!scanner.hasNextBoolean()) {
            WriteLine("Ungültige Eingabe! Bitte geben Sie 'true' oder 'false' ein.");
            scanner.next(); // consume the invalid input
        }
        boolean value = scanner.nextBoolean();
        scanner.nextLine(); // consume the line feed
        return value;
    }

    /**
     * Reads a boolean value from the user without a prompt message.
     * If the input is not a valid boolean, the user is prompted again.
     * 
     * @return The boolean value entered by the user.
     */
    public static boolean ReadBoolean() {
        while (!scanner.hasNextBoolean()) {
            WriteLine("Ungültige Eingabe! Bitte geben Sie 'true' oder 'false' ein.");
            scanner.next(); // consume the invalid input
        }
        boolean value = scanner.nextBoolean();
        scanner.nextLine(); // consume the line feed
        return value;
    }

    /**
     * Reads a long value from the user with error handling and a prompt message.
     * If the input is not a valid long, the user is prompted again.
     * 
     * @param prompt The message to prompt the user.
     * @return The long value entered by the user.
     */
    public static long ReadLong(String prompt) {
        Write(prompt);
        while (!scanner.hasNextLong()) {
            WriteLine("Ungültige Eingabe! Bitte geben Sie eine gültige Zahl ein.");
            scanner.next(); // consume the invalid input
        }
        long value = scanner.nextLong();
        scanner.nextLine(); // consume the line feed
        return value;
    }

    /**
     * Reads a long value from the user without a prompt message.
     * If the input is not a valid long, the user is prompted again.
     * 
     * @return The long value entered by the user.
     */
    public static long ReadLong() {
        while (!scanner.hasNextLong()) {
            WriteLine("Ungültige Eingabe! Bitte geben Sie eine gültige Zahl ein.");
            scanner.next(); // consume the invalid input
        }
        long value = scanner.nextLong();
        scanner.nextLine(); // consume the line feed
        return value;
    }

    /**
     * Reads a char value from the user with error handling and a prompt message.
     * 
     * @param prompt The message to prompt the user.
     * @return The char value entered by the user.
     */
    public static char ReadChar(String prompt) {
        Write(prompt);
        String input = scanner.next();
        scanner.nextLine(); // consume the line feed
        return input.charAt(0);
    }

    /**
     * Reads a char value from the user without a prompt message.
     * 
     * @return The char value entered by the user.
     */
    public static char ReadChar() {
        String input = scanner.next();
        scanner.nextLine(); // consume the line feed
        return input.charAt(0);
    }
}