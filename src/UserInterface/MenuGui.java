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
        MenuButton playerVsAIWhite = new MenuButton("Player (White) vs AI (Black)");
        MenuButton playerVsAIBlack = new MenuButton("Player (Black) vs AI (White)");
        panel.add(playerVsPlayer);
        panel.add(playerVsAIWhite);
        panel.add(playerVsAIBlack);
        playerVsPlayer.addActionListener(createActionListenerForHumans());
        playerVsAIWhite.addActionListener(createActionListenerForAIWhite());
        playerVsAIBlack.addActionListener(createActionListenerForAIBlack());
    }

    public void addWindow(DisplayWindow jframe){
        window = jframe;
    }

    private ActionListener createActionListenerForHumans(){
        return e -> {
            window.removePanels();

            Game game = new Game();
            game.setAiMode(false);
            game.setIsWhite(true);
            BoardGUI boardGUI = new BoardGUI(game);
            boardGUI.updateGUI();
            window.addPanel(boardGUI);
            window.refresh();
        };
    }

    private ActionListener createActionListenerForAIWhite(){
        return e -> {
            window.removePanels();

            Game game = new Game();
            game.setAiMode(true);

            game.simAI.setIsWhite(false);
            game.setIsWhite(true);

            BoardGUI boardGUI = new BoardGUI(game);
            boardGUI.updateGUI();
            window.addPanel(boardGUI);
            window.refresh();
        };
    }

    private ActionListener createActionListenerForAIBlack(){
        return e -> {
            window.removePanels();

            Game game = new Game();
            game.setAiMode(true);

            game.simAI.setIsWhite(true);
            game.setIsWhite(false);


            BoardGUI boardGUI = new BoardGUI(game);
            boardGUI.updateGUI();

            game.AIMakeMove();

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

