package Sudoku.Engine;

public class Game {
    private static final Game instance = new Game();
    private Board board;
    private boolean isGameRunning = true;

    private Game(int[] intArray){
        board = new Board(intArray);
    };

    private Game(int[][] intArray){
        board = new Board(intArray);
    };

    public static Game getGame() {
        return instance;
    }

    public void gameLoop() {

    }
}
