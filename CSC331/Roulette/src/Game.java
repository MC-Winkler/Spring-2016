/**
 * Plays a game of roulette.
 * 
 * @authors Robert and Shannon Duvall
 */
public class Game {
	// name of the game
	private static final String DEFAULT_NAME = "Roulette";

	private Wheel myWheel;
	private Bet[] myPossibleBets = { 
			new RedBlackBet("Red or Black", 1), 
			new OddEvenBet("Odd or Even", 1),
			new HighLowBet("High or Low", 1),
			new RowBet("Single Number", 35, 1),
			new RowBet("Two in a Row", 17, 2),
			new RowBet("Three in a Row", 11, 3) };

	/**
	 * Construct the game.
	 */
	public Game() {
		myWheel = new Wheel();
	}

	/**
	 * @return name of the game
	 */
	public String getName() {
		return DEFAULT_NAME;
	}

	/**
	 * Play a round of this game.
	 *
	 * For Roulette, this means prompting the player to make a bet, spinning the
	 * roulette wheel, and then verifying that the bet is won or lost.
	 *
	 * @param player
	 *            one that wants to play a round of the game
	 */
	public void play(Gambler player) {
		Bet bet;

		int amount = ConsoleReader.promptRange("How much do you want to bet", 0, player.myMoney);

		/**
		 * Place the given bet by prompting the user for the specific
		 * information need to complete the given bet.
		 *
		 * @param whichBet
		 *            specific bet chosen by the user
		 */
		int whichBet = promptForBet();

		bet = myPossibleBets[whichBet];

		String betChoice = bet.placeBet();

		System.out.print("Spinning ...");
		myWheel.spin();
		System.out.println("Dropped into " + myWheel.getColor() + " " + myWheel.getNumber());

		/**
		 * Checks if the given bet is won or lost given the user's choice and
		 * the result of spinning the wheel.
		 *
		 * @param betChoice
		 *            specific value user chose to try to win the bet
		 */
		if (bet.isMade(myWheel, betChoice)) {
			System.out.println("*** Congratulations :) You win ***");
			amount *= myPossibleBets[whichBet].myOdds;
		} else {
			System.out.println("*** Sorry :( You lose ***");
			amount *= -1;
		}
		player.updateBankroll(amount);

	}

	/**
	 * Prompt the user to make a bet from a menu of choices.
	 */
	private int promptForBet() {
		System.out.println("You can make one of the following types of bets:");
		for (int k = 0; k < myPossibleBets.length; k++) {
			System.out.println((k + 1) + ") " + myPossibleBets[k].getDescription());
		}

		return ConsoleReader.promptRange("Please make a choice", 1, myPossibleBets.length) - 1;
	}

}