package myGames;

import myCards.*;
import myDecks.*;

/**
 * This class represents a Person class
 * which has deck of cards, points, name and status
 */
public abstract class Person {
    Deck deck;
    private boolean status = true;
    private int points = 0;
    private String who = "Default Player";

    // ==================== constructor ====================

    /**
     * Construct a Player object with a given name
     * and an initialized deck of cards.
     */
    public Person(String name){
        this.who = name;
        this.deck = new Deck(2);
    }

    // ==================== getter and setters ====================

    /**
     * Get the game status of a person
     * @return boolean value of status
     */
    public boolean getStatus(){
        return status;
    }


    /**
     * Get the points one person get
     * @return a integer represent the points
     */
    public int getPoints(){
        return points;
    }


    /**
     * Get the Deck one person has
     * @return a Deck object represent the deck
     */
    public Deck getDeck(){
        return deck;
    }


    /**
     * Get the name of one person
     * @return a String object represent the name
     */
    public String getWho() {
        return who;
    }


    /**
     * set the game status of one person
     */
    public void setStatus(boolean b){
        status = b;
    }


    /**
     * set the game points of one person get
     */
    public void setPoints(int p){
        points = p;
    }


    /**
     * set the name of one person
     */
    public void setName(String n){
        who = n;
    }

    // ========================== methods ==========================

    public int displayPoints() {
        return getPoints();
    }

    /**
     * calculate and update the latest points of one person
     */
    public void updatePoints(){
        setPoints(deck.calculatePoints());
        if (getPoints() > 21) {
            setStatus(false);
        }
    }


    /**
     * check if a person bust
     * @return a true value if a person bust, otherwise false.
     */
    public boolean isBust() {
        return getPoints() > 21;
    }


    /**
     * Create the "hit" action
     * add one card to a person
     */
    public void hit(Card c){
        deck.addWith(c);
        updatePoints();
        if (isBust()) {
            stand();
        }
    }


    /**
     * Create the "stand" action
     * stop adding cards
     */
    public void stand(){
        setStatus(false);
    }


    /**
     * check if a person has BlackJack
     * @return a true value if a person has, otherwise false.
     */
    public boolean hasBlackJack(){
        return deck.getCards().get(0).getName() == 1
                && deck.getCards().get(1).getName() > 9;
    }


    /**
     * Display all cards one person has
     * @return a String object represents all cards of one person
     */
    public String displayCards (){
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < getDeck().getCards().size(); i++) {
            out.append(getDeck().getCards().get(i).toString());
            out.append("\n");
        }
        return out.toString();
    }
}
