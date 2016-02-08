
public class ThreeInARowBet extends Bet {

	public ThreeInARowBet(String description, int odds){
		super(description, odds);
	}
	
	protected String placeBet(){
		return ("" + ConsoleReader.promptRange("Enter first of three consecutive numbers", 1, 34));
	}
	
	protected boolean isMade(Wheel myWheel, String betChoice){
		return myWheel.getColor().equals(betChoice);
	}
}
