package myCards.fourSuits;
import myCards.*;

/**
 * This class represent a Clubs Card class
 */
public class Clubs extends Card{

// ==================== constructor ====================

    /**
     * Construct a card object using super method,
     * and set suit to Club
     */
    public Clubs(int name){
        super(name);
        this.setSuit(Suit.Club);
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
        return "(\u2663" + value + ") "
                + convertName(getName()) + " of " + this.getSuit();
    }

}
