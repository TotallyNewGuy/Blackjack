package myDecks;

import myCards.Card;
import myCards.fourSuits.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class DeckTest {
    Deck deck1;
    Deck deck2;
    Deck deck3;
    Deck deck4;
    Deck deck5;
    Hearts card1;
    Spades card2;
    Diamonds card3;
    Diamonds card4;
    Clubs card5;
    Card card123;


    @Before
    public void setUp() {
        card1 = new Hearts(1);
        card2 = new Spades(10);
        card3 = new Diamonds(12);
        card4 = new Diamonds(1);
        card5 = new Clubs(5);
        card123 = null;

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);

        deck1 = new Deck();
        deck2 = new Deck(10);
        deck3 = new Deck(20);
        deck4 = new Deck(cards);
        deck5 = new Deck(deck4);
    }


    @Test
    public void testGetCards() {
        assertEquals("[(♠01) Ace of Spade, (♠02) 2 of Spade, (♠03) 3 of Spade, (♠04) 4 of Spade, (♠05) 5 of Spade, (♠06) 6 of Spade, (♠07) 7 of Spade, (♠08) 8 of Spade, (♠09) 9 of Spade, (♠10) 10 of Spade, (♠11) Jack of Spade, (♠12) Queen of Spade, (♠13) King of Spade, (♥01) Ace of Heart, (♥02) 2 of Heart, (♥03) 3 of Heart, (♥04) 4 of Heart, (♥05) 5 of Heart, (♥06) 6 of Heart, (♥07) 7 of Heart, (♥08) 8 of Heart, (♥09) 9 of Heart, (♥10) 10 of Heart, (♥11) Jack of Heart, (♥12) Queen of Heart, (♥13) King of Heart, (♣01) Ace of Club, (♣02) 2 of Club, (♣03) 3 of Club, (♣04) 4 of Club, (♣05) 5 of Club, (♣06) 6 of Club, (♣07) 7 of Club, (♣08) 8 of Club, (♣09) 9 of Club, (♣10) 10 of Club, (♣11) Jack of Club, (♣12) Queen of Club, (♣13) King of Club, (♦01) Ace of Diamond, (♦02) 2 of Diamond, (♦03) 3 of Diamond, (♦04) 4 of Diamond, (♦05) 5 of Diamond, (♦06) 6 of Diamond, (♦07) 7 of Diamond, (♦08) 8 of Diamond, (♦09) 9 of Diamond, (♦10) 10 of Diamond, (♦11) Jack of Diamond, (♦12) Queen of Diamond, (♦13) King of Diamond]",deck1.getCards().toString());
        assertEquals("[(♥01) Ace of Heart, (♠10) 10 of Spade, (♦12) Queen of Diamond]",deck4.getCards().toString());
        assertEquals("[]",deck3.getCards().toString());
    }


    @Test
    public void testSetCards() {

        ArrayList<Card> updatedCards = new ArrayList<Card>();
        updatedCards.add(card4);
        updatedCards.add(card5);
        updatedCards.add(card1);
        deck4.setCards(updatedCards);
        assertEquals("[(♦01) Ace of Diamond, (♣05) 5 of Club, (♥01) Ace of Heart]",deck4.getCards().toString());
    }


    @Test
    public void testShuffle() {
        String string1 = deck4.getCards().toString();
        deck4.shuffle();
        String string2 = deck4.getCards().toString();
        String string3 = deck1.getCards().toString();
        deck1.shuffle();
        String string4 = deck1.getCards().toString();

        assertNotEquals(string1, string2);
        assertNotEquals(string3, string4);
    }


    @Test
    public void testAddWith() {
        deck5.addWith(card4);
        deck5.addWith(card5);
        assertEquals("[(♥01) Ace of Heart, (♠10) 10 of Spade, (♦12) Queen of Diamond, (♦01) Ace of Diamond, (♣05) 5 of Club]",deck5.getCards().toString());
        deck2.addWith(card4);
        deck2.addWith(card5);
        assertEquals("[(♦01) Ace of Diamond, (♣05) 5 of Club]",deck2.getCards().toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalAddwith() {
        deck5.addWith(card123);
        deck5.addWith(null);
    }

    @Test
    public void testRemoveTopOne() {
        deck4.removeTopOne();
        assertEquals("[(♠10) 10 of Spade, (♦12) Queen of Diamond]",deck4.getCards().toString());
        deck4.removeTopOne();
        assertEquals("[(♦12) Queen of Diamond]",deck4.getCards().toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalRemoveTopOne() {
        deck2.removeTopOne();
        deck3.removeTopOne();
    }

    @Test
    public void testSortAll() {
        deck4.sortAll();
        assertEquals("[(♥01) Ace of Heart, (♠10) 10 of Spade, (♦12) Queen of Diamond]",deck4.getCards().toString());
        deck4.addWith(card4);
        deck4.addWith(card5);
        deck4.sortAll();
        assertEquals("[(♥01) Ace of Heart, (♦01) Ace of Diamond, (♣05) 5 of Club, (♠10) 10 of Spade, (♦12) Queen of Diamond]",deck4.getCards().toString());
    }

    @Test
    public void testCalculatePoints() {
        assertEquals(340,deck1.calculatePoints());
        assertEquals(0,deck2.calculatePoints());
        assertEquals(21,deck4.calculatePoints());
        assertEquals(21,deck5.calculatePoints());
    }


}
