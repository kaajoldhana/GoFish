package gofish_assn;

import java.util.ArrayList;
import java.util.Random;

import gofish_assn.Card.Suits;
import java.util.Random;

public class Deck {
	ArrayList<Card> deck = new ArrayList<Card> (); //deck of cards
	final int NUM_CARDS = 52;  //for this kind of deck
	Random random = new Random();
	//creates a new sorted deck
	/**
	 * Default constructor for Deck
	 * creates standard deck of cards(52) with 13 ranks and 4 suits each
	 * creates deck in order of rank, shuffles deck
	 *
	 *
	 */
	public Deck() {
		deck = new ArrayList<Card>(NUM_CARDS);
		for(int i = 1; i < 14; i++){

				Card clubcard = new Card(i, Suits.club);
				Card heartcard = new Card(i, Suits.heart);
				Card diamondcard = new Card(i, Suits.diamond);
				Card spadecard = new Card(i, Suits.spade);
				deck.add(clubcard);
				deck.add(heartcard);
				deck.add(diamondcard);
				deck.add(spadecard);


		}
		shuffle();


		
		
	}

	/**
	 * Shuffles deck of cards by swapping random pairs
	 *
	 *
	 */
	public void shuffle() {
		for(int i = 0; i <NUM_CARDS; i++){
			int num = random.nextInt(52);
			Card temp = deck.get(num);
			deck.set(num,deck.get(i));
			deck.set(i, temp);
		}


		
	}
	/**
	 * Prints entire deck to console
	 * Utilizes toString() in Card class
	 *
	 */
	
	public void printDeck() {
		for(int i = 0; i< NUM_CARDS; i++){
			System.out.println(deck.get(i).toString());
		}

	}
	/**
	 * Deals a card to a Player
	 * Deck is shuffled, so chooses first card and returns
	 *
	 * @return Card
	 */
	
	public Card dealCard() {
		Card c = deck.get(0);
		deck.remove(0); //deal card
		
		return c;
		
	}
	/**
	 * Returns size of the deck
	 * Used mostly to check if it is empty
	 *
	 * @return size of deck
	 */
	public int getSize(){
		return deck.size();
	}
	

}
