
public class TwoInARowBet extends Bet {
	
	int UPPERBOUND = 35;
	
	public TwoInARowBet (String description, int odds){
		super(description, odds);
	}
	
	@Override
	protected String placeBet() {
		return ("" + ConsoleReader.promptRange("Enter first of two consecutive numbers", LOWERBOUND, UPPERBOUND));
	}

	@Override
	protected boolean isMade(Wheel myWheel, String betChoice) {
		int start = Integer.parseInt(betChoice);
        return (start <= myWheel.getNumber() && 
                myWheel.getNumber() < start + 2);		
	}

}
