
public class SingleNumberBet extends Bet {
	
	SingleNumberBet (String description, int odds){
		super(description, odds);
	}

	@Override
	protected String placeBet() {
		return ("" + ConsoleReader.promptRange("Enter a number between 1 and 36", LOWERBOUND, UPPERBOUND));
	}

	@Override
	protected boolean isMade(Wheel myWheel, String betChoice) {
		int choice = Integer.parseInt(betChoice);
		return myWheel.getNumber() == choice;
	}

}
