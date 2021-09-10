package myCards.fourSuits;
import myCards.*;

/**
 * This class represent a Diamonds Card class
 */
public class Diamonds extends Card {

// ==================== constructor ====================

    /**
     * Construct a card object using super method,
     * and set suit to Diamonds
     */
    public Diamonds(int name){
        super(name);
        this.setSuit(Suit.Diamond);
    }

// ======================= method =======================

    /**
     * Modify toString method for convenient
     * @return the string of the card in the format of "card number of card suit"
     *          with its unicode symbol
     */
    @Override
    public String toString(){
        String value = String.format("%02d",getName());
        return "(\u2666" + value + ") "
                + convertName(getName()) + " of " + this.getSuit();
    }
}
