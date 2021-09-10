package myGames;

import org.junit.Before;
import org.junit.Test;
import myDecks.*;
import myCards.*;
import myCards.fourSuits.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class DealerTest {
    Dealer Dealer1;
    Dealer Dealer2;
    Dealer Dealer3;
    Hearts card1;
    Spades card2;
    Diamonds card3;
    Diamonds card4;
    Clubs card5;
    Clubs card6;

    @Before
    public void setUp() throws Exception {
        card1 = new Hearts(2);
        card2 = new Spades(3);
        card3 = new Diamonds(12);
        card4 = new Diamonds(4);
        card5 = new Clubs(10);
        card6 = new Clubs(12);


        Dealer1 = new Dealer();
        ArrayList<Card> cards1 = new ArrayList<Card>();
        cards1.add(card1);
        cards1.add(card2);
        Dealer1.deck = new Deck(cards1);

        Dealer2 = new Dealer();
        ArrayList<Card> cards2 = new ArrayList<Card>();
        cards2.add(card3);
        cards2.add(card4);
        Dealer2.deck = new Deck(cards2);

        Dealer3 = new Dealer();
        ArrayList<Card> cards3 = new ArrayList<Card>();
        cards3.add(card5);
        cards3.add(card6);
        Dealer3.deck = new Deck(cards3);
    }

    @Test
    public void displayCards() {
        String dealer1Str = "(***) Hiding card\n(♠03) 3 of Spade\n";
        String dealer2Str = "(***) Hiding card\n(♦04) 4 of Diamond\n";
        String dealer3Str = "(***) Hiding card\n(♣12) Queen of Club\n";
        assertEquals(dealer1Str, Dealer1.displayCards());
        assertEquals(dealer2Str, Dealer2.displayCards());
        assertEquals(dealer3Str, Dealer3.displayCards());
    }

    @Test
    public void hit() {
        // succeed to add card
        Dealer1.hit(card6);
        String dealer1Str = "(***) Hiding card\n(♠03) 3 of Spade\n(♣12) Queen of Club\n";
        assertEquals(dealer1Str, Dealer1.displayCards());
        // fail to add card
        Dealer2.hit(card3);
        String dealer2Str = "(♦12) Queen of Diamond\n(♦04) 4 of Diamond\n(♦12) Queen of Diamond\n";
        assertEquals(dealer2Str, Dealer2.displayCards());
        Dealer3.hit(card4);
        String dealer3Str = "(♣10) 10 of Club\n(♣12) Queen of Club\n(♦04) 4 of Diamond\n";
        assertEquals(dealer3Str, Dealer3.displayCards());
    }

    @Test
    public void updatePoints() {
        Dealer1.hit(card4);
        Dealer1.updatePoints();
        assertEquals(9, Dealer1.getPoints());
        Dealer1.setStatus(true);
        Dealer1.hit(card5);
        assertEquals(19, Dealer1.getPoints());
    }

    @Test
    public void getPoints() {
        assertEquals(0, Dealer1.getPoints());
        assertEquals(0, Dealer2.getPoints());
        assertEquals(0, Dealer3.getPoints());
    }
}