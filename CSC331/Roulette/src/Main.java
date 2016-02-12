/**
 * Plays as many games of roulette until the user quits or runs out of money.
 * 
 * @authors Robert and Shannon Duvall
 */
public class Main
{
    public static void main (String[] args)
    {
        Game game = new Game();
        
        String playerName = ConsoleReader.promptForString("What is your name?");
        int initialAmount = ConsoleReader.promptForInt("How much money do you have?");
        Gambler player = new Gambler(playerName, initialAmount, game);

        

        do
        {
            game.play(player);
        }
        while (player.isSolvent());

      
    }
}
