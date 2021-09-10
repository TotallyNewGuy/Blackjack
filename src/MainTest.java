import myDecks.Deck;
import myDecks.Hand;

public class MainTest {
    public static void main(String[] args){
        // 创建52张牌的牌堆并洗牌
        // Create a deck of 52 cards, shuffle
        Deck oneDeck = new Deck();
        System.out.println("Create cards test:\n");
        oneDeck.printAll();
        System.out.println("\nshuffle cards test:\n");
        oneDeck.shuffle();
        oneDeck.printAll();

        // 创建两个容量为5的牌堆
        // Create two hands of 5 cards
        Hand firstHand = new Hand(5);
        Hand secondHand = new Hand(5);

        // 从牌堆里一张一张给两个牌堆发牌
        // Deal cards to two stacks, assign one card each time in turns
        // between the first and the second hands
        for (int i = 0; i < 5; i++) {
            firstHand.addWith(oneDeck.removeTopOne());
            secondHand.addWith(oneDeck.removeTopOne());
        }

        // 测试原牌库牌数
        // Check the deck after removing 10 cards
        System.out.printf("\nAfter removing 10 cards, " +
                "original deck has %d cards.\n", oneDeck.getCards().size());

        System.out.println("\nThe rest 42 cards:");
        System.out.println();
        oneDeck.printAll();
        System.out.println("\nThe rest 42 cards after sort:");
        System.out.println();
        oneDeck.sortAll();
        oneDeck.printAll();

        // 测试排序
        // Test sort method
        System.out.println("\nFive cards sort tests:");
        System.out.println("First hand:");
        System.out.println("Before sort:");
        System.out.println();
        firstHand.printAll();
        firstHand.sortAll();
        System.out.println("\nAfter sort:");
        System.out.println();
        firstHand.printAll();

        System.out.println("\nSecond hand:");
        System.out.println("Before sort:");
        System.out.println();
        secondHand.printAll();
        secondHand.sortAll();
        System.out.println("\nAfter sort:");
        System.out.println();
        secondHand.printAll();

        // 把10张手牌全部放回牌堆
        // Put 10 cards back to the deck
        for (int i = 0; i < 5; i++) {
            oneDeck.addWith(firstHand.removeTopOne());
        }
        for (int i = 0; i < 5; i++) {
            oneDeck.addWith(secondHand.removeTopOne());
        }

        // 测试原牌库牌数
        // Check the deck after adding 10 cards
        System.out.printf("\nAfter adding 10 cards, " +
                "original deck has %d cards.", oneDeck.getCards().size());

        System.out.println("\nThe deck after 10 cards were added:");
        System.out.println();
        oneDeck.printAll();
        System.out.println("\nThe deck after sort:");
        System.out.println();
        oneDeck.sortAll();
        oneDeck.printAll();

    }
}
