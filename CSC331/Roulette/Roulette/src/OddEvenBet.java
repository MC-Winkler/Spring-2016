import java.util.Set;
import java.util.TreeSet;

public class OddEvenBet extends Bet {

	private Set<String> choices;
	
	public OddEvenBet(String description, int odds){
		super(description, odds);
        choices = new TreeSet<String>();
        choices.add("even");
        choices.add("odd");
	}
	
	protected String placeBet(){
        return ("" + ConsoleReader.promptOneOf("Please bet", choices));
	}
	
	protected boolean isMade(Wheel myWheel, String betChoice){
        return (myWheel.getNumber() % 2 == 0 && betChoice.equals("even")) ||
                (myWheel.getNumber() % 2 == 1 && betChoice.equals("odd"));	
        }
}
