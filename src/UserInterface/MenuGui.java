package UserInterface;


import BackEndLogic.Game;

import javax.swing.*;

import java.awt.event.ActionListener;

public class MenuGui{
    JPanel panel = new JPanel();
    DisplayWindow window;
    public MenuGui(){
        createAIButtons();
    }

    private void createAIButtons(){
        MenuButton playerVsPlayer = new MenuButton("Player vs Player");
        MenuButton playerVsAI = new MenuButton("Player vs AI");
        panel.add(playerVsPlayer);
        panel.add(playerVsAI);
        playerVsPlayer.addActionListener(createActionListener());
//        playerVsAI.addActionListener(createActionListener());
    }

    public void addWindow(DisplayWindow jframe){
        window = jframe;
    }

    private ActionListener createActionListener(){
        return e -> {
            System.out.println("Button Pressed");
            window.removePanels();

            Game game = new Game();
            BoardGUI boardGUI = new BoardGUI(game);
            boardGUI.updateGUI();
            window.addPanel(boardGUI);
            window.refresh();
        };
    }

    public JPanel getPanel(){
        return panel;
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

