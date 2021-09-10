package myGUI;

import myCards.Card;
import myGames.CardGame;
import myGames.Person;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;

public class GameWindow extends JFrame implements ActionListener{

    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;

    public JLabel status;
    public JLabel dealerInfo;
    public JLabel playerInfo;

    public JPanel game = new JPanel();
    public JPanel dealerPanel = new JPanel();
    public JPanel playerPanel = new JPanel();
    public JPanel dealer = new JPanel();
    public JPanel player = new JPanel();
    public JPanel choice = new JPanel();

    public JButton hitButton;
    public JButton standButton;
    public Font medium = new Font("Helvetica", Font.ITALIC,16);
    public Font big = new Font("Helvetica", Font.BOLD,18);

    public Hashtable<String,JLabel> labelTable = new Hashtable<>(52);
    public CardGame model = new CardGame();
    public String userName = "Player";

    public GameWindow(String userName){
        super("Black Jack");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.LIGHT_GRAY);
        setLayout(new BorderLayout());

        Toolkit tl = Toolkit.getDefaultToolkit(); // get toolkit
        Dimension screeSize = tl.getScreenSize(); // get screen size
        Dimension frameSize = this.getSize(); // get windows size
        int x = (int)(screeSize.getWidth() - frameSize.getWidth()) / 2; // confirm windows position
        int y = (int)(screeSize.getHeight() - frameSize.getHeight()) / 2;
        setLocation(x,y);

        this.userName = userName;
        model.getPlayer().setName(userName);

        // Group info
        status = new JLabel("Group 16. Di Yang, Haonan Sun, Pei Zhuang, Zhihao Lyu");
        status.setFont(medium);
        add(status, BorderLayout.NORTH);

        // set labels hash table
        setLabelIcon("Spade", labelTable);
        setLabelIcon("Heart", labelTable);
        setLabelIcon("Club", labelTable);
        setLabelIcon("Diamond", labelTable);

        // create panel to store cards label
        dealerPanel.setLayout(new FlowLayout());
        playerPanel.setLayout(new FlowLayout());

        // add dealer first two cards into panel(including hiding card)
        JLabel cardBack = new JLabel("Hiding card");
        cardBack.setHorizontalTextPosition(JLabel.CENTER);
        cardBack.setVerticalTextPosition(JLabel.BOTTOM);
        cardBack.setIcon(scaleIcon(new ImageIcon("cardBackRed.png")));
        dealerPanel.add(cardBack);

        String secondCardName = Integer.toString(model.getDealerCards().get(1).getName());
        String secondCardSuit = model.getDealerCards().get(1).getSuit().toString();
        JLabel cur = labelTable.get(secondCardSuit + secondCardName);
        dealerPanel.add(cur);

        // add player first two cards into panel
        addCardLabel(model.getPlayerCards(), playerPanel);

        // add player and dealer cards and information into panels
        dealer.setLayout(new BorderLayout());
        dealerInfo = new JLabel("Dealer's points(at least): "
                                    + model.getDealer().displayPoints(), JLabel.CENTER);
        dealerInfo.setFont(big);
        dealer.add(dealerPanel, BorderLayout.CENTER);
        dealer.add(dealerInfo, BorderLayout.NORTH);

        player.setLayout(new BorderLayout());
        playerInfo = new JLabel(userName + "'s points: "
                                + model.getPlayer().getPoints(), JLabel.CENTER);
        playerInfo.setFont(big);
        player.add(playerPanel, BorderLayout.CENTER);
        player.add(playerInfo, BorderLayout.NORTH);

        // create a new panel to store dealer and player two panels
        game.setLayout(new GridLayout(2,1));
        game.add(dealer);
        game.add(player);
        add(game, BorderLayout.CENTER);

        // add hit and stand buttons into panel and layout
        hitButton = new JButton("Hit");
        standButton = new JButton("Stand");
        hitButton.addActionListener(this);
        standButton.addActionListener(this);
        choice.add(hitButton);
        choice.add(standButton);
        add(choice, BorderLayout.SOUTH);

    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (model.isDealerOver() && model.isPlayerOver()) {
            return;
        }

        JButton button = (JButton) e.getSource();

        if (hitButton.equals(button)) {
            model.getPlayer().hit(model.getPublicDeck().removeTopOne());
            addCardLabel(model.getPlayerCards(), playerPanel);
            // update player points
            playerInfo.setText(userName + "'s points: " + model.getPlayer().displayPoints());
            // update player cards
            playerPanel.revalidate();
            // update player all information
            player.revalidate();
            if (model.getPlayer().isBust()) {
                model.getDealer().stand();
                hitButton.setEnabled(false);
                standButton.setEnabled(false);
            }
        }
        else {
            model.getPlayer().stand();
            hitButton.setEnabled(false);
            standButton.setEnabled(false);
            if (model.getDealer().getPoints() >= 17) {
                model.getDealer().stand();
            }
            while (!model.isDealerOver()){
                model.getDealer().hit(model.getPublicDeck().removeTopOne());
            }
        }

