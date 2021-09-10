package myDecks;

import java.util.Collections;
import java.util.Random;
import java.util.ArrayList;
import myCards.*;
import myCards.fourSuits.*;

/**
 * This class represent a Deck class
 * which has an array list of cards, a player and a dealer
 */
public class Deck implements Common<Card>{
    private final static int SIZE = 52;
    private ArrayList<Card> cards;

    // ======================= constructor =======================

    /**
     * Construct a deck object
     */
    public Deck(){
        cards = new ArrayList<Card>(52);
        setUp();
    }


    /**
     * Construct a deck object with a specific number
     */
    public Deck(int number){
        cards = new ArrayList<Card>(number);
    }


    /**
     * Construct a deck object with an array of cards
     */
    public Deck(ArrayList<Card> cards){
        this.cards = cards;
    }


    /**
     * Construct a copy constructor which copies another deck
     * @param other the other deck to be copied from
     */
    public Deck(Deck other){
        // copy constructor
        cards = other.cards;
    }

    // ==================== getter and setters ====================

    /**
     * Return the array of cards
     */
    public ArrayList<Card> getCards(){
        return cards;
    }


    /**
     * Set a deck a new cards array
     */
    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    // ========================= methods =========================

    /**
     * Simulate the initial a deck - create 52 cards in order
     */
    @Override
    public void setUp() {
        for (int i = 0; i < SIZE / 13; i++) {
            for (int j = 0; j < SIZE / 4; j++) {
                if (i == 0) {
                    cards.add(new Spades(j + 1));
                }
                else if (i == 1) {
                    cards.add(new Hearts(j + 1));
                }
                else if (i == 2) {
                    cards.add(new Clubs(j + 1));
                }
                else {
                    cards.add(new Diamonds(j + 1));
                }
            }
        }
    }


    /**
     * Print all cards of one deck
     */
    @Override
    public void printAll() {
        for (int i = 0; i < this.getCards().size(); i++) {
            System.out.printf("#%d: %s\n", i + 1, this.getCards().get(i).toString());
        }
    }

    /**
     * Get a random number within a certain range of numbers
     * @param min the min number of the range
     * @param max the max number of the range
     * @return a random number within the min-max range
     */
    private int getRandomNum(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min) + min;
    }

    /**
     * Shuffle the array of cards
     */
    @Override
    public void shuffle() {
        for (int i = 0; i < cards.size(); i++) {
            int randIndex = getRandomNum(i, cards.size());
            Card temp = cards.get(randIndex);
            Card curr = cards.get(i);
            cards.set(i, temp);
            cards.set(randIndex, curr);
        }
    }


    /**
     * add a card to the current array of cards
     * @throws IllegalArgumentException when the card is invalid (if it is equal to null)
     * @param oneCard the card to be added to the array of cards
     */
    @Override
    public void addWith(Card oneCard) {
        if (oneCard == null) {
            throw new IllegalArgumentException("Invalid card.");
        }
        getCards().add(oneCard);
    }


    /**
     * Remove the top card in the current array of cards
     * @throws IllegalArgumentException if the array has no cards
     * @return the card to be removed from the array of cards
     */
    @Override
    public Card removeTopOne() {
        if (cards.size() <= 0) {
            throw new IllegalArgumentException("Not enough card to deal.");
        }
        Card topCard = cards.get(0);
        cards.remove(0);
        return topCard;
    }


    /**
     * Sort all cards in the current array based on the rank of cards
     * When the rank of several cards is the same, suit sequence: Spades, Hearts, Club, Diamonds
     */
    @Override
    public void sortAll() {
        // according different card values to sort
        getCards().sort(Card::compareTo);
    }


    /**
     * calculate the accumulated points of one deck
     */
    public int calculatePoints () {
        int sum = 0, numOfAce = 0, cardValue;

        for (int i = 0; i < getCards().size(); i++) {
            cardValue = getCards().get(i).getName();
            // if face value is bigger than 10, it counts 10
            if (cardValue > 9) {
                sum += 10;
            }
            // if face value is other number, just add them as normal
            else if (cardValue != 1) {
                sum += cardValue;
            }
            // if face value is 1, it need to considerate carefully
            else {
                numOfAce += 1;
            }
        }

        while (numOfAce > 0) {
            if (sum + 11 > 21) {
                sum += 1;
            } else {
                sum += 11;
            }
            numOfAce--;
        }

        return sum;
    }
}
