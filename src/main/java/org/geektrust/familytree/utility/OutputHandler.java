package org.geektrust.familytree.utility;

/**
 * This Class has been created to avoid
 * any direct System.out.print() statements
 */
public abstract class OutputHandler {

    private static boolean PRINTLN_ENABLED = true;

    /**
     * Prints the given string on Console
     * @param string String to print
     */
    public static void print(String string) {
        if(PRINTLN_ENABLED) System.out.println(string);
    }

    /**
     * Enables print function to display string on console
     */
    public static void enablePrint() {
        PRINTLN_ENABLED = true;
    }

    /**
     * Disables print function so no output is displayed
     */
    public static void disablePrint() {
        PRINTLN_ENABLED = false;
    }
}
