
public class RowBet extends Bet {

	int betType;
	int UPPERBOUND = 37;
	//LOWERBOUND is inherited from parent class bet
	
	public RowBet (String description, int odds, int betType){
		super(description, odds);
		this.betType = betType;
		UPPERBOUND -=betType;
	}
	@Override
	protected String placeBet() {
		return ("" + ConsoleReader.promptRange("Enter a number", LOWERBOUND, UPPERBOUND));		 
	}

	@Override
	protected boolean isMade(Wheel myWheel, String betChoice) {
		int start = Integer.parseInt(betChoice);
        return (start <= myWheel.getNumber() && 
                myWheel.getNumber() < start + betType);
	}

}
