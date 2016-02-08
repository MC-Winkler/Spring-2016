/**
 * Represents a players attempt to make a bet on the outcome of
 * the roulette wheel's spin.
 * 
 * @authors Robert and Shannon Duvall
 */
public abstract class Bet
{
    public String myDescription;
    public int myOdds;

    /**
     * Constructs a bet with the given name and odds.
     * 
     * @param description name of this kind of bet
     * @param odds odds given by the house for this kind of bet
     */
    public Bet (String description, int odds)
    {
        myDescription = description;
        myOdds = odds;
    }

    /**
     * @return name of this kind of bet
     */
    public String getDescription ()
    {
        return myDescription;
    }
    
    protected abstract String placeBet();
    
    protected abstract boolean isMade(Wheel myWheel, String betChoice);
}
