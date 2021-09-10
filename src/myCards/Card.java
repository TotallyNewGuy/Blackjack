package myCards;

/**
 * This class represent a Card class
 * which has a suit and a name(face value) in the blackjack game.
 */
public class Card implements Comparable<Card>{
    private Suit suit = null;
    private int name;

    // ==================== constructor ====================

    /**
     * Construct a card object
     */
    public Card(){
        // default constructor
    }


    /**
     * Construct a card object using the card name
     * @param name the name of the card
     */
    public Card(int name){
        this.name = name;
    }

    /**
     * Construct a card object using the card name and suit
     * @param name the name of the card
     * @param suit the suit of the card
     */
    public Card(int name, Suit suit) {
        this.name = name;
        this.suit = suit;
    }

    /**
     * Construct a copy method which copies another card
     * @param other the other card to be copied from
     */
    public Card(Card other){
        // copy constructor
        this.suit = other.getSuit();
        this.name = other.getName();
    }

    // ==================== getter and setters ====================

    /**
     * Get the name of the card
     * @return the name of the card
     */
    public int getName() {
        return name;
    }

    /**
     * Set the name of the card
     * @param name the name of the card
     */

    public void setCardName(int name) {
        if (name < 1 || name > 13) {
            throw new IllegalArgumentException("name invalid!");
        }
        this.name = name;
    }


    /**
     * Get the suit of the card
     * @return the suit of the card
     */
    public Suit getSuit() {
        return suit;
    }


    /**
     * Set the suit of the card
     * @param suit the suit of the card
     */
    public void setSuit(Suit suit){
        this.suit = suit;
    }

    // ========================== methods ==========================

    /**
     * Compare two cards and see if they are equal or not
     * @param otherCard the other card to be compared with
     * @return 0 if equal, otherwise the two cards are not equal
     */
    public int compareTo(Card otherCard){
        return this.name - otherCard.name;
    }


    /**
     * convert face value to normal name
     * @return the string of the card face value
     */
    // convert 11 - 13 to string
    public String convertName(int number){
        if (number == 11) {
            return "Jack";
        }
        else if (number == 12) {
            return "Queen";
        }
        else if (number == 13) {
            return "King";
        }
        else if (number == 1) {
            return "Ace";
        }
        else {
            return String.valueOf(getName());
        }
    }


    /**
     * generate a string for printing based on the card name
     * @return the string of the card in the format of "card number of card suit"
     */
    public String toString(){
        return convertName(getName()) + " of " + this.getSuit();
    }


}
