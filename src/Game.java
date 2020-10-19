public class Game {
    public int noOfGamesPlayed;
    public int Player1wins;
    public int Player2wins;
    public int playerTurn;

    public void startNewGame(){}
    public void startNewGameAI(){}
    public void selectColor(String color){}

    DisplayUI displayUI;
    Board gameBoard;

    public Game(){
        displayUI = new DisplayUI();
        gameBoard = new Board(displayUI.b);
    }
}

