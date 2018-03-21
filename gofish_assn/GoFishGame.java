package gofish_assn;
import java.io.*;
public class GoFishGame {
    private Player player1;
    private Player player2;
    private  Deck deck;
    private int num_books;
    private PrintWriter output;
    /**
     * Constructor for GoFishGame, also prepares program to output to file
     *
     *
     */
    public GoFishGame() {
        player1 = new Player("Tom");
        player2 = new Player("Leslie");
        deck = new Deck(); //creates new deck
        num_books = 0; //number of pairs made total

        try{
            File out = new File("gofish_out.txt");
            output  = new PrintWriter(out);

        }
        catch (FileNotFoundException fnfe){
            System.out.println("File not found! " + fnfe);
        }

        //ADD CASE IF A PLAYER ASKS FOR A CARD AND THE OTHER PLAYER DOESNT HAVE ANY CARDS
        //Player player1 = new Player("Tom");
        //Player player2 = new Player("Leslie");
        //Deck deck = new Deck();
        //int num_books = 0;
/*
		for(int i = 0; i<7; i++){
		    player1.addCardToHand(deck.dealCard());
		    player2.addCardToHand(deck.dealCard());
        }

        while(player1.checkHandForBook()){
		    output.println(player1.name + " books the "+ player1.book.get(player1.getBookSize()-1).getRank()); //last card added is last book made
            num_books++;
		}
        while(player2.checkHandForBook()){
            output.println(player2.name + " books the "+ player2.book.get(player2.getBookSize()-1).getRank()); //last card added is last book made
            num_books++;
        }

        while(num_books < 26 || deck.getSize() > 0){
		    if(player1.getHandSize() == 0){
                output.println(player1.name + " has no cards left");
                if(deck.getSize() == 0){
                    output.println("The Deck is empty");
                    break;
                }
                Card noCardLeft = deck.dealCard();
                player1.addCardToHand(noCardLeft);
                output.println(player1.name+ " draws a " + noCardLeft);
            }

            Card cardplay1 = player1.chooseCardFromHand();
            output.println(player1.name + " asks- Do you have a " + cardplay1);
            boolean hascard = player2.rankInHand(cardplay1);
            if(hascard == false){
                output.println(player2.name +" says- Go Fish");
                if(deck.getSize() == 0){
                    output.println("The Deck is empty");
                    break;
                }
                Card deal1 = deck.dealCard();
                player1.addCardToHand(deal1);
                output.println(player1.name+ " draws a "+ deal1);

                if(player1.checkHandForBook()){
                    num_books++;
                    output.println(player1.name + " books the " + deal1.getRank());

                }



            }
            else{
                Card c1 = player2.hasCardinHand(cardplay1);
                output.println(player2.name + " says- Yes, I have a " + c1);
                player1.addCardToHand(c1);
                player2.removeCardFromHand(c1);
                if(player1.checkHandForBook()){
                    num_books++;
                    output.println(player1.name+ " books the "+ cardplay1.getRank());
                }

            }
            if(player2.getHandSize() == 0){
                output.println(player2.name + " has no cards left");
                if(deck.getSize() == 0){
                    output.println("The Deck is empty");
                    break;
                }
                Card noCardLeft = deck.dealCard();
                player2.addCardToHand(noCardLeft);
                output.println(player2.name+ " draws a " + noCardLeft);

            }
            Card cardplay2 = player2.chooseCardFromHand();
            output.println(player2.name + " asks - Do you have a " + cardplay2);
            hascard = player1.rankInHand(cardplay2);

            if(hascard == false){
                output.println(player1.name + " says- Go Fish");
                if(deck.getSize() == 0){
                    output.println("The Deck is empty");
                    break;
                }
                Card deal2 = deck.dealCard();
                player2.addCardToHand(deal2);
                output.println(player2.name+ " draws a " + deal2);

                if(player2.checkHandForBook()){
                    num_books++;
                    output.println(player2.name+ " books the " + deal2.getRank());
                }
            }
            else{
                Card c2 = player1.hasCardinHand(cardplay2);
                output.println(player1.name + " says- Yes, I have a " + c2);
                player2.addCardToHand(c2);
                player1.removeCardFromHand(c2);
                if(player2.checkHandForBook()){
                    num_books++;
                    output.println(player2.name+ " books the " + cardplay2.getRank());
                }
            }

        }


        if(player1.getBookSize() > player2.getBookSize()){
		    output.println(player1.name + " wins with " + player1.getBookSize()/2 + " pairs!");
		    output.println(player1.book);
		    output.println(player2.name+ "has " + player2.getBookSize()/2+ " pairs!");
		    output.println(player2.book);

        }
        if(player1.getBookSize() < player2.getBookSize()){
            output.println(player2.name + " wins with " + player2.getBookSize()/2 + " pairs!");
            output.println(player2.book);
            output.println(player1.name+ "has " + player1.getBookSize()/2 + " pairs!");
            output.println(player1.book);

        }
        if(player1.getBookSize() == player2.getBookSize()){
		    output.println(player1.name + " ties with " + player2.name);
            output.println(player1.name+ "has " + player1.getBookSize()/2 + " pairs!");
            output.println(player1.book);
            output.println(player2.name+ "has " + player2.getBookSize()/2 + " pairs!");
            output.println(player2.book);

        }

*/
        // TODO Auto-generated constructor stub
    }
    /**
     * Deals initial cards to players
     *
     *
     *
     */
    public void dealCards(){

        for(int i = 0; i<7; i++){
            player1.addCardToHand(deck.dealCard());
            player2.addCardToHand(deck.dealCard());
        }

    }
    /**
     * Checks if player's hand is empty or if the deck is empty
     * if player's hand is empty, draw a card
     * if deck is empty, return trie
     *
     *@param p player who's hand is being checked
     *@return true if deck is empty
     *
     */
    public boolean checkEmptyHand(Player p){
        if(p.getHandSize() == 0){
            output.println(p.name + " has no cards left");
            if(deck.getSize() == 0){
                output.println("The Deck is empty");
                return true;
            }
            else{
                Card noCardLeft = deck.dealCard();
                p.addCardToHand(noCardLeft);
                output.println(p.name+ " draws a " + noCardLeft); //if the player's hand is empty
                return false;
            }
        }
        else{
            return false;
        }
    }
    /**
     * P1 asks P2 for a card to play the game
     *@param p1 player1 asking for the card
     *@param p2 player2 checking if they have the card
     *
     *
     */

