import java.util.Set;
import java.util.TreeSet;

public class HighLowBet extends Bet {

	private Set<String> choices;
	
	public HighLowBet(String description, int odds){
		super(description, odds);
		choices = new TreeSet<String>();
        choices.add("high");
        choices.add("low");
	}
	
	@Override
	protected String placeBet() {
        return ("" + ConsoleReader.promptOneOf("Please bet", choices));
	}

	@Override
	protected boolean isMade(Wheel myWheel, String betChoice) {
		return ((myWheel.getNumber() < 19) && betChoice.equals("low") ||
				(myWheel.getNumber() >= 19) && betChoice.equals("high"));
	}

}
