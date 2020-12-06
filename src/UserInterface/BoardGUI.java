package UserInterface;

import BackEndLogic.Board;
import BackEndLogic.Game;
import BackEndLogic.Spot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BoardGUI extends JPanel {
    private Button[][] Button = new Button[8][8];

    String move = "";
    public int noOfGamesPlayed;
    public int Player1wins;
    public int Player2wins;

    private Game game;

    private boolean isSelectedState = false;

    public BoardGUI(Game gameInfo){
        this.game = gameInfo;
        createButtons();
        createThingsBelowBoard();
        makeLayoutVisible();
    }

    private void createThingsBelowBoard(){
        JButton undoButton = new JButton("Undo Last Move");
        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.UndoLastMove();
//                backEndBoard = backEndGame.getBoard();
                updateGUI();
            }
        });
        this.add(undoButton);
        JButton startNewGame = new JButton("Start New Game");
        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // call the board.startNewGame() here
            }
        });
        this.add(startNewGame);
        JLabel player1Wins = new JLabel(" Player1 Wins: "+this.Player1wins);
        add(player1Wins);
        JLabel player2Wins = new JLabel(" Player2 Wins: "+this.Player2wins);
        add(player2Wins);
    }

    public void updateGUI(){
        Board backEndBoard = game.getBackEndBoard();
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(backEndBoard.isOccupied(i,j)){
                    Button[i][j].setIcon(backEndBoard.getPiece(i,j).getImage());
                }
                else{
                    Button[i][j].setIcon(null);
                }
            }
        }
    }

    private void highlightSpot(Spot inputSpot){
        Button[inputSpot.row][inputSpot.col].setBackground(Color.GREEN.darker().darker().darker().darker());
    }

    private void highlightCapture(Spot inputSpot){
        Button[inputSpot.row][inputSpot.col].setBackground(Color.RED.darker().darker());
    }

    public void highlightCheck(Spot kingSpot){
        Button[kingSpot.row][kingSpot.col].setBackground(Color.ORANGE.darker());
    }

    private void highlightAvailableMoves(ArrayList<Spot> availableMoves){
        Board backEndBoard = game.getBackEndBoard();
        for(int i=0; i<availableMoves.size(); i++){

            //Empty Spot
            if(!backEndBoard.isOccupied(availableMoves.get(i)))
                highlightSpot(availableMoves.get(i));

            //Opponent Piece's Spot
            else
                highlightCapture(availableMoves.get(i));
        }

    }

    private void refreshBackGrounds(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                // Set the color
                if(i%2==0){
                    if(j%2==0)
                        Button[i][j].setBackground(Color.LIGHT_GRAY);
                    else
                        Button[i][j].setBackground(Color.BLACK);
                }
                else {
                    if (j%2!=0)
                        Button[i][j].setBackground(Color.LIGHT_GRAY);
                    else
                        Button[i][j].setBackground(Color.BLACK);
                }
            }
        }
    }

    private void selectPiece(int x, int y){
        game.selectPiece(x,y);
        highlightAvailableMoves(game.getAvailableMoves());
    }

    private void moveSelectedPiece(int x, int y){
        game.makeMove(x, y);
        updateGUI();

        // Refactor these lines later
        game.getBackEndBoard().clearAvailableMoves();
        refreshBackGrounds();
        if(game.getBackEndBoard().checkIfKingIsChecked(true)){
            Spot reqSpot = game.getBackEndBoard().getKing(true).getCurrentSpot();
            highlightCheck(reqSpot);
        }
        if(game.getBackEndBoard().checkIfKingIsChecked(false)){
            Spot reqSpot = game.getBackEndBoard().getKing(false).getCurrentSpot();
            highlightCheck(reqSpot);
        }
    }

    private ActionListener createActionListener(int x, int y){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Make moves etc.

                if(isSelectedState){
                    moveSelectedPiece(x, y);
                    isSelectedState = false;
                }
                else{
                    selectPiece(x, y);
                    isSelectedState = true;
                }

            }
        };
    }

    private void createButtons(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                Button[i][j] = new Button();
                add(Button[i][j]);
                Button[i][j].addActionListener(createActionListener(i,j));

                // Set the color
                if(i%2==0){
                    if(j%2==0)
                        Button[i][j].setBackground(Color.LIGHT_GRAY);
                    else
                        Button[i][j].setBackground(Color.BLACK);
                }
                else {
                    if (j%2!=0)
                        Button[i][j].setBackground(Color.LIGHT_GRAY);
                    else
                        Button[i][j].setBackground(Color.BLACK);
                }
            }
        }
    }

    private void makeLayoutVisible() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 0,0));
    }
}
