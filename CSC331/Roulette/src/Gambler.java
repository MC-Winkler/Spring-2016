/**
 * Represents a Gambler simply as an amount to money to be spent.
 * 
 * @author Robert and Shannon Duvall
 */
public class Gambler
{
    public String myName;
    public int myMoney;


    /**
     * Constructs a gambler with the given name and an initial bankroll.
     * 
     * @param name used to refer to the gambler
     * @param money initial amount of the money the gambler has to spend
     */
    public Gambler (String name, int money, Game game)
    {
        myName = name;
        myMoney = money;
        System.out.println("Hello " + myName + 
                ", let's play " + game.getName());
        System.out.println();  
    }


    /**
     * @return true if the gambler has money left to spend, false otherwise
     */
    public boolean isSolvent ()
    {
    	if (myMoney > 0)
    		return true;
    	else{
    		System.out.println();
    		System.out.println("Goodbye " + myName + 
                           ", thanks for playing!");
    		return false;
    	}
    }


    /**
     * Changes the gambler's bankroll to reflect the given amount won or lost.
     *
     * @param amount money won (positive) or lost (negative) by the gambler
     */
    public void updateBankroll (int amount)
    {
        myMoney += amount;
    }
}
