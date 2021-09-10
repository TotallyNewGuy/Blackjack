package myCards;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    Card card1;
    Card card2;
    Card card3;
    Card card4;
    Card card5;
    Card card6;
    Card card7;
    Card card0;
    Card card00;

    @Before
    public void setUp() {
        card1 = new Card(1);
        card2 = new Card(12);
        card3 = new Card(10, Suit.Heart);
        card4 = new Card(card1);
        card5 = new Card(11,Suit.Club);
        card6 = new Card(13,Suit.Diamond);
        card7 = new Card(card5);
        card0 = new Card(0,Suit.Spade);
        card00 = new Card(15,Suit.Spade);

    }

    @Test
    public void testGetName() {
        assertEquals(1,card1.getName());
        assertEquals(12,card2.getName());
        assertEquals(11,card5.getName());

    }

    @Test
    public void testGetSuit() {
        assertEquals(Suit.Club,card5.getSuit());
        assertEquals(Suit.Diamond,card6.getSuit());
        assertEquals(Suit.Heart,card3.getSuit());
    }

    @Test
    public void testSetName() {
        card3.setCardName(1);
        card5.setCardName(13);
        card6.setCardName(10);
        assertEquals(1, card3.getName());
        assertEquals(13,card5.getName());
        assertEquals(10,card6.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalSetCardName() {
        card1.setCardName(-1);
        card2.setCardName(15);
    }

    @Test
    public void testSetSuit() {
        card1.setSuit(Suit.Heart);
        card2.setSuit(Suit.Diamond);
        card5.setSuit(Suit.Spade);
        assertEquals(card1.getSuit(),Suit.Heart);
        assertEquals(card2.getSuit(),Suit.Diamond);
        assertEquals(card5.getSuit(),Suit.Spade);
    }


    @Test
    public void testConvertName() {
        card3.convertName(11);
        card6.convertName(13);
        assertEquals("Queen",card2.convertName(12));
        assertEquals("Jack",card2.convertName(11));
        assertEquals("King",card2.convertName(13));
    }

    @Test
    public void testCompareTo() {
        Card card66 = new Card(13,Suit.Diamond);
        assertEquals(0,card6.compareTo(card6));
        assertEquals(0,card1.compareTo(card4));
        assertNotEquals(0,card6.compareTo(card2));
        assertNotEquals(0,card6.compareTo(card3));
    }

    @Test
    public void testToString() {
        assertEquals("10 of Heart",card3.toString());
        assertEquals("Jack of Club",card5.toString());
        assertEquals("King of Diamond",card6.toString());
    }
}

