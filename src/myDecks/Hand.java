package myDecks;

import myCards.Card;
import java.util.ArrayList;

/**
 * This class represent a hand of cards extend from Deck class
 */
public class Hand extends Deck{

    // ==================== constructor ====================

    /**
     * Construct a deck object
     */
    public Hand() {
        // default constructor
        setCards(new ArrayList<Card>());
    }

    /**
     * Construct a deck object with a specific number
     */
    public Hand(int number){
        // regular constructor
        super(number);
    }
}
