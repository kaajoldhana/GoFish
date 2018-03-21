package gofish_assn;

public class Card {
	/**
	 * Enumerates types of Suits
	 *
	 *
	 */
	public enum Suits {club, diamond, heart, spade}

	;

	static int TOP_RANK = 13; //King
	static int LOW_RANK = 1; //Ace

	int rank;  //1 is an Ace
	Suits suit;

	/**
	 * Default constructor for Card
	 *
	 *
	 */
	public Card() {
		rank = 1;
		suit = Suits.spade;
	}

	/**
	 * Constructs Card with given rank, suit
	 *
	 * @param r rank of card to be constructed
	 * @param s suit of card to be constructed, if suit input is a character
	 *
	 */
	public Card(int r, char s) {
		rank = r;
		suit = toSuit(s);

	}

	/**
	 * Constructs Card with given rank, suit
	 *
	 * @param r rank of card to be constructed
	 * @param s suit of card to be constructed, suit input is type Suit
	 *
	 */
	public Card(int r, Suits s) {
		rank = r;
		suit = s;

	}

	/**
	 * Converts character input to Suit type
	 *
	 * @param c character input for Suit
	 * @return Suit type of input character
	 */
	private Suits toSuit(char c) {
		if (c == 'c') {
			return Suits.club;
		}
		if (c == 'h') {
			return Suits.heart;
		}
		if (c == 'd') {
			return Suits.diamond;
		}
		if (c == 's') {
			return Suits.spade;
		}

		return Suits.spade; //dummy
	}

	/**
	 * Converts Suit to String (used in toString())
	 *
	 * @param s Suit to be converted
	 * @return String of suit type
	 */

	private String suitToString(Suits s) {
		switch (s) {
			case spade:
				return "Spades";
			case heart:
				return "Hearts";
			case club:
				return "Clubs";
			case diamond:
				return "Diamonds";
		}
		return "ERROR";
	}

	/**
	 * Converts rank to String (used in toString())
	 *
	 * @param r rank to be converted
	 * @return String of rank to be outputted
	 */
	private String rankToString(int r) {
		switch (r) {
			case 1:
				return "Ace";
			case 2:
				return "Two";
			case 3:
				return "Three";
			case 4:
				return "Four";
			case 5:
				return "Five";
			case 6:
				return "Six";
			case 7:
				return "Seven";
			case 8:
				return "Eight";
			case 9:
				return "Nine";
			case 10:
				return "Ten";
			case 11:
				return "Jack";
			case 12:
				return "Queen";
			case 13:
				return "King";
		}
		return "A"; //dummy
	}

	/**
	 * Returns rank of Card
	 *
	 * @return rank of Card
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * Returns Suit of Card
	 *
	 * @return Suit of Card
	 */
	public Suits getSuit() {
		return suit;
	}

	/**
	 * Returns String to describe rank and suit of Card
	 *
	 * @return String of Card
	 */
	public String toString() {
		String s = "";

		s = s + rankToString(getRank()) + " of " + suitToString(getSuit());

		return s;
	}
	/**
	 * Returns String to describe rank of Card
	 *@param r rank of Card to be converted to String
	 * @return String of Card
	 */
	public String getRankString(int r) {
		return rankToString(r);

	}
}
