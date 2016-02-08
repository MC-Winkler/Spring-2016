
public class ThreeInARowBet extends Bet {

	public ThreeInARowBet(String description, int odds){
		super(description, odds);
	}
	
	protected String placeBet(){
		return ("" + ConsoleReader.promptRange("Enter first of three consecutive numbers", 1, 34));
	}
	
	protected boolean isMade(Wheel myWheel, String betChoice){
		int start = Integer.parseInt(betChoice);
        return (start <= myWheel.getNumber() && 
                myWheel.getNumber() < start + 3);
	}
}
