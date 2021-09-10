package myCards.fourSuits;
import myCards.*;

/**
 * This class represent a Spades Card class
 */
public class Spades extends Card {

// ==================== constructor ====================

    /**
     * Construct a card object using super method,
     * and set suit to Spades
     */
    public Spades(int name){
        super(name);
        this.setSuit(Suit.Spade);
    }

// ======================= method =======================

    /**
     * Modify toString method for convenient
     * @return the string of the card in the format of "card number of card suit"
     *          with its unicode symbol
     */
    @Override
    public String toString(){
        String value = String.format("%02d", getName());
        return "(\u2660" + value + ") "
                + convertName(getName()) + " of " + this.getSuit();
    }
}
