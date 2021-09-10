package myCards.fourSuits;

import myCards.Card;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeartsTest {
    Hearts heart1;
    Hearts heart2;
    Hearts heart3;

    @Before
    public void setUp() {
        heart1 = new Hearts(1);
        heart2 = new Hearts(10);
        heart3 = new Hearts(12);
    }

    @Test
    public void testToString() {
        assertEquals("(♥01) Ace of Heart",heart1.toString());
        assertEquals("(♥10) 10 of Heart",heart2.toString());
        assertEquals("(♥12) Queen of Heart",heart3.toString());
    }

}

