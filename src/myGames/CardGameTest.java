package myGames;

import myCards.Card;
import myGames.CardGame;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CardGameTest {
    CardGame game1;
    CardGame game2;

    @Before
    public void setUp() throws Exception {
        game1 = new CardGame();
        game2 = new CardGame();
    }

    @Test
    public void getPlayer() {
        assertEquals(game1.player, game1.getPlayer());
        assertEquals(game2.player, game2.getPlayer());
    }

    @Test
    public void getDealer() {
        assertEquals(game1.dealer, game1.getDealer());
        assertEquals(game2.dealer, game2.getDealer());
    }

    @Test
    public void getDealerCards() {
        ArrayList<Card> game1Dealer = new ArrayList<Card>(2);
        Card card1 = game1.getDealer().getDeck().getCards().get(0);
        Card card2 = game1.getDealer().getDeck().getCards().get(1);
        game1Dealer.add(card1);
        game1Dealer.add(card2);
        assertEquals(game1Dealer, game1.getDealerCards());

        ArrayList<Card> game2Dealer = new ArrayList<Card>(2);
        Card card3 = game2.getDealer().getDeck().getCards().get(0);
        Card card4 = game2.getDealer().getDeck().getCards().get(1);
        game2Dealer.add(card3);
        game2Dealer.add(card4);
        assertEquals(game2Dealer, game2.getDealerCards());
    }

    @Test
    public void getPlayerCards() {
        ArrayList<Card> game1Player = new ArrayList<Card>(2);
        Card card1 = game1.getPlayer().getDeck().getCards().get(0);
        Card card2 = game1.getPlayer().getDeck().getCards().get(1);
        game1Player.add(card1);
        game1Player.add(card2);
        assertEquals(game1Player, game1.getPlayerCards());

        ArrayList<Card> game2Player = new ArrayList<Card>(2);
        Card card3 = game2.getPlayer().getDeck().getCards().get(0);
        Card card4 = game2.getPlayer().getDeck().getCards().get(1);
        game2Player.add(card3);
        game2Player.add(card4);
        assertEquals(game2Player, game2.getPlayerCards());
    }

    @Test
    public void isDealerOver() {
        assertEquals(!game1.dealer.getStatus(), game1.isDealerOver());
        assertEquals(!game2.dealer.getStatus(), game2.isDealerOver());
    }

    @Test
    public void isPlayerOver() {
        assertEquals(!game1.player.getStatus(), game1.isPlayerOver());
        assertEquals(!game2.player.getStatus(), game2.isPlayerOver());
    }

}