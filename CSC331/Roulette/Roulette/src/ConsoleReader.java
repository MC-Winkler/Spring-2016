import java.io.*;
import java.util.*;


/**
 * Provides a variety of methods to simplify getting user input
 * from the console.
 * 
 * Note: You don't need to refactor this class.
 * 
 * @authors Robert and Shannon Duvall
 */
public class ConsoleReader
{
    // by default, read input from the user's console
    private static Scanner in = new Scanner(System.in);

    /**
     * Prompts the user to input an integer value.
     *
     * @param prompt output to the user before waiting for input
     * @return the value entered, waiting if necessary until one is given
     */
    public static int promptForInt (String prompt)
    {
        System.out.print(prompt);
        return in.nextInt();
    }
   
    /**
     * Prompts the user to input an real value.
     *
     * @param prompt output to the user before waiting for input
     * @return the value entered, waiting if necessary until one is given
     */
    public static double promptForDouble (String prompt)
    {
        System.out.print(prompt);
        return in.nextDouble();
    }

    /**
     * Prompts the user to input a word.
     *
     * @param prompt output to the user before waiting for input
     * @return the value entered, waiting if necessary until one is given
     */
    public static String promptForString (String prompt)
    {
        System.out.print(prompt);
        return in.next();
    }

    /**
     * Prompts the user to input a complete line of text.
     *
     * @param prompt output to the user before waiting for input
     * @return the value entered, waiting if necessary until one is given
     */
    public static String promptForLine (String prompt)
    {
        System.out.print(prompt);
        return in.nextLine();
    }


    /**
     * Prompts the user to input an integer value between the given values, inclusive.
     * Note, repeatedly prompts the user until a valid value is entered.
     *
     * @param prompt output to the user before waiting for input
     * @param low minimum possible valid value allowed
     * @param hi maximum possible valid value allowed
     * @return the value entered, waiting if necessary until one is given
     */
    public static int promptRange (String prompt, int low, int hi)
    {
        int answer;

        do
        {
            answer = promptForInt(prompt + " between " + low + " and " + hi + "? ");
        }
        while (low > answer || answer > hi);

        return answer;
    }

    /**
     * Prompts the user to input an real value between the given values, inclusive.
     * Note, repeatedly prompts the user until a valid value is entered.
     *
     * @param prompt output to the user before waiting for input
     * @param low minimum possible valid value allowed
     * @param hi maximum possible valid value allowed
     * @return the value entered, waiting if necessary until one is given
     */
    public static double promptRange (String prompt, double low, double hi)
    {
        double answer;

        do
        {
            answer = promptForDouble(prompt + " between " + low + " and " + hi + "? ");
        }
        while (low > answer || answer > hi);

        return answer;
    }

    /**
     * Prompts the user to input yes or no to the given question.
     * Note, repeatedly prompts the user until yes or no is entered.
     *
     * @param prompt output to the user before waiting for input
     * @return the value entered, waiting if necessary until one is given
     */
    public static boolean promptYesNo (String prompt)
    {
        String answer;

        do
        {
            answer = promptForString(prompt + " (yes or no)? ");
        }
        while (!answer.equals("yes") && !answer.equals("no"));

        return (answer.equals("yes"));
    }

    /**
     * Prompts the user to input one of the given choices to the question.
     * Note, repeatedly prompts the user until a valid choice is entered.
     *
     * @param prompt output to the user before waiting for input
     * @param choices possible valid responses user can enter
     * @return the value entered, waiting if necessary until one is given
     */
    public static String promptOneOf (String prompt, Set<String> choices)
    {
        String result;

        do
        {
            result = promptForString(prompt + " on one of " + choices + "? ");
        }
        while (! choices.contains(result));

        return result;
    }
}
