package myGames;

import myCards.Card;
import myDecks.*;
import java.util.ArrayList;

/**
 * This class represents a BlackJack game
 * which has public deck, a player and a dealer
 */
public class CardGame {
    Deck publicDeck;
    Dealer dealer;
    Player player;

    // ==================== constructor ====================

    /**
     * Construct a CardGame object to Simulate a BlackJack game
     * Then, initial card dealing - deal 4 cards in total
     * two cards assigned to player, two cards to dealer
     * finally update points of dealer and player
     */
    public CardGame(){
        publicDeck = new Deck();
        dealer = new Dealer();
        player = new Player();
        publicDeck.shuffle(); // shuffle 52 cards

        dealer.getDeck().addWith(publicDeck.removeTopOne());
        player.hit(publicDeck.removeTopOne());

        dealer.getDeck().addWith(publicDeck.removeTopOne());
        player.hit(publicDeck.removeTopOne());

        // in case of first two cards value is bigger than 17
        dealer.setPoints(dealer.getDeck().calculatePoints());
    }

    // ==================== getter and setters ====================

    /**
     * Get the public deck of game
     * @return a Deck object represent the public deck
     */
    public Deck getPublicDeck() {
        return publicDeck;
    }


    /**
     * Get the Player object of game
     * @return a Player object represent the player
     */
    public Player getPlayer(){
        return player;
    }


    /**
     * Get the Dealer object of game
     * @return a Dealer object represent the dealer
     */
    public Dealer getDealer(){
        return dealer;
    }


    /**
     * Get the dealer cards of game
     * @return a dealer cards array represent the dealer's cards
     */
    public ArrayList<Card> getDealerCards(){
        return getDealer().getDeck().getCards();
    }


    /**
     * Get the player cards of game
     * @return a player cards array represent the player's cards
     */
    public ArrayList<Card> getPlayerCards(){
        return getPlayer().getDeck().getCards();
    }

    // ========================== methods ==========================

    /**
     * Check if dealer round is over
     * @return ture if dealer round is over, otherwise false
     */
    public boolean isDealerOver(){
        return !dealer.getStatus();
    }

    /**
     * Check if player round is over
     * @return ture if player round is over, otherwise false
     */
    public boolean isPlayerOver(){
        return !player.getStatus();
    }


    /**
     * Get the winner of BlackJack game
     * @return a Person object represents the winner
     */
    public Person getWinner(){
        if  (player.isBust()) {
            return dealer;
        }
        else if (dealer.isBust()) {
            return player;
        }
        else if (dealer.getPoints() > player.getPoints()) {
            return dealer;
        }
        else if (dealer.getPoints() < player.getPoints()) {
            return player;
        }
        else if (dealer.hasBlackJack() && !player.hasBlackJack()) {
            return dealer;
        }
        else if (!dealer.hasBlackJack() && player.hasBlackJack()) {
            return player;
        }
        else {
            return null;
        }
    }
}