    public void askCard(Player p1, Player p2){ //p1 asks p2 for a card, p2 gives a card or says go Fish
        boolean isEmpty = checkEmptyHand(p1);
      /*
        if(p1.getHandSize() == 0){
            output.println(p1.name + " has no cards left");
            if(deck.getSize() == 0){
                output.println("The Deck is empty");
                return;

            }
            else{
                Card noCardLeft = deck.dealCard();
                p1.addCardToHand(noCardLeft);
                output.println(p1.name+ " draws a " + noCardLeft); //if the player's hand is empty
            }

        }
*/
        if(isEmpty){
            return; //Deck is finished
        }
        Card cardplay1 = p1.chooseCardFromHand();
        output.println(p1.name + " asks - Do you have a " + cardplay1.getRankString(cardplay1.getRank()));
        //output.println(p1.name + " asks - Do you have a " + cardplay1.getRank());
        isEmpty = checkEmptyHand(p2);
        if(isEmpty){
            return;
        }
       // if(p2.getHandSize() == 0){
       //     output.println(p2.name + " has no cards left");

       // }

        boolean hascard = p2.rankInHand(cardplay1);
        if(hascard == false){

            output.println(p2.name +" says - Go Fish");
            if(deck.getSize() == 0){
               // output.println("The deck is empty\n");
                return;
            }
            else {

                Card deal1 = deck.dealCard();
                p1.addCardToHand(deal1);
                output.println(p1.name + " draws a " + deal1 + "\n");

                if (p1.checkHandForBook()) {
                    num_books++;
                    //output.println(p1.name + " books the " + deal1.getRank());
                    output.println(p1.name + " books the " + deal1.getRankString(deal1.getRank()));

                }
            }


        }
        else{
            Card c1 = p2.hasCardinHand(cardplay1);
            output.println(p2.name + " says - Yes, I have a " + c1.getRankString(c1.getRank()));
            p1.addCardToHand(c1);
            p2.removeCardFromHand(c1);
            if(p1.checkHandForBook()){
                num_books++;
                output.println(p1.name+ " books the "+ cardplay1.getRankString(cardplay1.getRank())+ "\n");
                askCard(p1,p2);
            }

        }

    }
    /**
     * Picks a winner based on the player with the highest number of pairs
     *
     *
     *
     */
    public void pickWinner(){
        if(player1.getBookSize() > player2.getBookSize()){
            output.println(player1.name + " wins with " + player1.getBookSize()/2 + " pairs!");
            output.println(player1.book);
            output.println(player2.name+ " has " + player2.getBookSize()/2 + " pairs!");
            output.println(player2.book);

        }
        if(player1.getBookSize() < player2.getBookSize()){
            output.println(player2.name + " wins with " + player2.getBookSize()/2 + " pairs!");
            output.println(player2.book);
            output.println(player1.name+ " has " + player1.getBookSize()/2 + " pairs!");
            output.println(player1.book);

        }
        if(player1.getBookSize() == player2.getBookSize()){
            output.println(player1.name + " ties with " + player2.name);
            output.println(player1.name+ " has " + player1.getBookSize()/2 + " pairs!");
            output.println(player1.book);
            output.println(player2.name+ " has " + player2.getBookSize()/2 + " pairs!");
            output.println(player2.book);

        }

    }
    /**
     * Main function to play the game
     * Checks inital cards for pairs
     *
     *
     */

    public void playGame(){
        dealCards();


        while(player1.checkHandForBook()){

          // output.println(player1.name + " books the "+ player1.book.get(player1.getBookSize()-1).getRank()); //last card added is last book made
            output.println(player1.name + " books the "+ player1.book.get(player1.getBookSize()-1).getRankString(player1.book.get(player1.getBookSize()-1).getRank()));

            num_books++;
        }
        while(player2.checkHandForBook()){
            output.println(player2.name + " books the "+ player2.book.get(player2.getBookSize()-1).getRankString(player2.book.get(player2.getBookSize()-1).getRank()));
           // output.println(player2.name + " books the "+ player2.book.get(player2.getBookSize()-1).getRank()); //last card added is last book made

            num_books++;
        }
        while(num_books < 26 || deck.getSize() > 0){
            askCard(player1,player2);
            if(deck.getSize() == 0){
                break;
            }
            askCard(player2,player1);
        }
        pickWinner();
        output.close();

    }


}