        if (model.isDealerOver() && model.isPlayerOver()) {
            // update dealer points
            dealerInfo.setText("Dealer's points: " + model.getDealer().getPoints());
            // update dealer cards(withdraw the hiding card)，delete the first card
            // and find the real card in hashtable and put it into panel
            dealerPanel.remove(0);
            String firstCardName = Integer.toString(model.getDealerCards().get(1).getName());
            String firstCardSuit = model.getDealerCards().get(1).getSuit().toString();
            dealerPanel.add(labelTable.get(firstCardSuit + firstCardName), 0);
            addCardLabel(model.getDealerCards(), dealerPanel);
            dealerPanel.revalidate();
            // update dealer all information
            dealer.revalidate();

            Person winner = model.getWinner();
            String result;
            if (winner == null) {
                result = "The game is a draw.";
            }
            else if (winner == model.getPlayer()) {
                result = "Congratulation! You win!";
            }
            else {
                result = "Sorry, you lose... Try again?";
            }

            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            ResultWindow infoWindow = new ResultWindow(this);
            infoWindow.getInfo().setText(result);
            infoWindow.getInfo().setFont(big);
            infoWindow.setVisible(true);

        }
    }

    public ImageIcon scaleIcon(ImageIcon i) {
        Image img = i.getImage();
        Image imgScaled = img.getScaledInstance(115, 176, 4);
        return new ImageIcon(imgScaled);
    }

    public void setLabelIcon(String suit, Hashtable<String, JLabel> table) {
        ArrayList<ImageIcon> temp = new ArrayList<>(13);
        for (int i = 0; i < 13; i++) {
            ImageIcon tempIcon = new ImageIcon(suit + "Image/" + (i + 1) + ".png");
            temp.add(scaleIcon(tempIcon));
        }
        for (int i = 0; i < 13; i++) {
            String name;
            switch (i + 1) {
                case 1 ->  name = "Ace";
                case 11 ->  name = "Jack";
                case 12 ->  name = "Queen";
                case 13 ->  name = "King";
                default ->  name = Integer.toString(i + 1);
            }
            JLabel poker = new JLabel(suit + " " + name);
            poker.setIcon(temp.get(i));
            poker.setHorizontalTextPosition(JLabel.CENTER);
            poker.setVerticalTextPosition(JLabel.BOTTOM);
            table.put(suit + (i + 1), poker);
        }
    }

    public void addCardLabel(ArrayList<Card> c, JPanel jp) {
        for (Card card : c) {
            int key = card.getName();
            String suit = card.getSuit().toString();
            jp.add(labelTable.get(suit + key));
        }
    }


    public void reset() {
        this.setVisible(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        hitButton.setEnabled(true);
        standButton.setEnabled(true);

        model.getDealer().setStatus(true);
        model.getPlayer().setStatus(true);

        if (model.getPublicDeck().getCards().size() > 9) {
            model.getDealerCards().clear();
            model.getPlayerCards().clear();

            model.getDealer().getDeck().addWith(model.getPublicDeck().removeTopOne());
            model.getPlayer().hit(model.getPublicDeck().removeTopOne());

            model.getDealer().getDeck().addWith(model.getPublicDeck().removeTopOne());
            model.getPlayer().hit(model.getPublicDeck().removeTopOne());

            model.getDealer().setPoints(model.getDealer().getDeck().calculatePoints());
        }
        else {
            model = new CardGame();
        }

        playerPanel.removeAll();
        addCardLabel(model.getPlayerCards(), playerPanel);
        // update player cards
        playerPanel.revalidate();
        // update player points
        playerInfo.setText(userName + "'s points: " + model.getPlayer().getPoints());
        // update player(card and points))
        player.revalidate();

        // update dealer cards
        dealerPanel.removeAll();
        JLabel cardBack = new JLabel("Hiding card");
        cardBack.setHorizontalTextPosition(JLabel.CENTER);
        cardBack.setVerticalTextPosition(JLabel.BOTTOM);
        cardBack.setIcon(scaleIcon(new ImageIcon("cardBackRed.png")));
        dealerPanel.add(cardBack);

        String secondCardName = Integer.toString(model.getDealerCards().get(1).getName());
        String secondCardSuit = model.getDealerCards().get(1).getSuit().toString();
        JLabel cur = labelTable.get(secondCardSuit + secondCardName);
        dealerPanel.add(cur);
        // update dealer points
        dealerInfo.setText("Dealer's points(at least): " + model.getDealer().displayPoints());
        // update dealer cards
        dealerPanel.revalidate();
        // update dealer(card and points))
        dealer.revalidate();

        this.setVisible(true);
    }
}
