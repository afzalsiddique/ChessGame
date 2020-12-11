package UserInterface;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGui{
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    public MenuGui(){
        createAIButtons();
//        makeLayoutVisible();
    }

    private void createAIButtons(){
        frame.setSize(700, 720);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout());
        MenuButton playerVsPlayer = new MenuButton("Player vs Player");
        MenuButton playerVsAI = new MenuButton("Player vs AI");
        panel.add(playerVsPlayer);
        panel.add(playerVsAI);
        playerVsPlayer.addActionListener(createActionListener());
        playerVsAI.addActionListener(createActionListener());
        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }


    private ActionListener createActionListener(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button Pressed");
                panel.setVisible(false);
            }
        };
    }
//    private void makeLayoutVisible() {
//        setLayout(new FlowLayout(FlowLayout.CENTER));
//    }



//    public int noOfGamesPlayed;
//    public int Player1wins;
//    public int Player2wins;
//    public int playerTurn;
//
//    public void startNewGame(){}
//    public void startNewGameAI(){}
//    public void selectColor(String color){}

//    DisplayUI displayUI;
//    Board gameBoard;

}

