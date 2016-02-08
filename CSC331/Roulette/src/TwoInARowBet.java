
public class TwoInARowBet extends Bet {

	public TwoInARowBet (String description, int odds){
		super(description, odds);
	}
	@Override
	protected String placeBet() {
		return ("" + ConsoleReader.promptRange("Enter first of two consecutive numbers", 1, 34));
	}

	@Override
	protected boolean isMade(Wheel myWheel, String betChoice) {
		int start = Integer.parseInt(betChoice);
        return (start <= myWheel.getNumber() && 
                myWheel.getNumber() < start + 2);		
	}

}
