package myCards.fourSuits;

import myCards.Card;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpadesTest {
    Spades spade1;
    Spades spade2;
    Spades spade3;

    @Before
    public void setUp() {
        spade1 = new Spades(1);
        spade2 = new Spades(10);
        spade3 = new Spades(12);
    }

    @Test
    public void testToString() {
        assertEquals("(♠01) Ace of Spade",spade1.toString());
        assertEquals("(♠10) 10 of Spade",spade2.toString());
        assertEquals("(♠12) Queen of Spade",spade3.toString());
    }

}

