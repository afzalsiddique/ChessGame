package UserInterface;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JPanel {
    public Game(){
        createAIButtons();
        makeLayoutVisible();
    }

    private void createAIButtons(){
        MenuButton playerVsPlayer = new MenuButton("Player vs Player");
        MenuButton playerVsAI = new MenuButton("Player vs AI");
        add(playerVsPlayer);
        add(playerVsAI);
        playerVsPlayer.addActionListener(createActionListener());
        playerVsAI.addActionListener(createActionListener());
    }

    private ActionListener createActionListener(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button Pressed");

            }
        };
    }
    private void makeLayoutVisible() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
    }



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

