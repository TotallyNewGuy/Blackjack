package myGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserWindow extends JFrame implements ActionListener {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 150;

    public JTextField name;
    public String userName;
    public JButton startGame = new JButton("Start Game");
    public JButton saveName = new JButton("Save Name");
    public JButton clear = new JButton("Clear");

    public UserWindow() {
        super("Welcome to Black Jack");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        Toolkit tl = Toolkit.getDefaultToolkit(); // get toolkit
        Dimension screeSize = tl.getScreenSize(); // get screen size
        Dimension frameSize = this.getSize(); // get windows size
        int x = (int)(screeSize.getWidth() - frameSize.getWidth()) / 2; // confirm windows position
        int y = (int)(screeSize.getHeight() - frameSize.getHeight()) / 2;
        setLocation(x,y);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        saveName.addActionListener(this);
        buttonPanel.add(saveName);
        startGame.setEnabled(false);
        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GameWindow(userName).setVisible(true);
            }
        });
        buttonPanel.add(startGame);


        clear.addActionListener(this);
        buttonPanel.add(clear);
        add(buttonPanel, BorderLayout.SOUTH);

        name = new JTextField("Enter your name", 20);
        JPanel size = new JPanel();
        size.add(name);
        size.setPreferredSize(new Dimension (70,50));
        add(size,BorderLayout.NORTH);

        JPanel context = new JPanel(new FlowLayout());
        JLabel des = new JLabel("Save name and then click Start Game.");
        context.add(des);
        add(context, BorderLayout.CENTER);
    }


    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        String actionCommand = e.getActionCommand();

        if (actionCommand.equals("Save Name")){
            userName = name.getText();
            startGame.setEnabled(true);
            saveName.setEnabled(false);
        }
        else if (actionCommand.equals("Clear")) {
            name.setText("");
            saveName.setEnabled(true);
            startGame.setEnabled(false);
        }
        else {
            name.setText("Error in memo interface");
        }
    }
}
