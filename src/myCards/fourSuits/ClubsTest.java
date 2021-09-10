package myCards.fourSuits;

import myCards.Card;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClubsTest {
    Clubs club1;
    Clubs club2;
    Clubs club3;

    @Before
    public void setUp() {
        club1 = new Clubs(1);
        club2 = new Clubs(10);
        club3 = new Clubs(12);
    }

    @Test
    public void testToString() {
        assertEquals("(♣01) Ace of Club",club1.toString());
        assertEquals("(♣10) 10 of Club",club2.toString());
        assertEquals("(♣12) Queen of Club",club3.toString());
    }

}
