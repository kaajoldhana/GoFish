package gofish_assn;

import java.util.ArrayList;
import java.util.Random;
public class Player {
	
	ArrayList<Card> hand = new ArrayList<Card>(); //holds cards in Player's hands
	ArrayList<Card> book = new ArrayList<Card>(); //pairs made during the game for each Player
	Random rand = new Random();
	String name; //name of Player
	/**
	 * Constructor- Creates Player with name
	 *
	 *
	 *
	 * @param name of Player
	 *
	 */
	public Player(String name) {

		this.name = name;
	}
	/**
	 * Adds card to player's hand- a card from the deck or from another player
	 *@param c card to be added to hand
	 *
	 *
	 */
	public void addCardToHand(Card c) {
		Card newcard = new Card(c.getRank(), c.getSuit());
		hand.add(newcard);

	
	}
	/**
	 * Removes a card from a player's hand- when a player has to give a card to the other player
	 *@param c Card to remove from the player's hand
	 *
	 *
	 * @return Card that was removed
	 *
	 */
	
	public Card removeCardFromHand(Card c) {
		for(int i = 0; i<hand.size(); i++){
			if((hand.get(i).getRank() == c.getRank()) && (hand.get(i).getSuit() == c.getSuit())){
				hand.remove(i);

			}
		}


		Card retCard = new Card(c.getRank(),c.getSuit());
		
		return retCard;
	}
	/**
	 * Returns String of Player name
	 *
	 *
	 *
	 * @return String - name of Player
	 *
	 */
	public String getName() {

		return name;
	}
	/**
	 * Returns String of a Player's hand
	 *
	 *
	 *
	 * @return String - of cards in hand
	 *
	 */
	
	public String handToString() {
		String s = new String();
		for(int i = 0; i<hand.size(); i++){
			s = s+ (hand.get(i));
		}

		return s;
	}
	/**
	 * Returns String of a Player's book
	 *
	 *
	 *
	 * @return String - of cards in book
	 *
	 */

	public String bookToString() {
		String s = new String();
		for(int i = 0; i<book.size(); i++){
			s = s+ book.get(i) + ", ";
		}
		return s;
	}
	/**
	 * Returns size of a Player's hand
	 *
	 *
	 *
	 * @return size - of cards in hand
	 *
	 */


	public int getHandSize() {
		return hand.size();


	}

	/**
	 * Returns the number of pairs a player has
	 *
	 *
	 *
	 * @return int- number of pairs
	 *
	 */

	public int getBookSize() {
		return book.size();

	}
	
	
	//Here are som ideas for additional functionality that you may want/need
	//OPTIONAL
    // comment out if you decide to not use it
    //this function will check a players hand for a pair. 
    //If a pair is found, it moves the cards to the book and returns true
	/**
	 * Returns true if a player's hand has a pair
	 *
	 *
	 *
	 * @return true if player has a pair/false if no pair
	 *
	 *
	 */
    public boolean checkHandForBook()
	{
		for(int i = 0; i<hand.size(); i++){
			for(int j = i+1; j<hand.size(); j++){
				if(hand.get(i).getRank() == hand.get(j).getRank()){
				    book.add(hand.get(i));
				    book.add(hand.get(j));
				    removeCardFromHand(hand.get(i));
				    removeCardFromHand(hand.get(j-1)); //index changes when card is removed
					//book.add(removeCardFromHand(hand.get(i)));
					//book.add(removeCardFromHand(hand.get(j)));
					return true;
				}
			}
		}
    	return false; //stubbed
    }


    //OPTIONAL
    // comment out if you decide to not use it    
    //Does the player have a card with the same rank as c in her hand?
	/**
	 * Returns true if a player's hand has a rank - used when a player is asking another player for a card
	 *
	 * @param c Card that a plyer asked for
	 * @return true if player has the card in hand
	 *
	 *
	 */
    public boolean rankInHand(Card c) {

		int player_rank = c.getRank();
		if(hand.size() == 0){
			return false;
		}
		for(int i = 0; i<hand.size(); i++){
			if(hand.get(i).getRank() == player_rank){
				return true;
			}
		}
    	return false; //stubbed
    }
	/**
	 * Returns a card from the player's hand to ask the other player if they have the card
	 *
	 *
	 * @return Card from player's hand
	 *
	 *
	 */
    
    //uses some strategy to choose one card from the player's
    //hand so they can say "Do you have a 4?"
    public Card chooseCardFromHand() {

		if(hand.size() > 0){
			int num = rand.nextInt(hand.size());
			Card askingcard = hand.get(num);
			Card returncard = new Card(askingcard.getRank(), askingcard.getSuit());
			return returncard;


		}
		return null;


    }
	/**
	 * checks to see if the player has the card in his hand
	 * @param c card being searched for
	 *
	 * @return true if the player has the card
	 *
	 *
	 */
    
    //Does the player have the card c in her hand?
    public boolean cardInHand(Card c) {
		int player_rank = c.getRank();
		for(int i = 0; i<hand.size(); i++){
			if(hand.get(i).getRank() == player_rank){
				return true;
			}
		}
		return false;



    }
    

    //OPTIONAL
    // comment out if you decide to not use it    
    //Does the player have a card with the same rank as c in her hand?
    //e.g. will return true if the player has a 7d and the parameter is 7c
	/**
	 * checks to see if the player has the card in his hand
	 *
	 *@param c card being searched for
	 * @return Card if the player has the card
	 *
	 *
	 */

    public Card hasCardinHand(Card c){
        int player_rank = c.getRank();
        for(int i = 0; i<hand.size(); i++){
            if(hand.get(i).getRank() == player_rank){
                return hand.get(i);
            }
        }
       return null;

    }

}
