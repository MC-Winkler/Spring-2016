import java.util.Set;
import java.util.TreeSet;

public class RedBlackBet extends Bet {
	
	private Set<String> choices;
	
	public RedBlackBet (String description, int odds){
		super(description, odds);
		choices = new TreeSet<String>();
        choices.add(Wheel.BLACK);
        choices.add(Wheel.RED);
	}
	
	protected String placeBet(){
    	return ("" + ConsoleReader.promptOneOf("Please bet", choices));
	}

	protected boolean isMade(Wheel myWheel, String betChoice){
		return myWheel.getColor().equals(betChoice);
	}
	
}
