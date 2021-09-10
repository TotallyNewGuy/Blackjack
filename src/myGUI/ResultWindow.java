package myGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultWindow extends JFrame implements ActionListener {

    public static final int SMALL_WIDTH = 300; //for confirm window
    public static final int SMALL_HEIGHT = 150; //for confirm window
    public JButton startAgain = new JButton("Restart");
    public JButton exit = new JButton("Exit");
    public JLabel info;
    public GameWindow game;

    public ResultWindow(GameWindow g){
        super("Game Result");
        setSize(SMALL_WIDTH, SMALL_HEIGHT);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout());
        this.game = g;

        Toolkit tl = Toolkit.getDefaultToolkit(); // get toolkit
        Dimension screeSize = tl.getScreenSize(); // get screen size
        Dimension frameSize = this.getSize(); // get windows size
        int x = (int)(screeSize.getWidth() - frameSize.getWidth()) / 2; // confirm windows position
        int y = (int)(screeSize.getHeight() - frameSize.getHeight()) / 2;
        setLocation(x,y);

        info = new JLabel("Game details", JLabel.CENTER);
        add(info, BorderLayout.CENTER);

        startAgain.addActionListener(this);
        exit.addActionListener(this);
        JPanel what = new JPanel();
        what.add(startAgain);
        what.add(exit);
        add(what, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        if (startAgain.equals(button)) {
            game.reset();
            dispose(); //Destroys only the ConfirmWindow.
        }
        else if (exit.equals(button)) {
            System.exit(0);
        }
        else {
            System.out.println("Unexpected Error in Confirm Window.");
        }
    }

    public JLabel getInfo(){
        return info;
    }
}
