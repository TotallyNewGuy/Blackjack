package myCards.fourSuits;

import myCards.Card;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiamondsTest {
    Diamonds diamond1;
    Diamonds diamond2;
    Diamonds diamond3;

    @Before
    public void setUp() {
        diamond1 = new Diamonds(1);
        diamond2 = new Diamonds(10);
        diamond3 = new Diamonds(12);
    }

    @Test
    public void testToString() {
        assertEquals("(♦01) Ace of Diamond",diamond1.toString());
        assertEquals("(♦10) 10 of Diamond",diamond2.toString());
        assertEquals("(♦12) Queen of Diamond",diamond3.toString());
    }

}

