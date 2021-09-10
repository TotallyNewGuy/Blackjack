package myGames;

import java.util.Scanner;

public class Main {
    public static Scanner keyboard;

    /**
     * print points one person get in game
     * @param p a Person object represent a person in game
     */
    public static void printPoints(Person p) {
        String who = p.getWho();
        int points = p.displayPoints();
        if (p instanceof Player){
            System.out.println(who + " has " + points + " points.");
        }
        else {
            if (p.getStatus()) {
                System.out.println(who + " at least has " + points + " points.");
            }
            else {
                System.out.println(who + " has " + points + " points.");
            }
        }
    }


    /**
     * print all cards one person has in game
     * @param p a Person object represent a person in game
     */
    public static void printCard(Person p) {
        System.out.println("==============================");
        System.out.println(p.displayCards());
    }


    /**
     * print points and cards of one person has in game
     * @param g a CardGame object represent a BlackJack game
     */
    public static void printInfo(CardGame g) {
        System.out.println();
        printPoints(g.dealer);
        printCard(g.dealer);
        printPoints(g.player);
        printCard(g.player);
    }

    public static void main(String[] args) {

        // loop A: check whether player round is over
        // if not, choose hit or stand
        // if choose hit
        // send a card to player
        // update points
        // check whether player round is over -> loop A

        // |
        // V

        // loop B: check whether dealer round is over
        // if not, make dealer hit
        // send a card to dealer
        // update points
        // check whether player round is over -> loop B

        // |
        // V

        // get winner
        // print some info

        // ======================= game start =======================

        CardGame game = new CardGame();
        printInfo(game);

        // ========================= loop A =========================

        while (!game.isPlayerOver()) {
            keyboard = new Scanner(System.in);
            System.out.println("1 -> hit; 2 -> stand:");
            int a = keyboard.nextInt();
            if (a == 1) {
                game.getPlayer().hit(game.getPublicDeck().removeTopOne());
            }
            else {
                game.getPlayer().stand();
            }
            printInfo(game);
        }

        // ========================= loop B =========================

        if (game.getDealer().getPoints() > 17) {
            game.getDealer().stand();
        }
        while (!game.isDealerOver() && !game.getPlayer().isBust()) {
            game.getDealer().hit(game.getPublicDeck().removeTopOne());
        }
        game.getDealer().stand();

        // ======================= get winner =======================

        System.out.println("\n        ************");
        System.out.println("        Final result");
        System.out.println("        ************");
        printInfo(game);

        Person winner = game.getWinner();
        if (winner == null) {
            System.out.println("The game is a draw.");
        }
        else {
            System.out.println("Our winner is: " + winner.getWho());
            System.out.println("=====================");
            System.out.println("Cards are:");
            winner.getDeck().printAll();
        }
    }
}
