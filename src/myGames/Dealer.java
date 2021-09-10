package myGames;

import myCards.Card;
import myDecks.Deck;
import java.util.ArrayList;

/**
 * This class represents a Dealer class extends from Person
 */
public class Dealer extends Person{

    // ==================== constructor ====================

    /**
     * Construct a Dealer object with default name
     */
    public Dealer(){
        super("Dealer");
    }

    // ====================== methods ======================

    /**
     * Modify hit method to fit hit rule of dealer
     * Create the "hit" action
     * add one card to a person
     */
    @Override
    public void hit(Card c){
        getDeck().addWith(c);
        updatePoints();
    }


    /**
     * Modify updatePoints method to fit hit rule of dealer
     * calculate and update the latest points of one person
     */
    @Override
    public void updatePoints(){
        setPoints(deck.calculatePoints());
        if (getPoints() >= 17) {
            stand();
        }
    }


    /**
     * Modify getPoints method to make sure calculate points of dealer correctly
     * @return a String object represents all cards of one person
     */
    @Override
    public int displayPoints() {
        if (getStatus()) {
            ArrayList<Card> temp1 = new ArrayList<>(getDeck().getCards().subList(1, getDeck().getCards().size()));
            Deck temp2 = new Deck(temp1);
            return temp2.calculatePoints();
        }
        else {
            return getPoints();
        }
    }


    /**
     * Modify displayCards method to simulate a hiding card of dealer
     * @return a String object represent all cards
     */
    @Override
    public String displayCards (){
        if (getStatus()) {
            StringBuilder out = new StringBuilder("(***) Hiding card\n");
            for (int i = 1; i < getDeck().getCards().size(); i++) {
                out.append(getDeck().getCards().get(i).toString());
                out.append("\n");
            }
            return out.toString();
        }
        else {
            return super.displayCards();
        }
    }
}
