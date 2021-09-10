package myCards.fourSuits;
import myCards.*;

/**
 * This class represent a Hearts Card class
 */
public class Hearts extends Card {

// ==================== constructor ====================

    /**
     * Construct a card object using super method,
     * and set suit to Hearts
     */
    public Hearts(int name){
        // regular constructor
        super(name);
        this.setSuit(Suit.Heart);
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
        return "(\u2665" + value + ") "
                + convertName(getName()) + " of " + this.getSuit();
    }
}
